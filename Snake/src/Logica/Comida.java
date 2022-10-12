package Logica;


import Visitor.Visitor;



abstract public class Comida extends Entidad{
    protected Posicion pos;
    protected EntidadGrafica imagen;
    protected boolean superponer;
    protected int tama�o;
    protected int consumido;
    

    abstract int getTama�o();
    abstract Posicion getPosicion();
    abstract EntidadGrafica  getEntidadGrafica();
    abstract boolean esColisionable();
    abstract void accept (Visitor visitor);
    
}
