package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.Jugador;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {
	
	private JTextField cantidadMineral;
	private JTextField cantidadGas;
	private JTextField poblacion;
	private Juego juego;
	
	public PanelInformacion(Juego juego){
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
		this.poblacion.setBounds(303, 90, 149, 20);
		this.setLayout(null);
		this.add(labelMineral);
		this.add(cantidadMineral);
		this.add(labelGas);
		this.add(cantidadGas);
		this.add(labelPoblacion);
		this.add(poblacion);
		this.actualizarDatos();
	}
	
	private void actualizarDatos() {
		Jugador jugadorActual = this.juego.turnoDeJugador();
		String numeroMineral = Integer.toString(jugadorActual.cantidadMineral());
		String numeroGas = Integer.toString(jugadorActual.cantidadGas());
		String poblacionOcupada = Integer.toString(jugadorActual.cantidadPoblacionOcupada());
		String poblacionMax = Integer.toString(jugadorActual.cantidadPoblacionPosible());
		this.cantidadMineral.setText(numeroMineral);
		this.cantidadGas.setText(numeroGas);
		this.poblacion.setText(poblacionOcupada + "/" + poblacionMax); 
	}

	@Override
	public void paintComponent(Graphics g){
		Dimension tam = this.getSize();
		String url = "/algo3/algocraft/imagenes/fondoInformacion.jpg";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		g.drawImage(imagen.getImage(), 0, 0, (int)tam.getWidth(), (int)tam.getHeight(), null);
		this.setOpaque(false);
	}
	
	public void setTamanio(int ancho , int alto){
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ( (int) ( ancho * 0.7 ) );
		int porcentajeAlto = alto - ( (int) ( alto * 0.6));
		this.setPreferredSize(new Dimension(porcentajeAncho , porcentajeAlto));
	}
}
