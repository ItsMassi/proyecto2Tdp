package Estado;

import Logica.EntidadGrafica;

public class EstadoLento extends Estado {
	
	protected EntidadGrafica look;
	protected static final float velocidad = (float) 0.5;
	
	public EstadoLento (EntidadGrafica look) {
		this.look = look;		
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
}
