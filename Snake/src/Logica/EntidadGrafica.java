package Logica;

import java.net.URL;

public class EntidadGrafica {

	private URL url;
	
	public EntidadGrafica (URL url) {
		this.url=url;
	}
	
	public void setURL(URL url) {
		this.url=url;
	}
	
	public URL getURL () {return url;}
	
}
