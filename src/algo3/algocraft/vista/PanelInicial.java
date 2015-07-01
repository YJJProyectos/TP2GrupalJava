package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelInicial extends JPanel {

	private JLabel labelTitulo;

	public PanelInicial() {
		super();
		this.setLayout(null);
		labelTitulo = new JLabel();
		String url = "/algo3/algocraft/imagenes/algocraft.png";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(600,
				60, Image.SCALE_SMOOTH));
		labelTitulo.setIcon(imagenEscalada);
		labelTitulo.setSize(600, 60);
		this.add(labelTitulo);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tam = this.getSize();
		String url = "/algo3/algocraft/imagenes/starcraft.jpg";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		g.drawImage(imagen.getImage(), 0, 0, (int) tam.getWidth(),
				(int) tam.getHeight(), null);
		this.setOpaque(false);
	}

	@Override
	public void setSize(int ancho, int alto) {
		super.setSize(ancho, alto);
		labelTitulo.setLocation(ancho / 2 - 300, alto / 2 - 200);
	}

}