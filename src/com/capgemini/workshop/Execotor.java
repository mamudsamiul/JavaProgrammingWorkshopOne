package com.capgemini.workshop;

import java.util.Scanner;

public class Execotor {
	static char player;
	static char computer;

	public static void main(String[] args) {
		System.out.println("Welcome to Tik Tak Toe Program");
		Scanner scan = new Scanner(System.in);
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] board = ticTacToeGame.createTicTacBoard(10);
		ticTacToeGame.takeInputFromPlayer(player, computer, scan);
		ticTacToeGame.showBoard(board);
	}
}
