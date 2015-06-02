package interfaces;


public interface Ocupable {

	public abstract boolean estaOcupada();

	public abstract boolean esTerrestre();
	
	public abstract Accionable ocupante();

	public abstract boolean ocupar(Accionable unidad);
	
}