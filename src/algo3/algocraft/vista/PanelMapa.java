package algo3.algocraft.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.modelo.mapa.Mapa;

@SuppressWarnings("serial")
public class PanelMapa extends JPanel {

	@SuppressWarnings("unused")
	private Mapa mapa;
	//private HashMap<Coordenada, VistaCasilla> vistaTablero;
	private PanelJuego panelJuego;

	public PanelMapa(Mapa mapa,PanelJuego panelJuego) throws CoordenadaInvalidaError {
		super();
		this.mapa = mapa;
		this.panelJuego = panelJuego;
		this.setLayout(new GridLayout(mapa.getFilas(), mapa.getColumnas()));

		for (int x = 1; x <= mapa.getFilas(); x++) {
			for (int y = 1; y <= mapa.getColumnas(); y++) {
				Coordenada coordenada = new Coordenada(x, y);
				Casilla casilla = mapa.getCasilla(coordenada);
				VistaCasilla vistaCasilla = new VistaCasilla(casilla,this.panelJuego);
				this.add(vistaCasilla);
			}
		}

	}

	public void actualizarDatos() {

		this.sacarBordes();
	}

	public void setTamanio(int ancho, int alto) {
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ((int) (ancho * 0.3));
		int porcentajeAlto = alto - ((int) (alto * 0.4));
		this.setPreferredSize(new Dimension(porcentajeAncho, porcentajeAlto));
	}

	public void sacarBordes() {
		Component[] componentes= this.getComponents(); 
		for (int i = 0; i < componentes.length; i++){
		 ((VistaCasilla) componentes[i]).sacarBorde();
		}
	}

}
