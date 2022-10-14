package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Nodo.*;
import Logica.Criatura;
import Logica.Entidad;
import Logica.Jugador;
import Logica.Nivel;
import Logica.Parte;
import Logica.Posicion;

public class GUI extends JFrame {
	private Criatura criatura;
	private Jugador player;
	//private Cronometro cronometro;
	private Nivel nivel;


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			//PARA CAMBIAR EL NIVEL, CAMBIA EL NUMERO DE ACA ABAJO
		  nivel = new Nivel (1);
		 criatura = nivel.getCriatura();
		contentPane.setLayout(new GridLayout(20,20));
		
		for(int y=0; y < nivel.getColumnas(); y++) {
			for(int x= 0; x < nivel.getFilas(); x++) {
				Entidad e = nivel.getEntidad(x, y);
				String imagen= e.getEntidadGrafica().getURL();
				ImageIcon grafico= new ImageIcon(imagen);
				JLabel label=  new JLabel ();
				label.setIcon(grafico);
				contentPane.add(label);
				
				label.addComponentListener(new ComponentAdapter() {
					public void componentResized(ComponentEvent e) {
						reDimensionar(label,grafico);
						label.setIcon(grafico);
					}
				});
				
				
			}
		}
		
		contentPane.setFocusable(true);
		contentPane.addKeyListener(new KeyListener() {
			public void keyPressed (KeyEvent e) {
				int key = e.getKeyCode();
				Parte cola=null;
				Iterator <Parte> it =  criatura.getCuerpo();
				while(it.hasNext()) {
					cola = it.next();
				}
				System.out.println("cola dentro Gui: "+ cola.getPosicion().getX());
				int reserva = criatura.getReserva();
				System.out.println("Reserva flecha: "+reserva);
				if(key == KeyEvent.VK_RIGHT) {
					/*
					 * Iterator <Parte> it =  criatura.getCuerpo();
					 * while (it.hasNext()) {
						//Parte nuevaCabeza = it.next();
						//System.out.println(nuevaCabeza.getPosicion().getX() + ", " + nuevaCabeza.getPosicion().getY());
						}
					*/
					Posicion pos = criatura.getMovimiento(2);
					Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
					criatura.moverDerecha(entidad);
					rePintar(cola.getPosicion(), reserva);
				}
				
				if(key== KeyEvent.VK_LEFT) {
					Posicion pos = criatura.getMovimiento(-2);
					Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
					criatura.moverIzquierda(entidad);
				}
				
				if(key==KeyEvent.VK_UP) {
					Posicion pos = criatura.getMovimiento(1);
					Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
					criatura.moverArriba(entidad);
				}
				
				if(key==KeyEvent.VK_DOWN) {
					Posicion pos = criatura.getMovimiento(-1);
					Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
					criatura.moverAbajo(entidad);
				}
				
			}

			@Override
			public void keyTyped (KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			private void rePintar (Posicion posicion, int r) {

				contentPane.setVisible(false);
				System.out.println("entidad dentro Gui antes actualizar "+ nivel.getEntidad(posicion.getX(), posicion.getY()).getEntidadGrafica().getURL());


				JPanel contentPane2 = new JPanel();
				contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane2.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane2);
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
								reDimensionar(label,grafico);
								label.setIcon(grafico);
							}
						});
						
						
					}
				}

				contentPane = contentPane2;
				contentPane.setVisible(true);
			}
		});
				
	}
	
	
	private void rePintar (Posicion posicion, int r) {
		System.out.println("REserva dentro Gui "+r);
		nivel = nivel.actualizar(posicion,r);
		for(int y=0; y < nivel.getColumnas(); y++) {
			for(int x= 0; x < nivel.getFilas(); x++) {
				System.out.println("Posicion: "+x+" "+y);
				Entidad e = nivel.getEntidad(x, y);
				String imagen= e.getEntidadGrafica().getURL();
				ImageIcon grafico= new ImageIcon(imagen);
				JLabel label=  new JLabel ();
				label.setIcon(grafico);
				contentPane.add(label);
				
				label.addComponentListener(new ComponentAdapter() {
					public void componentResized(ComponentEvent e) {
						reDimensionar(label,grafico);
						label.setIcon(grafico);
					}
				});
				
				
			}
		}
	}
	
	private void reDimensionar(JLabel label , ImageIcon  grafico){
		Image image= grafico.getImage();
		if(image!=null) {
			Image newing = image.getScaledInstance(label.getWidth(),label.getHeight() ,java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newing);
			
		}
		
	}
	
}
	
