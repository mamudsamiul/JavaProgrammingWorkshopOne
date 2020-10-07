package com.capgemini.workshop;

import java.util.Scanner;

public class Execotor {
	static boolean player;
	static boolean computer;

	public static void main(String[] args) {
		System.out.println("Welcome to Tik Tak Toe Program");
		Scanner scan = new Scanner(System.in);
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] board = ticTacToeGame.createTicTacBoard(10);
		ticTacToeGame.takeInputFromPlayer(player, computer, scan);
	}
}
