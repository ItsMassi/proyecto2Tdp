package Logica;

import Visitor.Visitor;

abstract public class Comida extends Entidad{

    public abstract int getTamano();
    public abstract void  setPosicion (int x, int y);
    public abstract void  setEntidadGrafica(EntidadGrafica i);
    public abstract Posicion getPosicion();
    public abstract EntidadGrafica  getEntidadGrafica();
    public abstract boolean esColisionable();
    public abstract void accept (Visitor visitor);
    public abstract int getPuntaje();
	public abstract void setConsumido();
}

