package tp2;

public class Mineral {

	private int cantidadMineral;

	public Mineral(int cantidad) {

		this.cantidadMineral = cantidad;
	}

	public int getMineral() {

		return this.cantidadMineral;
	}

	public int sacarMineral(int cantidadMineralASacar) {

		int cantidadMineralSacado = 0;

		if (this.cantidadMineral > 0) {
			cantidadMineralSacado = cantidadMineralASacar;
			if (this.cantidadMineral < cantidadMineralASacar){
				cantidadMineralSacado = this.cantidadMineral;
			}
			this.cantidadMineral -= cantidadMineralSacado;
		}

		return cantidadMineralSacado;
	}

}
