package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;
import interfaces.Navegable;
import interfaces.Ubicable;

public abstract class Casilla implements Ocupable {

	protected Ubicable ubicacion;
	protected Accionable ocupante;
	protected Navegable mapa;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public Accionable ocupante() {
		return ocupante;
	}

	public abstract boolean ocupar(Accionable unidad);
	public abstract boolean esTerrestre();
	
	public void desocupar() {
		ocupante = null;
	}
	
	public void situar(Ubicable posicion, Navegable escenario) {
		ubicacion = posicion;
		mapa = escenario;
	}
	
	public Ubicable posicion(){
		return ubicacion;
	}
	
	public int distanciaA(Ocupable otraPosicion) {
		return mapa.distanciaEntre(this,otraPosicion);
	}
}