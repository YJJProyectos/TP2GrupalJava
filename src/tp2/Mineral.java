package tp2;

import interfaces.Recolectable;

public class Mineral implements Recolectable {

	private int cantidadMineral;

	public Mineral(int cantidad) {

		this.cantidadMineral = cantidad;
	}

	public int extraerRecurso(int cantidadMineralASacar) {

		int cantidadMineralSacado = 0;

		if (this.cantidadMineral > 0) {
			cantidadMineralSacado = cantidadMineralASacar;
			if (this.cantidadMineral < cantidadMineralASacar) {
				cantidadMineralSacado = this.cantidadMineral;
			}
			this.cantidadMineral -= cantidadMineralSacado;
		}

		return cantidadMineralSacado;
	}

}
