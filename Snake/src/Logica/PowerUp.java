package Logica;

import Estado.Estado;
import Visitor.Visitor;

public class PowerUp extends Comida{
	protected Posicion pos;
	protected EntidadGrafica imagen;
	protected boolean superponer;
    protected int tamaño;
    protected int consumido;
    protected Estado estado;
	
    
	
    public  Posicion getPosicion() {return pos;}
    public EntidadGrafica  getEntidadGrafica() {return imagen;}
	public boolean esColisionable() {return superponer;}
	public int getTamaño() {return tamaño;}
	public Estado getEstado() {return estado;}
    public  void accept (Visitor visitor) {visitor.visit(this);}

}
