package tp2;

public interface Ocupable {

	public abstract boolean estaOcupada();

	public abstract boolean esTerrestre();
	
	public abstract Accionable obtenerElemento();

	public abstract void agregarElemento(Accionable elemento);

}
