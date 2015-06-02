package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import tp2.Coordenada;
import tp2.Mapa;

public class MapaTest {

	@Test
	public void deberiaTenerTamanio64() {
		Mapa mapa = new Mapa(4);

		Assert.assertEquals(mapa.tamanio(), 400);
	}
	@Test
	public void deberiaCalcularLasDistanciasDeLasCoordenadas(){
		
		Mapa mapa = new Mapa(4);
		int distancia ;
		Coordenada coordenadaA = new Coordenada(1,1);
		Coordenada coordenadaB = new Coordenada(2,3);
		distancia = mapa.distanciaEntre(coordenadaA,coordenadaB);
		Assert.assertEquals(2,distancia);
		coordenadaA = new Coordenada(1,1);
		coordenadaB = new Coordenada(4,1);
		distancia = mapa.distanciaEntre(coordenadaA,coordenadaB);
		Assert.assertEquals(3,distancia);	
		coordenadaA = new Coordenada(1,1);
		coordenadaB = new Coordenada(3,3);
		distancia = mapa.distanciaEntre(coordenadaA,coordenadaB);
		Assert.assertEquals(3,distancia);	
	}

}
