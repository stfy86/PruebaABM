package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbPantallas generated by hbm2java
 */
public class TbPantallas  implements java.io.Serializable {


     private int panCod;
     private String panNombre;
     private Set tbRolesXPantallases = new HashSet(0);

    public TbPantallas() {
    }

	
    public TbPantallas(int panCod) {
        this.panCod = panCod;
    }
    public TbPantallas(int panCod, String panNombre, Set tbRolesXPantallases) {
       this.panCod = panCod;
       this.panNombre = panNombre;
       this.tbRolesXPantallases = tbRolesXPantallases;
    }
   
    public int getPanCod() {
        return this.panCod;
    }
    
    public void setPanCod(int panCod) {
        this.panCod = panCod;
    }
    public String getPanNombre() {
        return this.panNombre;
    }
    
    public void setPanNombre(String panNombre) {
        this.panNombre = panNombre;
    }
    public Set getTbRolesXPantallases() {
        return this.tbRolesXPantallases;
    }
    
    public void setTbRolesXPantallases(Set tbRolesXPantallases) {
        this.tbRolesXPantallases = tbRolesXPantallases;
    }




}

