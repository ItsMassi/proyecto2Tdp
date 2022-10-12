package Estado;



import Logica.App;
import Logica.Criatura;
import Logica.EntidadGrafica;

public class EstadoNormal extends Estado {
	protected Criatura criatura;
	protected static final EntidadGrafica look = new EntidadGrafica(App.class.getResource("LookNormal.png"));
	protected static final float velocidad = 1;
	
	public EstadoNormal (Criatura c) {
		criatura = c;
		criatura.setEstado(this);
		criatura.lookear();
	}
	
	public float getVelocidad() {return velocidad;}
	public EntidadGrafica getAspecto () {return look;}

}
