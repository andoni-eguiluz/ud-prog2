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
		
		String[] pelis = { "CODA", "Belfast", "CODA", "Dune", "No mires arriba", "CODA", "Dune", "Drive my car", "licorice pizza" };
		
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
				int votosAnteriores = mapaVotosH.get( voto );
				mapaVotosH.put( voto, votosAnteriores + 1 );
			} else {
				// La peli no estaba ya en el mapa - hay que añadirla con 1 voto
				mapaVotosH.put( voto, 1 ); // boxing: es igual que mapaVotosH.put( voto, Integer.valueOf(1) );
			}
		}
		System.out.println(mapaVotosH);
	}
}

interface Movible {
	
}
