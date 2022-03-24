package tema2b.basicos;

import java.util.ArrayList;

public class Persona implements Comparable<Persona> {
	public static void main(String[] args) {
		ArrayList<Persona> listaP = new ArrayList<>();
		Persona p1 = new Persona( "Andoni" );
		listaP.add( p1 );
		listaP.add( new Persona( "Idoia" ) );
		listaP.add( new Persona( "Emilio" ) );
		listaP.add( new Persona( "Iratxe" ) );
		System.out.println( listaP );
		if (listaP.contains( new Persona("Andoni") )) {
			System.out.println( "Andoni está en la lista" );
		}
		System.out.println( p1.equals( "Andoni" ) );
		listaP.sort( null );
		System.out.println( listaP );
	}

	protected String nombre;
	
	@Override
	public int compareTo(Persona o) {
		return nombre.compareTo( o.nombre );
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Persona) {
			Persona p2 = (Persona) obj;
			return this.nombre.equals( p2.nombre );
		} else {
			return false;
		}
	}
	
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

}
