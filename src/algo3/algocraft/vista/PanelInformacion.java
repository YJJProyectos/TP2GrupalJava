package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.Unidad;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {

	private JTextField cantidadMineral;
	private JTextField cantidadGas;
	private JTextField poblacion;
	private JTextField nombre;
	private JTextField vida;
	private JTextField delJugador;
	private Juego juego;

	public PanelInformacion(Juego juego) {
		super();
		this.juego = juego;
		JLabel labelMineral = new VistaMinerales();
		labelMineral.setBounds(0, 90, 32, 20);
		this.cantidadMineral = new JTextField(10);
		this.cantidadMineral.setEditable(false);
		this.cantidadMineral.setBounds(42, 90, 86, 20);
		this.cantidadMineral.setText("minerales");
		JLabel labelGas = new VistaGas();
		labelGas.setBounds(138, 90, 20, 25);
		this.cantidadGas = new JTextField();
		this.cantidadGas.setEditable(false);
		this.cantidadGas.setText("cantidad gases");
		this.cantidadGas.setBounds(168, 90, 93, 20);
		JLabel labelPoblacion = new VistaPoblacion();
		labelPoblacion.setBounds(273, 90, 20, 20);
		this.poblacion = new JTextField();
		this.poblacion.setEditable(false);
		this.poblacion.setText("poblacion / maxima ");
		this.poblacion.setBounds(303, 90, 100, 20);
		this.nombre = new JTextField();
		this.nombre.setEditable(false);
		this.nombre.setBounds(410, 90, 200, 20);
		this.vida = new JTextField();
		this.vida.setEditable(false);
		this.vida.setBounds(0, 120, 70, 20);
		this.delJugador = new JTextField();
		this.delJugador.setEditable(false);
		this.delJugador.setBounds(100, 120, 200, 20);
		this.setLayout(null);
		this.add(labelMineral);
		this.add(cantidadMineral);
		this.add(labelGas);
		this.add(cantidadGas);
		this.add(labelPoblacion);
		this.add(poblacion);
		this.add(nombre);
		this.add(vida);
		this.add(this.delJugador);
		this.setSinInformacionAdicional();
		this.actualizarDatos();
	}

	public void actualizarDatos() {
		Jugador jugadorActual = this.juego.turnoDeJugador();
		String numeroMineral = Integer
				.toString(jugadorActual.cantidadMineral());
		String numeroGas = Integer.toString(jugadorActual.cantidadGas());
		String poblacionOcupada = Integer.toString(jugadorActual
				.cantidadPoblacionOcupada());
		String poblacionMax = Integer.toString(jugadorActual
				.cantidadPoblacionPosible());
		String nombreJugador = jugadorActual.getNombre();
		this.cantidadMineral.setText(numeroMineral);
		this.cantidadGas.setText(numeroGas);
		this.poblacion.setText(poblacionOcupada + "/" + poblacionMax);
		this.nombre.setText("Jugador actual: " + nombreJugador);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tam = this.getSize();
		String url = "/algo3/algocraft/imagenes/fondoInformacion.jpg";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		g.drawImage(imagen.getImage(), 0, 0, (int) tam.getWidth(),
				(int) tam.getHeight(), null);
		this.setOpaque(false);
	}

	public void setTamanio(int ancho, int alto) {
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ((int) (ancho * 0.7));
		int porcentajeAlto = alto - ((int) (alto * 0.6));
		this.setPreferredSize(new Dimension(porcentajeAncho, porcentajeAlto));
	}

	public void informacionEdificio(Unidad edificio) {
		String vida = Integer.toString(edificio.vidaRestante());
		String jugador = edificio.getJugador().getNombre();
		this.delJugador.setText("Del jugador: " + jugador);
		this.delJugador.setVisible(true);
		this.vida.setText("Vida: " + vida);
		this.vida.setVisible(true);
	}

	public void setSinInformacionAdicional() {
		this.vida.setVisible(false);
		this.delJugador.setVisible(false);
	}
}
