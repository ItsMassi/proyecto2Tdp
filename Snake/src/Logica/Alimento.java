package Logica;

import Estado.Estado;
import Visitor.Visitor;

public class Alimento extends Comida{
	protected Posicion pos;
	protected EntidadGrafica imagen;
	protected boolean superponer;
    protected int tamano;
    protected boolean consumido;
    protected int puntaje;
    protected Estado estado;

	
    public Alimento(int t, int p, EntidadGrafica i, Estado e) {
		tamano = t;
		puntaje = p;
		consumido = false;
		imagen = i;
		superponer = true;
		estado = e;
	}
    public void setPosicion (int x, int y) {
    	pos.setX(x);
    	pos.setY(y);
    }
    public void  setEntidadGrafica(EntidadGrafica i) {
    	imagen = i;
    } 
    public int getPuntaje(){
		return puntaje;
	}
    public void setConsumido(){
		consumido = true;
	}
    public boolean getConsumido(){
		return consumido;
	}
	public int getTamano() {
		return tamano;
	}
    public  Posicion getPosicion() {
    	return pos;
    }
    public EntidadGrafica getEntidadGrafica() {
    	return imagen;
    }
	public boolean esColisionable() {
		return superponer;
	}
    public  void accept (Visitor visitor) {
    	visitor.visit(this);
    }
}
