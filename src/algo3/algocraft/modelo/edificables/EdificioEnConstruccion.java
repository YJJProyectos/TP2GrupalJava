package algo3.algocraft.modelo.edificables;

import java.util.ArrayList;

import algo3.algocraft.modelo.accionables.Unidad;

public class EdificioEnConstruccion extends Unidad {
	private int turnosRestantes;
	private Unidad edificioTerminado;
	private ArrayList<UnidadEdificio> listaQueAlmacenaEdificiosTerminados;
	private ArrayList<Unidad> listaQueAlmacenaEdificiosEnConstruccion;

	public EdificioEnConstruccion(UnidadEdificio edificio,
			ArrayList<UnidadEdificio> listaEdificiosTerminados,
			ArrayList<Unidad> listaEdificiosEnCOnstruccion) {
		this.vida = 1;
		this.edificioTerminado = edificio;
		this.turnosRestantes = edificio.tiempoDeConstruccion();
		this.listaQueAlmacenaEdificiosTerminados = listaEdificiosTerminados;
		this.listaQueAlmacenaEdificiosEnConstruccion = listaEdificiosEnCOnstruccion;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int verTurnosRestantes() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			posicion.desocuparTierra();
			edificioTerminado.posicionar(posicion);
			listaQueAlmacenaEdificiosTerminados.add((UnidadEdificio) edificioTerminado);
			listaQueAlmacenaEdificiosEnConstruccion.remove(this);
		}
	}

}
