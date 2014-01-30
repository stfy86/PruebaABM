
package hibernate.helper;

import hibernate.pojo.TbUnidad;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UnidadFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbUnidad unidad) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(unidad); 
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

    public void actualizar(TbUnidad unidad) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(unidad); 
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

    public void eliminar(TbUnidad unidad) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(unidad); 
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

    public TbUnidad buscar(Integer idUnidad) throws HibernateException 
    { 
        TbUnidad unidad = null;  
        try 
        { 
            iniciarOperacion(); 
            unidad = (TbUnidad) sesion.get(TbUnidad.class, idUnidad); 
        } finally 
        { 
            sesion.close(); 
        }  

        return unidad; 
    }  

    public List<TbUnidad> listar() throws HibernateException 
    { 
        List<TbUnidad> listaUnidads = null;  

        try 
        { 
            iniciarOperacion(); 
            listaUnidads = sesion.createQuery("from TbUnidad").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaUnidads; 
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
