package Estado;

import java.net.URL;

import Logica.App;
import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoNormal extends Estado {
	protected Criatura criatura;
	protected static final EntidadGrafica look = new EntidadGrafica(App.class.getResource("LookNormal.png"));
	protected static final int velocidad = 1;
	
	public EstadoNormal (Criatura c) {
		criatura = c;
		criatura.setLook();
	}
	
	public int getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}
	
	
}
