package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ConfigurarObsequios extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt1Unidad;
	private JTextField txt5Unidades;
	private JTextField txtMasUnidades;
	private JLabel lblMasUnidades;
	private JLabel lbl5Unidades;
	private JLabel lbl1Unidad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ConfigurarObsequios.class.getResource("/images/ICONOS/iconoConfigurarObsequios.png")));
		setTitle("Configurar obsequios");
		setBounds(100, 100, 752, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 210, 227));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbl1Unidad = new JLabel("1 unidad");
			lbl1Unidad.setFont(new Font("Century Gothic", Font.BOLD, 14));
			lbl1Unidad.setBounds(22, 46, 71, 14);
			contentPanel.add(lbl1Unidad);
		}
		{
			lbl5Unidades = new JLabel("2 a 5 unidades");
			lbl5Unidades.setFont(new Font("Century Gothic", Font.BOLD, 14));
			lbl5Unidades.setBounds(22, 70, 106, 14);
			contentPanel.add(lbl5Unidades);
		}
		{
			lblMasUnidades = new JLabel("6 a más unidades");
			lblMasUnidades.setFont(new Font("Century Gothic", Font.BOLD, 14));
			lblMasUnidades.setBounds(22, 96, 135, 14);
			contentPanel.add(lblMasUnidades);
		}
		{
			txt1Unidad = new JTextField();
			txt1Unidad.setBounds(165, 44, 263, 20);
			contentPanel.add(txt1Unidad);
			txt1Unidad.setColumns(10);
		}
		{
			txt5Unidades = new JTextField();
			txt5Unidades.setBounds(165, 69, 263, 20);
			contentPanel.add(txt5Unidades);
			txt5Unidades.setColumns(10);
		}
		{
			txtMasUnidades = new JTextField();
			txtMasUnidades.setBounds(165, 94, 263, 20);
			contentPanel.add(txtMasUnidades);
			txtMasUnidades.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBackground(new Color(192, 210, 240));
			btnAceptar.setFont(new Font("Dubai", Font.BOLD, 16));
			btnAceptar.setIcon(new ImageIcon(ConfigurarObsequios.class.getResource("/images/ICONOS/btnGuardar.png")));
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(440, 36, 122, 39);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBackground(new Color(192, 210, 240));
			btnCancelar.setFont(new Font("Dubai", Font.BOLD, 16));
			btnCancelar.setIcon(new ImageIcon(ConfigurarObsequios.class.getResource("/images/ICONOS/btncerrar.png")));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(440, 85, 122, 39);
			contentPanel.add(btnCancelar);

			txt1Unidad.setText("" + MenuPrincipal.obsequio1);
			txt5Unidades.setText("" + MenuPrincipal.obsequio2);
			txtMasUnidades.setText("" + MenuPrincipal.obsequio3);
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(
					new ImageIcon(ConfigurarObsequios.class.getResource("/images/Logos/LogoModificarObsequio.png")));
			lblNewLabel.setBounds(568, 0, 156, 155);
			contentPanel.add(lblNewLabel);
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
		String nuevo1, nuevo2, nuevo3;
		int cambios = 0, opcion;

		// Leer los nuevos valores
		nuevo1 = txt1Unidad.getText();
		nuevo2 = txt5Unidades.getText();
		nuevo3 = txtMasUnidades.getText();

		// Verificar cambios
		if (!nuevo1.equals(MenuPrincipal.obsequio1))
			cambios++;
		if (!nuevo2.equals(MenuPrincipal.obsequio2))
			cambios++;
		if (!nuevo3.equals(MenuPrincipal.obsequio3))
			cambios++;

		if (cambios > 0) {
			opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de guardar los cambios?", "Confirmación",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (opcion == JOptionPane.YES_NO_OPTION) {
				guardarObsequio1();
				guardarObsequio2();
				guardarObsequio3();
				dispose();
			} else {
				// Revertira los cambios mostrando los valores originales
				mostrarResultados();
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se detectaron cambios", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	void guardarObsequio1() {
		MenuPrincipal.obsequio1 = txt1Unidad.getText();
	}

	void guardarObsequio2() {
		MenuPrincipal.obsequio2 = txt5Unidades.getText();
	}

	void guardarObsequio3() {
		MenuPrincipal.obsequio3 = txtMasUnidades.getText();
	}

	void mostrarResultados() {
		txt1Unidad.setText(MenuPrincipal.obsequio1);
		txt5Unidades.setText(MenuPrincipal.obsequio2);
		txtMasUnidades.setText(MenuPrincipal.obsequio3);
	}
}
