package Estado;

import Logica.EntidadGrafica;

public class EstadoVeloz extends Estado{
	protected EntidadGrafica look;
	protected static final float velocidad = 2;
	
	public EstadoVeloz (EntidadGrafica look) {
		this.look = look;		
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
}
