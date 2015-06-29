package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import algo3.algocraft.controlador.AccionBotonCrearCentroMineral;
import algo3.algocraft.controlador.AccionBotonCrearDeposotoDeSuministros;
import algo3.algocraft.controlador.AccionBotonCrearRefineria;
import algo3.algocraft.controlador.AccionBotonPasarTurno;
import algo3.algocraft.modelo.juego.Juego;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel {

	private JButton botonCrearDeposito;
	private JButton botonCrearRefineria;
	private JButton botonCrearCentroMineral;
	private JButton botonCrearBarraca;
	private JButton botonCrearFabrica;
	private JButton botonCrearPuertoEstelar;
	private JButton botonPasarTurno;
	private JButton botonPosicionarSoldado;
	private PanelJuego panelJuego;

	public PanelBotones(PanelJuego panelJuego, Juego juego) {

		super();
		this.panelJuego = panelJuego;
		this.setLayout(new GridLayout(20, 1));

		this.botonCrearDeposito = new JButton();
		this.botonCrearDeposito.setText("Crear Deposito de Suministros");
		this.botonCrearDeposito
				.addActionListener(new AccionBotonCrearDeposotoDeSuministros(
						this.panelJuego, juego));

		this.botonCrearRefineria = new JButton();
		this.botonCrearRefineria.setText("Crear Refineria");
		this.botonCrearRefineria
				.addActionListener(new AccionBotonCrearRefineria(
						this.panelJuego, juego));

		this.botonCrearCentroMineral = new JButton();
		this.botonCrearCentroMineral.setText("Crear Centro Mineral");
		this.botonCrearCentroMineral
				.addActionListener(new AccionBotonCrearCentroMineral(
						this.panelJuego, juego));

		this.botonCrearBarraca = new JButton();
		this.botonCrearBarraca.setText("Crear Barraca");
		// this.botonCrearBarraca.addActionListener(new
		// AccionBotonCrearBarraca(this);

		this.botonCrearFabrica = new JButton();
		this.botonCrearFabrica.setText("Crear Fabrica");
		// this.botonCrearFabrica.addActionListener(new
		// AccionBotonCrearFabrica(this);

		this.botonCrearPuertoEstelar = new JButton();
		this.botonCrearPuertoEstelar.setText("Crear Puerto Estelar");
		// this.botonCrearPuertoEstelar.addActionListener(new
		// AccionBotonCrearPuertoEstelar(this);
		this.botonPosicionarSoldado = new JButton();
		this.botonPosicionarSoldado.setText("Posicionar Soldado" + "("
				+ juego.turnoDeJugador().caintidadSoldadosParaPosicionar()
				+ ")");
		// this.botonPosicionarSoldado.addActionListener(new
		// AccionBotonPosicionarSoldado(this);

		this.botonPasarTurno = new JButton();
		this.botonPasarTurno.setText("Pasar Turno");
		this.botonPasarTurno.addActionListener(new AccionBotonPasarTurno(
				this.panelJuego));
		;
		this.add(this.botonCrearDeposito);
		this.add(this.botonCrearRefineria);
		this.add(this.botonCrearCentroMineral);
		this.add(this.botonCrearBarraca);
		this.add(this.botonCrearFabrica);
		this.add(this.botonCrearPuertoEstelar);
		this.add(Box.createHorizontalStrut(20));
		this.add(this.botonPosicionarSoldado);
		this.add(Box.createHorizontalStrut(20));
		this.add(this.botonPasarTurno);
	}

	public void setTamanio(int ancho, int alto) {
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ((int) (ancho * 0.7));
		int porcentajeAlto = alto - ((int) (alto * 0.6));
		this.setPreferredSize(new Dimension(porcentajeAncho, porcentajeAlto));
	}

}
