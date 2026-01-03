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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Diálogo que muestra un listado completo de todos los automóviles del sistema.
 * <p>
 * Permite visualizar los atributos de cada modelo (precio, color, peso, estado)
 * en modo de solo lectura.
 * </p>
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see Automovil
 * @see RepositorioAutos
 */
public class ListarAutomoviles extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnListar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { ListarAutomoviles dialog = new
	 * ListarAutomoviles();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 */
	/**
	 * 
	 */
	public ListarAutomoviles() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ListarAutomoviles.class.getResource("/images/ICONOS/iconoListarAutomovil.png")));
		setTitle("Listar de automóviles");
		setBounds(100, 100, 450, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 210, 227));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 220);
		contentPanel.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(192, 210, 240));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnCerrar.setIcon(new ImageIcon(ListarAutomoviles.class.getResource("/images/ICONOS/btncerrar.png")));
		btnCerrar.setBounds(102, 249, 110, 38);
		contentPanel.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(192, 210, 240));
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Dubai", Font.BOLD, 16));
		btnListar.setIcon(new ImageIcon(ListarAutomoviles.class.getResource("/images/ICONOS/btnListar.png")));
		btnListar.setBounds(224, 249, 110, 38);
		contentPanel.add(btnListar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	/**
	 * Lista todos los automóviles disponibles en el sistema
	 * <p>
	 * Recorre el repositorio de automóviles y muestra los datos de cada uno
	 * (modelo, precio, color, peso, estado) en el área de text. Al finalizar
	 * posiciona el cursor al inicio del texto.
	 * </p>
	 * 
	 * @param e Evento generado al presionar el botón Listar
	 */
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("LISTADO DE AUTOMÓVILES\n\n");

		for (Automovil a : RepositorioAutos.autos) {
			txtS.append("Modelo\t: " + a.getModelo() + "\n");
			txtS.append("Precio\t: $ " + String.format("%,10.2f", a.getPrecio()) + "\n");
			txtS.append("Color\t: " + a.getColor() + "\n");
			txtS.append("Peso\t: Kg. " + String.format("%,2.2f", a.getPeso()) + "\n");
			txtS.append("Estado\t: " + a.getEstado() + "\n\n");
		}

		txtS.setCaretPosition(0);
	}
}
