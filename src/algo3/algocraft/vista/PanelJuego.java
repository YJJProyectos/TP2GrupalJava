package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.modelo.unidades.Unidad;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {

	private JPanel panelSuperior;
	private PanelMapa panelMapa;
	private PanelBotones panelBotones;
	private PanelInformacion panelInformacion;
	private Juego juego;
	@SuppressWarnings("unused")
	private Casilla casillaActual;
	@SuppressWarnings("unused")
	private Unidad unidadActual;

	public PanelJuego(Juego juego) throws CoordenadaInvalidaError {
		super();
		this.juego = juego;
		this.setPaneles();
	}

	private void setPaneles() throws CoordenadaInvalidaError {
		this.setLayout(new BorderLayout());

		this.panelSuperior = new JPanel();
		this.panelSuperior.setLayout(new BorderLayout());
		this.panelMapa = new PanelMapa(this.juego.getMapa(),this);
		this.panelBotones = new PanelBotones(this, juego.turnoDeJugador());
		this.panelSuperior.add(panelMapa, BorderLayout.EAST);
		this.panelSuperior.add(panelBotones, BorderLayout.WEST);
		this.add(panelSuperior, BorderLayout.NORTH);

		this.panelInformacion = new PanelInformacion(this.juego);
		this.add(panelInformacion, BorderLayout.SOUTH);

	}

	@Override
	public void setSize(int ancho, int alto) {
		super.setSize(ancho, alto);
		this.panelInformacion.setTamanio(ancho, alto);
		this.panelMapa.setTamanio(ancho, alto);
		// this.panelSuperior.setSize(ancho, alto);
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

	public void actualizar() {
		this.panelInformacion.actualizarDatos();
		this.panelMapa.actualizarDatos();
	}

	public void pasarTurno() {
		this.juego.pasarTurno();
		this.actualizar();
	}

	public void setCasillaActual(Casilla casilla) {
		this.casillaActual = casilla;	
	}

	public void vistaInformacionEdificio(Unidad edificio) {
		this.panelInformacion.informacionEdificio(edificio);
	}

	public void setSinInformacionAdicional() {
		this.panelInformacion.setSinInformacionAdicional();
	}
}
