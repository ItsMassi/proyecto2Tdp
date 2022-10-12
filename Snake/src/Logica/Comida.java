package Logica;

import Estado.Estado;
import Visitor.Visitor;

abstract public class Comida extends Entidad{

	public abstract int getPuntaje();
    public abstract int getTamano();
    public abstract boolean getConsumido();
    public abstract void setConsumido();
    public abstract void accept (Visitor visitor);
    public abstract EntidadGrafica  getEntidadGrafica();
    public abstract void  setPosicion (int x, int y);
    public abstract void  setEntidadGrafica(EntidadGrafica i);
    public abstract Posicion getPosicion();
    public abstract boolean esColisionable();

}

