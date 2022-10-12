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
	
    
// constructor con posicion y entidadGrafica
    
    public void  setPosicion (int x, int y) {
    	pos.setX(x);
    	pos.setY(y);
    }
    public void  setEntidadGrafica(EntidadGrafica i) {imagen = i;} 
    
    public  Posicion getPosicion() {return pos;}
    public EntidadGrafica  getEntidadGrafica() {return imagen;}
	public boolean esColisionable() {return superponer;}
	public int getTamaño() {return tamaño;}
	public Estado getEstado() {return estado;}
    public  void accept (Visitor visitor) {visitor.visit(this);}

}
