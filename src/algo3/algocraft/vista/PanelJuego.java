package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {

	private PanelInformacion panelInformacion;
	private JPanel panelSuperior;
	private PanelMapa panelMapa;
	private PanelBotones panelBotones;

	public PanelJuego(int fila, int columna) {
		super();
		this.setPaneles(fila, columna);
	}

	private void setPaneles(int fila, int columna) {
		this.setLayout(new BorderLayout());
		this.panelInformacion = new PanelInformacion();
		this.panelSuperior = new JPanel();
		this.panelSuperior.setLayout(new BorderLayout());
		this.panelMapa = new PanelMapa(fila, columna);
		this.panelBotones = new PanelBotones();
		this.panelSuperior.add(panelMapa, BorderLayout.EAST);
		this.panelSuperior.add(panelBotones, BorderLayout.WEST);
		this.add(panelSuperior, BorderLayout.NORTH);
		this.add(panelInformacion, BorderLayout.SOUTH);

		for (int x = 0; x < fila; x++) {

			for (int y = 0; y < columna; y++) {
				panelMapa.add(new VistaTierra());
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
