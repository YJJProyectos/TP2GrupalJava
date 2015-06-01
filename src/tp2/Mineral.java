package tp2;

public class Mineral {

	private int cantidadMineral;

	public Mineral() {

		this.cantidadMineral = 1000;
	}

	public int getMineral() {

		return this.cantidadMineral;
	}

	public boolean sacarMineral(int cantidadMineralASacar) {

		boolean sePudoSacarMineral = false;

		if (this.cantidadMineral >= cantidadMineralASacar) {

			this.cantidadMineral -= cantidadMineralASacar;
			sePudoSacarMineral = true;
		}

		return sePudoSacarMineral;
	}

}
