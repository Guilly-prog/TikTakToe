package TicTacToe.main;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import TicTacToe.entities.enums.XorO;
import TicTacToe.model.Jogador;
import TicTacToe.model.TikTakToe;

public class App {

	private static Scanner scan;
	private static TikTakToe jogo;
	private static Jogador jogador1;
	private static Jogador jogador2;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		System.out.println("----------------------------------------");
		System.out.println("--Bem vindo ao jogo da velha do milhao--");
		System.out.println("primeiramente quais as dimencoes do tabuleiro?");

		Integer dimencao = scan.nextInt();
		scan.nextLine();
		jogo = new TikTakToe(dimencao);
		System.out.print(jogo.toString());

		System.out.println("Qual o seu nome?");
		String name = scan.nextLine();

		System.out.println("Quer ser o jogador X ou O?");
		String xo1 = scan.nextLine();
		String xo2; 

		if (xo1.equalsIgnoreCase("x")) {
			xo2 = "o";
		} else {
			xo2 = "x";
		}
		jogador1 = new Jogador(name, XorO.valueOf(xo1.toUpperCase(Locale.ROOT)));
		jogador2 = new Jogador(name, XorO.valueOf(xo2.toUpperCase(Locale.ROOT)));
		System.out.println("Certo, então seu adversario será: " + xo2);
		TikTakToe.setJogador1(jogador1);
		TikTakToe.setJogador2(jogador2);

		Integer counting = 2;
		do {
			if (counting % 2 == 0) {
				System.out.print("JOGADOR 1 '" + jogador1.getXo().getDescricao() + "' : ");
			} else {
				System.out.print("JOGADOR 2 '" + jogador2.getXo().getDescricao() + "' : ");
			}
			System.out.println("Qual será as coordenadas da sua jogada(linha x coluna)?");
			String lastMove = scan.nextLine();
			List<String> subStringList = Arrays.asList(lastMove.split(","));
			int x = 0;
			int y = 0;
			for(int i = 0; i < subStringList.size(); i++){
				subStringList.set(i, subStringList.get(i).trim());
				x = Integer.parseInt(subStringList.get(0));
				y = Integer.parseInt(subStringList.get(i));
			}
			if (counting % 2 == 0) {
				TikTakToe.realizaJogada(x, y, TikTakToe.getJogador1().getXo().getDescricao());
			} else {
				TikTakToe.realizaJogada(x, y, TikTakToe.getJogador2().getXo().getDescricao());
			}
			System.out.print(jogo.toString());
			counting ++;
		} while (true);


	}
}
