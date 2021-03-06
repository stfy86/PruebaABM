
package hibernate.helper;

import hibernate.pojo.TbUsuarios;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UsuariosFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbUsuarios usuario) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(usuario); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejarExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return id; 
    }  

    public void actualizar(TbUsuarios usuario) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(usuario); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejarExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public void eliminar(TbUsuarios usuario) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(usuario); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejarExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public TbUsuarios buscar(Integer idUsuario) throws HibernateException 
    { 
        TbUsuarios usuario = null;  
        try 
        { 
            iniciarOperacion(); 
            usuario = (TbUsuarios) sesion.get(TbUsuarios.class, idUsuario); 
        } finally 
        { 
            sesion.close(); 
        }  

        return usuario; 
    }  

    public List<TbUsuarios> listar() throws HibernateException 
    { 
        List<TbUsuarios> listaUsuarios = null;  

        try 
        { 
            iniciarOperacion(); 
            listaUsuarios = sesion.createQuery("from TbUsuarios").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaUsuarios; 
    }  

    private void iniciarOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  

    private void manejarExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 


}
