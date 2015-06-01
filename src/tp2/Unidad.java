package tp2;

public abstract class Unidad implements Accionable {
	int vida;

	public void recibir_danio(int danio) {
		return;
	}

	public int vida_restante() {
		return 0;
	}
}
