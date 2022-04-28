package tema4.ejemplos.tiempoProg;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TiempoProg implements Comparable<TiempoProg>, Serializable {
	private Date fecha;
	private int tiempo;
	
	/** Crea un nuevo objeto de tiempo de programación
	 * @param fecha	Fecha-hora de inicio del trabajo
	 * @param tiempo	Número de minutos dedicados (positivos, mayor que cero)
	 */
	public TiempoProg(Date fecha, int tiempo) {
		super();
		this.fecha = fecha;
		this.tiempo = tiempo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	@Override
	public String toString() {
		return fecha + " : " + tiempo;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
	public String aLinea() {
		return sdf.format(fecha) + "\t" + tiempo;
	}
	
	public TiempoProg leerLinea( String linea ) {
		TiempoProg ret = new TiempoProg( null, 0 );
		String[] trozos = linea.split("\t");
		try {
			ret.fecha = sdf.parse( trozos[0] );
			ret.tiempo = Integer.parseInt( trozos[1] );
		} catch (Exception e) {
			return null;
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return fecha.hashCode() + tiempo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TiempoProg) {
			TiempoProg tp2 = (TiempoProg) obj;
			return fecha.equals(tp2.fecha) && tiempo==tp2.tiempo;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(TiempoProg o) {
		int comp = this.fecha.compareTo( o.fecha );
		if (comp==0) {
			comp = this.tiempo - o.tiempo;
		}
		return comp;
	}
	
	public String metodoNuevo() {
		return "hola";
	}
	
}
