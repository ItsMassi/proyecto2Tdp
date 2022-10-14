package Estado;


import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoNormal extends Estado {
	protected EntidadGrafica look;
	protected static final float velocidad = 1;
	
<<<<<<< HEAD
	public EstadoNormal (Criatura criatura, EntidadGrafica look) {
		this.look = look;
		criatura.setEstado(this);
		criatura.lookear();
=======
	public EstadoNormal (EntidadGrafica look) {
		this.look = look;		
>>>>>>> 4091d7c5b1a98fbc5dfc562ddc8a473509c1f3c5
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}

}
