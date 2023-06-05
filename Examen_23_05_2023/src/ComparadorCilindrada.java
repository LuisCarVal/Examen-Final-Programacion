import java.util.Comparator;

public  class ComparadorCilindrada  implements Comparator<Moto> {
    @Override
    public int compare(Moto j1, Moto j2){
        return Integer.compare(j2.getCilindrada(),j1.getCilindrada());
    }
}
