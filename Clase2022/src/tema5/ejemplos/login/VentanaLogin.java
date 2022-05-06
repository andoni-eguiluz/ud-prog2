package tema5.ejemplos.login;

import java.awt.*;
import javax.swing.*;

public class VentanaLogin extends JFrame {
	public VentanaLogin() {
		// 1.- Crear contenedor - ya está creado, es this
		// new JFrame()
		// 2.- Configurar contenedor
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize( 500, 300 );
		this.setLocation( -1900, 100 );
		this.setTitle( "Login" );
		this.setLayout( new BorderLayout() );  // no hace falta
		// 3.- Crear resto de contenedores
		JPanel pCentral = new JPanel();
		JPanel pInferior = new JPanel();
		JPanel pSuperior = new JPanel();
		JPanel pIntermedio = new JPanel();
		// 4.- Configurar esos contenedores
		pCentral.setLayout( new BoxLayout( pCentral, BoxLayout.Y_AXIS ) );
		pCentral.setBackground( Color.CYAN );
		// 5.- Crear componentes
		JLabel lCabecera = new JLabel( "Identifícate con tus datos oficiales" );
		JLabel lUsuario = new JLabel( "Usuario:" );
		JTextField tfUsuario = new JTextField( "", 15 );
		JLabel lPassword = new JLabel( "Password:" );
		JTextField tfPassword = new JTextField( "", 15 );
		JCheckBox cbRecuerdame = new JCheckBox( "Recuérdame", true );
		JLabel lMensajeInfo = new JLabel( " " );
		JLabel lLogo = new JLabel( new ImageIcon( "src/utils/ventanas/ventanaBitmap/img/UD-blue-girable.png" ) );
		JButton bAceptar = new JButton( "Aceptar" );
		JButton bCancelar = new JButton( "Cancelar" );
		JButton bOlvidada = new JButton( "He olvidado mi contraseña" );
		// 6.- Configurar componentes
		bAceptar.setForeground( Color.GREEN );
		bAceptar.setEnabled( false );
		bOlvidada.setVisible( false );
		bCancelar.setToolTipText( "Pulsa aquí para cancelar el login" );
		// 7.- Asignar componentes a contenedores
		this.add( pCentral, BorderLayout.CENTER );
		this.add( pInferior, BorderLayout.SOUTH );
		this.add( lCabecera, BorderLayout.NORTH );
		this.add( lLogo, BorderLayout.WEST );
		pSuperior.add( lUsuario );
		pSuperior.add( tfUsuario );
		pCentral.add( pSuperior );
		pCentral.add( pIntermedio );
		pCentral.add( cbRecuerdame );
		pCentral.add( lMensajeInfo );
		pSuperior.add( lUsuario );
		pSuperior.add( tfUsuario );
		pIntermedio.add( lPassword );
		pIntermedio.add( tfPassword );
		pInferior.add( bAceptar );
		pInferior.add( bCancelar );
		pInferior.add( bOlvidada );
	}
}
