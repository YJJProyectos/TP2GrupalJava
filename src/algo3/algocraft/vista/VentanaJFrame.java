package algo3.algocraft.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import algo3.algocraft.controlador.AccionMenuSalir;
import algo3.algocraft.controlador.AccionResolucion;

@SuppressWarnings("serial")
public class VentanaJFrame extends JFrame{
	
	
	private int ancho = 900;
	private int alto = 700;
	private PanelImagen panel;
	private JMenu mnOpciones;
	private JMenu mnNewMenu;
	private JMenuItem menuComenzarJuego;
	private JMenuItem menuItemSalir;
	private JMenuItem menuItem1024;
	private JMenuItem menuItem800;
	private JMenuItem menuItemDefecto;
	private JMenuItem menuItem1280;
	
	public VentanaJFrame(){
		this.setTitle("AlgoCraft");
		this.setSize(ancho, alto);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		String url = "/algo3/algocraft/imagenes/terranicono.jpg";
		this.setIconImage((new ImageIcon(getClass().getResource(url))).getImage());
		this.setLayout(null);
		panel = new PanelImagen();
		panel.setBounds(0, 0, ancho, alto);
		this.add(panel);
		this.setResizable(false);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		mnOpciones = new JMenu("Opciones");
		barraMenu.add(mnOpciones);
		
		menuComenzarJuego = new JMenuItem("Comenzar Juego");
		mnOpciones.add(menuComenzarJuego);
		
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new AccionMenuSalir());
		mnOpciones.add(menuItemSalir);
		
		mnNewMenu = new JMenu("Resoluciones");
		barraMenu.add(mnNewMenu);
		
		menuItem1280 = new JMenuItem("1280x1024");
		menuItem1280.addActionListener(new AccionResolucion(this, 1280, 1024));
		mnNewMenu.add(menuItem1280);
		
		menuItem1024 = new JMenuItem("1024x768");
		menuItem1024.addActionListener(new AccionResolucion(this, 1024, 768));
		mnNewMenu.add(menuItem1024);
		
		menuItem800 = new JMenuItem("800x600");
		menuItem800.addActionListener(new AccionResolucion(this, 800, 600));
		mnNewMenu.add(menuItem800);
		
		menuItemDefecto = new JMenuItem("Por defecto");
		menuItemDefecto.addActionListener(new AccionResolucion(this, 900, 700));
		mnNewMenu.add(menuItemDefecto);
	}
	public void setDimension(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		panel.setSize(ancho, alto);
		this.setSize(ancho, alto);
	}
}
