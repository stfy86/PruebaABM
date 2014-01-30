
package hibernate.helper;

import hibernate.pojo.TbCargo;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CargosFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbCargo cargo) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(cargo); 
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

    public void actualizar(TbCargo cargo) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(cargo); 
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

    public void eliminar(TbCargo cargo) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(cargo); 
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

    public TbCargo buscar(Integer idCargo) throws HibernateException 
    { 
        TbCargo cargo = null;  
        try 
        { 
            iniciarOperacion(); 
            cargo = (TbCargo) sesion.get(TbCargo.class, idCargo); 
        } finally 
        { 
            sesion.close(); 
        }  

        return cargo; 
    }  

    public List<TbCargo> listar() throws HibernateException 
    { 
        List<TbCargo> listaCargos = null;  

        try 
        { 
            iniciarOperacion(); 
            listaCargos = sesion.createQuery("from TbCargo").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaCargos; 
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
