package algo3.algocraft.controlador.mouseRecurso;

import java.awt.event.MouseEvent;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

public class MouseTocarMinaDeMineral extends MouseTocarRecurso{

	public MouseTocarMinaDeMineral(Casilla casilla, PanelJuego panelJuego,
			Vistas vista) {
		super(casilla, panelJuego, vista);
	}
	
	@Override
	public void mouseClicked(MouseEvent click) {
		super.mouseClicked(click);
		if (click.getButton() == MouseEvent.BUTTON1) {
			this.panelJuego.setInformacionRecurso("Mina De Mineral", 
					this.casilla.getRecurso().getCantidad());
		}
	}

}
