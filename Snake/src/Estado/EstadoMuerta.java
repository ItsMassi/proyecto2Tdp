package Estado;

import Logica.App;
import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoMuerta extends Estado {
	protected static final EntidadGrafica look = null;
	protected static final float velocidad = 0;
	
	public EstadoMuerta (Criatura criatura) {
		criatura.setEstado(this);
		criatura.morir();
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
	
	
}
