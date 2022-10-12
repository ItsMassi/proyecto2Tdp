package Logica;
//Dani
import java.io.File;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        java.net.URL url = App.class.getResource("PlanosNivel.txt");//busca el archivo dentro del pc
        File file = new File(url.getPath());// abrimos el archivo dentro de java
        Scanner scan = new Scanner(file);
        
        char [][] map = new char[20][20];



        //comienzo de level Reader
        int y = 19;
        while (scan.hasNextLine()) {
            //como construimos de arriba a abajo empezamos por la fila de mas arriba
            String linea = scan.nextLine();
            //leemos cada linea de izquierda a dercha
            for(int x = 0; x < linea.length(); x++){
                map[x][y] = linea.charAt(x);
                System.out.println("Posicion: ("+x +","+y+") | char: "+map[x][y]);
            }
            //cuando termina cambiamos a la linea de abajo
            y--;
        }

        for (int i = 0; i < map.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < map[i].length; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
        System.out.println("Mapa de: "+map.length+"x"+map[0].length);
    }
}
