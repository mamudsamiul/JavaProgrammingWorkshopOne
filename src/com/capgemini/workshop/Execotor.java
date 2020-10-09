package com.capgemini.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Execotor {
	static char player;
	static char computer;

	public static void main(String[] args) {
		int location;
		char repeatGame = 'Y';
		boolean toss;
		ArrayList<Integer> computerMoveHistory = new ArrayList<Integer>();
		ArrayList<Integer> playerMoveHistory = new ArrayList<Integer>();
		int[] corner = { 1, 3, 7, 9 };
		int[] side = { 2, 4, 6, 8 };
		System.out.println("-----Welcome to Tik Tak Toe Game-----");
		Scanner scan = new Scanner(System.in);
		while (repeatGame == 'Y') {
			TicTacToeGame ticTacToeGame = new TicTacToeGame();
			char[] board = ticTacToeGame.createTicTacBoard(10);
			toss = ticTacToeGame.toss();
			if (toss == true) {
				System.out.println("You win the toss!");
				ticTacToeGame.takeInputFromPlayer(scan);

			} else {
				System.out.println("Computer win the toss!");
				ticTacToeGame.takeInputFromComputer();
			}
			ticTacToeGame.showBoard(board);
			System.out.println("Your Mark is: '" + player + "' And Computer's Mark is : '" + computer + "'");
			ComputerWinningLogic computerLogic = new ComputerWinningLogic(computer, player);

			while (true) {
				if (toss == true) {
					System.out.println("Your turn: ");
					location = ticTacToeGame.chooseLocation(board, scan);
					playerMoveHistory.add(location);
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
					System.out.println("Computer's turn");
					int[] block = computerLogic.blockTheMove(board, playerMoveHistory);
					int[] nextMove = computerLogic.placeMove(board, computerMoveHistory);
					if (block[0] < 0 && nextMove[0] < 0)
						location = computerLogic.randomMove(board, corner, side);
					else if (nextMove[1] < block[1])
						location = block[0];
					else
						location = nextMove[0];
					computerMoveHistory.add(location);
					board[location] = computer;
					ticTacToeGame.showBoard(board);
					String result = ticTacToeGame.checkWinner(board);
					System.out.println();
					if (result.charAt(0) == (computer)) {
						System.out.println("Alas!! Computer win the game!");
						break;
					}
					if (result.equals("Tie")) {
						System.out.println("Tie");
						break;
					}
					toss = true;
				}
			}

			while (true) {
				System.out.println("Do you want to play another round 'Y/N' ");
				repeatGame = scan.next().toUpperCase().charAt(0);
				if (repeatGame == 'Y' || repeatGame == 'N') {
					break;
				} else
					System.out.println("Invalid input!");

			}
		}

	}
}
