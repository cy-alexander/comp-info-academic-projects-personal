package proyecto;

/**
 * Representa un automóvil en el sistema de ventas.
 * <p>
 * Esta clase es el modelo de datos que almacena toda la información relacionada
 * con un automóvil: modelo, precio, color, peso y estado.
 * </p>
 * <p>
 * El modelo no puede ser modificado después de la creación del objeto, pero el
 * resto de atributos pueden ser actualizados mediante sus setters.
 * </p>
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see RepositorioAutos
 */
public class Automovil {

	/**
	 * Nombre del modelo del automóvil. Ejemplos: "Toyota Corolla", "Honda Civic",
	 * "Tesla Model 3"
	 */
	private String modelo;

	/**
	 * Precio del automóvil en dólares.
	 */
	private double precio;

	/**
	 * Color del automóvil.
	 */
	private String color;

	/**
	 * Peso del automóvil en kilogramos.
	 */
	private double peso;

	/**
	 * Estado actual del automóvil. Valores comunes: "Nuevo", "Usado"
	 */
	private String estado;

	/**
	 * Constructor que crea un nuevo automóvil con todos sus datos.
	 * 
	 * @param modelo El nombre del modelo del automóvil
	 * @param precio El precio del automóvil en dólares
	 * @param color  El color del automóvil
	 * @param peso   El peso del automóvil en kilogramos
	 * @param estado El estado del automóvil (Nuevo/Usado)
	 */
	public Automovil(String modelo, double precio, String color, double peso, String estado) {
		this.modelo = modelo;
		this.precio = precio;
		this.color = color;
		this.peso = peso;
		this.estado = estado;
	}

	/**
	 * Obtiene el modelo del automóvil.
	 * 
	 * @return El nombre del modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Obtiene el precio del automóvil.
	 * 
	 * @return El precio en dólares
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Obtiene el color del automóvil.
	 * 
	 * @return El color del automóvil
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Obtiene el peso del automóvil.
	 * 
	 * @return El peso en kilogramos
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Obtiene el estado del automóvil.
	 * 
	 * @return El estado (Nuevo/Usado)
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Modifica el precio del automóvil.
	 * 
	 * @param precio El nuevo precio en dólares
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Modifica el color del automóvil.
	 * 
	 * @param color El nuevo color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Modifica el peso del automóvil.
	 * 
	 * @param peso El nuevo peso en kilogramos
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Modifica el estado del automóvil.
	 * 
	 * @param estado El nuevo estado (Nuevo/Usado)
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}