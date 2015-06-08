package edificables;

import juego.Turno;
import mapa.Casilla;
import accionables.Unidad;

public class EdificioEnConstruccion extends Unidad {

	private Turno turnoActual;
	private int turnoInicial;
	private int tiempoDeConstruccion;
	private Unidad edificioTerminado;
	private Casilla posicion;

	public EdificioEnConstruccion(Unidad edificio, Turno turnoActual, int turnosNecesarios) {
		this.vida = 1;
		this.edificioTerminado = edificio;
		this.turnoActual = turnoActual;
		this.turnoInicial = turnoActual.getTurno();
		this.tiempoDeConstruccion = turnosNecesarios;	
	}

	public boolean esTerrestre() {
		return true;
	}

	public int verTurnosRestantes() {
		return tiempoDeConstruccion - (turnoActual.getTurno() - turnoInicial);
	}

	public void continuarConstruccion(){
		if(tiempoDeConstruccion == (turnoActual.getTurno() - turnoInicial)){
			posicion.desocuparTierra();
			posicion.ocupar(edificioTerminado);
		}
	}
	
}
