package Logica;

import Visitor.*;

//Dani
public abstract class Entidad {
    protected Posicion pos;
    protected EntidadGrafica imagen;
    protected boolean superponer;
    
    abstract void  setPosicion (int x, int y);
    abstract void  setEntidadGrafica(EntidadGrafica i);
    abstract Posicion getPosicion();
    abstract  public EntidadGrafica  getEntidadGrafica();
    abstract boolean esColisionable();
    abstract void accept (Visitor visitor);
}
