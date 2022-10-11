//Dani
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ranking {
    List<Jugador> rank = new LinkedList<Jugador>();

    public void agregar(Jugador j){
        ComparatorJugador comparator = new ComparatorJugador();
        if(rank.size()>=10){//si hay mas de 10 puntajes guardados
            rank.add(j);
            rank.sort(comparator);
            rank.remove(rank.size()-1);//elimina el ultimo de la lista
        }else{
            rank.add(j);
            rank.sort(comparator);
        }
    }

    public List<Jugador> getRank() {
        return rank;
    }

    public void display(){
        for(int i = 0; i < 4; i++){
            Jugador j = rank.get(i);
            System.out.println(j.getNombre()+" | " +j.getPuntaje());
        }
    }
}
