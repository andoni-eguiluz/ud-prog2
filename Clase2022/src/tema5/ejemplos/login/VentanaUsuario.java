package tema5.ejemplos.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class VentanaUsuario extends JFrame {
	private JPanel pCentral;
	private JComboBox<TipoUsuario> cbTipoUsuario;
	private JList<DatoUsuario> lDatos;  // Componente visual
	private DefaultListModel<DatoUsuario> modeloDatos; // Componente de datos (no visual)
	public VentanaUsuario( JFrame ventAnterior, DatoUsuario[] datos ) {
		// 1.- Configurar cont. principal
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( ventAnterior.getSize() );
		setTitle( "Gestión de datos de usuario" );
		setLocation( ventAnterior.getLocation() );
		// 2.- Crear contenedores
		pCentral = new JPanel();
		JPanel pSuperior = new JPanel();
		// 3.- Configurar contenedores
		pCentral.setBackground( Color.white );
		pCentral.setLayout( null );
		// 4.- Crear componentes
		cbTipoUsuario = new JComboBox<>( TipoUsuario.values() );
		modeloDatos = new DefaultListModel<DatoUsuario>();
		for (DatoUsuario du : datos) {
			modeloDatos.addElement( du );
		}
		lDatos = new JList<>( modeloDatos );
		crearVisualDeDatos( datos );
		// 5.- Configurar componentes
		// 6.- Asignar componentes a contenedores
		add( pCentral, BorderLayout.CENTER );
		add( pSuperior, BorderLayout.NORTH );
		JScrollPane sp = new JScrollPane( lDatos );
		add( sp, BorderLayout.WEST );
		pSuperior.add( cbTipoUsuario );
	}
	
	private void crearVisualDeDatos( DatoUsuario[] datos ) {
		for (DatoUsuario dato : datos) {
			JLabel l = new JLabel();
			l.setSize( 40, 20 );
			l.setLocation( dato.getX(), dato.getY() );
			l.setText( dato.getNombre() );
			l.setBackground( Color.LIGHT_GRAY );
			l.setOpaque( true );
			l.setHorizontalAlignment( JLabel.CENTER );
			pCentral.add( l );
		}
	}
}
