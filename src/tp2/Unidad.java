package tp2;

public abstract class Unidad implements Accionable {
	
	protected int vida;

	public void recibirDanio(int danio) {
		return;
	}

	public int vidaRestante() {
		return 0;
	}
}
