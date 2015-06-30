package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import algo3.algocraft.controlador.AccionBotonAtacar;
import algo3.algocraft.controlador.AccionBotonCrearBarraca;
import algo3.algocraft.controlador.AccionBotonCrearCentroMineral;
import algo3.algocraft.controlador.AccionBotonCrearDepositoDeSuministros;
import algo3.algocraft.controlador.AccionBotonCrearFabrica;
import algo3.algocraft.controlador.AccionBotonCrearPuertoEstelar;
import algo3.algocraft.controlador.AccionBotonCrearRefineria;
import algo3.algocraft.controlador.AccionBotonEntrenarEspectro;
import algo3.algocraft.controlador.AccionBotonEntrenarGolliat;
import algo3.algocraft.controlador.AccionBotonEntrenarMarine;
import algo3.algocraft.controlador.AccionBotonMover;
import algo3.algocraft.controlador.AccionBotonPasarTurno;
import algo3.algocraft.controlador.AccionBotonPosicionarSoldado;
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
	private JButton botonAtacar;
	private JButton botonMover;
	private JButton botonEntrenarMarine;
	private JButton botonEntrenarGolliat;
	private JButton botonEntrenarEspectro;

	private PanelJuego panelJuego;
	private Juego juego;

	public PanelBotones(PanelJuego panelJuego, Juego juego) {

		super();
		this.panelJuego = panelJuego;
		this.juego = juego;
		this.setLayout(new GridLayout(20, 1));

		this.botonCrearDeposito = new JButton();
		this.botonCrearDeposito.setText("Crear Deposito de Suministros");
		this.botonCrearDeposito
				.addActionListener(new AccionBotonCrearDepositoDeSuministros(
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
		this.botonCrearBarraca.addActionListener(new AccionBotonCrearBarraca(
				this.panelJuego, juego));

		this.botonCrearFabrica = new JButton();
		this.botonCrearFabrica.setText("Crear Fabrica");
		this.botonCrearFabrica.addActionListener(new AccionBotonCrearFabrica(
				this.panelJuego, juego));

		this.botonCrearPuertoEstelar = new JButton();
		this.botonCrearPuertoEstelar.setText("Crear Puerto Estelar");
		this.botonCrearPuertoEstelar
				.addActionListener(new AccionBotonCrearPuertoEstelar(
						this.panelJuego, juego));

		this.botonPosicionarSoldado = new JButton();
		this.botonPosicionarSoldado
				.setText("Posicionar Soldado"
						+ "("
						+ juego.turnoDeJugador()
								.cantidadSoldadosParaPosicionar() + ")");
		this.botonPosicionarSoldado
				.addActionListener(new AccionBotonPosicionarSoldado(
						this.panelJuego, juego));

		this.botonPasarTurno = new JButton();
		this.botonPasarTurno.setText("Pasar Turno");
		this.botonPasarTurno.addActionListener(new AccionBotonPasarTurno(
				this.panelJuego));

		this.botonAtacar = new JButton();
		this.botonAtacar.setText("Atacar");
		this.botonAtacar.addActionListener(new AccionBotonAtacar(
				this.panelJuego, juego));

		this.botonMover = new JButton();
		this.botonMover.setText("Mover");
		this.botonMover.addActionListener(new AccionBotonMover(this.panelJuego,
				juego));

		this.botonEntrenarMarine = new JButton();
		this.botonEntrenarMarine.setText("Entrenar Marine");
		this.botonEntrenarMarine
				.addActionListener(new AccionBotonEntrenarMarine(
						this.panelJuego, juego));

		this.botonEntrenarGolliat = new JButton();
		this.botonEntrenarGolliat.setText("Entrenar Golliat");
		this.botonEntrenarGolliat
				.addActionListener(new AccionBotonEntrenarGolliat(
						this.panelJuego, juego));

		this.botonEntrenarEspectro = new JButton();
		this.botonEntrenarEspectro.setText("Entrenar Espectro");
		this.botonEntrenarEspectro
				.addActionListener(new AccionBotonEntrenarEspectro(
						this.panelJuego, juego));

		this.botonAtacar.setVisible(false);
		this.botonMover.setVisible(false);
		this.botonEntrenarMarine.setVisible(false);
		this.botonEntrenarGolliat.setVisible(false);
		this.botonEntrenarEspectro.setVisible(false);

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
		this.add(Box.createHorizontalStrut(20));
		this.add(this.botonAtacar);
		this.add(this.botonMover);
		this.add(Box.createHorizontalStrut(20));
		this.add(this.botonEntrenarMarine);
		this.add(this.botonEntrenarGolliat);
		this.add(this.botonEntrenarEspectro);

	}

	public void visibilidadBotonEntrenarMarine(Boolean booleano) {
		this.botonEntrenarMarine.setVisible(booleano);
	}

	public void visibilidadBotonEntrenarGolliat(Boolean booleano) {
		this.botonEntrenarGolliat.setVisible(booleano);
	}

	public void visibilidadBotonEntrenarEspectro(Boolean booleano) {
		this.botonEntrenarEspectro.setVisible(booleano);
	}

	public void visibilidadBotonesUnidadSoldado(Boolean booleano) {
		this.botonAtacar.setVisible(booleano);
		this.botonMover.setVisible(booleano);
	}

	public void visibilidadCasillasEspeciales(Boolean booleano) {
		this.botonEntrenarMarine.setVisible(booleano);
		this.botonEntrenarGolliat.setVisible(booleano);
		this.botonEntrenarEspectro.setVisible(booleano);
		this.botonAtacar.setVisible(booleano);
		this.botonMover.setVisible(booleano);
	}

	public void setTamanio(int ancho, int alto) {
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ((int) (ancho * 0.7));
		int porcentajeAlto = alto - ((int) (alto * 0.6));
		this.setPreferredSize(new Dimension(porcentajeAncho, porcentajeAlto));
	}

	public void actualizarDatos() {
		this.botonPosicionarSoldado.setText("Posicionar Soldado" + "("
				+ this.juego.turnoDeJugador().cantidadSoldadosParaPosicionar()
				+ ")");
	}

}
