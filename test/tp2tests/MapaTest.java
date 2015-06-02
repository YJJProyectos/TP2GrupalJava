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
		long distancia ;
		Coordenada coordenadaA = new Coordenada(1,1);
		Coordenada coordenadaB = new Coordenada(2,3);
		distancia = mapa.distanciaEntre(coordenadaA,coordenadaB);
		Assert.assertEquals(2,distancia);
		
	}

}
