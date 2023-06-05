import java.util.Comparator;

public class ComparadorCamasDisp implements Comparator<Autocaravana> {
    @Override
    public int compare(Autocaravana j1, Autocaravana j2){
        return Integer.compare(j2.getCamasdisp(),j1.getCamasdisp());
    }
}
