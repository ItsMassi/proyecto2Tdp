import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class  Grilla  extends JPanel{
	private static final long serialVersionUID=1L;
	private static final int WIDTH=400;
	private static final int HEIGHT=400;


public Grilla() {
	setPreferredSize(new Dimension (WIDTH, HEIGHT));
}

public void grilla(Graphics g) {
	g.clearRect(0, 0, WIDTH, HEIGHT);
	g.setColor(Color.pink);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
	for(int i=0;i<WIDTH/20;i++) {
		g.drawLine(i*20, 0, i*20, HEIGHT);
	}
	for(int i=0;i<HEIGHT/20;i++) {
		g.drawLine(0, i*20, HEIGHT, i*20);
	}
}

}