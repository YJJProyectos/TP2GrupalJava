package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algo3.algocraft.controlador.MouseTocarCasillaVacia;
import algo3.algocraft.modelo.mapa.Casilla;

@SuppressWarnings("serial")
public class VistaCasilla extends JPanel implements Observer{

	private boolean yaPusoLaTierra = false;
	private int numero;
	private ConjuntoDeVistas vistas;
	private JLabel labelTerrestre;
	private JLabel labelAereo;
	private Casilla casilla;
	private PanelJuego panelJuego;


	public VistaCasilla(Casilla casilla,PanelJuego panelJuego) {
		super();
		this.setLayout(new BorderLayout());
		this.panelJuego = panelJuego;
		this.casilla = casilla;
		this.vistas = new ConjuntoDeVistas(this.casilla,this.panelJuego);
		casilla.addObserver(this);
		this.actualizarDatos();
		this.addMouseListener(new MouseTocarCasillaVacia(this.casilla,this.panelJuego,this));

	}

	public void actualizarDatos() {
		
		this.sacarBorde();
		
		if ( labelTerrestre != null){
			this.remove(labelTerrestre);
		}
		if ( labelAereo != null){
			this.remove(labelAereo);
		}
		if ( this.casilla.estaOcupadoElRecurso() ){
			labelTerrestre = 
				this.vistas.getVista(this.casilla.getRecurso().getClass());
			this.add(labelTerrestre,BorderLayout.WEST);
		}
		if ( this.casilla.estaOcupadaLaTierra() ){
			if ( labelTerrestre != null){
				this.remove(labelTerrestre);
			}
			labelTerrestre = 
				this.vistas.getVista(this.casilla.getOcupanteTerrestre().getClass());
			this.add(labelTerrestre,BorderLayout.WEST);
		}
		if ( this.casilla.estaOcupadoElAire() ){
			labelAereo = 
			this.vistas.getVista(this.casilla.getOcupanteAereo().getClass());
			this.add(labelAereo,BorderLayout.EAST);
		}
		this.repaint();
	}

	public void paintComponent(Graphics grafico) {

		Dimension dimension = getSize();
		if (!this.yaPusoLaTierra) {
			this.numero = (int) Math.round(Math.random() * 4);
		}
		String url;
		switch (numero) {
		case 0:
			url = "/algo3/algocraft/imagenes/tierra.jpg";
			break;
		case 1:
			url = "/algo3/algocraft/imagenes/tierra1.jpg";
			break;
		case 2:
			url = "/algo3/algocraft/imagenes/tierra2.jpg";
			break;
		default:
			url = "/algo3/algocraft/imagenes/tierra3.jpg";
			break;
		}
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		grafico.drawImage(imagen.getImage(), 0, 0, (int) dimension.getWidth(),
				(int) dimension.getHeight(), null);
		this.setOpaque(false);
		this.yaPusoLaTierra = true;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.actualizarDatos();
		
	}

	public void sacarBorde() {
		this.setBorder(null);
		if ( this.labelTerrestre != null){
			this.labelTerrestre.setBorder(null);
		}
		if ( this.labelAereo != null){
			this.labelAereo.setBorder(null);
		}
	}

}
