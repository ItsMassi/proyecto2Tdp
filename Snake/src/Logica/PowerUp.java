package Logica;

import Estado.Estado;
import Visitor.Visitor;

public class PowerUp extends Comida{
	protected Posicion pos;
	protected EntidadGrafica imagen;
	protected boolean superponer;
    protected int tamano;
    protected boolean consumido;
    protected Estado estado;
    protected int puntaje;
    
    public PowerUp(int t, int p, EntidadGrafica i, Estado e) {
		tamano = t;
		puntaje = p;
		consumido = false;
		imagen = i;
		superponer=true;
		estado = e;
	}
    public void  setPosicion (int x, int y) {
    	pos.setX(x);
    	pos.setY(y);
    }
    public void  setEntidadGrafica(EntidadGrafica i) {
    	imagen = i;
    } 
    public  Posicion getPosicion() {
    	return pos;
    }
    public EntidadGrafica  getEntidadGrafica() {
    	return imagen;
    }
	public boolean esColisionable() {
		return superponer;
	}
	public int getTamano() {
		return tamano;
	}
	public Estado getEstado() {
		return estado;
	}
    public  void accept (Visitor visitor) {
    	visitor.visit(this);
    }
	public int getPuntaje() {
		return puntaje;
	}
	public void setConsumido() {
		consumido = true;
	}

}
