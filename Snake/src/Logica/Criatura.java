package Logica;


import java.util.Iterator;

import Estado.*;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
import TDALista.*;
import Visitor.*;




public class Criatura {
	
	
	protected int orientacion;
	protected PositionList<Parte> miCuerpo;
	protected Estado miEstado;
	protected Visitor miVisitor;
	private int enReserva=0;
	
	//cuando se rea se crea en estado normal
	public Criatura (int orientacion, EntidadGrafica look, Estado estado, Visitor visitor, PositionList<Posicion> posiciones) {
		this.orientacion = orientacion;
		miCuerpo = new DoubleLinkedList <Parte> ();
		miEstado = new EstadoNormal (this); 
		Iterator <Posicion>  it = posiciones.iterator();
		while (it.hasNext()) {
			Posicion p = it.next();
			miCuerpo.addLast(new Parte (p.getX(), p.getY(), miEstado.getAspecto()));
		}
		miVisitor = new VisitorCriatura(this);
	}
	
	
	public void setOrientacion (int orientacion) {this.orientacion = orientacion;}
		
	public void setEstado (Estado estado) {miEstado=estado;}

	public int getOrientacion () {return orientacion;}
	
	public Iterator<Parte> getCuerpo () {return miCuerpo.iterator();}
	
	public Estado getEstado () {return miEstado;}
	
	
	public void lookear () {
		EntidadGrafica imagen = miEstado.getAspecto();
		Iterator <Parte>  it = miCuerpo.iterator();
		while (it.hasNext()) {
			it.next().setEntidadGrafica(imagen);
		}
	}
	
	public 	Criatura comer (Comida c) {
		try {
			Parte cola = miCuerpo.last().element();
			for (int i=0; i< c.getTamano(); i++) {
					miCuerpo.addLast(cola);
					enReserva ++;
			}
		} catch (EmptyListException e) {e.printStackTrace();}
		
		return this;
	}
		
	public void morir () {
		while (!miCuerpo.isEmpty()) {
			try {
				Parte p = miCuerpo.remove(miCuerpo.first());
				p.setPosicion(0, 0);
				p.setEntidadGrafica(null);
			} catch (EmptyListException | InvalidPositionException e) {e.printStackTrace();} 
		}
	}
	
	private Posicion desplazarEnX (Parte cabeza, int desplazar) {	
		int x = cabeza.getPosicion().getX() + desplazar;
		return new Posicion (x, cabeza.getPosicion().getY());
	}
	
	private Posicion desplazarEnY (Parte cabeza, int desplazar) {
		int y = cabeza.getPosicion().getY() + desplazar;
		return new Posicion (cabeza.getPosicion().getX(), y);
	}
	
	private void mover (Posicion p, EntidadGrafica imagenCabeza) {
		Parte nuevaCabeza = new Parte (p.getX(), p.getY(), imagenCabeza);
		miCuerpo.addFirst(nuevaCabeza);
		
		try {
			if (enReserva==0) {
				Parte cola = miCuerpo.remove(miCuerpo.last());
				cola.setPosicion(0,0);
				cola.setEntidadGrafica(null);
			}
			else 
				enReserva--;
		} catch (InvalidPositionException | EmptyListException e) {e.printStackTrace();}
		
		
	}
	
	public Criatura moverArriba (Entidad entidad) {
		try {
			if (orientacion != -1) {
				Parte cabeza = miCuerpo.first().element();	
				Posicion PosNuevaCabeza = desplazarEnY(cabeza, 1);
				mover (PosNuevaCabeza , cabeza.getEntidadGrafica());
				orientacion = 1;
			} 
		} catch (EmptyListException e) {e.printStackTrace();}
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public Criatura moverAbajo (Entidad entidad) {
		try {
			if (orientacion != 1) {
				Parte cabeza = miCuerpo.first().element();	
				Posicion PosNuevaCabeza = desplazarEnY(cabeza, -1);
				mover (PosNuevaCabeza , cabeza.getEntidadGrafica());
				orientacion = - 1;
			}
		} catch (EmptyListException e) {e.printStackTrace();}
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public Criatura moverIquierda (Entidad entidad) {
		try {
			if (orientacion != 2) {
				Parte cabeza = miCuerpo.first().element();	
				Posicion PosNuevaCabeza = desplazarEnX(cabeza, -1);
				mover (PosNuevaCabeza , cabeza.getEntidadGrafica());
				orientacion = -2;
			}
		} catch (EmptyListException e) {e.printStackTrace();}
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public Criatura moverDerecha (Entidad entidad) {
		try {
			if (orientacion != -2) {
				Parte cabeza = miCuerpo.first().element();	
				Posicion PosNuevaCabeza = desplazarEnX(cabeza, 1);
				mover (PosNuevaCabeza , cabeza.getEntidadGrafica());
				orientacion = 2;
			}
		} catch (EmptyListException e) {e.printStackTrace();}
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public void accept (Visitor visitor) {
		visitor.visit(this);
	}
	
}
