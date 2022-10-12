package Logica;

import Visitor.Visitor;

public class Alimento extends Comida{
	protected Posicion pos;
	protected EntidadGrafica imagen;
	protected boolean superponer;
    protected int tama�o;
    protected int consumido;
	

	public int getTama�o() {return tama�o;}
    public  Posicion getPosicion() {return pos;}
    public EntidadGrafica  getEntidadGrafica() {return imagen;}
	public boolean esColisionable() {return superponer;}
    public  void accept (Visitor visitor) {visitor.visit(this);}
}
