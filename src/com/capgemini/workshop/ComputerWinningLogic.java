package com.capgemini.workshop;

import java.util.ArrayList;
import java.util.Random;

public class ComputerWinningLogic {
	private char[] board;
	private char computer;
	private char player;
	private ArrayList<Integer> computerMoveHistory;
	private int nextMove;

	public ComputerWinningLogic(char computer, char player) {
		this.computer = computer;
		this.player = player;
	}

	public int placeMove(char[] board, ArrayList<Integer> computerMoveHistory) {
		this.board = board;
		this.computerMoveHistory = computerMoveHistory;
		int temp = 0;
		if (computerMoveHistory.size() == 0) {
			Random rand = new Random();
			int random = 1 + rand.nextInt(8);
			while (board[random] != ' ') {
				random = 1 + rand.nextInt(8);
			}
			nextMove = random;
			return nextMove;
		} else {
			for (int i : computerMoveHistory) {
				switch (i) {
				case 1:
					temp = winningPositionCheckingSix(2, 3, 4, 7, 5, 9);
					break;
				case 2:
					temp = winningPositionCheckingFour(1, 3, 5, 8);
					break;
				case 3:
					temp = winningPositionCheckingSix(1, 2, 5, 7, 6, 9);
					break;
				case 4:
					temp = winningPositionCheckingFour(1, 7, 5, 6);
					break;
				case 5:
					temp = winningPositionCheckingEight(1, 9, 3, 7, 4, 6, 2, 8);
					break;
				case 6:
					temp = winningPositionCheckingFour(3, 9, 4, 5);
					break;
				case 7:
					temp = winningPositionCheckingSix(1, 4, 3, 5, 8, 9);
					break;
				case 8:
					temp = winningPositionCheckingFour(2, 5, 7, 9);
					break;
				case 9:
					temp = winningPositionCheckingSix(1, 5, 7, 8, 3, 6);
					break;
				default:
					break;
				}
				if (temp > 0) {
					nextMove = temp;
					break;
				}
			}
			if (temp < 0) {
				Random rand = new Random();
				int random = 1 + rand.nextInt(8);
				while (board[random] != ' ') {
					random = 1 + rand.nextInt(8);
				}
				nextMove = random;
			}
			return nextMove;
		}

	}

	private int winningPositionCheckingSix(int firstNum, int secondNum, int thirdNum, int fourthNum, int fifthNum,
			int sixthNum) {
		int location = 0;
		if ((board[firstNum] != player || board[firstNum] == ' ')
				&& (board[secondNum] != player || board[secondNum] == ' ')) {
			if (board[firstNum] == ' ')
				location = firstNum;
			else
				location = secondNum;
		} else if ((board[fourthNum] != player || board[fourthNum] == ' ')
				&& (board[thirdNum] != player || board[thirdNum] == ' ')) {
			if (board[fourthNum] == ' ')
				location = fourthNum;
			else
				location = thirdNum;
		} else if ((board[fifthNum] != player || board[fifthNum] == ' ')
				&& (board[sixthNum] != player || board[sixthNum] == ' ')) {
			if (board[fifthNum] == ' ')
				location = fifthNum;
			else
				location = sixthNum;
		} else
			location = -1;
		return location;
	}

	private int winningPositionCheckingFour(int firstNum, int secondNum, int thirdNum, int fourthNum) {
		int location = 0;
		if ((board[firstNum] != player || board[firstNum] == ' ')
				&& (board[secondNum] != player || board[secondNum] == ' ')) {
			if (board[firstNum] == ' ')
				location = firstNum;
			else
				location = secondNum;
		} else if ((board[fourthNum] != player || board[fourthNum] == ' ')
				&& (board[thirdNum] != player || board[thirdNum] == ' ')) {
			if (board[fourthNum] == ' ')
				location = fourthNum;
			else
				location = thirdNum;
		} else
			location = -1;
		return location;
	}

	private int winningPositionCheckingEight(int firstNum, int secondNum, int thirdNum, int fourthNum, int fifthNum,
			int sixthNum, int seventhNum, int eightNum) {
		int location = 0;
		if ((board[firstNum] != player || board[firstNum] == ' ')
				&& (board[secondNum] != player || board[secondNum] == ' ')) {
			if (board[firstNum] == ' ')
				location = firstNum;
			else
				location = secondNum;
		} else if ((board[fourthNum] != player || board[fourthNum] == ' ')
				&& (board[thirdNum] != player || board[thirdNum] == ' ')) {
			if (board[fourthNum] == ' ')
				location = fourthNum;
			else
				location = thirdNum;
		} else if ((board[fifthNum] != player || board[fifthNum] == ' ')
				&& (board[sixthNum] != player || board[sixthNum] == ' ')) {
			if (board[fifthNum] == ' ')
				location = fifthNum;
			else
				location = sixthNum;
		} else if ((board[seventhNum] != player || board[seventhNum] == ' ')
				&& (board[eightNum] != player || board[eightNum] == ' ')) {
			if (board[seventhNum] == ' ')
				location = seventhNum;
			else
				location = eightNum;
		} else
			location = -1;
		return location;
	}
}
