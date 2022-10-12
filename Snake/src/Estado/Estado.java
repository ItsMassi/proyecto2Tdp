package Estado;

import Logica.*;
abstract public class Estado {
	protected Criatura criatura;
	
	abstract public int getVelocidad();
	abstract public EntidadGrafica getAspecto ();
	
}
