
package hibernate.helper;

import hibernate.pojo.TbArma;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ArmasFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbArma arma) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(arma); 
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

    public void actualizar(TbArma arma) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(arma); 
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

    public void eliminar(TbArma arma) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(arma); 
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

    public TbArma buscar(Integer idArma) throws HibernateException 
    { 
        TbArma arma = null;  
        try 
        { 
            iniciarOperacion(); 
            arma = (TbArma) sesion.get(TbArma.class, idArma); 
        } finally 
        { 
            sesion.close(); 
        }  

        return arma; 
    }  

    public List<TbArma> listar() throws HibernateException 
    { 
        List<TbArma> listaArmas = null;  

        try 
        { 
            iniciarOperacion(); 
            listaArmas = sesion.createQuery("from TbArma").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaArmas; 
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
