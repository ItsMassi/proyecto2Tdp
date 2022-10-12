package Estado;

import Logica.App;
import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoMuerta extends Estado {
	protected Criatura criatura;
	protected static final EntidadGrafica look = null;
	protected static final int velocidad = 0;
	
	public EstadoMuerta (Criatura c) {
		criatura = c;
		criatura.morir();
	}
	
	public int getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
	
	
}
