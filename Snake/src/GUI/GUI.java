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
import Logica.HiloCriatura;
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
		nivel = new Nivel (5);
		criatura = nivel.getCriatura();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 456, 469);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
				//PARA CAMBIAR EL NIVEL, CAMBIA EL NUMERO DE ACA ABAJO
			 
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
			
			HiloCriatura hilo= new HiloCriatura();
			hilo.setGui(this);
			hilo.start();
			System.out.println(" +++++++++++ " + hilo.isAlive());
				
	}
	
	
	public void rePintar (Posicion posicion, int r) {

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
	
	public void reDimensionar(JLabel label , ImageIcon  grafico){
		Image image= grafico.getImage();
		if(image!=null) {
			Image newing = image.getScaledInstance(label.getWidth(),label.getHeight() ,java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newing);
			
		}
		
	}

	public JPanel getPane() {return contentPane;}
	public void setPane(JPanel c) {contentPane=c;}
	public Criatura getCriatura() {return criatura;}
	public Nivel getNivel() {return nivel;}
}
	
