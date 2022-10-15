package Logica;
import GUI.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HiloCriatura extends Thread {
	GUI gui = null;
	Criatura criatura = null;
	public void run(){
			gui.getPane().setFocusable(true);
			gui.getPane().addKeyListener(new KeyListener() {
				public void keyPressed (KeyEvent e) {
					Nivel nivel = gui.getNivel();
					Criatura criatura = gui.getCriatura();
					int key = e.getKeyCode();
					Parte cola=null;
					Iterator <Parte> it =  criatura.getCuerpo();
					while(it.hasNext()) {
						cola = it.next();
					}
					System.out.println("cola dentro Gui: " + cola.getPosicion().getX());
					int reserva = criatura.getReserva();
					System.out.println("Reserva flecha: " + reserva);
					if(key == KeyEvent.VK_RIGHT) {
						Posicion pos = criatura.getMovimiento(2);
						Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
						criatura.moverDerecha(entidad);
						rePintar(cola.getPosicion(), reserva);
					}
					
					if(key== KeyEvent.VK_LEFT) {
						Posicion pos = criatura.getMovimiento(-2);
						Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
						criatura.moverIzquierda(entidad);
						rePintar(cola.getPosicion(), reserva);
					}
					
					if(key==KeyEvent.VK_UP) {
						Posicion pos = criatura.getMovimiento(1);
						Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
						criatura.moverArriba(entidad);
						rePintar(cola.getPosicion(), reserva);
					}
					
					if(key==KeyEvent.VK_DOWN) {
						Posicion pos = criatura.getMovimiento(-1);
						Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
						criatura.moverAbajo(entidad);
						rePintar(cola.getPosicion(), reserva);
					}
				}
					
	
				@Override
				public void keyTyped (KeyEvent e) {
					// TODO Auto-generated method stub
				}
	
				@Override
				public void keyReleased(KeyEvent e) {
					
				}
	
			});
	}
	
	public void setGui(GUI g) {
		gui = g;
	}
	
	private void rePintar (Posicion posicion, int r) {
		Nivel nivel = gui.getNivel();
	 
		gui.getPane().setVisible(false);
		System.out.println("entidad dentro Gui antes actualizar "+ nivel.getEntidad(posicion.getX(), posicion.getY()).getEntidadGrafica().getURL());


		JPanel contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(new BorderLayout(0, 0));
		gui.setContentPane(contentPane2);
		contentPane2.setLayout(new GridLayout(20,20));

		nivel = nivel.actualizar(posicion,r);
		System.out.println("entidad dentro Gui antes actualizar "+ nivel.getEntidad(posicion.getX(), posicion.getY()).getEntidadGrafica().getURL());
		for(int y=0; y < nivel.getColumnas(); y++) {
			for(int x= 0; x < nivel.getFilas(); x++) {
				System.out.println("Posicion: "+x+" "+y);
				Entidad e = nivel.getEntidad(x, y);
				String imagen= e.getEntidadGrafica().getURL();
				ImageIcon grafico= new ImageIcon(imagen);
				JLabel label=  new JLabel ();
				label.setIcon(grafico);
				contentPane2.add(label);
				
				label.addComponentListener(new ComponentAdapter() {
					public void componentResized(ComponentEvent e) {
						gui.reDimensionar(label,grafico);
						label.setIcon(grafico);
					}
				});
				

			}
		}
		gui.setPane(contentPane2);
		gui.getPane().setVisible(true);
		
	}
	
	
}
