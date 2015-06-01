package tp2;

public abstract class Unidad implements Accionable {
	
	protected int vida;

	public void recibirDanio(int danio) {
		vida = vida - danio;
	}

	public int vidaRestante() {
		return vida;
	}
}
