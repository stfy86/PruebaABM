
package hibernate.helper;

import hibernate.pojo.TbPersonalTipo;
import hibernate.HibernateUtil;
import hibernate.pojo.TbPersonal;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PersonalTipoFH
{  
    private Session sesion; 
    private Transaction tx;  

    public Integer guardar(TbPersonalTipo personalTipo) throws HibernateException 
    { 
        Integer id = 0;  

        try 
        { 
            iniciarOperacion(); 
            id = (Integer) sesion.save(personalTipo); 
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

    public void actualizar(TbPersonalTipo personalTipo) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.update(personalTipo); 
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

    public void eliminar(TbPersonalTipo personalTipo) throws HibernateException 
    { 
        try 
        { 
            iniciarOperacion(); 
            sesion.delete(personalTipo); 
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

    public TbPersonalTipo buscar(Integer idPersonalTipo) throws HibernateException 
    { 
        TbPersonalTipo personalTipo = null;  
        try 
        { 
            iniciarOperacion(); 
            personalTipo = (TbPersonalTipo) sesion.get(TbPersonalTipo.class, idPersonalTipo); 
        } finally 
        { 
            sesion.close(); 
        }  

        return personalTipo; 
    }  

    public List<TbPersonalTipo> listar() throws HibernateException 
    { 
        List<TbPersonalTipo> listaPersonalTipo = null;  

        try 
        { 
            iniciarOperacion(); 
            listaPersonalTipo = sesion.createQuery("from TbPersonalTipo").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaPersonalTipo; 
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

    private void addPersonal(Integer idPersonalTipo, TbPersonal personal) throws HibernateException {
        TbPersonalTipo personalTipo = null; 
        try 
        { 
            iniciarOperacion(); 
            personalTipo = (TbPersonalTipo) sesion.get(TbPersonalTipo.class, idPersonalTipo); 
            Set set = personalTipo.getTbPersonals();
            set.add(personal);    
            sesion.update(personalTipo); 
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
    
    private void removePersonal(Integer idPersonalTipo, TbPersonal personal) throws HibernateException {
        TbPersonalTipo personalTipo = null; 
        try 
        { 
            iniciarOperacion(); 
            personalTipo = (TbPersonalTipo) sesion.get(TbPersonalTipo.class, idPersonalTipo); 
            Set set = personalTipo.getTbPersonals();
            set.remove(personal);
            sesion.update(personalTipo); 
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
