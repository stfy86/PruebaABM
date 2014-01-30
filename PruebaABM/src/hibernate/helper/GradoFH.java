
package hibernate.helper;

import hibernate.pojo.TbGrado;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class GradoFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbGrado grado) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(grado); 
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

    public void actualizar(TbGrado grado) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(grado); 
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

    public void eliminar(TbGrado grado) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(grado); 
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

    public TbGrado buscar(Integer idGrado) throws HibernateException 
    { 
        TbGrado grado = null;  
        try 
        { 
            iniciarOperacion(); 
            grado = (TbGrado) sesion.get(TbGrado.class, idGrado); 
        } finally 
        { 
            sesion.close(); 
        }  

        return grado; 
    }  

    public List<TbGrado> listar() throws HibernateException 
    { 
        List<TbGrado> listaGrados = null;  

        try 
        { 
            iniciarOperacion(); 
            listaGrados = sesion.createQuery("from TbGrado").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaGrados; 
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
