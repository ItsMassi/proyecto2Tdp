package Logica;

import Estado.Estado;
import Visitor.Visitor;

public class Alimento extends Comida{
    protected int tamano;
	protected int puntaje;
	protected boolean consumido;
	protected EntidadGrafica imagen;

	protected Posicion pos;
	protected boolean superponer;

	
    public Alimento(int x, int y, int t, int p, EntidadGrafica i) {
		pos = new Posicion(x, y);
		tamano = t;
		puntaje = p;
		consumido = false;
		imagen = i;
		superponer = true;
	}
    public int getPuntaje(){
		return puntaje;
	}
    public int getTamano() {
		return tamano;
	}
    public boolean getConsumido(){
		return consumido;
	}
    public void setConsumido(){
		consumido = true;
	}
    public  void accept (Visitor visitor) {
    	visitor.visit(this);
    }
    public EntidadGrafica getEntidadGrafica() {
    	return imagen;
    }
    public void setPosicion (int x, int y) {
    	pos.setX(x);
    	pos.setY(y);
    }
    public void  setEntidadGrafica(EntidadGrafica i) {
    	imagen = i;
    } 

    public  Posicion getPosicion() {
    	return pos;
    }
  
	public boolean esColisionable() {
		return superponer;
	}
}
