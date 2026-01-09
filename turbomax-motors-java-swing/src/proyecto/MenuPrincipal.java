package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

/**
 * Ventana principal del sistema de ventas de automóviles "TurboMax Motors".
 * <p>
 * Contiene el menú principal con todas las opciones del sistema: mantenimiento
 * de automóviles, ventas, configuración de descuentos y obsequios. También
 * almacena las variables globales de configuración y estadísticas de ventas.
 * </p>
 * 
 * @author Alexander Carrasco
 * @version 1.0
 * @since 2025
 * @see Automovil
 * @see RepositorioAutos
 */
public class MenuPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguración;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarAutomovil;
	private JSeparator separator;
	private JMenuItem mntmModificarAutomovil;
	private JSeparator separator_1;
	private JMenuItem mntmListarAutomoviles;
	private JMenuItem mntmVender;
	private JMenuItem mntmConfigurarDescuentos;
	private JSeparator separator_2;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmAcercaTienda;

	Automovil auto1 = new Automovil("Toyota Corolla", 22000.0, "Blanco", 1350.5, "Nuevo");
	Automovil auto2 = new Automovil("Honda Civic", 24500.0, "Rojo", 1420.8, "Usado");
	Automovil auto3 = new Automovil("Tesla Model 3", 39990.0, "Gris", 1760.3, "Nuevo");
	Automovil auto4 = new Automovil("Chevrolet Tracker", 21000.0, "Azul", 1370.2, "Seminuevo");
	Automovil auto5 = new Automovil("Ford Mustang", 36000.0, "Negro", 1680.6, "Usado");

	/**
	 * Porcentajes de descuento según la cantidad de unidades compradas.
	 * <p>
	 * - porcentaje1: 1-5 unidades (5.0%) - porcentaje2: 6-10 unidades (7.5%) -
	 * porcentaje3: 11-15 unidades (10.0%) - porcentaje4: 16+ unidades (20.0%)
	 * </p>
	 */
	public static double porcentaje1 = 5.0;
	public static double porcentaje2 = 7.5;
	public static double porcentaje3 = 10.0;
	public static double porcentaje4 = 20.0;

	/**
	 * Obsequios según la cantidad de unidades compradas.
	 * <p>
	 * - obsequio1: 1 unidad - obsequio2: 2-5 unidades - obsequio3: 6+ unidades
	 * </p>
	 */
	public static String obsequio1 = "Vale para mantenimiento o revisión gratuita";
	public static String obsequio2 = "Kit premium de accesorios para auto";
	public static String obsequio3 = "Seguro vehicular gratuito por 1 año";

	/**
	 * Estadísticas de ventas por modelo de automóvil.
	 * <p>
	 * Los índices 0-4 corresponden a: 0=Toyota Corolla, 1=Honda Civic, 2=Tesla
	 * Model 3, 3=Chevrolet Tracker, 4=Ford Mustang
	 * </p>
	 */
	// Cantidad de ventas realizadas por modelo
	public static int canVenta0, canVenta1, canVenta2, canVenta3, canVenta4;

	// Cantidad de unidades vendidas por modelo
	public static int canUniVenta0, canUniVenta1, canUniVenta2, canUniVenta3, canUniVenta4;

	// Importes acumulados por modelo
	public static double impCompra0, impCompra1, impCompra2, impCompra3, impCompra4;
	public static double impPagar0, impPagar1, impPagar2, impPagar3, impPagar4;
	public static double impDesc0, impDesc1, impDesc2, impDesc3, impDesc4;

	/**
	 * Número total de ventas realizadas en el sistema.
	 */
	public static int numVenta = 0;

	/**
	 * Meta de ventas diaria en dólares.
	 */
	public static double cuotaDiaria = 200000.0;

	/**
	 * Constructor que inicializa la ventana principal y todos sus componentes.
	 * Configura el menú, establece el tamaño maximizado y carga la imagen de fondo.
	 */
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuPrincipal.class.getResource("/images/iconos/iconoTienda.png")));
		setTitle("TurboMax Motors 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoArchivo.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoSalir.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoMantenimiento.png")));
		menuBar.add(mnMantenimiento);

		mntmConsultarAutomovil = new JMenuItem("Consultar automóvil");
		mntmConsultarAutomovil
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoConsultarAutomovil.png")));
		mntmConsultarAutomovil.addActionListener(this);
		mnMantenimiento.add(mntmConsultarAutomovil);

		separator = new JSeparator();
		mnMantenimiento.add(separator);

		mntmModificarAutomovil = new JMenuItem("Modificar automóvil");
		mntmModificarAutomovil
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoModificarAutomovil.png")));
		mntmModificarAutomovil.addActionListener(this);
		mnMantenimiento.add(mntmModificarAutomovil);

		separator_1 = new JSeparator();
		mnMantenimiento.add(separator_1);

		mntmListarAutomoviles = new JMenuItem("Listar automóviles");
		mntmListarAutomoviles
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoListarAutomovil.png")));
		mntmListarAutomoviles.addActionListener(this);
		mnMantenimiento.add(mntmListarAutomoviles);

		mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoVentas.png")));
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoVender.png")));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);

		mnConfiguración = new JMenu("Configuración");
		mnConfiguración
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoConfiguracion.png")));
		menuBar.add(mnConfiguración);

		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.setIcon(
				new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoConfigurarDescuentos.png")));
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguración.add(mntmConfigurarDescuentos);

		separator_2 = new JSeparator();
		mnConfiguración.add(separator_2);

		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoConfigurarObsequios.png")));
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguración.add(mntmConfigurarObsequios);

		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoAyuda.png")));
		menuBar.add(mnAyuda);

		mntmAcercaTienda = new JMenuItem("Acerca de la tienda ");
		mntmAcercaTienda
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/iconos/iconoAcercaTienda.png")));
		mntmAcercaTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaTienda);

		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon icon = new ImageIcon(getClass().getResource("/images/Fondo.png"));
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Maneja los eventos de los elementos del menú. Delega cada acción a su método
	 * correspondiente.
	 * 
	 * @param e Evento generado por un elemento del menú
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcercaTienda) {
			actionPerformedMntmAcercaTienda(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarAutomoviles) {
			actionPerformedMntmListarAutomovil(e);
		}
		if (e.getSource() == mntmModificarAutomovil) {
			actionPerformedMntmModificarAutomovil(e);
		}
		if (e.getSource() == mntmConsultarAutomovil) {
			actionPerformedMntmConsultarAutomovil(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	/**
	 * Cierra la aplicación solicitando confirmación al usuario.
	 * 
	 * @param e Evento del menú "Salir"
	 */
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int salir;
		salir = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (salir == 0) {
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * Abre el diálogo para consultar información de automóviles.
	 * 
	 * @param e Evento del menú "Consultar automóvil"
	 */
	protected void actionPerformedMntmConsultarAutomovil(ActionEvent e) {
		ConsultarAutomovil ca = new ConsultarAutomovil();
		ca.setLocationRelativeTo(this);
		ca.setVisible(true);
	}

	/**
	 * Abre el diálogo para modificar datos de automóviles.
	 * 
	 * @param e Evento del menú "Modificar automóvil"
	 */
	protected void actionPerformedMntmModificarAutomovil(ActionEvent e) {
		ModificarAutomovil ma = new ModificarAutomovil();
		ma.setLocationRelativeTo(this);
		ma.setVisible(true);
	}

	/**
	 * Abre el diálogo para listar todos los automóviles.
	 * 
	 * @param e Evento del menú "Listar automóviles"
	 */
	protected void actionPerformedMntmListarAutomovil(ActionEvent e) {
		ListarAutomoviles la = new ListarAutomoviles();
		la.setLocationRelativeTo(this);
		la.setVisible(true);
	}

	/**
	 * Abre el diálogo para realizar una venta.
	 * 
	 * @param e Evento del menú "Vender"
	 */
	protected void actionPerformedMntmVender(ActionEvent e) {
		Vender v = new Vender();
		v.setLocationRelativeTo(this);
		v.setVisible(true);
	}

	/**
	 * Abre el diálogo para configurar los porcentajes de descuento.
	 * 
	 * @param e Evento del menú "Configurar descuentos"
	 */
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		ConfigurarDescuentos cd = new ConfigurarDescuentos();
		cd.setLocationRelativeTo(this);
		cd.setVisible(true);
	}

	/**
	 * Abre el diálogo para configurar los obsequios por cantidad.
	 * 
	 * @param e Evento del menú "Configurar obsequios"
	 */
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		ConfigurarObsequios co = new ConfigurarObsequios();
		co.setLocationRelativeTo(this);
		co.setVisible(true);
	}

	/**
	 * Abre el diálogo con información sobre la tienda.
	 * 
	 * @param e Evento del menú "Acerca de la tienda"
	 */
	protected void actionPerformedMntmAcercaTienda(ActionEvent e) {
		AcercaTienda at = new AcercaTienda();
		at.setLocationRelativeTo(this);
		at.setVisible(true);
	}
}