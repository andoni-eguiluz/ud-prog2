package tema1.clases.bolas;

import java.awt.Point;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class GrupoBolas {
	
	public static final int MAX_NUM_BOLAS = 1000;

	private Bola[] arrayBolas;   // null
	private int numBolas;
	
	/** Crea un nuevo grupo con capacidad máxima de MAX_NUM_BOLAS (por defecto)
	 */
	public GrupoBolas() {
		arrayBolas = new Bola[MAX_NUM_BOLAS];
		numBolas = 0;
		// Se crea relleno de nulls
	}
	
	/** Crea un nuevo grupo de capacidad máxima configurable
	 * @param capacidadMaxima	Capacidad máxima de este grupo
	 */
	public GrupoBolas( int capacidadMaxima ) {
		arrayBolas = new Bola[capacidadMaxima];
		numBolas = 0;
	}
	
	/** Añade una bola nueva
	 * Si no cabe, se saca error a consola y NO SE AÑADE
	 * @param bola	Bola a añadir
	 */
	public void anyadir( Bola bola ) {
		if (numBolas==arrayBolas.length) {
			System.err.println( "Grupo lleno: no se puede añadir bola");
			return;
		}
		arrayBolas[numBolas] = bola;
		numBolas++;
	}
	
	/** Devuelve el número de bolas contenidas en el grupo
	 * @return	Número actual de bolas
	 */
	public int tamanyo() {
		return numBolas;
	}
	
	/** Devuelve la capacidad máxima de este grupo de bolas
	 * @return	Número máximo de bolas que se podrán guardar
	 */
	public int tamanyoMaximo() {
		return arrayBolas.length;
	}
	
	public Bola coger( int indice ) {
		return arrayBolas[indice];
	}
	
	public void mueveYRebotaEnBordes( VentanaGrafica v, double tiempoSgs ) {
		for (int i=0; i<numBolas; i++) {
			Bola bola = arrayBolas[i];
			bola.mueveYRebota( v, tiempoSgs );
		}	
	}
	
	public void calculaChoques() {
		for (int i=0; i<numBolas; i++) {
			for (int j=i+1; j<numBolas; j++) {  // i y j no coinciden, son todas las parejas sin repetición
				// System.out.println( "Comparando bola " + i + " con bola " + j );
				Bola bola1 = arrayBolas[i];
				Bola bola2 = arrayBolas[j];
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
		for (int i=0; i<numBolas; i++) {
			Bola bola = arrayBolas[i];
			if (bola.contieneAPunto(punto)) {
				return i;
			}
		}
		return -1;
	}
	
	public void borrar( int indice ) {
		// Esto no vale:
		// arrayBolas[indice] = null;
		for (int i=indice+1; i<numBolas; i++) {
			arrayBolas[i-1] = arrayBolas[i];
		}
		arrayBolas[numBolas-1] = null;
		numBolas--;
	}
	
}
