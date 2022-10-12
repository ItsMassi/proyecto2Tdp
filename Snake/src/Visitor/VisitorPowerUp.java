package Visitor;

import Logica.Alimento;
import Logica.Celda;
import Logica.Criatura;
import Logica.Pared;
import Logica.Parte;
import Logica.PowerUp;

public class VisitorPowerUp implements Visitor {
	protected PowerUp power;
	
	public VisitorPowerUp(PowerUp pow) {
		power = pow;
	}
	public void visit(Alimento alimento) {
		
	}
	public void visit(PowerUp power) {
		
	}
	public void visit(Celda cel) {
		
	}
	public void visit(Pared pared) {
		
	}
	public void visit(Parte parte) {
		power.setConsumido();
		power.setPosicion(0, 0);
		power.setEntidadGrafica(null);
		parte.accept(this);
	}
	public void visit(Criatura criature){
		power.setConsumido();
		power.setPosicion(0, 0);
		power.setEntidadGrafica(null);
		criature.accept(this);
	}
}
