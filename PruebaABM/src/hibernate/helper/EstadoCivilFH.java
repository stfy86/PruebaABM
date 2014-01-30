
package hibernate.helper;

import hibernate.pojo.TbEstadoCivil;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EstadoCivilFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbEstadoCivil estadoCivil) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(estadoCivil); 
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

    public void actualizar(TbEstadoCivil estadoCivil) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(estadoCivil); 
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

    public void eliminar(TbEstadoCivil estadoCivil) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(estadoCivil); 
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

    public TbEstadoCivil buscar(Integer idEstadoCivil) throws HibernateException 
    { 
        TbEstadoCivil estadoCivil = null;  
        try 
        { 
            iniciarOperacion(); 
            estadoCivil = (TbEstadoCivil) sesion.get(TbEstadoCivil.class, idEstadoCivil); 
        } finally 
        { 
            sesion.close(); 
        }  

        return estadoCivil; 
    }  

    public List<TbEstadoCivil> listar() throws HibernateException 
    { 
        List<TbEstadoCivil> listaEstadoCivils = null;  

        try 
        { 
            iniciarOperacion(); 
            listaEstadoCivils = sesion.createQuery("from TbEstadoCivil").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaEstadoCivils; 
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
