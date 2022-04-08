package tema3.basicos;

import java.util.*;

public class PruebasJC {
	public static void main(String[] args) {
		
		// Java Collections -> parte de la API estructuras de datos
		
		Vector v = new Vector(); // Guarda datos --> polimorfismo
		// Almacén de objects
		v.add( new java.awt.Point(3,2));
		v.add( "Hola" );
		java.awt.Point punto = (java.awt.Point) v.get(0);
		
		// GENERICS -> 4
		ArrayList<String> lS = new ArrayList<>();  // Genérico
		lS.add( "hola" );
		// lS.add( new java.awt.Point(2,0));  // No funcionaría
		String s1 = lS.get(0);
		ArrayList<Object> lO = new ArrayList<>();  // Genérica y polimórfica
		// String s2 = lO.get(0);
		// con clases padres y con interfaces
		ArrayList<Movible> lM = new ArrayList<>();
		
		// ARRAYLIST - estructura lineal - ORDENADA POR INDICE / POSICION / PERMITE REPETICIÓN
		ArrayList<String> listaStrings = new ArrayList<>();
		listaStrings.add( "nuevo string" );
		listaStrings.add( 0, "string al inicio" );
		listaStrings.add( "último" );
		String valor = listaStrings.get( 1 );
		listaStrings.remove( 2 );
		listaStrings.add( "string al inicio" );
		System.out.println( listaStrings );
		listaStrings.remove( "string al inicio" );  // Ojo - usa equals
		System.out.println( listaStrings );
		System.out.println( listaStrings.size() );
		listaStrings.add( "a" );
		listaStrings.add( "a" );
		listaStrings.add( "a" );
		System.out.println( listaStrings.contains( "a" ) );
		System.out.println( listaStrings.indexOf( "a" ) );
		listaStrings.set( 3, "b" );
		System.out.println( listaStrings );
		// CRUD - Create Read (seaRch) Update Delete
		// Borrar
		//while (!listaStrings.isEmpty()) {  // listaStrings.isEmpty() == false
		//	listaStrings.remove(0);
		//}
		// Tb se puede recorrer
		for (String elemento : listaStrings) {  // ITERABLE - interface Iterable
			System.out.print( elemento );
		}
		listaStrings.clear();
		// conversor de arraylist a array
		// listaStrings.toArray()
		
		LinkedList<String> ll = new LinkedList<>();  // Comporta igual que arraylist
		
		String[] as = new String[10];  // Lineal, ord. por índice. ESPACIO MAXIMO definido en construcción + NO INSERCION NI BORRADO
		as[9] = "hola";
		
		String[] pelis = { "CODA", "Belfast", "CODA", "Dune", "No mires arriba", "CODA", "Dune", "Drive my car", "licorice pizza", "El método Williams" };
		
		/// LINEALES SIN POSICION SIN REPETICIÓN
		HashSet<String> conjH = new HashSet<>();  // equals() - hashCode()  -- reimplementarlo si procede
		TreeSet<String> conjT = new TreeSet<>();  // Tipo base debe implementar Comparable<E>
		for (String peli : pelis) {
			conjH.add( peli );
			conjT.add( peli );
		}
		System.out.println();
		System.out.println( conjH );
		System.out.println( conjT );
		System.out.println( conjH.contains( "CODA" ) );
		System.out.println( conjT.contains( "El método Williams" ) );
		conjH.remove( "CODA" );
		System.out.println( conjH.contains( "CODA" ) );
		
		// MAPAS
		HashMap<String,Integer> mapaVotosH = new HashMap<String,Integer>();
		TreeMap<String,Integer> mapaVotosT = new TreeMap<>();
		for (String voto : pelis) {
			if (mapaVotosH.containsKey( voto )) {
				// La peli estaba ya en el mapa - o sea, ya se la había votado anteriormente
				// Hay que sumar 1 a los votos que ya tuviera
				Integer votosAnteriores = mapaVotosH.get( voto );
				// votosAnteriores.no hay nada que lo pueda cambiar con + 1
				mapaVotosH.put( voto, votosAnteriores + 1 );
				mapaVotosT.put( voto, votosAnteriores + 1 );
			} else {
				// La peli no estaba ya en el mapa - hay que añadirla con 1 voto
				mapaVotosH.put( voto, 1 ); // boxing: es igual que mapaVotosH.put( voto, Integer.valueOf(1) );
				mapaVotosT.put( voto, 1 );
			}
		}
		System.out.println(mapaVotosH);
		System.out.println(mapaVotosT);
		// Se podría hacer sin sustituir unos valores con otros?
		HashMap<String,Contador> mapaVotosCont = new HashMap<String,Contador>();
		for (String voto : pelis) {
			if (mapaVotosCont.containsKey(voto)) {  // Segunda vez o posterior
				// mapaVotosCont.get( voto ).inc();
				Contador cont = mapaVotosCont.get( voto );
				cont.inc();
			} else { // Primera vez
				mapaVotosCont.put( voto, new Contador(1) );
			}
		}
		System.out.println( mapaVotosCont );
		// Cómo sacamos la ganadora?
		int mayor = 0;
		String peliGanadora = "";
		for (String clave : mapaVotosCont.keySet()) {
			Contador votosF = mapaVotosCont.get( clave );
			if (votosF.get() > mayor) {
				mayor = votosF.get();
				peliGanadora = clave;
			}
		}
		System.out.println( "Ganadora: " + peliGanadora + " con " + mayor + " votos." );
		// Se pueden guardar los jurados que votan a cada peli?
		HashMap<String,ArrayList<Integer>> mapaVotosJurado = new HashMap<>();
		System.out.println( mapaVotosJurado );
		for (int posiJurado=0; posiJurado<pelis.length; posiJurado++) {
			String peli = pelis[posiJurado];
			if (mapaVotosJurado.containsKey( peli )) {
				mapaVotosJurado.get( peli ).add( posiJurado );
			} else {
				ArrayList<Integer> listaVotos = new ArrayList<>();
				listaVotos.add( posiJurado );
				mapaVotosJurado.put( peli, listaVotos );
			}
		}
		System.out.println( mapaVotosJurado );
		for (String peli : mapaVotosJurado.keySet()) {
			ArrayList<Integer> votos = mapaVotosJurado.get( peli );
			System.out.println( " * \t" + peli + "\t" + votos );
		}
		
		// Podría hacer un mapa o un set en lugar de con strings película con objetos de clase Película?
		TreeSet<Pelicula> setPeliculas = new TreeSet<Pelicula>();
		for (String nombrePelicula : pelis) {
			setPeliculas.add( new Pelicula( nombrePelicula ) );
		}
		System.out.println( setPeliculas );
		HashSet<Pelicula> setPeliculasH = new HashSet<Pelicula>();
		for (String nombrePelicula : pelis) {
			Pelicula p = new Pelicula( nombrePelicula );
			setPeliculasH.add( p );
			System.out.println( " Peli " + nombrePelicula + " hashcode " + p.hashCode() );
		}
		Pelicula pp1 = new Pelicula( "CODA" );
		Pelicula pp2 = new Pelicula( "CODA" );
		System.out.println( pp1.equals( pp2 ) );
		System.out.println( setPeliculasH );
	}
}

class Pelicula implements Comparable<Pelicula> {
	String nombre;
	public Pelicula( String nombre ) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pelicula) {
			Pelicula p2 = (Pelicula) obj;
			return this.nombre.equals( p2.nombre );
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return nombre;
	}
	@Override
	public int compareTo(Pelicula o) {
		String nombreMay = nombre.toUpperCase().replaceAll("Á","A").replaceAll("Ñ","NZ");
		String nombre2May = o.nombre.toUpperCase().replaceAll("Á","A").replaceAll("Ñ","NZ");
		return -nombreMay.compareTo( nombre2May );
	}
}



class Contador {
	private int valor;
	public Contador( int valorInicial ) {
		valor = valorInicial;
	}
	public void inc() {
		valor++;
	}
	public int get() {
		return valor;
	}
	@Override
	public String toString() {
		return ""+valor;
	}
}

interface Movible {
	
}
