package Visitor;

import Logica.Alimento;
import Logica.Celda;
import Logica.Criatura;
import Logica.Pared;
import Logica.Parte;
import Logica.PowerUp;

public class VisitorAlimento implements Visitor{
	protected Alimento alimento;
	
	public VisitorAlimento(Alimento a) {
		alimento = a;
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
		alimento.setConsumido();
		alimento.setEntidadGrafica(null);
		alimento.setPosicion(0,0);
		parte.accept(this);
	}
	public void visit(Criatura criature) {
		alimento.setConsumido();
		alimento.setEntidadGrafica(null);
		alimento.setPosicion(0,0);
		criature.accept(this);
	}
}
