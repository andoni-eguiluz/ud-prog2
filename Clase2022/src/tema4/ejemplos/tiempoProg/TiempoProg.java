package tema4.ejemplos.tiempoProg;

import java.util.Date;

public class TiempoProg implements Comparable<TiempoProg> {
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
	
	
}
