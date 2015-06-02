package tp2;

public abstract class Casilla implements Ocupable {

	Accionable ocupante;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public void ocupar(Accionable ente) {
		ocupante = ente;
	}

}