package tema2.resueltos.brickBreaker;

import java.awt.Color;
import java.awt.Font;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class BloqueRompible extends Bloque {
	
	private int vida;
	
	public BloqueRompible(double x, double y, double ancho, double alto, Color color, Color colorFondo) {
		super(x, y, ancho, alto, 0, 0, color, colorFondo);
	}

	/** Crea un bloque rompible sin movimiento de tamaño 100x60
	 * @param x	Coord x del centro
	 * @param y	Coord y del centro
	 * @param color	color de borde
	 * @param colorFondo	color de fondo
	 * @param vida	Vida inicial del bloque
	 */
	public BloqueRompible( double x, double y, Color color, Color colorFondo, int vida ) {
		super( x, y, 100, 60, color, colorFondo );
		this.vida = vida;
	}
	
	@Override
	public void dibujar(VentanaGrafica v) {
		if (vida>0) {
			super.dibujar(v);  // Dibuja el bloque (como lo hace la clase padre)
			// Dibujar el texto
			Font tipo = new Font( "Arial", Font.PLAIN, 40 );
			v.dibujaTextoCentrado( x-ancho/2, y-alto/2, ancho, alto, vida + "", tipo, Color.BLACK, true );
		}
	}

		private ObjetoAnimacion bolaDeChoque = null;
	@Override
	public boolean chocaCon(ObjetoAnimacion objeto2) {
		boolean hayChoque = super.chocaCon(objeto2);
		if (hayChoque) {
			if (objeto2!=bolaDeChoque) {
				vida--;
			}
			bolaDeChoque = objeto2;
			System.out.println( "Consulta " + objeto2 );
		}
		return hayChoque;
	}

	
}
