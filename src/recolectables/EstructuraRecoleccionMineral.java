package recolectables;

public abstract class EstructuraRecoleccionMineral implements Recolectable {

	protected int cantidadMineral;

	public EstructuraRecoleccionMineral() {

		cantidadMineral = 0;
	}

	public abstract boolean Recolectar(Object object);

	public int getMineral() {

		return cantidadMineral;
	}

}
