package TicTacToe.model;

import TicTacToe.entities.enums.XorO;


public class Jogador {
	
	private String name;
	
	private Integer pontos = 0;
	
	private XorO xo;
	

	
	
	public Jogador(String name, XorO xo) {
		this.name = name;
		this.xo = xo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public XorO getXo() {
		return xo;
	}
	public void setXo(XorO xo) {
		this.xo = xo;
	}
	
}
