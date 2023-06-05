public class Moto extends Vehiculo{
    private int cilindrada;
    public Moto(String marca, String modelo, int kilometraje, String matricula, float precio, String tipo,int cilindrada){
        super(marca, modelo, kilometraje, matricula, precio, tipo);
        this.cilindrada=cilindrada;
    }

    @Override
    public float facturaAlquiler(int kms) {
        if (this.cilindrada >= 500){
            return (precio+(precio*20/100))*kms;
        }
        return precio*kms;
    }
    // getters y setters

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        String csv;
        csv= "VEHICULO:"+marca+";"+modelo+";"+kilometraje+";"+matricula+";"+precio+";"+disponible+";"+"Moto"+";"+cilindrada;
        return csv;
    }
}
