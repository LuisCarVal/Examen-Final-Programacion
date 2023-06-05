public class Coche extends Vehiculo{
    int pasajeros;
    public Coche(String marca, String modelo, int kilometraje, String matricula, float precio, String tipo,int pasajeros){
        super(marca, modelo, kilometraje, matricula, precio, tipo);
        if (pasajeros>=2 && pasajeros <=7){
            this.pasajeros=pasajeros;
        }else{
            this.pasajeros=5;
        }

    }



    // getters y setters

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        if(pasajeros>=2 && pasajeros<=7){
            this.pasajeros = pasajeros;
        }

    }

    @Override
    public  float facturaAlquiler(int kms) {
        if(this.pasajeros >=6 && this.pasajeros <=7){
            return (precio+(precio*10/100))*kms;
        }
        return precio*kms;
    }
    @Override
    public String toString() {
        String csv;
        csv= "VEHICULO:"+marca+";"+modelo+";"+kilometraje+";"+matricula+";"+precio+";"+disponible+";"+"Coche"+";"+pasajeros;
        return csv;
    }
}
