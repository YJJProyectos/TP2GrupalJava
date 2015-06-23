package algo3.algocraft.vista;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import algo3.algocraft.controlador.AccionEmpezar;
import algo3.algocraft.controlador.AccionEmpezarMapaJuego;
import algo3.algocraft.controlador.AccionSalir;
import algo3.algocraft.controlador.AccionResolucion;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentanaJFrame extends JFrame{
	
	
	private int ancho = 900;
	private int alto = 700;
	private JPanel panel,comenzarPanel,juegoPanel;
	private JMenu mnOpciones;
	private JMenu mnNewMenu;
	private JMenuItem menuComenzarJuego;
	private JMenuItem menuItemSalir;
	private JMenuItem menuItem1024;
	private JMenuItem menuItem800;
	private JMenuItem menuItemDefecto;
	private JButton botonComenzar,botonSalir,botonEmpezarMapa;
	private Container contenedor;
	
	public VentanaJFrame(){
		this.setTitle("AlgoCraft");
		Dimension dimension = this.getToolkit().getScreenSize();
		ancho = (int) dimension.getWidth();
		alto = (int) dimension.getHeight();
		this.setSize(ancho, alto);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		String url = "/algo3/algocraft/imagenes/terranicono.jpg";
		this.setIconImage((new ImageIcon(getClass().getResource(url))).getImage());
		contenedor = this.getContentPane();
		panel = new PanelImagen();
		panel.setSize(ancho, alto);
		contenedor.add(panel);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		mnOpciones = new JMenu("Opciones");
		barraMenu.add(mnOpciones);
		
		menuComenzarJuego = new JMenuItem("Reiniciar Juego");
		mnOpciones.add(menuComenzarJuego);
		
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new AccionSalir());
		mnOpciones.add(menuItemSalir);
		
		mnNewMenu = new JMenu("Resoluciones");
		barraMenu.add(mnNewMenu);
		
		menuItem1024 = new JMenuItem("1024x768");
		menuItem1024.addActionListener(new AccionResolucion(this, 1024, 768));
		mnNewMenu.add(menuItem1024);
		
		menuItem800 = new JMenuItem("800x600");
		menuItem800.addActionListener(new AccionResolucion(this, 800, 600));
		mnNewMenu.add(menuItem800);
		
		menuItemDefecto = new JMenuItem("Por defecto");
		menuItemDefecto.addActionListener(new AccionResolucion(this, 900, 700));
		mnNewMenu.add(menuItemDefecto);
		
		botonComenzar = new JButton();
		botonComenzar.setText("Comenzar Juego");
		botonComenzar.setBounds(ancho/2 - 100, alto/2 -100, 120, 50);
		botonComenzar.addActionListener(new AccionEmpezar(this));
		panel.add(botonComenzar);
		botonSalir = new JButton();
		botonSalir.setText("Salir");
		botonSalir.setBounds(ancho/2 -100, alto/2, 120, 50);
		botonSalir.addActionListener(new AccionSalir());
		panel.add(botonSalir);
		comenzarPanel = new ComenzarPanel();
		botonEmpezarMapa = new JButton();
		
	}
	public void setDimension(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		panel.setSize(ancho, alto);
		botonComenzar.setBounds(ancho/2 - 100, alto/2 -100, 120, 50);
		botonSalir.setBounds(ancho/2 -100, alto/2, 120, 50);
		botonEmpezarMapa.setBounds(ancho/2 - 100, alto/2 -100, 120, 50);
		comenzarPanel.setSize(ancho, alto);
		if ( juegoPanel != null){
			juegoPanel.setSize(ancho, alto);
		}
		this.setSize(ancho, alto);
	}
	public void cambiarPanelCargaDatos() {
		botonEmpezarMapa.setText("Mostrar Mapa");
		botonEmpezarMapa.setBounds(ancho/2 - 100, alto/2 -100, 120, 50);
		botonEmpezarMapa.addActionListener(new AccionEmpezarMapaJuego(this));
		comenzarPanel.add(botonEmpezarMapa);
		comenzarPanel.setSize(ancho, alto);
		contenedor.add(comenzarPanel);
		this.panel.setVisible(false);
		comenzarPanel.setVisible(true);
	}
	public void muestraPanelJuego() {
		this.panel.setVisible(false);
		this.comenzarPanel.setVisible(false);
		this.juegoPanel = new JuegoPanel(20, 20); // dimensiones mapa
		this.add(this.juegoPanel);
		this.juegoPanel.setSize(ancho, alto);
		this.juegoPanel.setVisible(true);
	}
}
