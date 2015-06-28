package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {

	private PanelInformacion panelInformacion;
	private JPanel panelSuperior;
	private PanelMapa panelMapa;
	private PanelBotones panelBotones;
	private Juego juego;
	private Mapa mapa;

	public PanelJuego(int fila, int columna) {
		super();
		this.setPaneles(fila, columna);
	}

	public PanelJuego(Juego juego) {
		super();
		this.juego = juego;
		this.mapa = this.juego.getMapa();
		this.setPaneles(mapa.getFilas(), mapa.getColumnas());
	}

	private void setPaneles(int fila, int columna) {
		this.setLayout(new BorderLayout());
		this.panelInformacion = new PanelInformacion(this.juego);
		this.panelSuperior = new JPanel();
		this.panelSuperior.setLayout(new BorderLayout());
		this.panelMapa = new PanelMapa(fila, columna);
		this.panelBotones = new PanelBotones();
		this.panelSuperior.add(panelMapa, BorderLayout.EAST);
		this.panelSuperior.add(panelBotones, BorderLayout.WEST);
		this.add(panelSuperior, BorderLayout.NORTH);
		this.add(panelInformacion, BorderLayout.SOUTH);

		for (int x = 1; x <= fila; x++) {

			for (int y = 1; y <= columna; y++) {
				panelMapa.add(new VistaTierra(new Coordenada(fila, columna), this.mapa));
			}

		}
	}

	@Override
	public void setSize(int ancho, int alto) {
		super.setSize(ancho, alto);
		this.panelInformacion.setTamanio(ancho, alto);
		this.panelMapa.setTamanio(ancho, alto);
		//this.panelSuperior.setSize(ancho, alto);
		this.panelBotones.setTamanio(ancho, alto);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tam = this.getSize();
		String url = "/algo3/algocraft/imagenes/fondoNegro.jpg";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		g.drawImage(imagen.getImage(), 0, 0, (int) tam.getWidth(),
				(int) tam.getHeight(), null);
		this.setOpaque(false);
	}
}
