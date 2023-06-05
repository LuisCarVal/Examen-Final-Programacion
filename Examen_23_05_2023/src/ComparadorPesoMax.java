import java.util.Comparator;

public class ComparadorPesoMax implements Comparator<Camioneta> {
    @Override
    public int compare(Camioneta j1, Camioneta j2){
        return Integer.compare(j2.getPesomax(),j1.getPesomax());
    }
}
