package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.NoHaySoldadosParaPosicionarError;
import algo3.algocraft.modelo.juego.NombresInvalidosError;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.BarracaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class IntegracionTest {

	@Test
	public void testDeIntegracion() throws RecursosInsuficientesError,
			CasillaOcupadaError, CoordenadaInvalidaError,
			RecolectorInvalidoError, PerteneceAOtroJugadorError,
			BarracaNoConstruidaError, NoHaySoldadosParaPosicionarError,
			JugadorIncorrectoError, YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError,
			PoblacionLimiteAlcanzadaError, NombresInvalidosError {
		int esquina1 = 1;
		int esquina4 = 20;
		int centro = 10;
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		jugador1.setNombre("1");
		jugador2.setNombre("2");
		Juego juego = new Juego(jugador1, jugador2);
		
		Assert.assertEquals(1, jugador1.cantidadUnidades());
		
		Jugador jugadorActual = juego.turnoDeJugador();
		Recurso mineral1 = juego.getMapa().obtenerRecursoEnPosicion(
				new Coordenada(esquina1, esquina1));
		Recurso volcan1 = juego.getMapa().obtenerRecursoEnPosicion(
				new Coordenada(esquina1, esquina1 + 1));
		CentroDeMineral centro1 = new CentroDeMineral(mineral1, jugadorActual);
		Refineria refineria1 = new Refineria(volcan1, jugadorActual);
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		Recurso mineral2 = juego.getMapa().obtenerRecursoEnPosicion(
				new Coordenada(esquina4, esquina4));
		Recurso volcan2 = juego.getMapa().obtenerRecursoEnPosicion(
				new Coordenada(esquina4, esquina4 - 1));
		@SuppressWarnings("unused")
		CentroDeMineral centro2 = new CentroDeMineral(mineral2, jugadorActual);
		@SuppressWarnings("unused")
		Refineria refineria2 = new Refineria(volcan2, jugadorActual);
		for (int i = 0; i < 150; i++) {
			juego.pasarTurno();
		}// Recolecto los recursos suficientes para poder realizar todas las
			// creaciones
		jugadorActual = juego.turnoDeJugador();
		Barraca barraca2 = new Barraca(jugadorActual, juego.getMapa()
				.getCasilla(new Coordenada(esquina4, esquina4 - 2)));
		@SuppressWarnings("unused")
		DepositoDeSuministros deposito2 = new DepositoDeSuministros(
				jugadorActual, juego.getMapa().getCasilla(
						new Coordenada(esquina4, esquina4 - 3)));
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		Barraca barraca1 = new Barraca(jugadorActual, juego.getMapa()
				.getCasilla(new Coordenada(esquina1, esquina1 + 2)));
		DepositoDeSuministros deposito1 = new DepositoDeSuministros(
				jugadorActual, juego.getMapa().getCasilla(
						new Coordenada(esquina1, esquina1 + 3)));
		for (int j = 0; j < 24; j++) {
			juego.pasarTurno();
		}// Creo las barracas y los suministros
		jugadorActual = juego.turnoDeJugador();
		Fabrica fabrica1 = new Fabrica(jugadorActual, juego.getMapa()
				.getCasilla(new Coordenada(esquina1, esquina1 + 4)), barraca1);
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		Fabrica fabrica2 = new Fabrica(jugadorActual, juego.getMapa()
				.getCasilla(new Coordenada(esquina4, esquina4 - 4)), barraca2);
		for (int k = 0; k < 24; k++) {
			juego.pasarTurno();
		}// creo las fabricas
		jugadorActual = juego.turnoDeJugador();
		barraca2.entrenarMarine(jugadorActual);
		fabrica2.entrenarGolliat(jugadorActual);
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		barraca1.entrenarMarine(jugadorActual);
		fabrica1.entrenarGolliat(jugadorActual);
		for (int l = 0; l < 12; l++) {
			juego.pasarTurno();
		}// creo los soldados
		jugadorActual = juego.turnoDeJugador();
		jugadorActual.posicionarSoldadoEnColaDeEspera(juego.getMapa()
				.getCasilla(new Coordenada(esquina1, esquina1 + 5)));
		jugadorActual.posicionarSoldadoEnColaDeEspera(juego.getMapa()
				.getCasilla(new Coordenada(esquina1, esquina1 + 6)));
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		jugadorActual.posicionarSoldadoEnColaDeEspera(juego.getMapa()
				.getCasilla(new Coordenada(esquina4, esquina4 - 5)));
		jugadorActual.posicionarSoldadoEnColaDeEspera(juego.getMapa()
				.getCasilla(new Coordenada(esquina4, esquina4 - 6)));

		UnidadSoldado marine1 = (UnidadSoldado) juego.getMapa()
				.obtenerElementoTerrestreEnPosicion(
						new Coordenada(esquina1, esquina1 + 5));
		UnidadSoldado golliat1 = (UnidadSoldado) juego.getMapa()
				.obtenerElementoTerrestreEnPosicion(
						new Coordenada(esquina1, esquina1 + 6));
		UnidadSoldado marine2 = (UnidadSoldado) juego.getMapa()
				.obtenerElementoTerrestreEnPosicion(
						new Coordenada(esquina4, esquina4 - 5));
		UnidadSoldado golliat2 = (UnidadSoldado) juego.getMapa()
				.obtenerElementoTerrestreEnPosicion(
						new Coordenada(esquina4, esquina4 - 6));

		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		marine1.mover(juego.getMapa()
				.getCasilla(new Coordenada(centro, centro)), jugadorActual);
		golliat1.mover(
				juego.getMapa().getCasilla(new Coordenada(centro, centro + 1)),
				jugadorActual);
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		marine2.mover(
				juego.getMapa().getCasilla(new Coordenada(centro + 1, centro)),
				jugadorActual);
		golliat2.mover(
				juego.getMapa().getCasilla(
						new Coordenada(centro + 1, centro + 1)), jugadorActual);
		
		Assert.assertEquals(8, jugador1.cantidadUnidades());
		
		marine2.atacarEnemigo(marine1, jugadorActual);
		golliat2.atacarEnemigo(marine1, jugadorActual);
		juego.pasarTurno();
		juego.pasarTurno();
		jugadorActual = juego.turnoDeJugador();
		marine2.atacarEnemigo(marine1, jugadorActual);
		golliat2.atacarEnemigo(marine1, jugadorActual);
		juego.pasarTurno();
		juego.pasarTurno();
		marine2.atacarEnemigo(marine1, jugadorActual);

		Assert.assertTrue(marine1.estaDestruido());

		golliat2.atacarEnemigo(golliat1, jugadorActual);
		juego.pasarTurno();
		
		Assert.assertEquals(7, jugador1.cantidadUnidades());
		
		juego.pasarTurno();
		for (int m = 0; m < 6; m++) {
			marine2.atacarEnemigo(golliat1, jugadorActual);
			golliat2.atacarEnemigo(golliat1, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}
		marine2.atacarEnemigo(golliat1, jugadorActual);

		Assert.assertTrue(golliat1.estaDestruido());

		marine2.mover(
				juego.getMapa().getCasilla(
						new Coordenada(esquina1 + 2, esquina1 + 2)),
				jugadorActual);
		golliat2.mover(
				juego.getMapa().getCasilla(
						new Coordenada(esquina1 + 2, esquina1 + 3)),
				jugadorActual);
		juego.pasarTurno();
		
		Assert.assertEquals(6, jugador1.cantidadUnidades());
		
		juego.pasarTurno();
		for (int n = 0; n < 28; n++) {
			marine2.atacarEnemigo(centro1, jugadorActual);
			golliat2.atacarEnemigo(centro1, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}
		Assert.assertTrue(centro1.estaDestruido());

		for (int o = 0; o < 55; o++) {
			marine2.atacarEnemigo(barraca1, jugadorActual);
			golliat2.atacarEnemigo(barraca1, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}
		
		Assert.assertEquals(5, jugador1.cantidadUnidades());
		
		golliat2.atacarEnemigo(barraca1, jugadorActual);

		Assert.assertTrue(barraca1.estaDestruido());

		juego.pasarTurno();
		
		Assert.assertEquals(4, jugador1.cantidadUnidades());
		
		juego.pasarTurno();

		for (int p = 0; p < 28; p++) {
			marine2.atacarEnemigo(deposito1, jugadorActual);
			golliat2.atacarEnemigo(deposito1, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}

		Assert.assertTrue(deposito1.estaDestruido());

		Assert.assertEquals(3, jugador1.cantidadUnidades());
		
		for (int q = 0; q < 41; q++) {
			marine2.atacarEnemigo(refineria1, jugadorActual);
			golliat2.atacarEnemigo(refineria1, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}
	
		golliat2.atacarEnemigo(refineria1, jugadorActual);

		Assert.assertTrue(refineria1.estaDestruido());

		juego.pasarTurno();
		
		Assert.assertEquals(2, jugador1.cantidadUnidades());
		
		juego.pasarTurno();

		for (int r = 0; r < 69; r++) {
			marine2.atacarEnemigo(fabrica1, jugadorActual);
			golliat2.atacarEnemigo(fabrica1, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}
		golliat2.atacarEnemigo(fabrica1, jugadorActual);
		
		Assert.assertTrue(fabrica1.estaDestruido());			
		juego.pasarTurno();
		juego.pasarTurno();

		Assert.assertEquals(1, jugador1.cantidadUnidades());
		
		//aca le falta romperle el deposito que esta cerca del gas
		// la cagada es que yo le habia puesto en 4 posiciones diferentes (random) 
		Assert.assertFalse(jugador1.estaDestruido());
		
		Unidad deposito = null;		
		boolean yaEncontrado = false;
		int fila = 2;
		int columna = 2;
		int filaEncontrada = 0;
		int columnaEncontrada = 0;
		Unidad depositoBuscado = juego.getMapa().obtenerElementoTerrestreEnPosicion
				(new Coordenada(fila, columna)); 
		if ( depositoBuscado != null && !yaEncontrado){
			if (jugadorActual != depositoBuscado.getJugador() ){
				deposito = depositoBuscado;
				yaEncontrado = true;
				filaEncontrada = fila;
				columnaEncontrada = columna;
			}		
		}
		fila = 2;
		columna = 19;
		depositoBuscado = juego.getMapa().obtenerElementoTerrestreEnPosicion
				(new Coordenada(fila, columna)); 
		if ( depositoBuscado != null && !yaEncontrado){
			if (jugadorActual != depositoBuscado.getJugador() ){
				deposito = depositoBuscado;
				yaEncontrado = true;
				filaEncontrada = fila;
				columnaEncontrada = columna;
			}		
		}
		fila = 19;
		columna = 2;
		depositoBuscado = juego.getMapa().obtenerElementoTerrestreEnPosicion
				(new Coordenada(fila, columna)); 
		if ( depositoBuscado != null && !yaEncontrado){
			if (jugadorActual != depositoBuscado.getJugador() ){
				deposito = depositoBuscado;
				yaEncontrado = true;
				filaEncontrada = fila;
				columnaEncontrada = columna;
			}		
		}
		fila = 19;
		columna = 19;
		depositoBuscado = juego.getMapa().obtenerElementoTerrestreEnPosicion
				(new Coordenada(fila, columna)); 
		if ( depositoBuscado != null && !yaEncontrado){
			if (jugadorActual != depositoBuscado.getJugador() ){
				deposito = depositoBuscado;
				yaEncontrado = true;
				filaEncontrada = fila;
				columnaEncontrada = columna;
			}		
		}
		
		// los acerco donde estaria el ultimo deposito
		marine2.mover(
				juego.getMapa().getCasilla
				(new Coordenada(filaEncontrada, columnaEncontrada +1 )),jugadorActual);
		golliat2.mover(
				juego.getMapa().getCasilla
				(new Coordenada(filaEncontrada, columnaEncontrada -1 )),jugadorActual);
		for (int i = 0; i < 28; i++){
			marine2.atacarEnemigo(deposito, jugadorActual);
			golliat2.atacarEnemigo(deposito, jugadorActual);
			juego.pasarTurno();
			juego.pasarTurno();
		}
		
		Assert.assertEquals(0, jugador1.cantidadUnidades());
		
		Assert.assertTrue(jugador1.estaDestruido());

		juego.pasarTurno();

		Assert.assertEquals(jugador2, juego.getGanador());

	}
}
