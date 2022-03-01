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
		String name1 = scan.nextLine();

		String xo1;
		String xo2;
		do {
			System.out.println("Quer ser o jogador X ou O?");
			xo1 = scan.nextLine();
			if (!xo1.equalsIgnoreCase("x") && !xo1.equalsIgnoreCase("o")) {
				System.out.println("Voce deve escolher entre 'x' ou 'o'");
			}
		} while (!xo1.equalsIgnoreCase("x") && !xo1.equalsIgnoreCase("o"));

		if (xo1.equalsIgnoreCase("x")) {
			xo2 = "o";
		} else {
			xo2 = "x";
		}
		System.out.println("Certo, então seu adversario será: " + xo2);
		System.out.println("Qual o nome do segundo joador?");
		String name2 = scan.nextLine();

		jogador1 = new Jogador(name1, XorO.valueOf(xo1.toUpperCase(Locale.ROOT)));
		jogador2 = new Jogador(name2, XorO.valueOf(xo2.toUpperCase(Locale.ROOT)));

		TikTakToe.setJogador1(jogador1);
		TikTakToe.setJogador2(jogador2);

		Integer counting = 2;
		String jogarNovamente;
		do {
			TikTakToe.popularTabuleiroInicial();
			do {
				if (counting % 2 == 0) {
					System.out.print(jogador1.getName() + " '" + jogador1.getXo().getDescricao() + "' : ");
				} else {
					System.out.print(jogador2.getName() + " '" + jogador2.getXo().getDescricao() + "' : ");
				}
				System.out.println("Qual será as coordenadas da sua jogada(linha x coluna)?");
				String lastMove = scan.nextLine();
				List<String> subStringList = Arrays.asList(lastMove.split(","));
				int x = 0;
				int y = 0;
				for (int i = 0; i < subStringList.size(); i++) {
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
				counting++;

			} while (!TikTakToe.verificaGanhador());
			System.out.println("O jogo acabou, gostaria de jogar de novo? 'sim' ou 'nao'");
			jogarNovamente = scan.nextLine();
		} while (jogarNovamente.equalsIgnoreCase("sim"));


	}
}
