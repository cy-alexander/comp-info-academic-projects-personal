package proyecto;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Ventana de inicio de sesión del sistema de venta de automóviles "TurboMax
 * Motors".
 * <p>
 * Esta clase proporciona la interfaz gráfica para que los usuarios se
 * autentiquen en el sistema. Incluye validación de credenciales, control de
 * intentos fallidos y opción para mostrar/ocultar la contraseña ingresada.
 * </p>
 * <p>
 * <strong>Credenciales por defecto:</strong>
 * <ul>
 * <li>Usuario: admin</li>
 * <li>Contraseña: 1234</li>
 * </ul>
 * 
 * </p>
 * <p>
 * El sistema permite un máximo de 3 intentos fallidos antes de bloquearse.
 * </p>
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see MenuPrincipal
 */
public class Login extends JFrame implements ActionListener {

	/**
	 * Número de serie para la serialización de la clase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contador de intentos fallidos de inicio de sesión.
	 * <p>
	 * Cuando alcanza 3 intentos fallidos, el sistema se bloquea automáticamente.
	 * </p>
	 */
	private int contadorFallidos = 0;

	/**
	 * Botón para cancelar el proceso de inicio de sesión y cerrar la aplicación.
	 */
	private JButton btnCancelar;

	/**
	 * Constructor que inicializa y configura la ventana de login.
	 * <p>
	 * Realiza las siguientes acciones:
	 * </p>
	 * <ul>
	 * <li>Configura el tamaño y posición de la ventana</li>
	 * <li>Inicializa todos los componentes gráficos (campos de texto, botones,
	 * labels)</li>
	 * <li>Configura los listeners para los eventos de botones</li>
	 * <li>Establece la validación de credenciales</li>
	 * <li>Implementa el control de intentos fallidos</li>
	 * </ul>
	 */
	public Login() {

		getContentPane().setBackground(SystemColor.activeCaption);

		setTitle("Inicio de Sesión");
		setSize(574, 362);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblUsuario = new JLabel("");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/images/ICONOS/IconoUsuario.png")));
		lblUsuario.setBounds(35, 64, 94, 77);

		JTextField campoUsuario = new JTextField(10);
		campoUsuario.setBackground(SystemColor.inactiveCaption);
		campoUsuario.setBounds(135, 87, 213, 33);

		JLabel lblContraseña = new JLabel("");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setIcon(new ImageIcon(Login.class.getResource("/images/ICONOS/IconoContraseña.png")));
		lblContraseña.setBounds(35, 140, 94, 77);

		JPasswordField txtContraseña = new JPasswordField(10);
		txtContraseña.setBackground(SystemColor.inactiveCaption);
		txtContraseña.setBounds(135, 161, 213, 33);

		JCheckBox mostrarCheck = new JCheckBox("Mostrar Contraseña");
		mostrarCheck.setBackground(SystemColor.activeCaption);
		mostrarCheck.setHorizontalAlignment(SwingConstants.CENTER);
		mostrarCheck.setFont(new Font("Century Gothic", Font.BOLD, 16));
		mostrarCheck.setBounds(135, 225, 213, 39);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/images/ICONOS/btnIngresar.png")));
		btnIngresar.setFont(new Font("Dubai", Font.BOLD, 17));
		btnIngresar.setBounds(100, 272, 130, 39);

		// Mostrar/Ocultar contraseña
		mostrarCheck.addActionListener(e -> {
			if (mostrarCheck.isSelected())
				txtContraseña.setEchoChar((char) 0);
			else
				txtContraseña.setEchoChar('*');
		});

		// Ingreso
		btnIngresar.addActionListener(e -> {
			String user = campoUsuario.getText();
			String pass = new String(txtContraseña.getPassword());

			if (user.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ningún campo debe estar vacío", "Alerta",
						JOptionPane.WARNING_MESSAGE);
				campoUsuario.setText("");
				txtContraseña.setText("");
				campoUsuario.requestFocus();
				return;
			}

			if (pass.length() < 4) {
				JOptionPane.showMessageDialog(null, "La contraseña debe tener un mínimo de 4 caracteres", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				campoUsuario.setText("");
				txtContraseña.setText("");
				campoUsuario.requestFocus();
				return;
			}

			if (user.equals("admin") && pass.equals("1234")) {
				JOptionPane.showMessageDialog(null, "Bienvenido, disfrute su instancia");

				// Abrir el menú principal
				MenuPrincipal ventanaP = new MenuPrincipal();
				ventanaP.setVisible(true);
				dispose();

			} else {
				contadorFallidos++;
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error",
						JOptionPane.ERROR_MESSAGE);
				campoUsuario.setText("");
				txtContraseña.setText("");
				campoUsuario.requestFocus();

				if (contadorFallidos >= 3) {
					JOptionPane.showMessageDialog(null, "Se ha superado el límite de intentos. Intente más tarde.",
							"Bloqueado", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		});

		// Botón por defecto
		getRootPane().setDefaultButton(btnIngresar);
		getContentPane().setLayout(null);

		// Añadir componentes
		getContentPane().add(lblUsuario);
		getContentPane().add(campoUsuario);
		getContentPane().add(lblContraseña);
		getContentPane().add(txtContraseña);
		getContentPane().add(mostrarCheck);
		getContentPane().add(btnIngresar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/images/ICONOS/btncerrar.png")));
		btnCancelar.setFont(new Font("Dubai", Font.BOLD, 17));
		btnCancelar.setBounds(242, 272, 130, 39);
		getContentPane().add(btnCancelar);

		JLabel lblNewLabel = new JLabel("Automotriz \"TurboMax Motors\"");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 29));
		lblNewLabel.setBounds(0, 0, 558, 60);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/Logos/LogoLogin.png")));
		lblNewLabel_1.setBounds(382, 64, 147, 144);
		getContentPane().add(lblNewLabel_1);
	}

	/**
	 * Método principal que inicia la aplicación.
	 * <p>
	 * Crea una instancia de la ventana de Login y la hace visible. Este es el punto
	 * de entrada del sistema.
	 * </p>
	 * 
	 * @param args Argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		new Login().setVisible(true);
	}

	/**
	 * Maneja los eventos de acción de los botones de la ventana.
	 * <p>
	 * Actualmente solo maneja el evento del botón "Cancelar".
	 * </p>
	 * 
	 * @param e El evento de acción generado por un componente
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	/**
	 * Cierra la ventana de login y finaliza la aplicación.
	 * <p>
	 * Este método se ejecuta cuando el usuario presiona el botón "Cancelar".
	 * Termina la ejecución del programa sin iniciar sesión.
	 * </p>
	 * 
	 * @param e El evento de acción del botón cancelar
	 */
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}