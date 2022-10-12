package Logica;

import java.net.URL;

//Dani
public class Nivel {

  Entidad[][] nivel;
  LevelReader reader = new LevelReader(1);
  String[] arr = reader.getDirImagenes().list();
  String urlCelda = "";
  String urlAlimento = "";
  String urlPowerup = "";
  String urlPared = "";
  Criatura criatura;

  public Nivel() {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].contains("bgcell")) {
        urlCelda = arr[i];
      }

      if (arr[i].contains("foodcell")) {
        urlAlimento = arr[i];
      }

      if (arr[i].contains("pucell")) {
        urlPowerup = arr[i];
      }

      if (arr[i].contains("wallcell")) {
        urlPared = arr[i];
      }
    }

    nivel = new Entidad[20][20];
    for (int x = 0; x < nivel.length; x++) {
      for (int y = 0; y < nivel[0].length; y++) {
        nivel[x][y] = new Celda(x, y, new EntidadGrafica(urlCelda));
      }
    }
  }

  public void modificar(int x, int y, Entidad ent) {
    nivel[x][y] = ent;
  }

  public void buildNivel() {
    nivel = reader.buildNivel(this);
  }

  public Posicion generatePosicionValida() { //<-dentro de esto una entidad
    //crea una posicion random para la comida
    int posX = (int) ((Math.random() * (19 - 1)) + 1);
    int posY = (int) ((Math.random() * (19 - 1)) + 1);
    //dentro del while reemplazar por un visitor
    while (!nivel[posX][posY].esColisionable()) { //si es una pared
      //haces reroll
      posX = (int) ((Math.random() * (19 - 1)) + 1);
      posY = (int) ((Math.random() * (19 - 1)) + 1);
    }

    return new Posicion(posX, posY);
  }

  public void agregarComida() {
    Posicion posicion = generatePosicionValida();
    nivel[posicion.getX()][posicion.getY()] =
      new Alimento(
        posicion.getX(),
        posicion.getY(),
        1,
        100,
        new EntidadGrafica(urlAlimento)
      );
  }

  public Entidad[][] getNivel() {
    return nivel;
  }
  
  public Criatura getCriatura () {
	  return criatura;
  }
  public int getFilas() {
    return nivel.length;
  }

  public int getColumnas() {
    return nivel[0].length;
  }

  public Entidad getEntidad(int x, int y) {
    return nivel[x][y];
  }

  public void display() {
    System.out.println("Iniciando Display=====================");

    /*
         * System.out.println("URL base:     +");
        System.out.println(urlAlimento);
        System.out.println(urlPared);
        System.out.println(urlcell);
        System.out.println("+++++++++++++++++++++++++++++++++");
        */
    for (int i = 0; i < nivel.length; i++) {
      // Loop through all elements of current row
      for (int j = nivel[i].length - 1; j >= 0; j--) {
        //System.out.println("Posicion: ("+i +","+j);
        if (nivel[i][j].getEntidadGrafica().getURL().equals(urlAlimento)) {
          System.out.print('o');
          //System.out.println(" = "+ nivel[i][j].getUrl());
        } else if (nivel[i][j].getEntidadGrafica().getURL().equals(urlPared)) {
          System.out.print('x');
          // System.out.println(" = "+ nivel[i][j].getUrl());
        } else if (nivel[i][j].getEntidadGrafica().getURL().equals(urlCelda)) {
          System.out.print('#');
          //System.out.println(" = "+ nivel[i][j].getUrl());
        } else {
          System.out.print("S");
          //System.out.println(" = "+ nivel[i][j].getUrl());
        }
      }

      System.out.println();
    }
    System.out.println("nivela de: " + nivel.length + "x" + nivel[0].length);
    //System.out.println("Cant de comida: " + comida.size());
    //System.out.println("Cant de muros: " + muro.size());
    System.out.println(
      "comida (1,18): " + nivel[1][18].getEntidadGrafica().getURL()
    ); //deberia ser '@'
    System.out.println("(0,19): " + nivel[0][19].getEntidadGrafica().getURL()); //deberia ser 'a'
    System.out.println(
      "(19,19): " + nivel[19][19].getEntidadGrafica().getURL()
    ); //deberia ser 'b'
    System.out.println("(0,0): " + nivel[0][0].getEntidadGrafica().getURL()); //deberia ser 'c'
    System.out.println("(19,0): " + nivel[19][0].getEntidadGrafica().getURL()); //deberia ser 'd'
  }

  public static void main(String[] args) {
    Nivel nivel = new Nivel();
    nivel.buildNivel();
    nivel.display();

    System.out.println(
      "Fin de la ejecución |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
    );
  }
}
