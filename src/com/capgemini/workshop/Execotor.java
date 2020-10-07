package com.capgemini.workshop;

public class Execotor {

	public static void main(String[] args) {
		System.out.println("Welcome to Tik Tak Toe Program");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] board = ticTacToeGame.createTicTacBoard(10);
	}
}
