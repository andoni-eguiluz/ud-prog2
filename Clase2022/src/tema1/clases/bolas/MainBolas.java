package tema1.clases.bolas;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;


import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class MainBolas {

	private static VentanaGrafica v = null;

	// Lista de bolas
	// private static ArrayList<Bola> listaBolas = new ArrayList<Bola>();
	private static GrupoBolas grupoBolas = new GrupoBolas();
	// private static Bola bola1;  // No es necesario si usamos la lista
	
	public static void main(String[] args) {
		// pruebas();
		// mover();
		rebotarBolas();
	}
	
	private static void rebotarBolas() {
		v = new VentanaGrafica( 1000, 600, "Bolitas" );
		// v.getJFrame().setLocation( 2000, 0 );  // Segunda pantalla (solo si se tiene)
		// Bola bola1 = new Bola( 200, 500, -900, 100, 25, Color.CYAN, Color.GREEN );
		grupoBolas.anyadir( new Bola( 200, 500, -900, 100, 25, Color.CYAN, Color.GREEN ) );
		// Bola bola2 = new Bola(300, 300, 100, 100, 20, Color.BLUE, Color.YELLOW );
		grupoBolas.anyadir( new Bola(300, 300, 100, 100, 20, Color.BLUE, Color.YELLOW ) );
		double tiempoSgs = 0.01;
		long tiempoMsgs = (long) (tiempoSgs * 1000);
		// BUCLE DE TIEMPO REAL
		// INPUT - PROCESS - OUTPUT
		while (!v.estaCerrada()) {
			if ( v.getCodUltimaTeclaTecleada()==KeyEvent.VK_PLUS ) {  // Tecla +
				// Crear bola nueva
				// System.out.println( "Tecla +" );
				// Bola bola3 = new Bola( v );  // Nueva bola aleatoria
				grupoBolas.anyadir( new Bola( v ) );
			}
			Point click = v.getRatonPulsado();
			if (click!=null) {
				System.out.println( "Click en " + click );
				int bolaEnClick = grupoBolas.buscaBolaEnPunto( click );
				if (bolaEnClick!=-1) {
					System.out.println( "Pulsada bola " + bolaEnClick );
					grupoBolas.coger(bolaEnClick).borrar(v);
					// Lo que es lo mismo que:
					// Bola b = grupoBolas.coger( bolaEnClick );
					// b.borrar( v );
					grupoBolas.borrar( bolaEnClick );
				}
			}
			
			// Mover y rebotar en bordes
			// bola1.mueveYRebota( v, tiempoSgs );
			// bola2.mueveYRebota( v, tiempoSgs );
			// if (bola3!=null) { bola3.mueveYRebota(v, tiempoSgs ); }
	
			grupoBolas.mueveYRebotaEnBordes( v, tiempoSgs );
			
			// Choque y rebote entre bolas
			// if (bola1.hayChoqueConBola(bola2)) {
			//	// Rebote
			//	bola1.setvX( -bola1.getvX() );
			//	bola1.setvY( -bola1.getvY() );
			//	bola2.setvX( -bola2.getvX() );
			//	bola2.setvY( -bola2.getvY() );
			// }
			grupoBolas.calculaChoques();
			
			v.espera( tiempoMsgs );
		}
	}
	
//	private static void mover() {
//		VentanaGrafica v = new VentanaGrafica( 1000, 600, "Bolitas" );
//		v.getJFrame().setLocation( 2000, 0 );
//		bola1 = new Bola( 100, 100 );
//		bola1.dibujar( v );
//		for (int i=0; i<100; i++) {
//			bola1.borrar( v );
//			bola1.setX( 100 + i );
//			bola1.setY( 100 + i );
//			bola1.dibujar( v );
//			v.espera( 20 );
//		}
//	}
//	
//	private static void pruebas() {
//		// bola1 = new Bola( 100, 150, 0, 0, 10, Color.BLUE, Color.WHITE );
//		bola1 = new Bola( 100, 100 );
//		System.out.println( bola1.getRadio() );
//		Bola bola2 = new Bola();
//		if (bola2.equals(bola1)) {
//			System.out.println( "Son iguales" );
//		}
//		if (bola1.equals(bola2)) {
//			System.out.println( "Son iguales" );
//		}
//		System.out.println( bola1 );
//	}
}
