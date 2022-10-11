//Dani
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.net.URL;

public class LevelReader {

  LinkedList<Entry<Integer, Integer>> comida = new LinkedList<>(); //coleccion de ubicacion de comida  [no usado hasta tener clase comida]
  LinkedList<Entry<Integer, Integer>> muro = new LinkedList<>(); //por ahora no usado mas delante lo usaremos
  char[][] map;

  public LevelReader() {
    URL url = App.class.getResource("PlanosNivel.txt"); //busca el archivo dentro del pc
    File file = new File(url.getPath()); // abrimos el archivo dentro de java
    try {
      //prepara el archivo
      Scanner scan = new Scanner(file);

      int ancho = Integer.parseInt(scan.nextLine()); // Esto es X
      int alto = Integer.parseInt(scan.nextLine()); // Esto es Y
      int cantMuros = Integer.parseInt(scan.nextLine());
      map = new char[ancho][alto];

      //comienza a leer el archivo
      int y = map[0].length - 1;
      while (scan.hasNextLine()) {

        //como construimos de arriba a abajo empezamos por la fila de mas arriba del texto
        String linea = scan.nextLine();

        //leemos cada linea de izquierda a dercha
        for (int x = 0; x < linea.length(); x++) {
          map[x][y] = linea.charAt(x);
          if (map[x][y] == 'o') {
            comida.add(new Entry<Integer, Integer>(x, y));
          }
          if (map[x][y] == 'x') {
            muro.add(new Entry<Integer, Integer>(x, y));
          }
          System.out.println(
            "Posicion: (" + x + "," + y + ") | char: " + map[x][y]
          );
        }
        //cuando termina cambiamos a la linea de abajo
        y--;
      }

      System.out.println("=================NIVEL CARGADO=================");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Entidad[][] buildNivel(Nivel nivel){

    URL url = App.class.getResource("PlanosNivel.txt"); //busca el archivo dentro del pc
    File file = new File(url.getPath()); // abrimos el archivo dentro de java
    try {
      //prepara el archivo
      Scanner scan = new Scanner(file);

      int ancho = Integer.parseInt(scan.nextLine()); // Esto es X
      int alto = Integer.parseInt(scan.nextLine()); // Esto es Y
      int cantMuros = Integer.parseInt(scan.nextLine());

      //comienza a leer el archivo
      int y = nivel.getAlto() - 1;
      while (scan.hasNextLine()) {

        //como construimos de arriba a abajo empezamos por la fila de mas arriba del texto
        String linea = scan.nextLine();

        //leemos cada linea de izquierda a dercha
        for (int x = 0; x < linea.length(); x++) {
          char caracter = linea.charAt(x);
          if (caracter == 'o') {
            nivel.modificar(x, y, new Alimento(x,y));
          }else
          if(caracter == '#'){
            nivel.modificar(x, y, new cell(x,y));
          }else{
            nivel.modificar(x, y, new Pared(x,y));
          }
          System.out.println(
            "Posicion: (" + x + "," + y + ") | char: " + caracter
          );
        }
        //cuando termina cambiamos a la linea de abajo
        y--;
      }

      System.out.println("=================NIVEL CONSTRUIDO=================");
    } catch (Exception e) {
      e.printStackTrace();
    }

    return nivel.getNivel();
  }

  public void display() {
    for (int i = 0; i < map.length; i++) {
      // Loop through all elements of current row
      for (int j = map[i].length - 1; j >= 0; j--) {
        //System.out.println("Posicion: ("+i +","+j);
        System.out.print(map[i][j]);
      }

      System.out.println();
    }
    System.out.println("Mapa de: " + map.length + "x" + map[0].length);
    System.out.println("Cant de comida: " + comida.size());
    System.out.println("Cant de muros: " + muro.size());
    System.out.println("comida (1,18): " + map[1][18]); //deberia ser 'o'
    System.out.println("(0,19): " + map[0][19]); //deberia ser 'a'
    System.out.println("(19,19): " + map[19][19]); //deberia ser 'b'
    System.out.println("(0,0): " + map[0][0]); //deberia ser 'c'
    System.out.println("(19,0): " + map[19][0]); //deberia ser 'd'
    
  }

  public static void main(String[] args) {
    LevelReader lvl = new LevelReader();
    lvl.display();
  }
}
