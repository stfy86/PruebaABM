package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0



/**
 * TbPlanilla generated by hbm2java
 */
public class TbPlanilla  implements java.io.Serializable {


     private int plaCod;
     private String plaNombreCorto;
     private String plaNombreLargo;

    public TbPlanilla() {
    }

    public TbPlanilla(int plaCod, String plaNombreCorto, String plaNombreLargo) {
       this.plaCod = plaCod;
       this.plaNombreCorto = plaNombreCorto;
       this.plaNombreLargo = plaNombreLargo;
    }
   
    public int getPlaCod() {
        return this.plaCod;
    }
    
    public void setPlaCod(int plaCod) {
        this.plaCod = plaCod;
    }
    public String getPlaNombreCorto() {
        return this.plaNombreCorto;
    }
    
    public void setPlaNombreCorto(String plaNombreCorto) {
        this.plaNombreCorto = plaNombreCorto;
    }
    public String getPlaNombreLargo() {
        return this.plaNombreLargo;
    }
    
    public void setPlaNombreLargo(String plaNombreLargo) {
        this.plaNombreLargo = plaNombreLargo;
    }




}


