package Logica;
//Dani
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.net.URL;

public class Celda extends Entidad{
    Posicion pos;
    String url;
    protected boolean superponer;

    Celda(int x, int y) {
        pos = new Posicion(x, y);
        url = App.class.getResource("bgcell.png").getPath();
    }

    public Posicion getPos() {
        return pos;
    }

    public String getURL() {
        return url;
    }
}
