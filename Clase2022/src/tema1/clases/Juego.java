package tema1.clases;

import java.util.Date;

public class Juego {
	
	// STATIC
	public static int numTotalHorasJugadas;
	
	
	// NO STATIC 
	
	private String nombre = "default";
	private String genero;
	private int edadMinimaRecomendada;
	private Date fechaCompra;
	private int numHorasJugadas;
	private double precioFinal;
	private double precioSinIva;
	private double iva;  // Supongamos que el iva es un 21%
	
	/** Crea un nuevo juego
	 * @param nombre	Nombre de ese juego
	 */
	public Juego( String nombre ) {
		// 1.- CREA UN NUEVO OBJETO DE ESTA CLASE (asigna memoria)
		// 2.- Se asigna la REFERENCIA de ese espacio a la variable this
		// this se asigna al objeto en curso
		// 3.- Nuestro trabajo - inicializar:
		this.nombre = nombre;
		// 4.- DEVUELVE LA REFERENCIA this
	}
	
	/** Crea un nuevo juego con nombre y horas jugadas. Si el nuevo dato de horas es incorrecto, 
	 * se muestra mensaje de error y el valor de horas no se cambia
	 * @param nombre	Nombre de ese juego
	 * @param numHorasJugadas	Número nuevo de horas jugadas. Debe ser positivo o cero.
	 */
	public Juego( String nombre, int numHorasJugadas ) {
		this.nombre = nombre;
//		if (numHorasJugadas < 0) {
//			System.err.println( "Error: número de horas " + numHorasJugadas + " es negativo" );
//		} else {
//			this.numHorasJugadas = numHorasJugadas;
//		}
		this.setNumHorasJugadas(numHorasJugadas);
	}
	
	/** Devuelve el nombre del juego
	 * @return	Nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/** Devuelve el número de horas jugadas a este juego
	 * @return	Número entero de horas (>= 0)
	 */
	public int getNumHorasJugadas() {
		return this.numHorasJugadas;
	}
	
	/** Modifica el número de horas jugadas. Si el nuevo dato es incorrecto, 
	 * se muestra mensaje de error y el valor no se cambia
	 * @param nhoras	Número nuevo de horas jugadas. Debe ser positivo o cero.
	 */
	public void setNumHorasJugadas( int numHorasJugadas ) {
		// this se asigna al objeto en curso
		if (numHorasJugadas < 0) {
			System.err.println( "Error: número de horas " + numHorasJugadas + " es negativo" );
		} else {
			this.numHorasJugadas = numHorasJugadas;
		}
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdadMinimaRecomendada() {
		return edadMinimaRecomendada;
	}

	public void setEdadMinimaRecomendada(int edadMinimaRecomendada) {
		this.edadMinimaRecomendada = edadMinimaRecomendada;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	/** Modifica el precio final del juego, cambiando también el precio base y el iva
	 * @param precioFinal	Precio final (iva incluido)
	 */
	public void setPrecioFinal(double precioFinal) {
		// TODO Corregir para el precio no negativo
		this.precioFinal = precioFinal;
		this.precioSinIva = precioFinal / 121 * 100;
		this.iva = precioFinal / 121 * 21;
	}

	public double getPrecioSinIva() {
		return precioSinIva;
	}

	public void setPrecioSinIva(double precioSinIva) {
		// TODO  Corregir
		// FIXME
		this.precioSinIva = precioSinIva;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		// TODO  Corregir
		this.iva = iva;
	}

	@Override  // Herencia - lo entenderemos mejor
	public boolean equals(Object j) {  // Object en vez de Juego?  Lo entenderemos con herencia
		Juego juego2 = (Juego) j;
		// return this.nombre.equals(juego2.nombre) && this.numHorasJugadas==juego2.numHorasJugadas;
		boolean ret = this.nombre.equals(juego2.nombre);
		boolean ret2 = this.numHorasJugadas == juego2.numHorasJugadas;
		return ret && ret2;
	}
	
}
