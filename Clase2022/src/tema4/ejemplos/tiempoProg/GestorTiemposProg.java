package tema4.ejemplos.tiempoProg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class GestorTiemposProg {
	private ArrayList<TiempoProg> listaTiempos = new ArrayList<>();  // plan A
	public GestorTiemposProg() {
		listaTiempos = new ArrayList<>();  // plan B
	}
	/**
	 * @return
	 */
	public ArrayList<TiempoProg> getTiempos() {
		return listaTiempos;
	}
	public void addTiempo( TiempoProg tp ) {
		listaTiempos.add( tp );
	}
	
	/**
	 * @param binario	Si es true se guarda en binario, false se guarda en modo texto
	 * @param nomFichero
	 */
	public void guardarFichero( boolean binario, String nomFichero ) throws IOException {
		if (binario) {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(nomFichero));
			oos.writeObject( listaTiempos );
			oos.close();
		} else {
			// try (PrintStream ps = new PrintStream( nomFichero )) {
			PrintStream ps = new PrintStream( nomFichero );
			// ps.println( listaTiempos.toString() );
			for (TiempoProg tp : listaTiempos) {
				ps.println( tp.aLinea() );
			}
			ps.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void cargarFichero( boolean binario, String nomFichero ) throws IOException, ClassNotFoundException {
		if (binario) {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream(nomFichero));
			listaTiempos = (ArrayList<TiempoProg>) ois.readObject();
			ois.close();
		} else {
			// TODO
		}
	}
	
}
