public class Camioneta extends Vehiculo{
    private int pesomax;
    public Camioneta(String marca, String modelo, int kilometraje, String matricula, float precio, String tipo,int pesomax){
        super(marca, modelo, kilometraje, matricula, precio, tipo);
        if (pesomax >= 3500 && pesomax<= 7500){
            this.pesomax=pesomax;
        }
        /*
        else {
            throw new IllegalArgumentException("Valor inválido para pesoMaximo");
        }
         */

    }
    //getters y setters


    public int getPesomax() {
        return pesomax;
    }

    public void setPesomax(int pesomax) {
        if (pesomax >= 3500 && pesomax <=7500){
            this.pesomax=pesomax;
        }
        // pillar IllegalArgumentException?
    }

    @Override
    public float facturaAlquiler(int kms) {
        if (pesomax >= 5000 && pesomax <=7500){
            return (precio+(precio*30/100))*kms;
        }
        return precio*kms;
    }
    @Override
    public String toString() {
        String csv;
        csv= "VEHICULO:"+marca+";"+modelo+";"+kilometraje+";"+matricula+";"+precio+";"+disponible+";"+"Camioneta"+";"+pesomax;
        return csv;
    }
}
