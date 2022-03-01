package tema1.clases.bolas;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class MainBolas {

	private static VentanaGrafica v = null;
	private static Bola bola1;
	
	public static void main(String[] args) {
		// pruebas();
		// mover();
		rebotarBolas();
	}
	
	private static void rebotarBolas() {
		v = new VentanaGrafica( 1000, 600, "Bolitas" );
		v.getJFrame().setLocation( 2000, 0 );  // Segunda pantalla
		bola1 = new Bola( 200, 200, -500, 50, 25, Color.CYAN, Color.GREEN );
		bola1.mueveYRebota( v );
		Bola bola2 = new Bola(300, 300, 100, 100, 20, Color.BLUE, Color.YELLOW );
		bola2.mueveYRebota( v );
	}
	
	private static void mover() {
		VentanaGrafica v = new VentanaGrafica( 1000, 600, "Bolitas" );
		v.getJFrame().setLocation( 2000, 0 );
		bola1 = new Bola( 100, 100 );
		bola1.dibujar( v );
		for (int i=0; i<100; i++) {
			bola1.borrar( v );
			bola1.setX( 100 + i );
			bola1.setY( 100 + i );
			bola1.dibujar( v );
			v.espera( 20 );
		}
	}
	
	private static void pruebas() {
		// bola1 = new Bola( 100, 150, 0, 0, 10, Color.BLUE, Color.WHITE );
		bola1 = new Bola( 100, 100 );
		System.out.println( bola1.getRadio() );
		Bola bola2 = new Bola();
		if (bola2.equals(bola1)) {
			System.out.println( "Son iguales" );
		}
		if (bola1.equals(bola2)) {
			System.out.println( "Son iguales" );
		}
		System.out.println( bola1 );
	}
}
