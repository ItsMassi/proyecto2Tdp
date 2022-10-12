package Logica;



import Visitor.Visitor;

public class Parte  extends Entidad{
	protected Posicion pos;
    protected EntidadGrafica imagen;
    protected boolean superponer;

    public Parte (int x, int y, EntidadGrafica i) {
    	pos  = new Posicion (x, y);
    	imagen = i;
    }
    
    public void  setPosicion (int x, int y) {
    	pos.setX(x);
    	pos.setY(y);
    }
    public void  setEntidadGrafica(EntidadGrafica i) {imagen = i;} 
    
    public  Posicion getPosicion() {return pos;}
    public EntidadGrafica  getEntidadGrafica() {return imagen;}
	public boolean esColisionable() {return superponer;}
    public  void accept (Visitor visitor) {visitor.visit(this);}

}