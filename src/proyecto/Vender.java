package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Diálogo que procesa la compra segun el modelo y muestra los detalles en una
 * boleta
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see Automovil
 * @see ReposiorioAutos
 */
public class Vender extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JComboBox<String> cboModelo;
	private JButton btnVender;
	private JButton btnCerrar;
	private JLabel lblNewLabel;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { Vender dialog = new Vender();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	// Crea la GUI
	public Vender() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vender.class.getResource("/images/ICONOS/iconoVender.png")));
		setTitle("Vender");
		setBounds(100, 100, 822, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 210, 227));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblModelo = new JLabel("Modelo");
			lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
			lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 14));
			lblModelo.setBounds(14, 19, 87, 21);
			contentPanel.add(lblModelo);
		}
		{
			lblPrecio = new JLabel("Precio($)");
			lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
			lblPrecio.setFont(new Font("Century Gothic", Font.BOLD, 14));
			lblPrecio.setBounds(14, 52, 89, 18);
			contentPanel.add(lblPrecio);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
			lblCantidad.setFont(new Font("Century Gothic", Font.BOLD, 14));
			lblCantidad.setBounds(14, 85, 87, 18);
			contentPanel.add(lblCantidad);
		}
		{
			cboModelo = new JComboBox<String>();
			cboModelo.addActionListener(this);
			cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] { "Toyota Corolla", "Honda Civic",
					"Tesla Model 3", "Chevrolet Tracker", "Ford Mustang" }));
			cboModelo.setBounds(114, 19, 310, 22);
			contentPanel.add(cboModelo);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(114, 53, 310, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(114, 85, 310, 20);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnVender = new JButton("Vender");
			btnVender.setBackground(new Color(192, 210, 240));
			btnVender.setFont(new Font("Dubai", Font.BOLD, 16));
			btnVender.setIcon(new ImageIcon(Vender.class.getResource("/images/ICONOS/btnVender.png")));
			btnVender.addActionListener(this);
			btnVender.setBounds(452, 13, 127, 34);
			contentPanel.add(btnVender);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setBackground(new Color(192, 210, 240));
			btnCerrar.setFont(new Font("Dubai", Font.BOLD, 16));
			btnCerrar.setIcon(new ImageIcon(Vender.class.getResource("/images/ICONOS/btncerrar.png")));
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(452, 56, 127, 34);
			contentPanel.add(btnCerrar);
		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 414, 244);
		contentPanel.add(scrollPane);
		{
			txtS = new JTextArea();
			txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
			scrollPane.setViewportView(txtS);
		}

		txtPrecio.setText(String.valueOf(definirPrecio(0)));
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Vender.class.getResource("/images/Logos/LogoVender.png")));
			lblNewLabel.setBounds(390, 30, 416, 417);
			contentPanel.add(lblNewLabel);
		}

		cboModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int modelo = leerModelo();
				double precio = definirPrecio(modelo);
				txtPrecio.setText(String.valueOf(precio));
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	/**
	 * Procesa la venta de un automóvil cuando se presiona el botón Vender.
	 * <p>
	 * Realiza el siguiente flujo: valida la cantidad, calcula importes y
	 * descuentos, asigna obsequio, actualiza estadísticas, imprime la boleta y
	 * limpia el formulario.
	 * </p>
	 * 
	 * @param e Evento generado al presionar el botón Vender
	 */
	protected void actionPerformedBtnVender(ActionEvent e) {
		int modelo = leerModelo();
		int can = definirCantidad();

		// Validar que la cantidad sea válida antes de continuar
		if (can <= 0) {
			return; // Salir del método si la cantidad no es válida
		}

		Automovil a = RepositorioAutos.autos.get(modelo);

		double precio = a.getPrecio();
		double impCompra = calcularImporteCompra(can, precio);
		double impDesc = calcularImporteDescuento(can, impCompra);
		double impPagar = calcularImportePagar(impCompra, impDesc);

		String obsequio = calcularObsequio(modelo, can);

		realizarIncrementos(modelo, can, impCompra, impDesc, impPagar);

		MenuPrincipal.numVenta++;

		imprimirResultado(a.getModelo(), impCompra, impDesc, impPagar, can, obsequio, precio);

		JOptionPane.showMessageDialog(this, "Venta realizada con éxito", "Venta exitosa",
				JOptionPane.INFORMATION_MESSAGE);

		// Limpiar el campo de cantidad después de una venta exitosa
		txtCantidad.setText("");
		txtCantidad.requestFocus();
	}

	/**
	 * 
	 * @return
	 */
	int leerModelo() {
		return cboModelo.getSelectedIndex();
	}

	/**
	 * Lee y valida la cantidad de unidades ingresada por el usuario.
	 * <p>
	 * Realiza las siguientes validaciones:
	 * </p>
	 * <ul>
	 * <li>Verifica que el campo no esté vacío</li>
	 * <li>Verifica que sea un número entero válido</li>
	 * <li>Verifica que la cantidad sea mayor a cero</li>
	 * </ul>
	 * <p>
	 * Si alguna validación falla, muestra un mensaje de error y devuelve 0.
	 * </p>
	 * 
	 * @return La cantidad ingresada si es válida, 0 si hay algún error
	 */
	int definirCantidad() {
		try {
			String texto = txtCantidad.getText().trim();

			// Validar que el campo no esté vacío
			if (texto.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad", "Campo vacío",
						JOptionPane.WARNING_MESSAGE);
				txtCantidad.setText("");
				txtCantidad.requestFocus();
				return 0;
			}

			int cantidad = Integer.parseInt(texto);

			// Validar que la cantidad sea positiva
			if (cantidad <= 0) {
				JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0", "Cantidad inválida",
						JOptionPane.WARNING_MESSAGE);
				txtCantidad.setText("");
				txtCantidad.requestFocus();
				return 0;
			}

			return cantidad;

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un número entero válido", "Formato incorrecto",
					JOptionPane.ERROR_MESSAGE);
			txtCantidad.setText("");
			txtCantidad.requestFocus();
			return 0;
		}
	}

	/**
	 * 
	 * @param mod
	 * @return
	 */
	String modeloAutomovil(int mod) {
		Automovil a = RepositorioAutos.autos.get(mod);
		return a.getModelo();
	}

	/**
	 * 
	 * @param mod
	 * @return
	 */
	double definirPrecio(int mod) {
		Automovil a = RepositorioAutos.autos.get(mod);
		return a.getPrecio();
	}

	/**
	 * Calcula el importe de compra multiplicando la cantidad solicitada por el
	 * precio según el indice seleccionado
	 * 
	 * @param cantidad La cantidad de unidades a comprar
	 * @param precio   El precio unitario del automóvil en dólares
	 * @return El importe total de la compra en dólares
	 */
	double calcularImporteCompra(int cantidad, double precio) {
		return cantidad * precio;
	}

	/**
	 * Calcula el importe del descuento según la cantidad de unidades compradas
	 * <p>
	 * Aplica los siguientes porcentajes de descuento:
	 * <ul>
	 * <li>1-5 unidades: 5%</li>
	 * <li>6-10 unidades: 7.5%</li>
	 * <li>11-15 unidades: 10%</li>
	 * <li>16+ unidades: 20%</li>
	 * </ul>
	 * </p>
	 * 
	 * @param can La cantidad de unidades compradas
	 * @param ic  El importe de compra (cantidad * precio)
	 * @return El monto del descuento en dólares
	 */
	double calcularImporteDescuento(int can, double ic) {
		double id = 0;
		if (can < 6)
			id = (MenuPrincipal.porcentaje1 / 100) * ic;
		else if (can < 11)
			id = (MenuPrincipal.porcentaje2 / 100) * ic;
		else if (can < 16)
			id = (MenuPrincipal.porcentaje3 / 100) * ic;
		else
			id = (MenuPrincipal.porcentaje4 / 100) * ic;

		return id;
	}

	/**
	 * Calcula el importe final a pagar restando el descuento del importe de compra
	 * 
	 * @param ic El importe de compra (precio * cantidad)
	 * @param id El importe del descuendo aplicado
	 * @return El importe final que debe pagar el cliente
	 */
	double calcularImportePagar(double ic, double id) {
		double ip = 0;
		ip = ic - id;
		return ip;
	}

	/**
	 * Actualiza las estadísticas de ventas acumuladas del modelo vendido
	 * <p>
	 * Incrementa los contadores globales de ventas, unidades vendidas e importes
	 * acumulados (compra, descuento y pago) según el modelo del automóvil vendido.
	 * Las estadísticas se alamacenan en variables estáticas de MenuPrincipal.
	 * </p>
	 * 
	 * @param mod     El índice del modelo vendido (0=Toyota, 1=Honda, 2=Tesla,
	 *                3=Chevrolet, 4=Ford)
	 * @param can     La cantidad de unidades vendidas
	 * @param impcom  El importe total de compra en dólares
	 * @param impdesc El importe del descuento aplicado en dólares
	 * @param imppag  El importe final pagado en dólares
	 */
	void realizarIncrementos(int mod, int can, double impcom, double impdesc, double imppag) {
		switch (mod) {
		case 0:
			MenuPrincipal.canVenta0++;
			MenuPrincipal.canUniVenta0 += can;
			MenuPrincipal.impCompra0 += impcom;
			MenuPrincipal.impDesc0 += impdesc;
			MenuPrincipal.impPagar0 += imppag;
			break;
		case 1:
			MenuPrincipal.canVenta1++;
			MenuPrincipal.canUniVenta1 += can;
			MenuPrincipal.impCompra1 += impcom;
			MenuPrincipal.impDesc1 += impdesc;
			MenuPrincipal.impPagar1 += imppag;
			break;
		case 2:
			MenuPrincipal.canVenta2++;
			MenuPrincipal.canUniVenta2 += can;
			MenuPrincipal.impCompra2 += impcom;
			MenuPrincipal.impDesc2 += impdesc;
			MenuPrincipal.impPagar2 += imppag;
			break;
		case 3:
			MenuPrincipal.canVenta3++;
			MenuPrincipal.canUniVenta3 += can;
			MenuPrincipal.impCompra3 += impcom;
			MenuPrincipal.impDesc3 += impdesc;
			MenuPrincipal.impPagar3 += imppag;
			break;
		case 4:
			MenuPrincipal.canVenta4++;
			MenuPrincipal.canUniVenta4 += can;
			MenuPrincipal.impCompra4 += impcom;
			MenuPrincipal.impDesc4 += impdesc;
			MenuPrincipal.impPagar4 += imppag;
			break;

		}
	}

	/**
	 * Determina el obsequio correspondiente según la cantidad de unidades compradas
	 * <p>
	 * Los obsequios se asignan de la siguiente manera:
	 * <ul>
	 * <li>1 unidad: Vale para mantenimiento o revisión gratuitas</li>
	 * <li>2-5 unidad: Kit premiun de accesorios para autos</li>
	 * <li>6+ unidad: Seguro vehicular por un año</li>
	 * </ul>
	 * </p>
	 * 
	 * @param mod
	 * @param can
	 * @return
	 */
	String calcularObsequio(int mod, int can) {
		String obs;

		if (can == 1) {
			obs = MenuPrincipal.obsequio1;
		} else if (can < 6) {
			obs = MenuPrincipal.obsequio2;
		} else if (can > 5) {
			obs = MenuPrincipal.obsequio3;
		} else {
			obs = "Sin obsequio";
		}

		return obs;
	}

	void imprimirResultado(String modelo, double ic, double id, double ip, int can, String obs, double prec) {
		txtS.setText("BOLETA DE LA VENTA\n\n");
		txtS.append("Modelo\t\t\t: " + modelo + "\n");
		txtS.append("Precio\t\t\t: " + " $" + String.format("%,12.2f", prec) + "\n");
		txtS.append("Cantidad\t\t: " + String.format("%12d", can) + "\n");
		txtS.append("Importe compra\t\t: " + " $" + String.format("%,12.2f", ic) + "\n");
		txtS.append("Importe descuento\t: " + " $" + String.format("%,12.2f", id) + "\n");
		txtS.append("Importe pagar\t\t: " + " $" + String.format("%,12.2f", ip) + "\n");
		txtS.append("Obsequio\t\t: " + obs + "\n");
	}
}
