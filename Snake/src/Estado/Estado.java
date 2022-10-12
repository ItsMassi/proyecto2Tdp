package Estado;

import Logica.*;
abstract public class Estado {
	protected Criatura criatura;
	protected float velocidad;
	protected EntidadGrafica imagen;
	
	abstract public float getVelocidad();
	abstract public EntidadGrafica getAspecto ();
	
}
