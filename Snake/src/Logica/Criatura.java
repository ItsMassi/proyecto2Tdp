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
	private Jugador jugador;
	
	//cuando se rea se crea en estado normal
	public Criatura (Jugador jugador, int orientacion, Estado estado, PositionList<Posicion> posiciones) {
		this.jugador = jugador;
		this.orientacion = orientacion;
		miCuerpo = new DoubleLinkedList <Parte> ();
		Iterator <Posicion>  it = posiciones.iterator();
		miEstado = estado; 
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
	
	public Jugador getJugador() {return jugador;}
	
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
	
	public Parte getCabeza() {
		Parte cabeza=null;
		try {
			 cabeza = miCuerpo.first().element();
		} catch (EmptyListException e) {e.printStackTrace();}
		return cabeza;
	}
	
	public Posicion getMovimiento (int o) {
		Posicion pos = null;
			switch (o) {
				case 1: {pos = desplazarEnY(1);
				break;}
				case -1: {pos = desplazarEnY(-1);
				break;}
				case 2: {pos = desplazarEnX(1);
				break;}
				case -2: {pos = desplazarEnY(-1);
				break;}
			}
		
		return pos;		
	}
	
	private Posicion desplazarEnX (int desplazar) {	
		Parte cabeza = getCabeza();
		int x = cabeza.getPosicion().getX() + desplazar;
		return new Posicion (x, cabeza.getPosicion().getY());
	}
	
	private Posicion desplazarEnY (int desplazar) {
		Parte cabeza = getCabeza();
		int y = cabeza.getPosicion().getY() + desplazar;
		return new Posicion (cabeza.getPosicion().getX(), y);
	}
	
	private void mover (Posicion p) {
		Parte nuevaCabeza = new Parte (p.getX(), p.getY(), getCabeza().getEntidadGrafica());
		miCuerpo.addFirst(nuevaCabeza);
		
		try {
			if (enReserva == 0) {
				Parte cola = miCuerpo.remove(miCuerpo.last());
				cola.setPosicion(0,0);
				cola.setEntidadGrafica(null);
			}
			else 
				enReserva--;
		} catch (InvalidPositionException | EmptyListException e) {e.printStackTrace();}
		
		
	}
	
	public Criatura moverArriba (Entidad entidad) {
		if (orientacion != -1) {
			Posicion PosNuevaCabeza = desplazarEnY(1);
			mover (PosNuevaCabeza);
			orientacion = 1;
		} 
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public Criatura moverAbajo (Entidad entidad) {
		if (orientacion != -1) {
			Posicion PosNuevaCabeza = desplazarEnY(-1);
			mover (PosNuevaCabeza);
			orientacion = 1;
		} 
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public Criatura moverIzquierda (Entidad entidad) {
		if (orientacion != -1) {
			Posicion PosNuevaCabeza = desplazarEnX(1);
			mover (PosNuevaCabeza);
			orientacion = 1;
		} 
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public Criatura moverDerecha (Entidad entidad) {
		if (orientacion != -1) {
			Posicion PosNuevaCabeza = desplazarEnX(-1);
			mover (PosNuevaCabeza);
			orientacion = 1;
		} 
		
		entidad.accept(miVisitor);
		
		return this;
	}
	
	public void accept (Visitor visitor) {
		visitor.visit(this);
	}


	

	
}
