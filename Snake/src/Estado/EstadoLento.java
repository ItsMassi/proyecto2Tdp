package Estado;


import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoLento extends Estado {
	
	protected static final EntidadGrafica look = new EntidadGrafica("");
	protected static final float velocidad = (float) 0.5;
	
	public EstadoLento (Criatura criatura) {
		criatura.setEstado(this);
		criatura.lookear();
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
}
