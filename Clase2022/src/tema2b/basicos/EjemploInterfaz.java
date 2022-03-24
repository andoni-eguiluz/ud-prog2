package tema2b.basicos;

import java.awt.Point;
import java.util.ArrayList;

public class EjemploInterfaz {
	public static void main(String[] args) {
		CA a = new CA();
		CB b = new CB();
		CC c = new CC();
		CE e = new CE();
		a.mA();
		b.mB();
		a.m1();
		c.m1();
		Im1 m = a;
		// m = b;
		m = c;
		ArrayList<Im1> listaM = new ArrayList<>();
		listaM.add( a );
		// listaM.add( b );  // No se puede
		listaM.add( c );
		listaM.add( e );
		for (Im1 m1 : listaM) {
			m1.m1();
			if (m1 instanceof Movible2D) {
				Movible2D mov = (Movible2D) m1;  // CAST protegido por el instanceof
				mov.mover(0.1);
			}
		}
		ArrayList<Object> listaO = new ArrayList<>();
		listaO.add( a );
		listaO.add( b );
		listaO.add( c );
		listaO.add( e );
		// Hacer m1() con todos los que puedan
		for (Object objeto : listaO) {
//			if (objeto instanceof CA) {
//				((CA)objeto).m1();
//			} else if (objeto instanceof CC) {
//				((CC)objeto).m1();
//			} else if (objeto instanceof CE) {
//				((CE)objeto).m1();
//			}
			if (objeto instanceof Im1) {
				((Im1)objeto).m1();
			}
		}
	}
}

interface Im1 {  // clase MUY abstracta
	// No tiene datos
	void m1();  // No tiene código - los métodos son abstractos y public
}

interface ConvertibleAString {
	public String toString();
}

interface Movible2D {
	void mover( double tiempo );
	Point getPosicion(); 
}

class CA extends Object implements Im1, Movible2D {
	public void mA() { System.out.println( "mA" ); }
	public void m1() { System.out.println( "m1a" ); }
	public void mover( double t ) {
		System.out.println( "Se mueve" );
	}
	public Point getPosicion() {
		return null;
	}
}

class CB {
	public void mB() { System.out.println( "mB" ); }
}

class CC implements Im1 {
	public void m1() { System.out.println( "m1" ); }
}

abstract class CD implements Im1 {
	protected int d;
	public abstract void m1();
}

class CE extends CD {
	public void m1() { System.out.println( "m1" ); }
}
