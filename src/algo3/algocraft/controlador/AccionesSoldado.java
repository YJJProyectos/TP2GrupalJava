package algo3.algocraft.controlador;

import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.DistanciaFueraDeRangoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.Sonido;
import algo3.algocraft.vista.VentanaError;

public class AccionesSoldado {
	
	
	public static void atacar(PanelJuego panelJuego){
		if ( panelJuego.getUnidadIzquierdo() != null){
			try {
				UnidadSoldado soldado = (UnidadSoldado) panelJuego.getUnidadIzquierdo();
				Unidad unidadAtacada = panelJuego.getUnidadDerecho();
				soldado.atacarEnemigo
				 (unidadAtacada, panelJuego.getJuego().turnoDeJugador());
				Sonido.atacar(soldado);
				if ( unidadAtacada.estaDestruido()){
					unidadAtacada.sonidoDestruccion();
				}
			} catch (PerteneceAlMismoJugadorError e) {
				String textoError = "<html>La unidad que quiere atacar pertenece al mismo jugador <html>";
				new VentanaError(textoError);
			} catch (NoPuedeAtacarMultiplesVecesError e) {
				String textoError = "<html>La unidad no puede atacar multiples veces <html>";
				new VentanaError(textoError);
			} catch (JugadorIncorrectoError e) {
				String textoError = "<html>La unidad pertenece a otro jugador <html>";
				new VentanaError(textoError);
			} catch (DistanciaFueraDeRangoError e) {
				String textoError = "<html>La unidad esta fuera de rango <html>";
				new VentanaError(textoError);
			} catch (ClassCastException error) {

				
			} catch (Exception error) {

			}

		}
	}
	
	public static void mover(PanelJuego panelJuego){
		if ( panelJuego.getUnidadIzquierdo() != null ){
			try {
				UnidadSoldado soldado = 
						(UnidadSoldado)(panelJuego.getUnidadIzquierdo());
				soldado.mover(panelJuego.getCasillaDestino(), panelJuego.getJuego().turnoDeJugador());
			} catch (CasillaOcupadaError e) {
				String textoError = "<html>Casilla ocupada <html>";
				new VentanaError(textoError);
			} catch (JugadorIncorrectoError e) {
				String textoError = "<html>La unidad pertenece a otro jugador <html>";
				new VentanaError(textoError);
			} catch (ClassCastException error) {

				
			}catch (Exception e) {
				
			}
		}
	}

}
