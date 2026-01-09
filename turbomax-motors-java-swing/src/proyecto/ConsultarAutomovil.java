package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.DropMode;

/**
 * Diálogo para consultar información detallada de los automóviles dispobibles.
 * Permite Seleccionar un modelo y visualizar sus características.
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see Automovil
 * @See RepositorioAutos
 */
public class ConsultarAutomovil extends JDialog implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
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
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { ConsultarAutomovil dialog =
	 * new ConsultarAutomovil();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 */

	/**
	 * Constructor que inicializa el diálogo y carga los datos del primer automóvil.
	 */
	public ConsultarAutomovil() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ConsultarAutomovil.class.getResource("/images/ICONOS/iconoConsultarAutomovil.png")));
		setTitle("Consultar automóvil");
		setBounds(100, 100, 522, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 210, 227));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 24, 90, 23);
		lblModelo.setForeground(Color.DARK_GRAY);
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblModelo);

		lblPrecio = new JLabel("Precio ($)");
		lblPrecio.setBounds(12, 58, 90, 23);
		lblPrecio.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblPrecio);

		lblColor = new JLabel("Color");
		lblColor.setBounds(12, 91, 90, 23);
		lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColor.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblColor);

		lblPeso = new JLabel("Peso(kg)");
		lblPeso.setBounds(12, 124, 90, 23);
		lblPeso.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblPeso);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(12, 155, 90, 26);
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblEstado);

		cboModelo = new JComboBox<String>();
		cboModelo.setBounds(114, 25, 147, 22);
		cboModelo.setBackground(SystemColor.control);
		cboModelo.addItemListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] { "Toyota Corolla", "Honda Civic",
				"Tesla Model 3", "Chevrolet Tracker", "Ford Mustang" }));
		contentPanel.add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(114, 60, 147, 20);
		txtPrecio.setDropMode(DropMode.INSERT);
		txtPrecio.setBackground(new Color(255, 255, 255));
		txtPrecio.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtPrecio.setEditable(false);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtColor = new JTextField();
		txtColor.setBounds(114, 93, 147, 20);
		txtColor.setBackground(new Color(255, 255, 255));
		txtColor.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtColor.setEditable(false);
		contentPanel.add(txtColor);
		txtColor.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(114, 126, 147, 20);
		txtPeso.setBackground(new Color(255, 255, 255));
		txtPeso.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtPeso.setEditable(false);
		contentPanel.add(txtPeso);
		txtPeso.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setBounds(114, 159, 147, 20);
		txtEstado.setBackground(new Color(255, 255, 255));
		txtEstado.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEstado.setEditable(false);
		contentPanel.add(txtEstado);
		txtEstado.setColumns(10);

		btnCerrar = new JButton(" Cerrar");
		btnCerrar.setBounds(114, 196, 112, 46);
		btnCerrar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnCerrar.setBackground(new Color(192, 210, 240));
		btnCerrar.setIcon(new ImageIcon(ConsultarAutomovil.class.getResource("/images/ICONOS/btncerrar.png")));
		btnCerrar.addActionListener(this);
		contentPanel.add(btnCerrar);

		cboModelo.setSelectedIndex(0);

		Automovil a = RepositorioAutos.autos.get(0);

		txtPrecio.setText("" + a.getPrecio());
		txtColor.setText(a.getColor());
		txtPeso.setText("" + a.getPeso());
		txtEstado.setText(a.getEstado());

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(216, 12, 267, 261);
		lblNewLabel.setIcon(
				new ImageIcon(ConsultarAutomovil.class.getResource("/images/Logos/LogoConsultarAutomovil.png")));
		contentPanel.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboModelo) {
			itemStateChangedCboModelo(e);
		}
	}

	/**
	 * Actualiza los campos de texto cuando el usuario selecciona un modelo
	 * diferente en el ComboBox
	 * <p>
	 * Obtiene el automóvil correspondiente al modelo seleccionado desde el
	 * repositorio y muestra sus datos (precio, color, peso, estado) en los campos
	 * de texto.
	 * </p>
	 * 
	 * @param e El evento generado al cambiar la selección del ComboBox
	 */
	protected void itemStateChangedCboModelo(ItemEvent e) {
		int modelo = leerModelo();
		Automovil a = RepositorioAutos.autos.get(modelo);

		mostrarResultados(a.getPrecio(), a.getColor(), a.getPeso(), a.getEstado());
	}

	/**
	 * Obtiene el indice del modelo de automóvil seleccionado en el ComboBox
	 * 
	 * @return El indice del modelo selecciona (0-4)
	 */
	int leerModelo() {
		return cboModelo.getSelectedIndex();
	}

	/**
	 * Muestra lso datos del automóvil en los campos de texto del diálogo.
	 * 
	 * @param prec El precio del automóvil en dolares
	 * @param col  El color del automóvil
	 * @param pes  El peso del automóvil en kilogramos
	 * @param est  El estado del automovil (Nuevo/Usado/Seminuevo)
	 */
	void mostrarResultados(double prec, String col, double pes, String est) {
		txtPrecio.setText(String.format("%.2f", prec));
		txtColor.setText(col);
		txtPeso.setText(String.format("%.2f", pes));
		txtEstado.setText(est);
	}
}
