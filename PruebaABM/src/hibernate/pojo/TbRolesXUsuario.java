package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0



/**
 * TbRolesXUsuario generated by hbm2java
 */
public class TbRolesXUsuario  implements java.io.Serializable {


     private int rouCod;
     private int usCod;
     private int rolCod;

    public TbRolesXUsuario() {
    }

    public TbRolesXUsuario(int rouCod, int usCod, int rolCod) {
       this.rouCod = rouCod;
       this.usCod = usCod;
       this.rolCod = rolCod;
    }
   
    public int getRouCod() {
        return this.rouCod;
    }
    
    public void setRouCod(int rouCod) {
        this.rouCod = rouCod;
    }
    public int getUsCod() {
        return this.usCod;
    }
    
    public void setUsCod(int usCod) {
        this.usCod = usCod;
    }
    public int getRolCod() {
        return this.rolCod;
    }
    
    public void setRolCod(int rolCod) {
        this.rolCod = rolCod;
    }




}


