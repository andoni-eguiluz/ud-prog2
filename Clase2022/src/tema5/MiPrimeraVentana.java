package tema5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiPrimeraVentana {
	public static void main(String[] args) {
		System.out.println( "inicio" );
		// 1.- Crear ventana y contenedores
		JFrame ventana = new JFrame();
		JPanel panel = new JPanel();
		// 2.- Configurar ventana
		ventana.setTitle( "Mi ventana" );
		ventana.setSize( 400, 300 );
		ventana.setLocation( 2000, 100 );
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// 2b.- Configurar layout
		// ventana.setLayout( new BorderLayout() );  // Por defecto los JFrames
		// ventana.setLayout( new BoxLayout( ventana.getContentPane(), BoxLayout.X_AXIS ) );
		// ventana.setLayout( new GridLayout( 3, 2 ) );
		// ventana.setLayout( new FlowLayout() );
		ventana.setLayout( null );
		panel.setLayout( new FlowLayout() );  // Por defecto los paneles
		// 3.- Crear componentes
		JButton boton1 = new JButton( "Aceptar" );
		JButton boton2 = new JButton( "Cancelar" );
		JTextField texto1 = new JTextField( "Hola" );
		JTextField texto2 = new JTextField( "Adiós" );
		JButton botonC = new JButton( "Centro" );
		JLabel etiquetaTexto = new JLabel( "Texto de prueba" );
		// 3b.- Configurar los componentes
		boton1.setForeground( Color.RED );
		boton1.setFont( new Font( "Arial", Font.BOLD, 48 ) );
		boton2.setEnabled( false );
		boton1.setLocation( 100, 150 );
		boton1.setSize( 120, 53 );
		texto1.setBounds( 250, 300, 395, 282 );
		botonC.setBounds( 100, 100, 200,300);
		// 4.- Añadir componentes a contenedores
		ventana.add( boton1 );  // Center por defecto
		ventana.add( texto1 );
		ventana.add( texto2 );
		ventana.add( botonC );
		ventana.add( panel );
		panel.add( etiquetaTexto );
		panel.add( boton2 );
		// ...
		// ...
		ventana.setVisible( true );  // MAGIA
		
		System.out.println( "fin" );
	}
}
