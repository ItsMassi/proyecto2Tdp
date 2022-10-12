package Logica;

import java.net.URL;

public class Parte  extends Entidad{
    protected Posicion posicion;
    protected EntidadGrafica imagen;
    protected static final boolean superponer = false;

    Parte(Posicion p, EntidadGrafica imagen) {
        pos = p;
        this.imagen = imagen;
    }
    
    public void setPosicion(Posicion pos) {
        posicion = pos;
    }

    public void setEntidadGrafica(EntidadGrafica imagen) {
    	 this.imagen = imagen;
    }
    
    public boolean esColisionable () {return superponer;}
    
    public Posicion getPos() {
        return posicion;
    }

    public	EntidadGrafica getEntidadGrafica() {
        return imagen;
    }

}