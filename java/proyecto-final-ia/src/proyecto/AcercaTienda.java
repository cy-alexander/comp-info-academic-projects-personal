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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AcercaTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSeparator separator;
	private JButton btnCerrar;
	private JLabel lblAutores;
	private JLabel lblAutor;
	private JLabel lblLogo;
	private JSeparator separator_1;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { try { AcercaTienda dialog = new
	 * AcercaTienda(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 */
	public AcercaTienda() {
		setModal(true);
		setTitle("Acerca de la tienda");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AcercaTienda.class.getResource("/images/ICONOS/iconoAcercaTienda.png")));
		setBounds(100, 100, 525, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 210, 227));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTienda = new JLabel("Sistema venta de automóviles 1.0");
			lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblTienda.setFont(new Font("Dubai", Font.BOLD, 32));
			lblTienda.setBounds(0, 0, 509, 71);
			contentPanel.add(lblTienda);
		}

		separator = new JSeparator();
		separator.setBounds(0, 69, 528, 2);
		contentPanel.add(separator);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(192, 210, 240));
		btnCerrar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnCerrar.setIcon(new ImageIcon(AcercaTienda.class.getResource("/images/ICONOS/btncerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(405, 255, 111, 43);
		contentPanel.add(btnCerrar);

		lblAutores = new JLabel("Autores");
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Dubai", Font.BOLD, 28));
		lblAutores.setBounds(0, 69, 528, 43);
		contentPanel.add(lblAutores);

		lblAutor = new JLabel("Alexander Carrasco Yaicate");
		lblAutor.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblAutor.setBounds(209, 127, 319, 29);
		contentPanel.add(lblAutor);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AcercaTienda.class.getResource("/images/Logos/LogoAcercaTienda.png")));
		lblLogo.setBounds(58, 124, 128, 128);
		contentPanel.add(lblLogo);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 110, 528, 2);
		contentPanel.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(0, 255, 528, 2);
		contentPanel.add(separator_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
