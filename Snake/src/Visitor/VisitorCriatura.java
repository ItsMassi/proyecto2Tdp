package Visitor;

import Logica.Alimento;
import Logica.Celda;
import Logica.Criatura;
import Logica.Pared;
import Logica.Parte;
import Logica.PowerUp;

public class VisitorCriatura implements Visitor {
	Criatura criatura;
	
	public VisitorCriatura (Criatura c) {
		criatura = c;
	}
	
	public void visit (Alimento alimento) {
		criatura.comer(alimento);
		criatura.getJugador().setPuntaje (alimento.getPuntaje());
	}
	
	public void visit (PowerUp powerUp) {
		criatura.comer (powerUp);
		criatura.setEstado (powerUp.getEstado());
		criatura.getJugador().aumentarPuntaje (powerUp.getPuntaje());
	}
	
	public void visit (Celda celda) {}
	
	public void visit (Pared pared) {
		criatura.morir();
	}
	
	public void visit (Parte parte) {
		criatura.morir();
	}
	
	public void visit (Criatura criatura) {}
}
