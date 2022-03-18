package tema2.resueltos.objetodle;

import javax.swing.JOptionPane;

public class MainObjetodle {
	public static void main(String[] args) {
		String[] opciones = new String[] { "Letras", "Dígitos", "Colores" };
		Object elige = JOptionPane.showInputDialog( null, "Elige juego", "Selección", JOptionPane.QUESTION_MESSAGE, null, opciones, "Letras" );
		if ("Letras".equals(elige)) {
			wordleNormal();
		} else if ("Colores".equals(elige)) {
			wordleColor();
		} else if ("Dígitos".equals(elige)) {
			wordleNumeros();
		}
	}
	
	private static void wordleNormal() {
		Elemento[] elementos = new Elemento[26];
		char letra = 'A';
		int indice = 0;
		while (letra <= 'Z') {
			Letra l = new Letra( EstadoElemento.TECLA, letra );
			letra = (char) (letra + 1);
			elementos[indice] = l;
			indice++;
		};
		Opciones opciones = new Opciones( elementos );
		Objetodle o = new Objetodle( opciones );
		o.run();
	}
	
	private static void wordleColor() {
		Elemento[] elementos = {
			new Color( EstadoElemento.TECLA, java.awt.Color.BLUE ),
			new Color( EstadoElemento.TECLA, new java.awt.Color( 0, 150, 0 ) ),  // Verde un poco diferente para no confundirlo con el verde de wordle
			new Color( EstadoElemento.TECLA, java.awt.Color.RED ),
			new Color( EstadoElemento.TECLA, java.awt.Color.CYAN ),
			new Color( EstadoElemento.TECLA, java.awt.Color.YELLOW ),
			new Color( EstadoElemento.TECLA, java.awt.Color.MAGENTA ),
			new Color( EstadoElemento.TECLA, java.awt.Color.WHITE ),
			new Color( EstadoElemento.TECLA, java.awt.Color.PINK ),
			new Color( EstadoElemento.TECLA, java.awt.Color.LIGHT_GRAY ),
		};
		Opciones opciones = new Opciones( elementos );
		Objetodle o = new Objetodle( opciones );
		o.run();
	}
	
	private static void wordleNumeros() {
		Elemento[] elementos = new Elemento[10];
		int indice = 0;
		while (indice < 10) {
			Numero n = new Numero( EstadoElemento.TECLA, indice );
			elementos[indice] = n;
			indice++;
		};
		Opciones opciones = new Opciones( elementos );
		Objetodle o = new Objetodle( opciones );
		o.run();
	}
	
}
