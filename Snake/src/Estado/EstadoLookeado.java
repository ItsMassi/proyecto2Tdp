package Estado;

import Logica.EntidadGrafica;

public class EstadoLookeado extends Estado {
	protected EntidadGrafica look;
	protected static final float velocidad = 1;
	
	public EstadoLookeado (EntidadGrafica look) {
		this.look = look;		
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}


}
