package Logica;
import GUI.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class HiloCriatura extends Thread {
	GUI gui = null;
	Criatura criatura = null;
	Nivel nivel;
	
	public HiloCriatura () {
			
	}
	
	public void run(){
		while (true) {
	
		}
	}
	
	private void leerTeclas() {
		InputMap inputMap = gui.getPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = gui.getPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "mover derecha");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "mover izquierda");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "mover arriba");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "mover abajo"); 

        actionMap.put("mover derecha", new Movimiento("DERECHA"));
        actionMap.put("mover izquierda", new Movimiento("IZQUIERDA"));
        actionMap.put("mover arriba", new Movimiento("ARRIBA"));
        actionMap.put("mover abajo", new Movimiento("ABAJO"));
	}
	
	
	public void setGui(GUI g) {
		gui = g;
		leerTeclas();
	}
	
	private void rePintar (Posicion posicion, int r) {
		Nivel nivel = gui.getNivel();
	 
		gui.getPane().setVisible(false);
		//System.out.println("entidad dentro Gui antes actualizar "+ nivel.getEntidad(posicion.getX(), posicion.getY()).getEntidadGrafica().getURL());


		JPanel contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(new BorderLayout(0, 0));
		gui.setContentPane(contentPane2);
		contentPane2.setLayout(new GridLayout(20,20));

		nivel = nivel.actualizar(posicion,r);
		//System.out.println("entidad dentro Gui antes actualizar "+ nivel.getEntidad(posicion.getX(), posicion.getY()).getEntidadGrafica().getURL());
		for(int y=0; y < nivel.getColumnas(); y++) {
			for(int x= 0; x < nivel.getFilas(); x++) {
				//System.out.println("Posicion: "+x+" "+y);
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
		leerTeclas();
	}

	private class Movimiento extends AbstractAction {
		String s;
		public Movimiento (String s) {
			this.s = s;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ENTREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			Nivel nivel = gui.getNivel();
			Criatura criatura = gui.getCriatura();
			Parte cola=null;
			int reserva = criatura.getReserva();
			Iterator <Parte> it =  criatura.getCuerpo();
			while(it.hasNext()) {
				cola = it.next();
			}
			if (s=="DERECHA") {
				
				Posicion pos = criatura.getMovimiento(2);
				Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
				criatura.moverDerecha(entidad);
				rePintar(cola.getPosicion(), reserva);
			}
			
			if (s=="IZQUIERDA") {
				Posicion pos = criatura.getMovimiento(-2);
				Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
				criatura.moverIzquierda(entidad);
				rePintar(cola.getPosicion(), reserva);
			}
			
			if (s=="ARRIBA") {
				Posicion pos = criatura.getMovimiento(1);
				Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
				criatura.moverArriba(entidad);
				rePintar(cola.getPosicion(), reserva);
			}
			
			if (s=="ABAJO") {
				Posicion pos = criatura.getMovimiento(-1);
				Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
				criatura.moverAbajo(entidad);
				rePintar(cola.getPosicion(), reserva);
			}
			
		}
		
		
	}
}
	

