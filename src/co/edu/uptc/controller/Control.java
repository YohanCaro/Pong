package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Player;

public class Control {

	private List<Player> jugadores;
	private int[] datos;
	
	public Control() {
		jugadores = new ArrayList<>();
		datos = new int[3];
		for (int i = 0; i < datos.length; i++) {
			datos[i] = 0;
		}
	}
	
	public void agregarJugador(String nickName, int puntaje) {
		if (buscarJugador(nickName) == null) {
			Player jugador = new Player(nickName, puntaje);
			this.jugadores.add(jugador);
		} else {
			Player jugador = new Player(nickName, puntaje);
			this.jugadores.set(numeroJugador(nickName), jugador);
		}
	}

	public Player buscarJugador(String nickName) {
		Player jugador = null;
		for (int j = 0; j < this.jugadores.size(); j++) {
			if (nickName.equals(jugadores.get(j).getNickName())) {
				jugador = jugadores.get(j);
			}
		}
		return jugador;
	}
	
	public int numeroJugador(String nickName) {
		int jugador = 0;
		for (int j = 0; j < this.jugadores.size(); j++) {
			if (nickName.equals(jugadores.get(j).getNickName())) {
				jugador = j;
			}
		}
		return jugador;
	}
	
	public void ordenarPuntajes() {
		for (int i = 0; i < jugadores.size() -1; i++) {
			for (int j = i+1; j < jugadores.size(); j++) {
				if (jugadores.get(i).getPuntaje() < jugadores.get(j).getPuntaje()) {
					Player temp = jugadores.get(i);
					jugadores.set(i, jugadores.get(j));
					jugadores.set(j, temp);
				}
			}
		}
	}
	
	public List<String> cadenaPuntajes() {
		List<String> lista = new ArrayList<>();
		this.ordenarPuntajes();
		
		if (jugadores != null && !jugadores.isEmpty()) {
			for (Player jugador : jugadores) {
				StringBuilder cadena = new StringBuilder();
				cadena.append(jugador.getNickName());
				cadena.append(" - " + jugador.getPuntaje() + " puntos!");
				lista.add(cadena.toString());
			}
		}
		
		return lista;
	}
	

	public List<Player> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Player> jugadores) {
		this.jugadores = jugadores;
	}

	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datos) {
		this.datos = datos;
	}
	
}