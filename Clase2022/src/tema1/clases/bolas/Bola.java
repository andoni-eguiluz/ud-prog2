package tema1.clases.bolas;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Bola {
	private static Random random = new Random();
	private static Color[] colores = { Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.BLACK }; 
	
	// Inicializador static - solo 1 vez al principio
//	static {
//		random = new Random();
//	}
	
	private double xCentro;  // x del centro
	private double yCentro;  // y del centro
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
	
	/** Crea una bola nueva con datos aleatorios
	 * Posición: dentro de la ventana
	 * Radio: entre 10 y 20 pixels
	 * Velocidad x,y: entre 10 y 100 pixels por segundo (signo aleatorio + o -)
	 * Color de borde y fondo: aleatorios entre los colores amarillo, rojo, verde, azul, cyan, magenta, negro
	 * @param v	Ventana en la que crear la bola
	 */
	public Bola(VentanaGrafica v) {
		radio = random.nextInt(11) + 10;
		xCentro = random.nextInt(v.getAnchura()-radio-radio) + radio;
		yCentro = random.nextInt(v.getAltura()-radio-radio) + radio;
		vX = random.nextInt(91) + 10;
		vY = random.nextInt(91) + 10;
		if (random.nextBoolean()) {
			vX = -vX;
		}
		if (random.nextBoolean()) {
			vY = -vY;
		}
		colorBorde = colores[ random.nextInt(colores.length) ];
		colorFondo = colores[ random.nextInt(colores.length) ];
	}

	public double getX() {
		return xCentro;
	}
	
	public void setX(double x) {
		this.xCentro = x;
	}

	public double getY() {
		return yCentro;
	}

	public void setY(double y) {
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
	

	
	
	// METODO BLOQUEANTE -- No devuelve el control de forma inmediata (OJO!)

	// Cómo funciona tiempo y frecuencia de refresco?  Son inversos
	// Por ejemplo si quiero moverme a 100 píxeles por segundo:
	// Pausa 10 msgs = 0.010 sgs -> 100 fps -> ¿cuántos avanzo en cada f? 1
	// Pausa 40 msgs = 0.040 sgs -> 25 fps ->                             4
	// Pausa               x sgs -> y fps ->                              100/y = 100*x
	/** Mueve la bola y la rebota en los bordes hasta que se 
	 * cierre la ventana. NO DEVUELVE EL CONTROL HASTA QUE
	 * LA VENTANA SE CIERRA
	 * @param v
	 */
	public void mueveYRebota( VentanaGrafica v ) {
		double tiempoSegs = 0.01;
		long tiempoMsgs = (long) (tiempoSegs * 1000);
		dibujar( v );
		while (!v.estaCerrada()) {
			// ESPERA
			borrar( v );  // 1. Borramos
			// 2. Movemos
			System.out.println( "Antes " + getX() + "," + getY() + " - nuevo x = " + ((getvX()*tiempoSegs) + getX()) );
			setX( (getvX()*tiempoSegs) + getX() );  // x = x + vX;  // x += vX;
			setY( (getvY()*tiempoSegs) + getY() );
			System.out.println( "Después " + getX() + "," + getY() );
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
			// System.out.println( "Tiempo " + tiempoSegs + " - en milis " + tiempoMsgs + " x = " + xCentro );
		}
	}
	
	/** Mueve la bola un intervalo de tiempo y la rebota con los 
	 * bordes si procede
	 * @param v	Ventana en la que se mueve y rebota
	 * @param tiempoSegs	Tiempo transcurrido en segundos
	 */
	public void mueveYRebota( VentanaGrafica v, double tiempoSegs ) {
		borrar( v );  // 1. Borramos
		// 2. Movemos
		setX( (getvX()*tiempoSegs) + getX() );  // x = x + vX;  // x += vX;
		setY( (getvY()*tiempoSegs) + getY() );
		// 3. Detectamos choques
		if (hayChoqueHorizontal(v)) {
			vX = -vX;
		}
		if (hayChoqueVertical(v)) {
			vY = -vY;
		}
		// 4. Dibujamos
		dibujar( v );
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
	
	public boolean hayChoqueVertical( VentanaGrafica vent ) {
		return (yCentro <= radio) || (yCentro >= vent.getAltura() - radio);
	}
	
	/** Comprueba choque de la bola con otra
	 * @param otraBola	Bola con la que comprobar
	 * @return	true si se tocan, false si no
	 */
	public boolean hayChoqueConBola(Bola otraBola) {
		double ladox = this.xCentro - otraBola.xCentro;
		double ladoy = this.yCentro - otraBola.yCentro;
		double dist = Math.sqrt( ladox*ladox + ladoy*ladoy );
		return dist <= radio + otraBola.radio;
	}

	/** Comprueba si un punto de ventana está dentro
	 * de la bola
	 * @param punto Punto a comprobar
	 * @return	true si está dentro, false si no
	 */
	public boolean contieneAPunto( Point punto ) {
		// TODO
		double ladox = xCentro - punto.x;
		double ladoy = yCentro - punto.y;
		double dist = Math.sqrt( ladox*ladox + ladoy*ladoy );
		return dist <= radio;
	}
	
}
