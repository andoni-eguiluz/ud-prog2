package tema1.clases.bolas;

import java.awt.Point;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class GrupoBolasArrayList {
	private ArrayList<Bola> listaBolas;
	
	public GrupoBolasArrayList() {
		listaBolas = new ArrayList<Bola>();
	}
	
	public void anyadir( Bola bola ) {
		listaBolas.add( bola );
	}
	
	public int tamanyo() {
		return listaBolas.size();
	}
	
	public Bola coger( int indice ) {
		return listaBolas.get( indice );
	}
	
	public void mueveYRebotaEnBordes( VentanaGrafica v, double tiempoSgs ) {
		for (int i=0; i<listaBolas.size(); i++) {
			Bola bola = listaBolas.get(i);
			bola.mueveYRebota( v, tiempoSgs );
		}	
	}
	
	public void calculaChoques() {
		for (int i=0; i<listaBolas.size(); i++) {
			for (int j=i+1; j<listaBolas.size(); j++) {  // i y j no coinciden, son todas las parejas sin repetición
				// System.out.println( "Comparando bola " + i + " con bola " + j );
				Bola bola1 = listaBolas.get(i);
				Bola bola2 = listaBolas.get(j);
				if (bola1.hayChoqueConBola(bola2)) {  // Rebote
					bola1.setvX( -bola1.getvX() );
					bola1.setvY( -bola1.getvY() );
					bola2.setvX( -bola2.getvX() );
					bola2.setvY( -bola2.getvY() );
				}
			}
		}
	}
	
	/** Busca una bola del grupo que contenga
	 * un punto de la ventana
	 * @param punto	Punto a comprobar
	 * @return	El índice de la bola que contiene
	 * ese punto o -1 si ninguna bola está ahí
	 */
	public int buscaBolaEnPunto( Point punto ) {
		for (int i=0; i<listaBolas.size(); i++) {
			Bola bola = listaBolas.get(i);
			if (bola.contieneAPunto(punto)) {
				return i;
			}
		}
		return -1;
	}
	
	public void borrar( int indice ) {
		listaBolas.remove( indice );
	}
	
}
