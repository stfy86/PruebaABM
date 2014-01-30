
package hibernate.helper;

import hibernate.pojo.TbGiraduria;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class GiraduriaFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbGiraduria giraduria) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(giraduria); 
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

    public void actualizar(TbGiraduria giraduria) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(giraduria); 
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

    public void eliminar(TbGiraduria giraduria) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(giraduria); 
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

    public TbGiraduria buscar(Integer idGiraduria) throws HibernateException 
    { 
        TbGiraduria giraduria = null;  
        try 
        { 
            iniciarOperacion(); 
            giraduria = (TbGiraduria) sesion.get(TbGiraduria.class, idGiraduria); 
        } finally 
        { 
            sesion.close(); 
        }  

        return giraduria; 
    }  

    public List<TbGiraduria> listar() throws HibernateException 
    { 
        List<TbGiraduria> listaGiradurias = null;  

        try 
        { 
            iniciarOperacion(); 
            listaGiradurias = sesion.createQuery("from TbGiraduria").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaGiradurias; 
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
