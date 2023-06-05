public class Autocaravana extends Vehiculo{
    private int camasdisp;
    public Autocaravana(String marca, String modelo, int kilometraje, String matricula, float precio, String tipo,int camasdisp){
        super(marca, modelo, kilometraje, matricula, precio, tipo);
        if(camasdisp >=1 && camasdisp <=6){
            this.camasdisp=camasdisp;
        }
        // Es necesario pillar la excepcion?
        else {
            throw new IllegalArgumentException("Valor inválido para camasDisponibles");
        }
        disponible=true; // ??
    }
    // getters y setters


    public int getCamasdisp() {
        return camasdisp;
    }

    public void setCamasdisp(int camasdisp) {
        if(camasdisp >=1 && camasdisp <=6){
            this.camasdisp=camasdisp;
        }
        // Es necesario?
        else {
            throw new IllegalArgumentException("Valor inválido para camasDisponibles");
        }
    }


    // Thats ok?
    @Override
    public float facturaAlquiler(int kms) {
        if(camasdisp >=5 && camasdisp <=6){
            return (precio+(precio*15/100))*kms;
        }
        return precio*kms;
    }
    @Override
    public String toString() {
        String csv;
        csv= "VEHICULO:"+marca+";"+modelo+";"+kilometraje+";"+matricula+";"+precio+";"+disponible+";"+"Autocaravana"+";"+camasdisp;
        return csv;
    }
}

