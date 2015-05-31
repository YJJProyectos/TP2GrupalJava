package tp2;

public abstract class Casilla implements Ocupable {

	public boolean esta_ocupada() {
		return false;
	}

	public boolean es_terrestre() {
		return true;
	}
}
