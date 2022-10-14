package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Criatura;
import Logica.Entidad;
import Logica.Jugador;
import Logica.Nivel;
import Logica.Posicion;

public class gui extends JFrame {
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
					gui frame = new gui();
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
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 
		 criatura = nivel.getCriatura();
		contentPane.setLayout(new GridLayout(20,20));
		
		for(int x=0; x < nivel.getFilas(); x++) {
			for(int y= 0; y < nivel.getColumnas(); y++) {
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
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_RIGHT) {
			Posicion pos = criatura.getMovimiento(2);
			Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
			criatura.moverDerecha(entidad);
		}
		
		if(key== KeyEvent.VK_LEFT) {
			Posicion pos = criatura.getMovimiento(-2);
			Entidad entidad = nivel.getEntidad(pos.getX(),pos.getY());
			criatura.moverIquierda(entidad);
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
}
	
