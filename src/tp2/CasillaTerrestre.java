package tp2;

import recolectables.Recolectable;
import edificables.Edificable;

public class CasillaTerrestre extends Casilla {
	
	Edificable edificio;
	Recolectable recurso;
	
	public boolean es_terrestre() {
		return true;
	}
}
