package tp2;

public interface Accionable {

	public abstract void recibirDanio(int cantidadDanio);

	public abstract int vidaRestante();
	
	public boolean estaDestruido();

}
