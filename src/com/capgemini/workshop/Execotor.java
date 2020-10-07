package com.capgemini.workshop;

import java.util.Scanner;

public class Execotor {
	static char player;
	static char computer;

	public static void main(String[] args) {
		int location;
		boolean toss;
		System.out.println("-----Welcome to Tik Tak Toe Game-----");
		Scanner scan = new Scanner(System.in);
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] board = ticTacToeGame.createTicTacBoard(10);
		toss = ticTacToeGame.toss();
		if (toss == true) {
			System.out.println("It is Your Turn");
			ticTacToeGame.takeInputFromPlayer(scan);
			System.out.println("player input is : " + player);
			ticTacToeGame.showBoard(board);
		} else
			System.out.println("Computer turn");

		while (true) {
			if (toss == true) {
				location = ticTacToeGame.chooseLocation(board, scan);
				board[location] = player;
				ticTacToeGame.showBoard(board);
				String result = ticTacToeGame.checkWinner(board);
				System.out.println();
				if (result.equals("X")) {
					System.out.println("You are the winner");
					break;
				}
				if (result.equals("Tie")) {
					System.out.println("Tie");
					break;
				}
				toss = true;
			} else
				break;

		}
	}
}
