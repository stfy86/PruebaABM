package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * TbCargo generated by hbm2java
 */
public class TbCargo  implements java.io.Serializable {


     private int carCod;
     private String carNombreCorto;
     private String carNombreLargo;
     private Set tbPersonals = new HashSet(0);

    public TbCargo() {
    }

	
    public TbCargo(int carCod, String carNombreCorto, String carNombreLargo) {
        this.carCod = carCod;
        this.carNombreCorto = carNombreCorto;
        this.carNombreLargo = carNombreLargo;
    }
    public TbCargo(int carCod, String carNombreCorto, String carNombreLargo, Set tbPersonals) {
       this.carCod = carCod;
       this.carNombreCorto = carNombreCorto;
       this.carNombreLargo = carNombreLargo;
       this.tbPersonals = tbPersonals;
    }
   
    public int getCarCod() {
        return this.carCod;
    }
    
    public void setCarCod(int carCod) {
        this.carCod = carCod;
    }
    public String getCarNombreCorto() {
        return this.carNombreCorto;
    }
    
    public void setCarNombreCorto(String carNombreCorto) {
        this.carNombreCorto = carNombreCorto;
    }
    public String getCarNombreLargo() {
        return this.carNombreLargo;
    }
    
    public void setCarNombreLargo(String carNombreLargo) {
        this.carNombreLargo = carNombreLargo;
    }
    public Set getTbPersonals() {
        return this.tbPersonals;
    }
    
    public void setTbPersonals(Set tbPersonals) {
        this.tbPersonals = tbPersonals;
    }




}

