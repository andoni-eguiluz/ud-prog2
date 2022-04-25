package tema4.resueltos.registros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class GrupoRegistros {

	protected ArrayList<Registro> listaRegistros;
	protected HashSet<Registro> setRegistros;
	protected TreeSet<String> setUsuarios;
	protected HashMap<String,Integer> mapaConteoRegistros;
	
	public GrupoRegistros() {
		listaRegistros = new ArrayList<>();
		setRegistros = new HashSet<>();
		setUsuarios = new TreeSet<>();
		mapaConteoRegistros = new HashMap<>();
	}
	
	public GrupoRegistros( String nomFichero ) {
		this();
		leerDeFicheroTexto( nomFichero );
	}
	
	public void leerDeFicheroTexto( String nomFichero ) {
		Scanner lector = new Scanner( GrupoRegistros.class.getResourceAsStream( "datos-registro.txt" ) );
		int numLinea = 1;
		int numLineasErroneas = 0;
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			try {
				Registro registro = Registro.crearDeLinea( linea );
				if (registro!=null) {
					anyadirInterno( registro );
				}
			} catch (Exception e) {
				numLineasErroneas++;
				System.out.println( "Error en línea " + numLinea + " del fichero de entrada. Revise fichero" );
			}
			numLinea++;
		}
		// Podría gestionarse de algún modo si aparecen demasiadas líneas erroneas
		if (numLineasErroneas>0) {
			System.out.println( String.format( "Líneas erróneas (datos perdidos): %1d (%1.2f%%)", numLineasErroneas, (1.0*numLineasErroneas/(numLinea-1)) ) );
		}
		lector.close();
	}
	
	public void guardarEnFicheroTexto( String nomFichero ) {
		try {
			PrintStream ficSalida = new PrintStream(nomFichero);
			for (Registro r : listaRegistros) {
				ficSalida.println( r.sacaLinea() );
			}
			ficSalida.close();
		} catch (FileNotFoundException e) {
			System.out.println( "Error en fichero de salida. No se ha generado " + nomFichero );
		}
	}
	
	@SuppressWarnings("unchecked")
	public void leerDeFicheroBinario( String nomFichero ) {
		try {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream( nomFichero ) );
			listaRegistros = (ArrayList<Registro>) ois.readObject();
			setRegistros = (HashSet<Registro>) ois.readObject();
			setUsuarios = (TreeSet<String>) ois.readObject();
			mapaConteoRegistros = (HashMap<String,Integer>)  ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println( "Error en lectura de fichero binario " + nomFichero );
			e.printStackTrace();
		}
	}
	
	public void guardarEnFicheroBinario( String nomFichero ) {
		try {
			ObjectOutputStream ois = new ObjectOutputStream( new FileOutputStream( nomFichero ) );
			ois.writeObject( listaRegistros );
			ois.writeObject( setRegistros );
			ois.writeObject( setUsuarios );
			ois.writeObject( mapaConteoRegistros );
			ois.close();
		} catch (IOException e) {
			System.out.println( "Error en escritura de fichero binario " + nomFichero );
			e.printStackTrace();
		}
	}
	
	public void anyadir( Registro registro ) {
		anyadirInterno( registro );
	}
	
	private void anyadirInterno( Registro registro ) {
		listaRegistros.add( registro );
		setRegistros.add( registro );
		if (registro instanceof RegistroDeUsuario) {
			RegistroDeUsuario ru = (RegistroDeUsuario) registro;
			setUsuarios.add( ru.getUsuario() );
		}
		if (registro instanceof RegistroDeUsuario) {
			RegistroDeUsuario ru = (RegistroDeUsuario) registro;
			if (mapaConteoRegistros.containsKey(ru.getUsuario())) {
				mapaConteoRegistros.replace( ru.getUsuario(), mapaConteoRegistros.get(ru.getUsuario()) + 1 );
			} else {
				mapaConteoRegistros.put( ru.getUsuario(), 1 );
			}
		}
	}
	
	public int getNumRegistros( String usuario ) {
		if (mapaConteoRegistros.containsKey(usuario)) {
			return mapaConteoRegistros.get( usuario );
		} else {
			return 0;
		}
	}
	
	public ArrayList<Registro> getListaRegistros() {
		return listaRegistros;
	}
	
	public boolean estaEnGrupo( Registro r ) {
//		for (Registro reg : listaRegistros) {
//			if (reg.equals(r)) {
//				return true;
//			}
//		}
//		return false;
		return listaRegistros.contains( r ); // tiempo lineal
	}

	public boolean estaEnGrupoEficiente( Registro r ) {
		return setRegistros.contains( r );  // tiempo constante
	}

	public TreeSet<String> getUsuariosUnicosOrdenados() {
		return setUsuarios;
	}
	
}
