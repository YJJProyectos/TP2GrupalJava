package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel {

	private JButton botonCrearRefineria;
	private JButton botonCrearCentroMineral;
	private JButton botonCrearBarraca;
	private JButton botonCrearFabrica;
	private JButton botonCrearPuertoEstelar;
	private JButton botonPasarTurno;

	public PanelBotones() {

		super();
		this.setLayout(new GridLayout(20, 1));

		this.botonCrearRefineria = new JButton();
		this.botonCrearRefineria.setText("Crear Refineria");
		// this.botonCrearRefineria.setBounds(ancho/2 - 100, alto/2 -100, 120,
		// 50);
		// this.botonCrearRefineria
		// .addActionListener(new AccionBotonCrearRefineria(this));

		this.botonCrearCentroMineral = new JButton();
		this.botonCrearCentroMineral.setText("Crear Centro Mineral");
		// this.botonCrearCentroMineral.setBounds(ancho/2 - 100, alto/2 -100,
		// 120, 50);
		// this.botonCrearCentroMineral.addActionListener(new
		// AccionBotonCrearCentroMineral(this);

		this.botonCrearBarraca = new JButton();
		this.botonCrearBarraca.setText("Crear Barraca");
		// this.botonCrearBarraca.setBounds(ancho/2 - 100, alto/2 -100, 120,
		// 50);
		// this.botonCrearBarraca.addActionListener(new
		// AccionBotonCrearBarraca(this);

		this.botonCrearFabrica = new JButton();
		this.botonCrearFabrica.setText("Crear Fabrica");
		// this.botonCrearFabrica.setBounds(ancho/2 - 100, alto/2 -100, 120,
		// 50);
		// this.botonCrearFabrica.addActionListener(new
		// AccionBotonCrearFabrica(this);

		this.botonCrearPuertoEstelar = new JButton();
		this.botonCrearPuertoEstelar.setText("Crear Puerto Estelar");
		// this.botonCrearPuertoEstelar.setBounds(ancho/2 - 100, alto/2 -100,
		// 120, 50);
		// this.botonCrearPuertoEstelar.addActionListener(new
		// AccionBotonCrearPuertoEstelar(this);

		this.botonPasarTurno = new JButton();
		this.botonPasarTurno.setText("Pasar Turno");
		// this.botonPasarTurno.setBounds(ancho/2 - 100, alto/2 -100, 120, 50);
		// this.botonPasarTurno.addActionListener(new
		// AccionBotonPasarTurno(this);
		;
		this.add(this.botonCrearRefineria);
		this.add(this.botonCrearCentroMineral);
		this.add(this.botonCrearBarraca);
		this.add(this.botonCrearFabrica);
		this.add(this.botonCrearPuertoEstelar);
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
