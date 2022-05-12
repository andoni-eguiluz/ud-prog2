package tema5.ejemplos.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lMensajeInfo;
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
		pCentral.setBorder( BorderFactory.createLineBorder( Color.RED ));
		pSuperior.setBorder( BorderFactory.createLineBorder( Color.GREEN ));
		pIntermedio.setBorder( BorderFactory.createLineBorder( Color.MAGENTA ));
		// 5.- Crear componentes
		JLabel lCabecera = new JLabel( "Identifícate con tus datos oficiales" );
		final JLabel lUsuario = new JLabel( "Usuario:" );
		JTextField tfUsuario = new JTextField( "", 15 );
		JLabel lPassword = new JLabel( "Password:" );
		JTextField tfPassword = new JTextField( "", 15 );
		JCheckBox cbRecuerdame = new JCheckBox( "Recuérdame", true );
		lMensajeInfo = new JLabel( " " );
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
		// if botón pulsado  // no se puede
		// 8.- Inicializar los gestores de eventos
		// bCancelar.addActionListener( new EscuchadorBotonExterno() );  // manera 1 - clases externas
		// bCancelar.addActionListener( new EscuchadorBotonInterno() );  // manera 2 - clases internas
		// Manera 3: Clases internas anónimas
		bCancelar.addActionListener( new ActionListener() {  // creando un nuevo objeto de una clase sin nombre que implementa ActionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// NO SE EJECUTA EN EL MISMO TIEMPO
				// NO SE EJECUTA EN EL MISMO CONTEXTO (No tiene las mismas variables)
				lMensajeInfo.setText( "Pulsado cancelar" );
				// lUsuario.setText( "noseque" ); // Si hay que hacerlo como atributo, o saber el truco
			}
		});
		// Sigue
		tfUsuario.addKeyListener( new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println( "TYPED " + e );
				if (e.getKeyChar()>='0' && e.getKeyChar()<='9') {
					System.out.println( "Es un dígito" );
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println( "RELEASED " + e );
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println( "PRESSED " + e );
			}
		});
		tfUsuario.addFocusListener( new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println( "LOST " + e );
			}
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println( "GAINED " + e );
			}
		});
	}
	
	class EscuchadorBotonInterno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println( "Botón cancelar pulsado" );
			lMensajeInfo.setText( "Pulsado cancelar" );  // Error - no acceso al atributo
		}
	}

	
}

class EscuchadorBotonExterno implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println( "Botón cancelar pulsado" );
		// lMensajeInfo.setText( "Pulsado cancelar" );  // Error - no acceso al atributo
	}
}
