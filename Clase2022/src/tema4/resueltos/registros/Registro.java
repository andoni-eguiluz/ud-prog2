package tema4.resueltos.registros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Registro {
	
	public static final SimpleDateFormat FORMATEADOR_FECHA = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
	/** Devuelve una fecha desde un string con formato dd/MM/yyyy HH:mm
	 * @param fechaEnString	Fecha en string
	 * @return	Fecha en objeto de tipo Date
	 * @throws ParseException	Si la fecha string no es correcta
	 */
	public static Date getFechaFromString( String fechaEnString ) throws ParseException {
		Date fecha =  Registro.FORMATEADOR_FECHA.parse( fechaEnString );
		return fecha;
	}

	/** Crea un nuevo registro partiendo de una línea de texto con todos los datos en orden, separados por tabulador
	 * El objeto que se crea depende de la línea y se instancia alguna de las clases hijas (PrecioCarburante, PrecioElectricidad, etc.)
	 * @param linea	Línea de texto de la que extraer los datos
	 * @return	nuevo registro con esos datos, null si hay algún error
	 */
	public static Registro crearDeLinea( String linea ) throws ParseException {
		Registro registro = PrecioCarburante.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		registro = PrecioElectricidad.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		registro = SesionUsuario.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		registro = Consulta.crearDeLinea( linea );
		if (registro!=null) {
			return registro;
		}
		return null;
	}

	
	protected Date fecha;
	public Registro(Date fecha) {
		super();
		this.fecha = fecha;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return FORMATEADOR_FECHA.format( fecha );
	}
	
	public abstract String sacaLinea();
	
}
