package Logica;
//Dani
public class Jugador{
    private int puntaje;
    private String nombre;
    private int cronometro;
    private Nivel nivel;

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void aumentarPuntaje(int puntaje) {
        this.puntaje += puntaje;    	
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTiempo(int t) {
        cronometro = t;
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }
    public int getTiempo() {
        return cronometro;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public Nivel getNivel() {
        return nivel;
    }

}
