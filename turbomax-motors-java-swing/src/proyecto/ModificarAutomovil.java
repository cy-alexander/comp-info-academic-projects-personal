package proyecto;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Diálogo que permite modificar los atributos de un automóvil del sistema
 * <p>
 * El usuario puede seleccionar un modelo y editar su precio, color, peso y
 * estado. Los cambios se guardan directamente en el repositorio de automóviles.
 * </p>
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see Automovil
 * @see RepositoAutos
 */
public class ModificarAutomovil extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblColor;
	private JLabel lblPeso;
	private JLabel lblEstado;
	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtColor;
	private JTextField txtPeso;
	private JTextField txtEstado;
	private JButton btnCerrar;
	private JButton btnGuardar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ModificarAutomovil dialog = new
	 * ModificarAutomovil();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 * 
	 * /** Create the dialog.
	 */
	/**
	 * Constructor que inicializa el diálogo y carga los datos del primer automóvil.
	 */
	public ModificarAutomovil() {
		setModal(true);
		getContentPane().setBackground(new Color(192, 210, 227));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ModificarAutomovil.class.getResource("/images/ICONOS/iconoModificarAutomovil.png")));
		setTitle("Modificar automóvil");
		setBounds(100, 100, 488, 354);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblModelo.setBounds(12, 24, 90, 23);
		getContentPane().add(lblModelo);

		lblPrecio = new JLabel("Precio ($)");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrecio.setBounds(12, 58, 90, 23);
		getContentPane().add(lblPrecio);

		lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColor.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblColor.setBounds(12, 91, 90, 23);
		getContentPane().add(lblColor);

		lblPeso = new JLabel("Peso(kg)");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPeso.setBounds(12, 124, 90, 23);
		getContentPane().add(lblPeso);

		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(12, 155, 90, 26);
		getContentPane().add(lblEstado);

		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] { "Toyota Corolla", "Honda Civic",
				"Tesla Model 3", "Chevrolet Tracker", "Ford Mustang" }));
		cboModelo.setBounds(114, 25, 147, 22);
		getContentPane().add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(114, 60, 147, 20);
		getContentPane().add(txtPrecio);

		txtColor = new JTextField();
		txtColor.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtColor.setColumns(10);
		txtColor.setBounds(114, 93, 147, 20);
		getContentPane().add(txtColor);

		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtPeso.setColumns(10);
		txtPeso.setBounds(114, 126, 147, 20);
		getContentPane().add(txtPeso);

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtEstado.setColumns(10);
		txtEstado.setBounds(114, 159, 147, 20);
		getContentPane().add(txtEstado);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnCerrar.setBackground(new Color(192, 210, 240));
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(ModificarAutomovil.class.getResource("/images/ICONOS/btncerrar.png")));
		btnCerrar.setBounds(114, 249, 123, 46);
		getContentPane().add(btnCerrar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBackground(new Color(192, 210, 240));
		btnGuardar.setIcon(new ImageIcon(ModificarAutomovil.class.getResource("/images/ICONOS/btnGuardar.png")));
		btnGuardar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnCerrar.setBackground(new Color(192, 210, 240));
		btnGuardar.setBounds(114, 191, 123, 46);
		getContentPane().add(btnGuardar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(ModificarAutomovil.class.getResource("/images/Logos/LogoModificarAutomovil.png")));
		lblNewLabel.setBounds(233, 12, 227, 300);
		getContentPane().add(lblNewLabel);

		int index = cboModelo.getSelectedIndex();
		Automovil a = RepositorioAutos.autos.get(index);

		txtPrecio.setText(String.valueOf(a.getPrecio()));
		txtColor.setText(a.getColor());
		txtPeso.setText(String.valueOf(a.getPeso()));
		txtEstado.setText(a.getEstado());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedcboModelo(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	/**
	 * Guarda las modificaciones realizadas en el automóvil seleccionado, Muestra un
	 * mensaje de confirmación y cierra el diálogo
	 * 
	 * @param e Evento generado al presionar el botón Guardar
	 */
	protected void actionPerformedBtnGuardar(ActionEvent e) {

		int index = cboModelo.getSelectedIndex();
		Automovil a = RepositorioAutos.autos.get(index);

		a.setPrecio(Double.parseDouble(txtPrecio.getText()));
		a.setColor(txtColor.getText());
		a.setPeso(Double.parseDouble(txtPeso.getText()));
		a.setEstado(txtEstado.getText());

		JOptionPane.showInternalMessageDialog(null, "Modificación Exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);

		dispose();
	}

	/**
	 * Actualiza los campos de texto cuando se seleccione un modelo diferente. Carga
	 * y muestra los datos del automóvil seleccionado.
	 * 
	 * @param e Evento generado al cambiar la seleccion del ComBox
	 */
	protected void actionPerformedcboModelo(ActionEvent e) {

		int index = cboModelo.getSelectedIndex();

		Automovil a = RepositorioAutos.autos.get(index);

		mostrarResultados(a.getPrecio(), a.getColor(), a.getPeso(), a.getEstado());
	}

	/**
	 * Muestra los datos del automóvil en los campos de texto del diálogo
	 * 
	 * @param prec El precio del automóvil en dólares
	 * @param col  El color del automóvil
	 * @param pes  El peso del automóvil
	 * @param est  El estado del automóvil (Nuevo/Usado/Seminuevo)
	 */
	void mostrarResultados(double prec, String col, double pes, String est) {
		txtPrecio.setText(String.format("%.2f", prec));
		txtColor.setText(col);
		txtPeso.setText(String.format("%.2f", pes));
		txtEstado.setText(est);
	}
}
