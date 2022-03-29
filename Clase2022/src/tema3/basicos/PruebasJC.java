package tema3.basicos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

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
		System.out.println( listaStrings );
		// Borrar
		//while (!listaStrings.isEmpty()) {  // listaStrings.isEmpty() == false
		//	listaStrings.remove(0);
		//}
		listaStrings.clear();
		// conversor de arraylist a array
		// listaStrings.toArray()
		
		LinkedList<String> ll = new LinkedList<>();  // Comporta igual que arraylist
		
		String[] as = new String[10];  // Lineal, ord. por índice. ESPACIO MAXIMO definido en construcción + NO INSERCION NI BORRADO
		as[9] = "hola";
		
		
		/// LINEALES SIN POSICION SIN REPETICIÓN
		HashSet<String> conjH = new HashSet<>();
		TreeSet<String> conjT = new TreeSet<>();
		
		
		
	}
}

interface Movible {
	
}
