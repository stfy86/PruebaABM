package hibernate.pojo;
// Generated 30/01/2014 01:58:01 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * TbBonificacionesXPersonal generated by hbm2java
 */
public class TbBonificacionesXPersonal  implements java.io.Serializable {


     private int bopCod;
     private TbPersonal tbPersonal;
     private TbBonificaciones tbBonificaciones;
     private int bopMonto;
     private boolean bopActivo;
     private Date bopFecha;

    public TbBonificacionesXPersonal() {
    }

    public TbBonificacionesXPersonal(int bopCod, TbPersonal tbPersonal, TbBonificaciones tbBonificaciones, int bopMonto, boolean bopActivo, Date bopFecha) {
       this.bopCod = bopCod;
       this.tbPersonal = tbPersonal;
       this.tbBonificaciones = tbBonificaciones;
       this.bopMonto = bopMonto;
       this.bopActivo = bopActivo;
       this.bopFecha = bopFecha;
    }
   
    public int getBopCod() {
        return this.bopCod;
    }
    
    public void setBopCod(int bopCod) {
        this.bopCod = bopCod;
    }
    public TbPersonal getTbPersonal() {
        return this.tbPersonal;
    }
    
    public void setTbPersonal(TbPersonal tbPersonal) {
        this.tbPersonal = tbPersonal;
    }
    public TbBonificaciones getTbBonificaciones() {
        return this.tbBonificaciones;
    }
    
    public void setTbBonificaciones(TbBonificaciones tbBonificaciones) {
        this.tbBonificaciones = tbBonificaciones;
    }
    public int getBopMonto() {
        return this.bopMonto;
    }
    
    public void setBopMonto(int bopMonto) {
        this.bopMonto = bopMonto;
    }
    public boolean isBopActivo() {
        return this.bopActivo;
    }
    
    public void setBopActivo(boolean bopActivo) {
        this.bopActivo = bopActivo;
    }
    public Date getBopFecha() {
        return this.bopFecha;
    }
    
    public void setBopFecha(Date bopFecha) {
        this.bopFecha = bopFecha;
    }




}


