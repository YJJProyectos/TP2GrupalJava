package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algo3.algocraft.controlador.MouseTocarCasillaVacia;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

@SuppressWarnings({ "serial", "unused" })
public class VistaCasilla extends JPanel implements Observer{

	private boolean yaPusoLaTierra = false;
	private int numero;
	private HashMap<Object, Object> labels;
	private ConjuntoDeVistas vistas;
	private JLabel labelTerrestre;
	private JLabel labelAereo;
	private Casilla casilla;
	private PanelJuego panelJuego;

	// private JLabel labelRecurso;
	// private Casilla casilla;

	public VistaCasilla(Casilla casilla,PanelJuego panelJuego) {
		super();
		this.setLayout(new BorderLayout());
		this.panelJuego = panelJuego;
		this.casilla = casilla;
		this.vistas = new ConjuntoDeVistas(this.casilla,this.panelJuego);
		// this.casilla = casilla;
		casilla.addObserver(this);
		this.actualizarDatos();
		this.addMouseListener(new MouseTocarCasillaVacia(this.casilla,this.panelJuego,this));

	}

	public void inicializarLabels() {

		//labels.put(Marine.class, new VistaMarine());
		//labels.put(Golliat.class, new VistaGolliat());
		//labels.put(MinaDeMinerales.class, new VistaMinaDeMinerales());
		//labels.put(VolcanDeGasVespeno.class, new VistaVolcanDeGas());
		// labels.put(Barraca.class, new VistaBarraca());
		// labels.put(Fabrica.class, new VistaFabrica());
		// labels.put(PuertoEstelar.class, new VistaPuertoEstelar());

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
		//agrego espectro para probar
		/*labelAereo = this.vistas.getVista(Espectro.class);
		this.add(labelAereo,BorderLayout.NORTH); */
	}

	public void paintComponent(Graphics grafico) {

		// super.paintComponent(grafico);
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

	// ESTO ESTABA EN VISTA TIERRA:

	/*
	 * public VistaTierra(){ super(); //this.setLayout(null); this.setLayout(new
	 * BorderLayout()); // todo lo de abajo es para meter las vistas aleatorias
	 * int numero = (int) Math.round(Math.random()*3); JLabel labelTerrestre =
	 * null; switch (numero){ case 0: labelTerrestre = new VistaMarine();
	 * this.add(labelTerrestre,BorderLayout.WEST); break; case 1: labelTerrestre
	 * = new VistaGolliat(); this.add(labelTerrestre,BorderLayout.WEST); break;
	 * case 2: labelTerrestre = new VistaMinaDeMineral();
	 * this.add(labelTerrestre,BorderLayout.WEST); break; case 3: labelTerrestre
	 * = new VistaVolcanDeGas(); this.add(labelTerrestre,BorderLayout.WEST);
	 * break; default: break; } numero = (int) Math.round(Math.random()); JLabel
	 * labelAereo = null; if (numero == 0) { labelAereo = new VistaNave();
	 * this.add(labelAereo, BorderLayout.NORTH); } }
	 */

}
