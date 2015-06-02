package tp2;

public abstract class Casilla implements Ocupable {

	Accionable ocupante;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public Accionable obtenerElemento() {
		return ocupante;
	}

	public void agregarElemento(Accionable elemento) {
		ocupante = elemento;
		
	}

}