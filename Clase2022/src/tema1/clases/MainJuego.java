package tema1.clases;

public class MainJuego {
	public static void main(String[] args) {
		Juego miJuego = new Juego( "Tetris" );
		// miJuego.nombre = "Tetris";
		System.out.println( miJuego.nombre );
		miJuego.nombre = "Otro";
		System.out.println( miJuego.edadMinimaRecomendada );
	}
}
