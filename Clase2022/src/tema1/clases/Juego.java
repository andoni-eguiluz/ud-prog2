package tema1.clases;

import java.util.Date;

public class Juego {
	
	// STATIC
	public static int numTotalHorasJugadas;
	
	
	// NO STATIC 
	
	public String nombre = "default";
	public String genero;
	public int edadMinimaRecomendada;
	public Date fechaCompra;
	public int numHorasJugadas;
	
	public Juego( String pNombre ) {
		nombre = pNombre;
	}
	
}
