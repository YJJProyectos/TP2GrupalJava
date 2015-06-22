package algo3.algocraft.vista;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JuegoPanel extends JPanel {

	public JuegoPanel(int fila, int columna) {
		super();
		this.setPaneles(fila, columna);
	}

	private void setPaneles(int fila, int columna) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel otroPanel = new JPanel();
        otroPanel.setLayout(new GridLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JPanel panelInterior = new JPanel();
        panelInterior.setLayout(new GridLayout(fila, columna));
        JPanel otro = new JPanel();
        otro.setLayout(new GridLayout());
        panel.add(otro);
        panel.add(panelInterior);
        this.add(panel);
        this.add(otroPanel);
        
        for (int x = 0; x < fila; x++) {

        	for (int y = 0; y < columna; y++) {

        		panelInterior.add(new TierraVista());

        	}

        }
	}
}
