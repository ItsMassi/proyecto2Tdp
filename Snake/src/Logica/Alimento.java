//Dani
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.net.URL;

public class Alimento extends Entidad{
    Posicion pos;
    String url;

    Alimento(int x, int y) {
        pos = new Posicion(x, y);
        url = App.class.getResource("foodcell.png").getPath();
    }

    public Posicion getPos() {
        return pos;
    }

    public String getUrl() {
        return url;
    }
}
