package Logica;

import Visitor.*;

//Dani
public abstract class Entidad {
    protected Posicion pos;
    protected EntidadGrafica imagen;
    protected boolean superponer;
    
    abstract Posicion getPosicion();
    abstract EntidadGrafica  getEntidadGrafica();
    abstract boolean esColisionable();
    abstract void accept (Visitor visitor);
}
