package tema4.ejemplos.registros;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class GrupoRegistros {
	protected ArrayList<Registro> listaRegistros;
	public GrupoRegistros( String nomFichero ) {
		listaRegistros = new ArrayList<>();
		//Scanner lectorTeclado = new Scanner( System.in );
		Scanner lector = new Scanner( GrupoRegistros.class.getResourceAsStream( "datos-registro.txt" ) );  // Recurso - solo para leer
		// Scanner lector = new Scanner( new File( "datos/datos-registro.txt" ) );  // Fichero - leer y escribir
		int contLineas = 0;
		while (lector.hasNextLine()) {
			contLineas++;
			String linea = lector.nextLine();
			try {
				Registro registro = Registro.crearDeLinea( linea );
				if (registro!=null) {
					listaRegistros.add( registro );
				}
			} catch (Exception e) {
				System.out.println( "Línea perdida por error: " + contLineas );
			}
		}
		lector.close();
	}
	public ArrayList<Registro> getListaRegistros() {
		return listaRegistros;
	}
	
}
