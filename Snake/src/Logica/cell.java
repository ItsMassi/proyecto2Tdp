//Dani
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.net.URL;

public class cell extends Entidad{
    Posicion pos;
    String url;

    cell(int x, int y) {
        pos = new Posicion(x, y);
        url = App.class.getResource("bgcell.png").getPath();
    }

    public Posicion getPos() {
        return pos;
    }

    public String getUrl() {
        return url;
    }
}
