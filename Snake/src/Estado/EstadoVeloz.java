package Estado;

import Logica.App;
import Logica.Criatura;
import Logica.EntidadGrafica;
 
public class EstadoVeloz extends Estado{
	protected static final EntidadGrafica look = new EntidadGrafica(App.class.getResource("LookVeloz.png"));
	protected static final float velocidad = 2;
	
	public EstadoVeloz (Criatura criatura) {
		criatura.setEstado(this);
		criatura.lookear();
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
}
