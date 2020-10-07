package com.capgemini.workshop;

import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame {
	Random rand;

	public char[] createTicTacBoard(int size) {
		char[] boardSize = new char[size];
		for (int i = 0; i < boardSize.length; i++) {
			boardSize[i] = ' ';
		}
		return boardSize;
	}

	public void takeInputFromPlayer(Scanner scan) {
		System.out.println("Enter Your marker 'X' or 'O' ");
		char entry = scan.next().toUpperCase().charAt(0);
		if (entry == 'X') {
			Execotor.player = 'X';
			Execotor.computer = 'O';
		} else if (entry == 'O') {
			Execotor.player = 'O';
			Execotor.computer = 'X';
		} else
			System.out.println("Invalid Input!");
	}

	public void showBoard(char[] board) {
		System.out.println();
		System.out.println("--------------");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("--------------");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("--------------");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("--------------");
	}

	public int chooseLocation(char[] board, Scanner scan) {
		int location;
		while (true) {
			System.out.println("Enter the Location between 1 to 9");
			location = scan.nextInt();
			if (board[location] == ' ')
				break;
			else
				System.out.println("Location is not empty");
		}
		return location;
	}

	public boolean toss() {
		rand = new Random();
		int randomNumber = rand.nextInt(2);
		if (randomNumber == 1)
			return true;
		else
			return false;
	}

	public void determineGame() {

	}

	public String checkWinner(char[] board) {
		String match;
		for (int i = 0; i < 8; i++) {
			match = null;
			switch (i) {
			case 0:
				match = String.valueOf(board[1]) + String.valueOf(board[2]) + String.valueOf(board[3]);
				break;
			case 1:
				match = String.valueOf(board[4]) + String.valueOf(board[5]) + String.valueOf(board[6]);
				break;
			case 2:
				match = String.valueOf(board[7]) + String.valueOf(board[8]) + String.valueOf(board[9]);
				break;
			case 3:
				match = String.valueOf(board[1]) + String.valueOf(board[5]) + String.valueOf(board[9]);
				break;
			case 4:
				match = String.valueOf(board[7]) + String.valueOf(board[5]) + String.valueOf(board[3]);
				break;
			case 5:
				match = String.valueOf(board[1]) + String.valueOf(board[4]) + String.valueOf(board[7]);
				break;
			case 6:
				match = String.valueOf(board[2]) + String.valueOf(board[5]) + String.valueOf(board[8]);
				break;
			case 7:
				match = String.valueOf(board[3]) + String.valueOf(board[6]) + String.valueOf(board[9]);
				break;
			default:
				break;
			}
			if (match.equals("XXX"))
				return "X";
			else if (match.equals("OOO"))
				return "O";
		}
		if (boardFill(board)) {
			return "Next round";
		}

		return "Tie";

	}

	private boolean boardFill(char[] board) {
		boolean flag = false;
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
