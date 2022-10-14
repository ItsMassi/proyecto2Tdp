package Estado;


import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoNormal extends Estado {
	protected EntidadGrafica look;
	protected static final float velocidad = 1;
	
	public EstadoNormal (Criatura criatura, EntidadGrafica look) {
		criatura.setEstado(this);
		this.look = look;
		criatura.lookear();
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}

}
