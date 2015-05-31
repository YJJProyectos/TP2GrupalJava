package Recolectables;

public class Refineria extends EstructuraRecoleccionGas implements Recolectable {

	public Refineria() {

		super();
	}

	public boolean Recolectar(Object gas) {

		// Gas elGas = (Gas) gas;
		// elGas.cantidad()
		this.cantidadGas += 5;
		return true;
	}

}
