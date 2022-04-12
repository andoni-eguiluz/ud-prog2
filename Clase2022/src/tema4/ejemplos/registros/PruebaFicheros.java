package tema4.ejemplos.registros;

import java.text.ParseException;

public class PruebaFicheros {
	public static void main(String[] args) {
		try {
			// Código donde puede producirse el error
			GrupoRegistros grupo = new GrupoRegistros( "datos-registro.txt" );
			System.out.println( grupo.getListaRegistros() );
			System.out.println( grupo.getListaRegistros().size() );
		} catch (NullPointerException | IndexOutOfBoundsException exc) {
			System.out.println( exc.getClass() );
			exc.printStackTrace();
			System.out.println( "Ha habido un error de null pointer");
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println( "Ha habido un parse exception" );
		} catch (Exception e) {
			// Código con el que vamos a gestionarlo
			System.out.println( "Ha fallado la lectura" );
		}
		System.out.println( "Fin de programa");
	}
}
