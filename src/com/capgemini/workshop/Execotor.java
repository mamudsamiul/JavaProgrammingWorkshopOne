package com.capgemini.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Execotor {
	static char player;
	static char computer;

	public static void main(String[] args) {
		ArrayList<Integer> computerMoveHistory = new ArrayList<Integer>();
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

		} else {
			System.out.println("Computer's turn");
			ticTacToeGame.takeInputFromComputer();
		}
		System.out.println("Your Mark is: '" + player + "' And Computer's Mark is : '" + computer + "'");
		ticTacToeGame.showBoard(board);
		ComputerWinningLogic computerLogic = new ComputerWinningLogic(computer, player);

		while (true) {
			if (toss == true) {
				location = ticTacToeGame.chooseLocation(board, scan);
				board[location] = player;
				ticTacToeGame.showBoard(board);
				String result = ticTacToeGame.checkWinner(board);
				System.out.println();
				if (result.charAt(0) == (player)) {
					System.out.println("You are the winner");
					break;
				}
				if (result.equals("Tie")) {
					System.out.println("Tie");
					break;
				}
				toss = false;
			} else {
				location = computerLogic.placeMove(board, computerMoveHistory);
				computerMoveHistory.add(location);
				System.out.println("location is " + location);
				board[location] = computer;
				ticTacToeGame.showBoard(board);
				String result = ticTacToeGame.checkWinner(board);
				System.out.println();
				if (result.charAt(0) == (computer)) {
					System.out.println("Computer win the game!");
					break;
				}
				if (result.equals("Tie")) {
					System.out.println("Tie");
					break;
				}
				toss = true;
			}

		}
	}
}
