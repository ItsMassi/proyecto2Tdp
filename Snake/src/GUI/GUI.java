package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Criatura;
import Logica.Jugador;
import Logica.Nivel;

public class GUI extends JFrame {
	//Atributos de instancia 
	private Criatura snake;
	private Jugador player;
	private Cronometro cronometro;
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
		JFrame frame= new JFrame();
		Grilla p= new Grilla();
		frame.add(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snake");
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	

}
