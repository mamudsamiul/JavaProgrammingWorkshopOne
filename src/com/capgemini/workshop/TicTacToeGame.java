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
		rand= new Random();
		int randomNumber=rand.nextInt(2);
		if(randomNumber==1)
			return true;
		else
			return false;
	}
}
