package algo3.algocraft.vista;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import algo3.algocraft.controlador.AccionAcercaDeCreadores;
import algo3.algocraft.controlador.AccionEmpezar;
import algo3.algocraft.controlador.AccionEmpezarMapaJuego;
import algo3.algocraft.controlador.AccionReiniciar;
import algo3.algocraft.controlador.AccionSalir;
import algo3.algocraft.controlador.AccionResolucion;
import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.Jugador;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentanaInicio extends JFrame{
	
	
	private int ancho = 900;
	private int alto = 700;
	private JPanel inicioPanel,comenzarPanel,juegoPanel;
	private JMenu menuArchivo;
	private JMenu menuResoluciones;
	private JMenu menuAcercaDe;
	private JMenuItem menuComenzarJuego;
	private JMenuItem menuItemSalir,menuItem1024,menuItem800,menuItemDefecto,
	                  menuItemResMaxima;
	private JMenuItem menuCreadores;
	private JButton botonComenzar,botonSalir,botonEmpezarMapa;
	private Container contenedor;
	
	private Juego juego;
	
	public VentanaInicio(){
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
		inicioPanel = new PanelInicial();
		inicioPanel.setSize(ancho, alto);
		contenedor.add(inicioPanel);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		menuArchivo = new JMenu("Archivo");
		barraMenu.add(menuArchivo);
		
		menuComenzarJuego = new JMenuItem("Reiniciar Juego");
		menuComenzarJuego.addActionListener(new AccionReiniciar(this));
		menuArchivo.add(menuComenzarJuego);
		
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new AccionSalir());
		menuArchivo.add(menuItemSalir);
		
		menuResoluciones = new JMenu("Resoluciones");
		barraMenu.add(menuResoluciones);
		
		menuItemResMaxima = new JMenuItem("Pantalla completa");
		menuItemResMaxima.addActionListener(new AccionResolucion(this,
				(int)dimension.getWidth(),(int)dimension.getHeight()));
		menuResoluciones.add(menuItemResMaxima);
		
		menuItem1024 = new JMenuItem("1024x768");
		menuItem1024.addActionListener(new AccionResolucion(this, 1024, 768));
		menuResoluciones.add(menuItem1024);
		
		menuItem800 = new JMenuItem("800x600");
		menuItem800.addActionListener(new AccionResolucion(this, 800, 600));
		menuResoluciones.add(menuItem800);
		
		menuItemDefecto = new JMenuItem("Por defecto");
		menuItemDefecto.addActionListener(new AccionResolucion(this, 900, 700));
		menuResoluciones.add(menuItemDefecto);
		
		menuAcercaDe = new JMenu("Acerca De");
		barraMenu.add(menuAcercaDe);
		
		menuCreadores = new JMenuItem("Creadores");
		menuCreadores.addActionListener(new AccionAcercaDeCreadores());
		menuAcercaDe.add(menuCreadores);
		
		botonComenzar = new JButton();
		botonComenzar.setText("Comenzar Juego");
		botonComenzar.setBounds(ancho/2 - 100, alto/2 -100, 130, 40);
		botonComenzar.addActionListener(new AccionEmpezar(this));
		inicioPanel.add(botonComenzar);
		botonSalir = new JButton();
		botonSalir.setText("Salir");
		botonSalir.setBounds(ancho/2 -100, alto/2, 130, 40);
		botonSalir.addActionListener(new AccionSalir());
		inicioPanel.add(botonSalir);
		comenzarPanel = new PanelComenzar();
		botonEmpezarMapa = new JButton();
		comenzarPanel.add(botonEmpezarMapa);
		comenzarPanel.setSize(ancho, alto);
		contenedor.add(comenzarPanel);
	}
	public void setDimension(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		inicioPanel.setSize(ancho, alto);
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
		botonEmpezarMapa.setBounds(ancho/2 - 100, alto/2 -100, 130, 40);
		botonEmpezarMapa.addActionListener(new AccionEmpezarMapaJuego(this));
		this.inicioPanel.setVisible(false);
		this.comenzarPanel.setVisible(true);
	}
	public void muestraPanelJuego() {
		this.inicioPanel.setVisible(false);
		if ( this.juegoPanel != null){
			this.juegoPanel.setVisible(false);
		}
		this.comenzarPanel.setVisible(false);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		this.juego = new Juego(jugador1, jugador2);
		this.juegoPanel = new PanelJuego(this.juego);
		this.add(this.juegoPanel);
		this.juegoPanel.setSize(ancho, alto);
		this.juegoPanel.setVisible(true);
	}
	
	public void reiniciar(){
		this.comenzarPanel.setVisible(false);
		if ( this.juegoPanel != null){
			this.juegoPanel.setVisible(false);
		}
		this.inicioPanel.setVisible(true);
	}
}
