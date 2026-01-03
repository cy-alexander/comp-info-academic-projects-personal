package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class ConfigurarDescuentos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl15Unidades;
	private JLabel lbl10Unidades;
	private JLabel lbl5Unidades;
	private JLabel lblMas15;
	private JTextField txt5Unidades;
	private JTextField txt10Unidades;
	private JTextField txt15Unidades;
	private JTextField txtMas15;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ConfigurarDescuentos dialog = new ConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarDescuentos() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ConfigurarDescuentos.class.getResource("/images/ICONOS/iconoConfigurarDescuentos.png")));
		setTitle("Configurar descuentos");
		setBounds(100, 100, 677, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 210, 227));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbl5Unidades = new JLabel("1 a 5 unidades");
			lbl5Unidades.setBounds(35, 22, 136, 14);
			lbl5Unidades.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPanel.add(lbl5Unidades);
		}
		{
			lbl10Unidades = new JLabel("6 a 10 unidades");
			lbl10Unidades.setBounds(35, 48, 136, 14);
			lbl10Unidades.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPanel.add(lbl10Unidades);
		}
		{
			lbl15Unidades = new JLabel("11 a 15 unidades");
			lbl15Unidades.setBounds(35, 74, 136, 14);
			lbl15Unidades.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPanel.add(lbl15Unidades);
		}
		{
			lblMas15 = new JLabel("Más de 15 unidades");
			lblMas15.setBounds(35, 97, 136, 14);
			lblMas15.setFont(new Font("Century Gothic", Font.BOLD, 14));
			contentPanel.add(lblMas15);
		}
		{
			txt5Unidades = new JTextField();
			txt5Unidades.setBounds(188, 20, 109, 20);
			contentPanel.add(txt5Unidades);
			txt5Unidades.setColumns(10);
		}
		{
			txt10Unidades = new JTextField();
			txt10Unidades.setBounds(188, 45, 109, 20);
			contentPanel.add(txt10Unidades);
			txt10Unidades.setColumns(10);
		}
		{
			txt15Unidades = new JTextField();
			txt15Unidades.setBounds(188, 70, 109, 20);
			contentPanel.add(txt15Unidades);
			txt15Unidades.setColumns(10);
		}
		{
			txtMas15 = new JTextField();
			txtMas15.setBounds(188, 95, 109, 20);
			contentPanel.add(txtMas15);
			txtMas15.setColumns(10);
		}

		lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(302, 46, 29, 16);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(302, 21, 29, 16);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(302, 74, 29, 16);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setBounds(302, 99, 29, 16);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		contentPanel.add(lblNewLabel_3);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(192, 210, 240));
		btnAceptar.setBounds(339, 24, 122, 39);
		btnAceptar.setIcon(new ImageIcon(ConfigurarDescuentos.class.getResource("/images/ICONOS/btnGuardar.png")));
		btnAceptar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(192, 210, 240));
		btnCancelar.setBounds(339, 76, 122, 39);
		btnCancelar.setIcon(new ImageIcon(ConfigurarDescuentos.class.getResource("/images/ICONOS/btncerrar.png")));
		btnCancelar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnCancelar.addActionListener(this);
		contentPanel.add(btnCancelar);

		// Muestra los porcentajes iniciales
		txt5Unidades.setText("" + MenuPrincipal.porcentaje1);
		txt10Unidades.setText("" + MenuPrincipal.porcentaje2);
		txt15Unidades.setText("" + MenuPrincipal.porcentaje3);
		txtMas15.setText("" + MenuPrincipal.porcentaje4);
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setIcon(new ImageIcon(
					ConfigurarDescuentos.class.getResource("/images/Logos/LogoConfigurarDescuentos.png")));
			lblNewLabel_4.setBounds(483, 12, 148, 113);
			contentPanel.add(lblNewLabel_4);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			double nuevo1, nuevo2, nuevo3, nuevo4;
			int cambios = 0, opcion;

			// Leer nuevos valores
			nuevo1 = Double.parseDouble(txt5Unidades.getText());
			nuevo2 = Double.parseDouble(txt10Unidades.getText());
			nuevo3 = Double.parseDouble(txt15Unidades.getText());
			nuevo4 = Double.parseDouble(txtMas15.getText());

			// Verifica si hubo cambios
			if (nuevo1 != MenuPrincipal.porcentaje1)
				cambios++;
			if (nuevo2 != MenuPrincipal.porcentaje2)
				cambios++;
			if (nuevo3 != MenuPrincipal.porcentaje3)
				cambios++;
			if (nuevo4 != MenuPrincipal.porcentaje4)
				cambios++;

			if (cambios > 0) {
				opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de guardar los cambios?", "Confirmación",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opcion == JOptionPane.YES_OPTION) {
					guardarDescuento1();
					guardarDescuento2();
					guardarDescuento3();
					guardarDescuento4();
					dispose();
				} else {
					// Revertira los cambios mostrando los valores originales
					mostrarResultados();
				}
			} else {
				JOptionPane.showMessageDialog(this, "No se detectaron cambios", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
			// Valida si se ingresan números
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Ingrese solo números válidos en los campos", "Error de entrada",
					JOptionPane.WARNING_MESSAGE);

		}
		// Métodos para guardar
	}

	void guardarDescuento1() {
		MenuPrincipal.porcentaje1 = Double.parseDouble(txt5Unidades.getText());
	}

	void guardarDescuento2() {
		MenuPrincipal.porcentaje2 = Double.parseDouble(txt10Unidades.getText());
	}

	void guardarDescuento3() {
		MenuPrincipal.porcentaje3 = Double.parseDouble(txt15Unidades.getText());
	}

	void guardarDescuento4() {
		MenuPrincipal.porcentaje4 = Double.parseDouble(txtMas15.getText());
	}

	void mostrarResultados() {
		txt5Unidades.setText(String.valueOf(MenuPrincipal.porcentaje1));
		txt10Unidades.setText(String.valueOf(MenuPrincipal.porcentaje2));
		txt15Unidades.setText(String.valueOf(MenuPrincipal.porcentaje3));
		txtMas15.setText(String.valueOf(MenuPrincipal.porcentaje4));
	}
}
