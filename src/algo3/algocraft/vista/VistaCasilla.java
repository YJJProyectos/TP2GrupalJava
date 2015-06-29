package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.vista.terrestre.VistaGolliat;
import algo3.algocraft.vista.terrestre.VistaMarine;
import algo3.algocraft.vista.terrestre.VistaMinaDeMinerales;
import algo3.algocraft.vista.terrestre.VistaVolcanDeGas;

@SuppressWarnings("serial")
public class VistaCasilla extends JPanel {

	private boolean yaPusoLaTierra = false;
	private int numero;
	private HashMap<Object, Object> labels;
	private JLabel labelTerrestre;
	private JLabel labelAereo;

	// private JLabel labelRecurso;
	// private Casilla casilla;

	public VistaCasilla(Casilla casilla) {
		super();
		this.setLayout(new BorderLayout());
		// this.casilla = casilla;
		this.actualizarDatos();

	}

	public void inicializarLabels() {

		labels.put(Marine.class, new VistaMarine());
		labels.put(Golliat.class, new VistaGolliat());
		labels.put(MinaDeMinerales.class, new VistaMinaDeMinerales());
		labels.put(VolcanDeGasVespeno.class, new VistaVolcanDeGas());
		// labels.put(Barraca.class, new VistaBarraca());
		// labels.put(Fabrica.class, new VistaFabrica());
		// labels.put(PuertoEstelar.class, new VistaPuertoEstelar());

	}

	public void actualizarDatos() {

		// this.setLayout(null);
		// todo lo de abajo es para meter las vistas aleatorias

		int numero = (int) Math.round(Math.random() * 3);
		this.labelTerrestre = null;
		switch (numero) {
		case 0:
			labelTerrestre = new VistaMarine();
			this.add(labelTerrestre, BorderLayout.WEST);
			break;
		case 1:
			labelTerrestre = new VistaGolliat();
			this.add(labelTerrestre, BorderLayout.WEST);
			break;
		case 2:
			labelTerrestre = new VistaMinaDeMinerales();
			this.add(labelTerrestre, BorderLayout.WEST);
			break;
		case 3:
			labelTerrestre = new VistaVolcanDeGas();
			this.add(labelTerrestre, BorderLayout.WEST);
			break;
		default:
			break;
		}
		numero = (int) Math.round(Math.random());
		this.labelAereo = null;
		if (numero == 0) {
			labelAereo = new VistaNave();
			this.add(labelAereo, BorderLayout.NORTH);
		}

		// if (this.casilla.estaOcupadaLaTierra()) {
		// this.labelTerrestre = (JLabel) labels.get(this.casilla
		// .getOcupanteTerrestre().getClass());
		// this.add(this.labelTerrestre, BorderLayout.WEST);
		// }

		// if (this.casilla.estaOcupadoElAire()) {
		// this.labelAereo = (JLabel) labels.get(this.casilla
		// .getOcupanteAereo().getClass());
		// this.add(this.labelAereo, BorderLayout.NORTH);
		// }

		// if (this.casilla.estaOcupadoElRecurso()) {
		// this.labelRecurso = (JLabel) labels.get(this.casilla.getRecurso()
		// .getClass());
		// this.add(this.labelRecurso, BorderLayout.SOUTH);
		// }
		//
		// this.addMouseListener(new MouseTocarTerrestre(this));
		// this.addMouseListener(new MouseTocarAereo(this));
		// this.addMouseListener(new MouseTocarRecurso(this));

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
