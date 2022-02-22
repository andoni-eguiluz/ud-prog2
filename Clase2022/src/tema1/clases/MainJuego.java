package tema1.clases;

public class MainJuego {
	public static void main(String[] args) {
		Juego miJuego = new Juego( "Tetris" );
		// miJuego.nombre = "Tetris";
		System.out.println( miJuego.getNombre() );
		// miJuego.nombre = "Otro";
		// miJuego.setNombre( "Otro" );  -- no escribo este método
		miJuego.setNumHorasJugadas( -10 );
		System.out.println( miJuego.getEdadMinimaRecomendada() );
		System.out.println( miJuego.getNumHorasJugadas() );
		Juego miJuego2 = new Juego( "Mario", -15 );
		System.out.println( miJuego2.getNumHorasJugadas() );
		Juego miJuego3 = null;
		// NO - Error de ejecución - miJuego3.setNumHorasJugadas( 100 );
		miJuego.setPrecioFinal( 12.10 );
		System.out.println( miJuego.getPrecioFinal() );
		System.out.println( miJuego.getPrecioSinIva() );
		Juego miJuego4 = null;
		miJuego3 = new Juego( "Monkey Island", 150 );
		miJuego4 = new Juego( "Monkey Island", 150 );
		if (miJuego3.equals(miJuego4)) {
			System.out.println( "Juego 3 y 4 son iguales" );
		}
		System.out.println( miJuego4 );
	}
}
