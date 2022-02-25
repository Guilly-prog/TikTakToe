package TicTacToe.model;

import TicTacToe.entities.enums.XorO;

public class TikTakToe {

	private static Integer n;

	private static XorO[][] tabuleiro;

	private static Jogador jogador1;

	private static Jogador jogador2;


	public static void popularTabuleiroInicial() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				tabuleiro[i][j] = XorO.TYPE_BLANK;
//				tabuleiro[i][j] = XorO.TYPE_O;
			}
		}
	}

	public static boolean verificaGanhador() {
		for(int i = 0; i<n; i++) {
			if (tabuleiro[i][0].getDescricao().equalsIgnoreCase(jogador1.getXo().toString())) {
				return true;
			}
			for(int j = 0; j<n; j++) {

			}			
		}
		return true;
	}

	/**
	 * Metodo que preenche uma posicao especifica da matrix com o valor indicado
	 * @param x
	 * @param y
	 * @param valor
	 * @return
	 */
	public static boolean realizaJogada(Integer x, Integer y, String valor){
		if (tabuleiro[x][y] != XorO.TYPE_BLANK){
			return false;
		} else {
			XorO[][] tab = tabuleiro;
			tab[x][y] = validaValor(valor);
		}
		return true;
	}


	/**
	 * Metodo que valida se o valor inserido é um valor valido
	 * @param valor
	 * @return XorO
	 */
	public static XorO validaValor(String valor){
		if (valor.equalsIgnoreCase("x")){
			return XorO.X;
		} else if (valor.equalsIgnoreCase("o")){
			return XorO.O;
		} else {
			System.out.println("Caracter invalido, tente novamente");
			return XorO.TYPE_BLANK;
		}
	}

	@Override
	public String toString() {
		String statusTabuleiro = "";
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				statusTabuleiro += tabuleiro[i][j].getDescricao();
				if (j<n-1) {
					statusTabuleiro += " | ";
				}
			}
			statusTabuleiro += " \n";
		}
		return statusTabuleiro;
	}


	public TikTakToe(Integer n) {
		this.n = n;
		this.tabuleiro = new XorO[n][n];
		popularTabuleiroInicial();
	}

	public static Jogador getJogador1() {
		return jogador1;
	}
	public static void setJogador1(Jogador jogador1) {
		TikTakToe.jogador1 = jogador1;
	}

	public static Jogador getJogador2() {
		return jogador2;
	}
	public static void setJogador2(Jogador jogador2) {
		TikTakToe.jogador2 = jogador2;
	}

	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}

	public XorO[][] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(XorO[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}



}
