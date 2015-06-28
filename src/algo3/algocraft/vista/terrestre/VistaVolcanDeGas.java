package algo3.algocraft.vista.terrestre;

import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;


@SuppressWarnings("serial")
public class VistaVolcanDeGas extends VistaTerrestre{
	
	public VistaVolcanDeGas(Coordenada coordenada, Mapa mapa){
		super(coordenada, mapa);
		String url = "/algo3/algocraft/imagenes/Volcan.png";
		this.setImagen(url);
	}

}
