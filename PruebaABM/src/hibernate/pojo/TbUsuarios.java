package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0



/**
 * TbUsuarios generated by hbm2java
 */
public class TbUsuarios  implements java.io.Serializable {


     private int usCod;
     private Integer usCi;
     private String usNombre;
     private String usApellido;

    public TbUsuarios() {
    }

	
    public TbUsuarios(int usCod) {
        this.usCod = usCod;
    }
    public TbUsuarios(int usCod, Integer usCi, String usNombre, String usApellido) {
       this.usCod = usCod;
       this.usCi = usCi;
       this.usNombre = usNombre;
       this.usApellido = usApellido;
    }
   
    public int getUsCod() {
        return this.usCod;
    }
    
    public void setUsCod(int usCod) {
        this.usCod = usCod;
    }
    public Integer getUsCi() {
        return this.usCi;
    }
    
    public void setUsCi(Integer usCi) {
        this.usCi = usCi;
    }
    public String getUsNombre() {
        return this.usNombre;
    }
    
    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }
    public String getUsApellido() {
        return this.usApellido;
    }
    
    public void setUsApellido(String usApellido) {
        this.usApellido = usApellido;
    }




}

