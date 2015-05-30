package Algo3;

public class Refineria implements Recolectable {

	private int cantidadGas;

	public Refineria() {

		this.cantidadGas = 0;
	}

	public int getGas() {

		return this.cantidadGas;
	}

	public boolean recolectar(Object gas) {

		// Gas elGas = (Gas) gas;
		// elGas.cantidad()
		this.cantidadGas += 5;
		return true;
	}

}
