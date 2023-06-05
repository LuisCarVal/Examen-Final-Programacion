import java.util.Comparator;

public  class ComparadorPrecio implements Comparator<Coche> {
    @Override
    public int compare(Coche j1, Coche j2){
        return Float.compare(j2.getPrecio(),j1.getPrecio());
    }
}
