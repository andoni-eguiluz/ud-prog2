package tema1.clases.bolas;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Bola {
	private int xCentro;  // x del centro
	private int yCentro;  // y del centro
	private int vX;
	private int vY;
	private int radio;
	private Color colorFondo;
	private Color colorBorde;
	
	public Bola(int x, int y, int vX, int vY, int radio, Color colorFondo, Color colorBorde) {
		this.xCentro = x;
		this.yCentro = y;
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
		return xCentro;
	}

	public void setX(int x) {
		this.xCentro = x;
	}

	public int getY() {
		return yCentro;
	}

	public void setY(int y) {
		this.yCentro = y;
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
		return this.xCentro==bola2.xCentro && this.yCentro==bola2.yCentro && this.colorBorde.equals(bola2.colorBorde);
	}

	@Override
	public String toString() {
		return "Bola [x=" + xCentro + ", y=" + yCentro + ", radio=" + radio + "]";
	}

	public void dibujar( VentanaGrafica v ) {
		v.dibujaCirculo( this.getX(), this.getY(), this.getRadio(), 2.0f, this.getColorBorde(), this.getColorFondo() );
	}
	
	public void borrar( VentanaGrafica v ) {
		v.dibujaCirculo( this.getX(), this.getY(), this.getRadio(), 2.0f, Color.WHITE, Color.WHITE );
	}
	
	// Pausa 10 msgs -> 100 fps -> 100 px/seg --> ¿cuánto avanzo en cada f? 1
	// Pausa 40 msgs -> 25 fps ->                                           4
	// Pausa x msgs  --> y fps ->                                           100/y = 100*x
	public void mueveYRebota( VentanaGrafica v ) {
		double tiempoSegs = 0.01;
		long tiempoMsgs = (long) (tiempoSegs * 1000);
		dibujar( v );
		while (!v.estaCerrada()) {
			borrar( v );  // 1. Borramos
			// 2. Movemos
			setX( (int) (getvX()*tiempoSegs) + getX() );  // x = x + vX;  // x += vX;
			setY( (int) (getvY()*tiempoSegs) + getY() );
			// 3. Detectamos choques
			if (hayChoqueHorizontal(v)) {
				vX = -vX;
			}
			if (hayChoqueVertical(v)) {
				vY = -vY;
			}
			// 4. Dibujamos
			dibujar( v );
			// 5. Esperamos
			v.espera( tiempoMsgs );
			System.out.println( "Tiempo " + tiempoSegs + " - en milis " + tiempoMsgs + " x = " + xCentro );
		}
	}
	
	public boolean hayChoqueHorizontal(VentanaGrafica v) {
		if (xCentro <= radio) {
			return true;
		}
		if (xCentro >= v.getAnchura() - radio) {
			return true;
		}
		return false;
	}
	
	public boolean hayChoqueVertical( VentanaGrafica v ) {
		return (yCentro <= radio) || (yCentro >= v.getAltura() - radio);
	}
	
}
