public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int kilometraje;
    protected String matricula;
    protected float precio;
    protected String tipo;
    protected boolean disponible;

    public Vehiculo(String marca, String modelo, int kilometraje, String matricula, float precio, String tipo) { // boolean disponible se pondria?
        this.marca = marca;
        this.modelo = modelo;
        if (kilometraje <0){
            this.kilometraje=0;
        }else{
            this.kilometraje= kilometraje;
        }
        this.matricula = matricula;
        this.precio = precio;
        this.tipo = tipo;
        this.disponible = true; // está bien poner true?
    }

    // Métodos

    abstract public float facturaAlquiler(int kms);


    // getters y setters

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getMatricula() {
        return matricula;
    }

    public float getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    // Comprobamos que al usar el set, el numero siempre sea positivo igual o mayor a 0
    public void setKilometraje(int kilometraje) {
        if (kilometraje>=0){
            this.kilometraje += kilometraje;
        }
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    // no se si está bien hecho así
    public String toString(){
        String csv;
        csv= "VEHICULO:"+this.marca+";"+this.modelo+";"+this.kilometraje+";"+this.matricula+";"+this.precio+";"+this.disponible+";"+this.tipo;
        return csv;
    }
}
