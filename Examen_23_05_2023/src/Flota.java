import com.sun.jdi.FloatValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class Flota {
    private String nombreGerente;
    private String dniGerente;
    private String emailGerente;
    private Map<String, Vehiculo> misVehiculos;

    public Flota(String nombreGerente, String dniGerente, String emailGerente) {
        this.nombreGerente = nombreGerente;
        this.dniGerente = dniGerente;
        this.emailGerente = emailGerente;
        this.misVehiculos= new HashMap<>();
    }
    // Métodos

    public Moto[] motosDisponibles(){
ArrayList<Moto> misMotosDisp = new ArrayList<>();
ArrayList<Vehiculo> misVehiculos = new ArrayList<>(this.misVehiculos.values());
        for (Vehiculo v : misVehiculos) {
            if (v.getTipo().equals("Moto") && v.getDisponible() == true){
                misMotosDisp.add((Moto) v);
            }
        }
        misMotosDisp.sort(new ComparadorCilindrada());
        Moto[] m = new Moto[misMotosDisp.size()];
        return misMotosDisp.toArray(m);

    }
    public Coche[] cochesDisponibles(){
        ArrayList<Coche> misCochesDisp = new ArrayList<>();
        ArrayList<Vehiculo> misVehiculos = new ArrayList<>(this.misVehiculos.values());
        for (Vehiculo v : misVehiculos) {
            if (v.getTipo().equals("Coche") && v.getDisponible() == true){
                misCochesDisp.add((Coche) v);
            }
        }
        misCochesDisp.sort(new ComparadorPrecio());
        Coche[] c = new Coche[misCochesDisp.size()];
        return misCochesDisp.toArray(c);
    }
    public Camioneta[] camionetasDisponibles(){
        ArrayList<Camioneta> misCamionetasDisp = new ArrayList<>();
        ArrayList<Vehiculo> misVehiculos = new ArrayList<>(this.misVehiculos.values());
        for (Vehiculo v: misVehiculos) {
            if (v.getTipo().equals("Camioneta") && v.getDisponible() == true){
                misCamionetasDisp.add((Camioneta)v);
            }
        }
        misCamionetasDisp.sort(new ComparadorPesoMax());

        Camioneta[] c = new Camioneta[misCamionetasDisp.size()];
        return misCamionetasDisp.toArray(c);
    }
    public Autocaravana[] AutocaravanasDisponibles(){
        ArrayList<Autocaravana> misAutocaravanasDisp = new ArrayList<>();
        ArrayList<Vehiculo> misVehiculos = new ArrayList<>(this.misVehiculos.values());
        for (Vehiculo v : misVehiculos) {
            if (v.getTipo().equals("Autocaravana") && v.getDisponible() == true){
                misAutocaravanasDisp.add((Autocaravana) v);
            }
        }
        misAutocaravanasDisp.sort(new ComparadorCamasDisp());
        Autocaravana[] c = new Autocaravana[misAutocaravanasDisp.size()];
        return misAutocaravanasDisp.toArray(c);
    }
    public Vehiculo crearVehiculo(String[] datosAtributos, String tipo){
        switch (tipo){
            case "Moto":{
                // return?
                Moto m = new Moto(datosAtributos[1],datosAtributos[2],Integer.valueOf(datosAtributos[3]),datosAtributos[4],Float.valueOf(datosAtributos[5]),datosAtributos[6],Integer.valueOf(datosAtributos[7]));
                break;
            }
            case "Coche":{
                Coche m = new Coche(datosAtributos[1],datosAtributos[2],Integer.valueOf(datosAtributos[3]),datosAtributos[4],Float.valueOf(datosAtributos[5]),datosAtributos[6],Integer.valueOf(datosAtributos[7]));
                break;
            }
            case "Camioneta":{
                Camioneta m = new Camioneta(datosAtributos[1],datosAtributos[2],Integer.valueOf(datosAtributos[3]),datosAtributos[4],Float.valueOf(datosAtributos[5]),datosAtributos[6],Integer.valueOf(datosAtributos[7]));
                break;
            }
            case "Autocaravana":{
                Autocaravana m = new Autocaravana(datosAtributos[1],datosAtributos[2],Integer.valueOf(datosAtributos[3]),datosAtributos[4],Float.valueOf(datosAtributos[5]),datosAtributos[6],Integer.valueOf(datosAtributos[7]));
                break;
            }
            default:
                System.out.println("Introduzca Moto, Coche, Camioneta o Autocaravana");
        }
        return null;
    }
    public void putVehiculo(Vehiculo v){
        /*
        if(misVehiculos.containsKey(v.getMatricula())){
         misVehiculos.remove(v.getMatricula());
         misVehiculos.put(v.getMatricula(),v);
        }else{
         misVehiculos.put(v.getMatricula(),v);
        }
         */
        // es lo mismo que lo de arriba

        if(misVehiculos.containsKey(v.getMatricula())){
            misVehiculos.remove(v.getMatricula());
        }
        misVehiculos.put(v.getMatricula(), v);
    }
    public float facturarVehiculo(String matricula, int kms){
        Vehiculo v = misVehiculos.get(matricula);
        // Hace falta controlar si la matricula que hemos obtenido no perternece a ningun vehiculo?
        // Es lo mismo que si pongo v? o es diferente
        misVehiculos.get(matricula).setKilometraje(kms);
        misVehiculos.get(matricula).setDisponible(true);
        return (v.facturaAlquiler(kms));
        // hace falta devolver excepcion?
    }
    public boolean alquilarVehiculo(String matricula){
        if (misVehiculos.containsKey(matricula)){
            misVehiculos.get(matricula).setDisponible(false);
            return true;
        }else{
            return false;
        }
    }


    // getters y setters

    public String getNombreGerente() {
        return nombreGerente;
    }

    public String getDniGerente() {
        return dniGerente;
    }

    public String getEmailGerente() {
        return emailGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }

    public void setDniGerente(String dniGerente) {
        this.dniGerente = dniGerente;
    }

    public void setEmailGerente(String emailGerente) {
        this.emailGerente = emailGerente;
    }

    public Map<String, Vehiculo> getMisVehiculos() {
        return misVehiculos;
    }

    @Override
    public String toString() {
       String csv;
       csv=nombreGerente+";"+dniGerente+";"+emailGerente;
       return csv;
    }
}
