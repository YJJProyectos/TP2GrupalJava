package algo3.algocraft.vista;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VentanaManualDeJuego extends JOptionPane{
	
	public VentanaManualDeJuego(){
		JOptionPane
		.showMessageDialog(
				null,
				"<html> Hacer click primero en un casillero luego boton para construir <br>"
						+ " Bordes naranjas son recursos, azules unidades terrestres,"
						+ " verde unidades aereas, rojo es de casilla<br>"
						+ " Para mover primero se debe seleccionar la unidad con click "
						+ "izquierdo luego click derecho a la casilla a mover <br>"
						+ " Para atacar primero se debe seleccionar a la unidad atacante con click"
						+ " izquierdo luego click derecho a la unidad a atacar<br>"
						+ " Para construir fabrica primero se debe seleccionar una barraca construida"
						+ " luego seleccionar la casilla a ocupar y tocar crear fabrica<br>"
						+ " Para construir Puerto estelar se debe seleccionar una fabrica construida"
						+ " luego seleccionar la casilla a ocupar y tocar crear puerto estelar<br>"
						+ " Un soldado para posicionar no cuenta como unidad hasta que no se posicione<br>"
						+ " El boton posicionar soldado, posiciona el primer soldado que se acaba de crear, "
						+ " inicialmente el jugador comienza con un marine a posicionar<br>"
						+ " Para posicionar el soldado primero se debe seleccionar una casilla vacia "
						+ "(terrestre y/o aerea) luego pulsar el boton <br>"
						+ " Un jugador gana si el otro jugador se queda sin unidades(edificios/soldados)<br>"
						+ " Que disfrute el juego! <html>",
				"Manual De Juego", JOptionPane.INFORMATION_MESSAGE);
	}

}
