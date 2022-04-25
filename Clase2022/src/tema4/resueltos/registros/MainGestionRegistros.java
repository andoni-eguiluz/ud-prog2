package tema4.resueltos.registros;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

public class MainGestionRegistros {

	public static void main(String[] args) {
		GrupoRegistros grupo = new GrupoRegistros( "datos-registro.txt" );
		System.out.println( "TODOS LOS REGISTROS:" );
		for (Registro reg : grupo.getListaRegistros()) {
			System.out.println( "  " + reg.toString() );
		}
		// TODO Listar solo los registros de usuario
		for (Registro reg : grupo.getListaRegistros()) {
			if (reg instanceof RegistroDeUsuario) {
				System.out.println( reg );
			}
		}
		// TODO Listar solo los precios
		System.out.println( "LISTA DE PRECIOS");
		for (Registro reg : grupo.getListaRegistros()) {
//			if (reg instanceof PrecioElectricidad) {
//				// ..
//			} else if (reg instanceof PrecioCarburante) {
//				// ..
//			}
			if (reg instanceof ConPrecio) {
				System.out.println( reg.toString() );
			}
		}
		// TODO Calcular la media de todos los precios
		double suma = 0;
		int cont = 0;
		for (Registro reg : grupo.getListaRegistros()) {
			if (reg instanceof ConPrecio) {
				ConPrecio precio = (ConPrecio) reg;
				suma += precio.getPrecio();
				cont++;
			}
		}
		System.out.println( "MEDIA DE PRECIOS: " + (suma/cont) );
		
		// TODO Listar todos los usuarios
		System.out.println( "LISTA DE USUARIOS:");
		for (Registro reg : grupo.getListaRegistros()) {
			if (reg instanceof RegistroDeUsuario) {
				System.out.println( ((RegistroDeUsuario)reg).getUsuario() );
			}
		}
		
		// TODO Listar los precios en rango 0.4 y 1.8
		for (Registro reg : grupo.getListaRegistros()) {
			if (reg instanceof ConPrecio) {
				ConPrecio precio = (ConPrecio) reg;
				if (precio.estaPrecioEnRango(0.4, 1.8)) {
					System.out.println( reg );
				}
			}
		}
		
		// TODO Crear lista solo de RegistroDeUsuarios
		ArrayList<RegistroDeUsuario> listaRU = new ArrayList<>();
		for (Registro reg : grupo.getListaRegistros()) {
			if (reg instanceof RegistroDeUsuario) {
				listaRU.add( (RegistroDeUsuario) reg );
			}
		}
		System.out.println( "LISTA DE USUARIOS: " + listaRU );
		
		ejercicio3b4( grupo );
	}
	
	private static void ejercicio3b4( GrupoRegistros grupo ) {
		// Comprobar si un registro está en el grupo
		Registro regTest = grupo.getListaRegistros().get(7);
		System.out.println( grupo.estaEnGrupo( regTest ) );
		Date ahora = new Date();
		Registro regNuevo = new PrecioCarburante( ahora, "test", TipoCarburante.GASOLINA_95, 1.75 );
		long tiempoActual = System.nanoTime();
		boolean busqueda = false;
		for (int i=0; i<10000; i++) {
			busqueda = grupo.estaEnGrupo( regNuevo );
		}
		System.out.println( busqueda );
		System.out.println( "Tiempo 1: " + (System.nanoTime() - tiempoActual));
		
		// Mejorado
		System.out.println( grupo.estaEnGrupoEficiente( regTest ) );
		tiempoActual = System.nanoTime();
		for (int i=0; i<10000; i++) {
			busqueda = grupo.estaEnGrupo( regNuevo );
		}
		System.out.println( busqueda );
		System.out.println( "Tiempo 2: " + (System.nanoTime() - tiempoActual));
		grupo.anyadir( regNuevo );
		Registro regNuevo2 = new PrecioCarburante( ahora, "test", TipoCarburante.GASOLINA_95, 1.75 );
		System.out.println( grupo.estaEnGrupoEficiente( regNuevo2 ) );
		System.out.println( regNuevo.hashCode() );
		System.out.println( regNuevo2.hashCode() );
		System.out.println( regNuevo.equals( regNuevo2 ));
		
		// Grupo de usuarios únicos ordenados
		TreeSet<String> uUnicos = grupo.getUsuariosUnicosOrdenados();
		for (String usuario : uUnicos) {
			System.out.println( "\t" + usuario );
		}
		
		// Num regs por usuario
		System.out.println( grupo.getNumRegistros( "elena" ) );
	}

}
