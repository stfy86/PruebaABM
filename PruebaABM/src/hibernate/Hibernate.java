package hibernate;
//
import java.util.List;
// FILE HELPER
import hibernate.helper.ArmasFH;
import hibernate.helper.BonificacionesFH;
import hibernate.helper.CargosFH;
import hibernate.helper.EstadoCivilFH;
import hibernate.helper.GiraduriaFH;
import hibernate.helper.GradoFH;
import hibernate.helper.PersonalTipoFH;
import hibernate.helper.SueldosFH;
import hibernate.helper.UnidadFH;
import hibernate.helper.UsuariosFH;
// POJO
import hibernate.pojo.TbArma;
import hibernate.pojo.TbBonificaciones;
import hibernate.pojo.TbCargo;
import hibernate.pojo.TbEstadoCivil;
import hibernate.pojo.TbGiraduria;
import hibernate.pojo.TbGrado;
import hibernate.pojo.TbPersonalTipo;
import hibernate.pojo.TbSueldos;
import hibernate.pojo.TbUnidad;
import hibernate.pojo.TbUsuarios;

public class Hibernate
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //TB_ARMA
        //abmArma();
        
        //TB_BONIFICACIONES
        //abmBonificaciones();
        
        //TB_CARGO
        //abmCargo();
        
        //TB_GIRADURIA
        //abmGiraduria();
        
        //TB_PERSONAL_TIPO
        //abmPersonalTipo();
        
        //TB_DESCUENTOS
        //abmDescuentos();
        
        //TB_ESTADO_CIVIL
        //abmEstadoCivil();

        //TB_GRADO
        //abmGrado();
        
        //TB_SUELDOS
        //abmSueldos();
        
        //TB_UNIDAD
        //abmUnidad();
        
        //TB_USUARIOS
        //abmUsuarios(); 
           
    }
    
    public static void abmArma(){
        ArmasFH armasDAO = new ArmasFH();
        TbArma armaRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Arma 
        TbArma arma1 = new TbArma(1,"A1", "arma1");
        TbArma arma2 = new TbArma(2,"A2", "arma2");
        TbArma arma3 = new TbArma(3,"A3", "arma3");

        //Guardamos las tres instancias, guardamos el id del arma1 para usarlo posteriormente 
        idAEliminar = armasDAO.guardar(arma1);
        armasDAO.guardar(arma2);
        armasDAO.guardar(arma3);

        //Modificamos el arma 2 y lo actualizamos 
        arma2.setArNombreLargo("arma2modif");
        armasDAO.actualizar(arma2);

        //Recuperamos el arma1 de la base de datos 
        armaRecuperado = armasDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + armaRecuperado.getArNombreLargo());

        //Eliminamos al armaRecuperado (que es el arma3) 
        armasDAO.eliminar(armaRecuperado);

        //Obtenemos la lista de armas que quedan en la base de datos y la mostramos 
        List<TbArma> listaArmas = armasDAO.listar();
        System.out.println("Hay " + listaArmas.size() + "armas en la base de datos");

        for (TbArma c : listaArmas)
        {
            System.out.println("-> " + c.getArNombreCorto());
        }
        
    }

    private static void abmBonificaciones() {
        BonificacionesFH bonificacionDAO = new BonificacionesFH();
        TbBonificaciones bonificacionRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Bonificacion
        TbBonificaciones bonificacion1 = new TbBonificaciones(1,"bonificacion 1", "b1");
        TbBonificaciones bonificacion2 = new TbBonificaciones(2,"bonificacion 2", "b2");
        TbBonificaciones bonificacion3 = new TbBonificaciones(3,"bonificacion 3", "b3");

        //Guardamos las tres instancias, guardamos el id de bonificaion1 para usarlo posteriormente 
        idAEliminar = bonificacionDAO.guardar(bonificacion1);
        bonificacionDAO.guardar(bonificacion2);
        bonificacionDAO.guardar(bonificacion3);

        //Modificamos la bonificacion2 y lo actualizamos 
        bonificacion2.setBonNombre("bonificacion 2 modif");
        bonificacionDAO.actualizar(bonificacion2);

        //Recuperamos bonificacion1 de la base de datos 
        bonificacionRecuperado = bonificacionDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + bonificacionRecuperado.getBonNombre());

        //Eliminamos bonificacionRecuperado (que es bonificacion3) 
        bonificacionDAO.eliminar(bonificacionRecuperado);

        //Obtenemos la lista de armas que quedan en la base de datos y la mostramos 
        List<TbBonificaciones> listaBonificaciones = bonificacionDAO.listar();
        System.out.println("Hay " + listaBonificaciones.size() + "bonificaciones en la base de datos");

        for (TbBonificaciones c : listaBonificaciones)
        {
            System.out.println("-> " + c.getBonNombre());
        }
                
        
    }

    private static void abmCargo() {
        
        CargosFH cargosDAO = new CargosFH();
        TbCargo cargoRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Cargo 
        TbCargo cargo1 = new TbCargo(1,"C1", "cargo 1");
        TbCargo cargo2 = new TbCargo(2,"C2", "cargo 2");
        TbCargo cargo3 = new TbCargo(3,"C3", "cargo 3");

        //Guardamos las tres instancias, guardamos el id del cargo1 para usarlo posteriormente 
        idAEliminar = cargosDAO.guardar(cargo1);
        cargosDAO.guardar(cargo2);
        cargosDAO.guardar(cargo3);

        //Modificamos el cargo 2 y lo actualizamos 
        cargo2.setCarNombreLargo("cargo 2 modif");
        cargosDAO.actualizar(cargo2);

        //Recuperamos el cargo1 de la base de datos 
        cargoRecuperado = cargosDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + cargoRecuperado.getCarNombreLargo());

        //Eliminamos al cargoRecuperado (que es el cargo3) 
        cargosDAO.eliminar(cargoRecuperado);

        //Obtenemos la lista de cargos que quedan en la base de datos y la mostramos 
        List<TbCargo> listaCargos = cargosDAO.listar();
        System.out.println("Hay " + listaCargos.size() + "cargos en la base de datos");

        for (TbCargo c : listaCargos)
        {
            System.out.println("-> " + c.getCarNombreCorto());
        }
        
        
        
    }

    private static void abmGiraduria() {
        GiraduriaFH giraduriasDAO = new GiraduriaFH();
        TbGiraduria giraduriaRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Giraduria 
        TbGiraduria giraduria1 = new TbGiraduria(1,"A1", "giraduria1", "direccion1", "1111");
        TbGiraduria giraduria2 = new TbGiraduria(2,"A2", "giraduria2", "direccion2", "2222");
        TbGiraduria giraduria3 = new TbGiraduria(3,"A3", "giraduria3", "direccion3", "3333");

        //Guardamos las tres instancias, guardamos el id del giraduria1 para usarlo posteriormente 
        idAEliminar = giraduriasDAO.guardar(giraduria1);
        giraduriasDAO.guardar(giraduria2);
        giraduriasDAO.guardar(giraduria3);

        //Modificamos el giraduria 2 y lo actualizamos 
        giraduria2.setGiNombreLargo("giraduria2modif");
        giraduriasDAO.actualizar(giraduria2);

        //Recuperamos el giraduria1 de la base de datos 
        giraduriaRecuperado = giraduriasDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + giraduriaRecuperado.getGiNombreLargo());

        //Eliminamos al giraduriaRecuperado (que es el giraduria3) 
        giraduriasDAO.eliminar(giraduriaRecuperado);

        //Obtenemos la lista de giradurias que quedan en la base de datos y la mostramos 
        List<TbGiraduria> listaGiradurias = giraduriasDAO.listar();
        System.out.println("Hay " + listaGiradurias.size() + "giradurias en la base de datos");

        for (TbGiraduria c : listaGiradurias)
        {
            System.out.println("-> " + c.getGiNombreCorto());
        }
        

    }

    private static void abmGrado() {
        
        GradoFH gradosDAO = new GradoFH();
        TbGrado gradoRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Arma 
        TbGrado grado1 = new TbGrado(1,"G1", "grado1");
        TbGrado grado2 = new TbGrado(2,"G2", "grado2");
        TbGrado grado3 = new TbGrado(3,"G3", "grado3");

        //Guardamos las tres instancias, guardamos el id del grado1 para usarlo posteriormente 
        idAEliminar = gradosDAO.guardar(grado1);
        gradosDAO.guardar(grado2);
        gradosDAO.guardar(grado3);

        //Modificamos el grado 2 y lo actualizamos 
        grado2.setGraNombreLargo("grado2modif");
        gradosDAO.actualizar(grado2);

        //Recuperamos el grado1 de la base de datos 
        gradoRecuperado = gradosDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + gradoRecuperado.getGraNombreLargo());

        //Eliminamos al gradoRecuperado (que es el grado3) 
        gradosDAO.eliminar(gradoRecuperado);

        //Obtenemos la lista de grados que quedan en la base de datos y la mostramos 
        List<TbGrado> listaArmas = gradosDAO.listar();
        System.out.println("Hay " + listaArmas.size() + "grados en la base de datos");

        for (TbGrado c : listaArmas)
        {
            System.out.println("-> " + c.getGraNombreCorto());
        }
        
        
    }

    private static void abmUnidad() {
        UnidadFH unidadsDAO = new UnidadFH();
        TbUnidad unidadRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Arma 
        TbUnidad unidad1 = new TbUnidad(1,"U1", "unidad1");
        TbUnidad unidad2 = new TbUnidad(2,"U2", "unidad2");
        TbUnidad unidad3 = new TbUnidad(3,"U3", "unidad3");

        //Guardamos las tres instancias, guardamos el id del unidad1 para usarlo posteriormente 
        idAEliminar = unidadsDAO.guardar(unidad1);
        unidadsDAO.guardar(unidad2);
        unidadsDAO.guardar(unidad3);

        //Modificamos el unidad 2 y lo actualizamos 
        unidad2.setUniNombreLargo("unidad2modif");
        unidadsDAO.actualizar(unidad2);

        //Recuperamos el unidad1 de la base de datos 
        unidadRecuperado = unidadsDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + unidadRecuperado.getUniNombreLargo());

        //Eliminamos al unidadRecuperado (que es el unidad3) 
        unidadsDAO.eliminar(unidadRecuperado);

        //Obtenemos la lista de unidads que quedan en la base de datos y la mostramos 
        List<TbUnidad> listaUnidads = unidadsDAO.listar();
        System.out.println("Hay " + listaUnidads.size() + "unidads en la base de datos");

        for (TbUnidad c : listaUnidads)
        {
            System.out.println("-> " + c.getUniNombreCorto());
        }
        
        
        
    }

    private static void abmUsuarios() {
        UsuariosFH usuariosDAO = new UsuariosFH();
        TbUsuarios usuarioRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Arma 
        TbUsuarios usuario1 = new TbUsuarios(1,1111,"usuarioNombre1", "usuarioAperllido1");
        TbUsuarios usuario2 = new TbUsuarios(2,2222, "usuarioNombre2", "usuarioApellido2");
        TbUsuarios usuario3 = new TbUsuarios(3,3333, "usuarioNombre3", "usuarioApellido3");

        //Guardamos las tres instancias, guardamos el id del usuario1 para usarlo posteriormente 
        idAEliminar = usuariosDAO.guardar(usuario1);
        usuariosDAO.guardar(usuario2);
        usuariosDAO.guardar(usuario3);

        //Modificamos el usuario 2 y lo actualizamos 
        usuario2.setUsNombre("usuarioNombre2modif");
        usuariosDAO.actualizar(usuario2);

        //Recuperamos el usuario1 de la base de datos 
        usuarioRecuperado = usuariosDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + usuarioRecuperado.getUsNombre());

        //Eliminamos al usuarioRecuperado (que es el usuario3) 
        usuariosDAO.eliminar(usuarioRecuperado);

        //Obtenemos la lista de usuarios que quedan en la base de datos y la mostramos 
        List<TbUsuarios> listaArmas = usuariosDAO.listar();
        System.out.println("Hay " + listaArmas.size() + "usuarios en la base de datos");

        for (TbUsuarios c : listaArmas)
        {
            System.out.println("-> " + c.getUsNombre());
        }
        
    
    }

    private static void abmEstadoCivil() {
        EstadoCivilFH estadoCivilsDAO = new EstadoCivilFH();
        TbEstadoCivil estadoCivilRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de EstadoCivil 
        TbEstadoCivil estadoCivil1 = new TbEstadoCivil(1,"estadoCivil1");
        TbEstadoCivil estadoCivil2 = new TbEstadoCivil(2,"estadoCivil2");
        TbEstadoCivil estadoCivil3 = new TbEstadoCivil(3,"estadoCivil3");

        //Guardamos las tres instancias, guardamos el id del estadoCivil1 para usarlo posteriormente 
        idAEliminar = estadoCivilsDAO.guardar(estadoCivil1);
        estadoCivilsDAO.guardar(estadoCivil2);
        estadoCivilsDAO.guardar(estadoCivil3);

        //Modificamos el estadoCivil 2 y lo actualizamos 
        estadoCivil2.setEcDescripcion("estadoCivil2modif");
        estadoCivilsDAO.actualizar(estadoCivil2);

        //Recuperamos el estadoCivil1 de la base de datos 
        estadoCivilRecuperado = estadoCivilsDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + estadoCivilRecuperado.getEcDescripcion());

        //Eliminamos al estadoCivilRecuperado (que es el estadoCivil3) 
        estadoCivilsDAO.eliminar(estadoCivilRecuperado);

        //Obtenemos la lista de estadoCivils que quedan en la base de datos y la mostramos 
        List<TbEstadoCivil> listaEstadoCivils = estadoCivilsDAO.listar();
        System.out.println("Hay " + listaEstadoCivils.size() + "estadoCivils en la base de datos");

        for (TbEstadoCivil c : listaEstadoCivils)
        {
            System.out.println("-> " + c.getEcDescripcion());
        }
    }

    private static void abmSueldos() {
        SueldosFH sueldosDAO = new SueldosFH();
        TbSueldos sueldoRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Sueldo 
        TbSueldos sueldo1 = new TbSueldos(1,"sueldo1");
        TbSueldos sueldo2 = new TbSueldos(2,"sueldo2");
        TbSueldos sueldo3 = new TbSueldos(3,"sueldo3");

        //Guardamos las tres instancias, guardamos el id del sueldo1 para usarlo posteriormente 
        idAEliminar = sueldosDAO.guardar(sueldo1);
        sueldosDAO.guardar(sueldo2);
        sueldosDAO.guardar(sueldo3);

        //Modificamos el sueldo 2 y lo actualizamos 
        sueldo2.setSueNombre("sueldo2modif");
        sueldosDAO.actualizar(sueldo2);

        //Recuperamos el sueldo1 de la base de datos 
        sueldoRecuperado = sueldosDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + sueldoRecuperado.getSueNombre());

        //Eliminamos al sueldoRecuperado (que es el sueldo3) 
        sueldosDAO.eliminar(sueldoRecuperado);

        //Obtenemos la lista de sueldos que quedan en la base de datos y la mostramos 
        List<TbSueldos> listaSueldos = sueldosDAO.listar();
        System.out.println("Hay " + listaSueldos.size() + "sueldos en la base de datos");

        for (TbSueldos c : listaSueldos)
        {
            System.out.println("-> " + c.getSueNombre());
        }
        
    
    }

    private static void abmPersonalTipo() {
        PersonalTipoFH personalTiposDAO = new PersonalTipoFH();
        TbPersonalTipo personalTipoRecuperado = null;
        Integer idAEliminar = 0;

        //Creamos tres instancias de Sueldo 
        TbPersonalTipo personalTipo1 = new TbPersonalTipo(1,"personalTipo1");
        TbPersonalTipo personalTipo2 = new TbPersonalTipo(2,"personalTipo2");
        TbPersonalTipo personalTipo3 = new TbPersonalTipo(3,"personalTipo3");

        //Guardamos las tres instancias, guardamos el id del personalTipo1 para usarlo posteriormente 
        idAEliminar = personalTiposDAO.guardar(personalTipo1);
        personalTiposDAO.guardar(personalTipo2);
        personalTiposDAO.guardar(personalTipo3);

        //Modificamos el personalTipo 2 y lo actualizamos 
        personalTipo2.setPetNombre("personalTipo2modif");
        personalTiposDAO.actualizar(personalTipo2);

        //Recuperamos el personalTipo1 de la base de datos 
        personalTipoRecuperado = personalTiposDAO.buscar(idAEliminar);
        System.out.println("Recuperamos a " + personalTipoRecuperado.getPetNombre());

        //Eliminamos al personalTipoRecuperado (que es el personalTipo3) 
        personalTiposDAO.eliminar(personalTipoRecuperado);

        //Obtenemos la lista de personalTipos que quedan en la base de datos y la mostramos 
        List<TbPersonalTipo> listaPersonalTipo = personalTiposDAO.listar();
        System.out.println("Hay " + listaPersonalTipo.size() + "personalTipos en la base de datos");

        for (TbPersonalTipo c : listaPersonalTipo)
        {
            System.out.println("-> " + c.getPetNombre());
        }
        
    }
    
    

}
