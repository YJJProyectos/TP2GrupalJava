package recolectables;

public abstract class Refineria extends EstructuraRecoleccionMineral implements
		Recolectante {

	public Refineria(Recolectable mineral) {
		super(mineral);
	}
}
