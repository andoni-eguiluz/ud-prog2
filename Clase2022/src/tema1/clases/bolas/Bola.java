package tema1.clases.bolas;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Bola {
	private int x;
	private int y;
	private int vX;
	private int vY;
	private int radio;
	private Color colorFondo;
	private Color colorBorde;
	
	public Bola(int x, int y, int vX, int vY, int radio, Color colorFondo, Color colorBorde) {
		this.x = x;
		this.y = y;
		this.vX = vX;
		this.vY = vY;
		this.radio = radio;
		this.colorFondo = colorFondo;
		this.colorBorde = colorBorde;
	}

	/** Crea una bola nueva sin velocidad, con radio 10, fondo blanco y borde azul
	 * @param x	Coordenada x del centro de la bola
	 * @param y	Coordenada y del centro de la bola
	 */
	public Bola(int x, int y) {
		this( x, y, 0, 0, 10, Color.WHITE, Color.BLUE );
//		this.x = x;
//		this.y = y;
//		this.vX = 0;
//		this.vY = 0;
//		this.radio = 10;
//		colorFondo = Color.WHITE;
//		colorBorde = Color.BLUE;
	}
	
	/** Crea una bola nueva en las coordenadas 100,100, sin velocidad, con radio 10, fondo blanco y borde azul
	 */
	public Bola() {
		this( 100, 100, 0, 0, 10, Color.WHITE, Color.BLUE );
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getvX() {
		return vX;
	}

	public void setvX(int vX) {
		this.vX = vX;
	}

	public int getvY() {
		return vY;
	}

	public void setvY(int vY) {
		this.vY = vY;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}

	public Color getColorBorde() {
		return colorBorde;
	}

	public void setColorBorde(Color colorBorde) {
		this.colorBorde = colorBorde;
	}
	
	@Override
	public boolean equals(Object obj) {
		Bola bola2 = (Bola) obj;
		return this.x==bola2.x && this.y==bola2.y && this.colorBorde.equals(bola2.colorBorde);
	}

	@Override
	public String toString() {
		return "Bola [x=" + x + ", y=" + y + ", radio=" + radio + "]";
	}

	public void dibujar( VentanaGrafica v ) {
		v.dibujaCirculo( this.getX(), this.getY(), this.getRadio(), 2.0f, this.getColorBorde(), this.getColorFondo() );
	}
	
	public void borrar( VentanaGrafica v ) {
		v.dibujaCirculo( this.getX(), this.getY(), this.getRadio(), 2.0f, Color.WHITE, Color.WHITE );
	}
	
}
