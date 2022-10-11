//Dani
import java.util.Comparator;

public class ComparatorJugador implements Comparator<Jugador> {

    @Override
    public int compare(Jugador o1, Jugador o2) {
        return Integer.compare(o1.getPuntaje(), o2.getPuntaje());
    }
    
}
