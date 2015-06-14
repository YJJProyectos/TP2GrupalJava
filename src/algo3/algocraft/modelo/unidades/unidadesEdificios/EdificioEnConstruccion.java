package algo3.algocraft.modelo.unidades.unidadesEdificios;

import java.util.ArrayList;

import algo3.algocraft.modelo.unidades.Unidad;

public class EdificioEnConstruccion extends Unidad {
	private int turnosRestantes;
	private Unidad edificioTerminado;
	private ArrayList<Unidad> listaUnidades;

	public EdificioEnConstruccion(UnidadEdificio edificio,
			ArrayList<Unidad> listaUnidadesJugador) {
		this.vida = 1;
		this.edificioTerminado = edificio;
		this.turnosRestantes = edificio.tiempoDeConstruccion();
		this.listaUnidades = listaUnidadesJugador;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int verTurnosRestantes() {
		return turnosRestantes;
	}

	public void pasarTurno() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			posicion.desocuparTierra();
			edificioTerminado.posicionar(posicion);
			listaUnidades.remove(this);
			listaUnidades.add(edificioTerminado);

		}
	}

}
