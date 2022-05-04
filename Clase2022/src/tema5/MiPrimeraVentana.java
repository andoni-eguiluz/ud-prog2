package tema5;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MiPrimeraVentana {
	public static void main(String[] args) {
		System.out.println( "inicio" );
		// 1.- Crear ventana
		JFrame ventana = new JFrame();
		// 2.- Configurar ventana
		ventana.setTitle( "Mi ventana" );
		ventana.setSize( 400, 300 );
		ventana.setLocation( 2000, 100 );
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// 2b.- Configurar layout
		ventana.setLayout( new BorderLayout() );
		// 3.- Crear componentes
		JButton boton1 = new JButton( "Aceptar" );
		JButton boton2 = new JButton( "Cancelar" );
		JTextField texto1 = new JTextField( "Hola" );
		JTextField texto2 = new JTextField( "Adiós" );
		JButton botonC = new JButton( "Centro" );
		// 4.- Añadir componentes a contenedores
		ventana.add( boton1, BorderLayout.NORTH );  // Center por defecto
		ventana.add( boton2, BorderLayout.SOUTH );  // Center
		ventana.add( texto1, BorderLayout.WEST );
		ventana.add( texto2, BorderLayout.EAST );
		ventana.add( botonC, BorderLayout.CENTER );
		// ...
		// ...
		ventana.setVisible( true );  // MAGIA
		
		System.out.println( "fin" );
	}
}
