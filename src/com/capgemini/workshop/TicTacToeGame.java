package com.capgemini.workshop;

import java.util.Scanner;

public class TicTacToeGame {
	public char[] createTicTacBoard(int size) {
		char[] boardSize = new char[size];
		for (int i = 0; i < boardSize.length; i++) {
			boardSize[i] = ' ';
		}
		return boardSize;
	}

	public void takeInputFromPlayer(char player, char computer, Scanner scan) {
		System.out.println("Enter 'X' or 'O' ");
		char entry = scan.next().toUpperCase().charAt(0);
		if (entry == 'X')
			player = 'X';
		else if (entry == 'O')
			player = 'o';
		else
			System.out.println("Invalid Input!");
	}

	public void showBoard(char[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println("Board Layout: " + board);
		}
	}
}
