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
	private static Jogador jogador;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		System.out.println("----------------------------------------");
		System.out.println("--Bem vindo ao jogo da velha do milhao--");
		System.out.println("primeiramente quais as dimencoes do tabuleiro?");

		Integer dimencao = scan.nextInt();
		jogo = new TikTakToe(dimencao);
		System.out.print(jogo.toString());

		System.out.println("Qual o seu nome?");
		String name = scan.next();

		System.out.println("Quer ser o jogador X ou Y?");
		String xo = scan.next();
		jogador = new Jogador(name, XorO.valueOf(xo.toUpperCase(Locale.ROOT)));

		System.out.println("Qual será as coordenadas da sua jogada?");
		String lastMove = scan.next();
		List<String> subStringList = Arrays.asList(lastMove.split(","));
		for(int i = 0; i < subStringList.size(); i++){
			subStringList.set(i, subStringList.get(i).trim());
		}
		TikTakToe.realizaJogada(
				Integer.parseInt(subStringList.get(0)),
				Integer.parseInt(subStringList.get(1)),
				jogo.getJogador1().getXo().getDescricao());
		
		
		
		
	}
}
