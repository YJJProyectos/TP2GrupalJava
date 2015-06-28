package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {
	
	public PanelInformacion(){
		super();
		JLabel labelMineral = new VistaMinerales();
		labelMineral.setBounds(0, 90, 32, 20);
		JTextField cantidadMineral = new JTextField(10);
		cantidadMineral.setEditable(false);
		cantidadMineral.setBounds(42, 90, 86, 20);
		cantidadMineral.setText("minerales");
		JLabel labelGas = new VistaGas();
		labelGas.setBounds(138, 90, 20, 25);
		JTextField cantidadGas = new JTextField();
		cantidadGas.setEditable(false);
		cantidadGas.setText("cantidad gases");
		cantidadGas.setBounds(168, 90, 93, 20);
		JLabel labelPoblacion = new VistaPoblacion();
		labelPoblacion.setBounds(273, 90, 20, 20);
		JTextField poblacion = new JTextField();
		poblacion.setEditable(false);
		poblacion.setText("poblacion / maxima ");
		poblacion.setBounds(303, 90, 149, 20);
		setLayout(null);
		this.add(labelMineral);
		this.add(cantidadMineral);
		this.add(labelGas);
		this.add(cantidadGas);
		this.add(labelPoblacion);
		this.add(poblacion);
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
