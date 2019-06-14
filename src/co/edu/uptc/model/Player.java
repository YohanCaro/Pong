package co.edu.uptc.model;

public class Player {

	private String nickName;
	private int puntaje;
	
	public Player(String nickName, int puntaje) {
		this.nickName = nickName;
		this.puntaje = puntaje;
	}
	
	public Player() {
		
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
}
