package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0



/**
 * TbArma generated by hbm2java
 */
public class TbArma  implements java.io.Serializable {


     private int arCod;
     private String arNombreCorto;
     private String arNombreLargo;

    public TbArma() {
    }

    public TbArma(int arCod, String arNombreCorto, String arNombreLargo) {
       this.arCod = arCod;
       this.arNombreCorto = arNombreCorto;
       this.arNombreLargo = arNombreLargo;
    }
   
    public int getArCod() {
        return this.arCod;
    }
    
    public void setArCod(int arCod) {
        this.arCod = arCod;
    }
    public String getArNombreCorto() {
        return this.arNombreCorto;
    }
    
    public void setArNombreCorto(String arNombreCorto) {
        this.arNombreCorto = arNombreCorto;
    }
    public String getArNombreLargo() {
        return this.arNombreLargo;
    }
    
    public void setArNombreLargo(String arNombreLargo) {
        this.arNombreLargo = arNombreLargo;
    }




}

