package Logica;
import Estado.*;
import TDALista.*;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

//Dani
public class Nivel {
  Jugador jugador = new Jugador();
  LevelReader reader = new LevelReader(2);
  Entidad[][] nivel = new Entidad[20][20];
  File[] arr = reader.getDirImagenes().listFiles();
  String urlCelda = "";
  String urlAlimento = "";
  String urlPowerup = "";
  String urlPared = "";
  String urlCuerpo = "";
  Criatura criatura;

  /*
   * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   * ALERTA IMPORTANTE ALERTA IMPORTANTE ALERTA IMPORTANTE ALERTA IMPORTANTE ALERTA IMPORTANTE 
   * POR AHORA EL CONSTRUCTOR SOLO CREA UN NIVEL VACIO MAS ADELANTE HAY QUE CORREGIR
   * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  */
  public Nivel(int stage) {
    //buscamos los componentes de las imagenes
    for (int i = 0; i < arr.length; i++) {

      System.out.println("empieza a asignar las imagenes");
      if (arr[i].getAbsolutePath().contains("bgcell")) {
        urlCelda = arr[i].getAbsolutePath();
        //System.out.println(urlCelda);
      }

      if (arr[i].getAbsolutePath().contains("foodcell")) {
        urlAlimento = arr[i].getAbsolutePath();
        //System.out.println(urlAlimento);
      }

      if (arr[i].getAbsolutePath().contains("pucell")) {
        urlPowerup = arr[i].getAbsolutePath();
        //System.out.println(urlPowerup);
      }

      if (arr[i].getAbsolutePath().contains("wallcell")) {
        urlPared = arr[i].getAbsolutePath();
        //System.out.println(urlPared);
      }

      if(arr[i].getAbsolutePath().contains("bodycell")){
        urlCuerpo = arr[i].getAbsolutePath();
        //System.out.println(urlCuerpo);
      }
    }
    nivel = reader.buildNivel(this,stage);
    //creamos el estado de la criatura
    Estado est = new EstadoNormal(new EntidadGrafica(urlCuerpo));

    //creamos la criatura
    PositionList<Posicion> lista = new DoubleLinkedList<Posicion>();
    lista.addLast(new Posicion(10, 10));
    lista.addLast(new Posicion(11, 10));
    lista.addLast(new Posicion(12, 10));

    criatura = new Criatura (jugador, 1, est,  lista);
    Iterator<Parte> iterador = criatura.getCuerpo();
    while (iterador.hasNext()) {
      Parte parte = iterador.next();
      nivel[parte.getPosicion().getX()][parte.getPosicion().getY()] = parte;
    }

    //inicializamos la lista
    /* 
    nivel = new Entidad[20][20];
    for (int x = 0; x < nivel.length; x++) {
      for (int y = 0; y < nivel[0].length; y++) {
        nivel[x][y] = new Celda(x, y, new EntidadGrafica(urlCelda));
      }
    }*/
    
  }
  
  //FALTA CORREGIR
  public void actualizar(){
    Iterator<Parte> iterador = criatura.getCuerpo();
    while (iterador.hasNext()) {
      Parte parte = iterador.next();
      nivel[parte.getPosicion().getX()][parte.getPosicion().getY()] = parte;
    }
  }
  public void modificar(int x, int y, Entidad ent) {
    nivel[x][y] = ent;
  }

  public Nivel buildNivel(int stage) {
    nivel = reader.buildNivel(this,stage);
    return this;
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
    return 20;
  }

  public int getColumnas() {
    return 20;
  }

  public Entidad getEntidad(int x, int y) {
    return nivel[x][y];
  }

  public void display() {
    System.out.println("Iniciando Display=====================");


          System.out.println("URL base:     +");
        System.out.println(urlAlimento);
        System.out.println(urlPared);
        System.out.println(urlCelda);
        System.out.println("+++++++++++++++++++++++++++++++++");
        
    for (int i = 0; i < nivel.length; i++) {
      // Loop through all elements of current row
      for (int j = nivel[i].length - 1; j >= 0; j--) {
        System.out.println(nivel[i][j].getEntidadGrafica().getURL());
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
    Nivel nivel = new Nivel(1);
    //nivel.buildNivel();
    nivel.display();

    System.out.println(
      "Fin de la ejecución |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
    );
  }
}
