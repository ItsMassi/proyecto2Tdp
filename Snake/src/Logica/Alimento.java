package Logica;

import Visitor.Visitor;

public class Alimento extends Comida{
	protected Posicion pos;
	protected EntidadGrafica imagen;
	protected boolean superponer;
    protected int tamano;
    protected int consumido;
	
    // constructor con posicion y entidadGrafica
    
    public void  setPosicion (int x, int y) {
    	pos.setX(x);
    	pos.setY(y);
    }
    public void  setEntidadGrafica(EntidadGrafica i) {imagen = i;} 
    
	public int getTamano() {return tamano;}
    public  Posicion getPosicion() {return pos;}
    public EntidadGrafica  getEntidadGrafica() {return imagen;}
	public boolean esColisionable() {return superponer;}
    public  void accept (Visitor visitor) {visitor.visit(this);}
}
