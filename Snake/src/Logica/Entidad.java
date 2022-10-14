package Logica;

import Visitor.*;

//Dani
public abstract class Entidad {
 
    abstract void  setPosicion (int x, int y);
    abstract void  setEntidadGrafica(EntidadGrafica i);
    abstract Posicion getPosicion();
    abstract  public EntidadGrafica  getEntidadGrafica();
    abstract boolean esColisionable();
    abstract void accept (Visitor visitor);
}
