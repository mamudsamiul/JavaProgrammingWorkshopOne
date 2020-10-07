package com.capgemini.workshop;

import java.util.Scanner;

public class TicTacToeGame {
	public char[] createTicTacBoard(int size) {
		char[] boardSize = new char[size];
		return boardSize;
	}

	public void takeInputFromPlayer(Boolean player, Boolean computer, Scanner scan) {
		System.out.println("Enter 'X' or 'O' ");
		String entry = scan.next();
		if (entry.equals("X")) {
			player = true;
			computer = false;
		} else if (entry.equals("O")) {
			player = false;
			computer = true;
		} else
			System.out.println("Invalid Input!");
	}
}
