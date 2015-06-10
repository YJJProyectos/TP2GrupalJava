package algo3.algocraft.modelo.recolectables;


public class MinaDeMinerales implements Recolectable {

	private int cantidadMineral;

	public MinaDeMinerales(int cantidad) {

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

	public int getCantidadMineral() {
		return this.cantidadMineral;
	}

}
