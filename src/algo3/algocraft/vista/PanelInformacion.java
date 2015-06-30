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
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

@SuppressWarnings({ "serial" })
public class PanelInformacion extends JPanel {

	private JTextField cantidadMineral,cantidadGas,poblacion,unidadEnConstruccion;
	private JTextField nombre,vida,tipoUnidad,delJugador,enConstruccion;
	private JTextField danioTerrestre, danioAereo, rangoTerrestre, rangoAereo;
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
		this.tipoUnidad = new JTextField();
		this.tipoUnidad.setEditable(false);
		this.tipoUnidad.setBounds(0, 120, 200, 20);
		this.vida = new JTextField();
		this.vida.setEditable(false);
		this.vida.setBounds(230, 120, 70, 20);
		this.delJugador = new JTextField();
		this.delJugador.setEditable(false);
		this.delJugador.setBounds(330, 120, 190, 20);
		this.enConstruccion = new JTextField();
		this.enConstruccion.setEditable(false);
		this.enConstruccion.setBounds(540, 120, 160, 20);
		this.unidadEnConstruccion = new JTextField();
		this.unidadEnConstruccion.setEditable(false);
		this.unidadEnConstruccion.setBounds(720, 120, 150, 20);
		this.danioTerrestre = new JTextField();
		this.danioTerrestre.setEditable(false);
		this.danioTerrestre.setBounds(0, 150, 120, 20);
		this.rangoTerrestre = new JTextField();
		this.rangoTerrestre.setEditable(false);
		this.rangoTerrestre.setBounds(140, 150, 120, 20);
		this.danioAereo = new JTextField();
		this.danioAereo.setEditable(false);
		this.danioAereo.setBounds(280, 150, 120, 20);
		this.rangoAereo = new JTextField();
		this.rangoAereo.setEditable(false);
		this.rangoAereo.setBounds(420, 150, 120, 20);
		this.setLayout(null);
		this.add(labelMineral);
		this.add(this.cantidadMineral);
		this.add(labelGas);
		this.add(this.cantidadGas);
		this.add(labelPoblacion);
		this.add(this.poblacion);
		this.add(this.nombre);
		this.add(this.tipoUnidad);
		this.add(this.vida);
		this.add(this.delJugador);
		this.add(this.enConstruccion);
		this.add(this.danioTerrestre);
		this.add(this.rangoTerrestre);
		this.add(this.danioAereo);
		this.add(this.rangoAereo);
		this.add(this.unidadEnConstruccion);
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

	public void informacionEdificio(UnidadEdificio edificio) {
		this.setInformacionVidaNombreJugador(edificio);
		this.enConstruccion.setText
		("En construccion(" + edificio.tiempoDeConstruccion() + " turnos)" );
		if ( edificio.tiempoDeConstruccion() <= 0 ){
			this.enConstruccion.setText("Construido");
		}
		this.enConstruccion.setVisible(true);
	}

	public void setSinInformacionAdicional() {
		this.tipoUnidad.setVisible(false);
		this.vida.setVisible(false);
		this.delJugador.setVisible(false);
		this.enConstruccion.setVisible(false);
		this.danioTerrestre.setVisible(false);
		this.rangoTerrestre.setVisible(false);
		this.danioAereo.setVisible(false);
		this.rangoAereo.setVisible(false);
		this.unidadEnConstruccion.setVisible(false);
	}
	
	public void setInformacionUnidadEnEntrenamiento(String datos){
		this.unidadEnConstruccion.setText(datos);
		this.unidadEnConstruccion.setVisible(true);
	}

	public void informacionSoldado(UnidadSoldado soldado) {
		
		this.setInformacionVidaNombreJugador(soldado);
		String danioTerrestre = Integer.toString(soldado.getDanioTerrestre());
		String danioAereo = Integer.toString(soldado.getDanioAereo());
		String rangoTerrestre = Integer.toString(soldado.getRangoTerrestre());
		String rangoAereo = Integer.toString(soldado.getRangoAereo());
		this.danioTerrestre.setText("Danio Terrestre: "+ danioTerrestre );
		this.rangoTerrestre.setText("Rango Terrestre: " + rangoTerrestre);
		this.danioAereo.setText("Danio Aereo: " + danioAereo);
		this.rangoAereo.setText("Rango Aereo: "+ rangoAereo);
		this.danioTerrestre.setVisible(true);
		this.rangoTerrestre.setVisible(true);
		this.danioAereo.setVisible(true);
		this.rangoAereo.setVisible(true);
	}
	
	private void setInformacionVidaNombreJugador(Unidad unidad) {
		String tipoUnidad = unidad.getNombre();
		String vida = Integer.toString(unidad.vidaRestante());
		String jugador = unidad.getJugador().getNombre();
		this.tipoUnidad.setText(tipoUnidad);
		this.tipoUnidad.setVisible(true);
		this.delJugador.setText("Del jugador: " + jugador);
		this.delJugador.setVisible(true);
		this.vida.setText("Vida: " + vida);
		this.vida.setVisible(true);
	}
}
