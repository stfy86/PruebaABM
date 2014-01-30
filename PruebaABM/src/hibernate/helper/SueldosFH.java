
package hibernate.helper;

import hibernate.pojo.TbSueldos;
import hibernate.HibernateUtil;
import hibernate.pojo.TbPersonal;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class SueldosFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbSueldos sueldo) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(sueldo); 
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

    public void actualizar(TbSueldos sueldo) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(sueldo); 
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

    public void eliminar(TbSueldos sueldo) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(sueldo); 
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

    public TbSueldos buscar(Integer idSueldos) throws HibernateException 
    { 
        TbSueldos sueldo = null;  
        try 
        { 
            iniciarOperacion(); 
            sueldo = (TbSueldos) sesion.get(TbSueldos.class, idSueldos); 
        } finally 
        { 
            sesion.close(); 
        }  

        return sueldo; 
    }  

    public List<TbSueldos> listar() throws HibernateException 
    { 
        List<TbSueldos> listaSueldos = null;  

        try 
        { 
            iniciarOperacion(); 
            listaSueldos = sesion.createQuery("from TbSueldos").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaSueldos; 
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

    private void addPersonal(Integer idSueldo, TbPersonal personal) throws HibernateException {
        TbSueldos sueldo = null; 
        try 
        { 
            iniciarOperacion(); 
            sueldo = (TbSueldos) sesion.get(TbSueldos.class, idSueldo); 
            Set set = sueldo.getTbSueldosXPersonals();
            set.add(personal);    
            sesion.update(sueldo); 
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
    
    private void removePersonal(Integer idSueldo, TbPersonal personal) throws HibernateException {
        TbSueldos sueldo = null; 
        try 
        { 
            iniciarOperacion(); 
            sueldo = (TbSueldos) sesion.get(TbSueldos.class, idSueldo); 
            Set set = sueldo.getTbSueldosXPersonals();
            set.remove(personal);
            sesion.update(sueldo); 
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

}
