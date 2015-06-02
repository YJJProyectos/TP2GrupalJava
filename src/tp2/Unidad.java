package tp2;
import interfaces.Accionable;
import interfaces.Ocupable;

public abstract class Unidad implements Accionable {
	
	protected Ocupable casilla;
	protected int vida;

	public void recibirDanio(int danio) {
		vida = vida - danio;
	}

	public int vidaRestante() {
		return vida;
	}
	
	public boolean estaDestruido(){
		return (vida <= 0);
	}
	
	public void posicionar(Ocupable casilla){
		if (casilla.ocupar(this)) this.casilla = casilla;
	}
}
