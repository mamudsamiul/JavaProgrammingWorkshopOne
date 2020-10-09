package com.capgemini.workshop;

import java.util.ArrayList;
import java.util.Random;

public class ComputerWinningLogic {
	private char[] board;
	private char computer;
	private char player;
	private ArrayList<Integer> computerMoveHistory;
	private ArrayList<Integer> playerMoveHistory;
	private int[] nextMove = { 0, 0 };

	public ComputerWinningLogic(char computer, char player) {
		this.computer = computer;
		this.player = player;
	}

	public int[] placeMove(char[] board, ArrayList<Integer> computerMoveHistory) {
		this.board = board;
		this.computerMoveHistory = computerMoveHistory;
		int[] temp = { 0, 0 };
		if (computerMoveHistory.size() == 0) {
			Random rand = new Random();
			int random = 1 + rand.nextInt(8);
			while (board[random] != ' ') {
				random = 1 + rand.nextInt(8);
			}
			nextMove[0] = random;
			nextMove[1] = 0;
			return nextMove;
		} else {
			for (int i : computerMoveHistory) {
				switch (i) {
				case 1:
					temp = winningPositionCheckingSix(computer, 2, 3, 4, 7, 5, 9);
					break;
				case 2:
					temp = winningPositionCheckingFour(computer, 1, 3, 5, 8);
					break;
				case 3:
					temp = winningPositionCheckingSix(computer, 1, 2, 5, 7, 6, 9);
					break;
				case 4:
					temp = winningPositionCheckingFour(computer, 1, 7, 5, 6);
					break;
				case 5:
					temp = winningPositionCheckingEight(computer, 1, 9, 3, 7, 4, 6, 2, 8);
					break;
				case 6:
					temp = winningPositionCheckingFour(computer, 3, 9, 4, 5);
					break;
				case 7:
					temp = winningPositionCheckingSix(computer, 1, 4, 3, 5, 8, 9);
					break;
				case 8:
					temp = winningPositionCheckingFour(computer, 2, 5, 7, 9);
					break;
				case 9:
					temp = winningPositionCheckingSix(computer, 1, 5, 7, 8, 3, 6);
					break;
				default:
					break;
				}
				if (temp[0] > 0 && temp[1] == 2) {
					nextMove = temp;
					break;
				} else if (temp[0] > 0)
					nextMove = temp;
			}
			if (temp[0] < 0) {

				nextMove[0] = -1;
				nextMove[1] = -1;
			}
			return nextMove;
		}

	}

	public int randomMove(char[] board) {
		Random rand = new Random();
		int random = 1 + rand.nextInt(8);
		while (board[random] != ' ') {
			random = 1 + rand.nextInt(8);
		}
		int nextMove = random;
		return nextMove;
	}

	public int[] blockTheMove(char[] board, ArrayList<Integer> computerMoveHistory) {
		this.board = board;
		this.computerMoveHistory = computerMoveHistory;
		int[] temp = { 0, 0 };
		if (computerMoveHistory.size() < 2) {
			nextMove[0] = -1;
		} else {
			for (int i : computerMoveHistory) {
				switch (i) {
				case 1:
					temp = winningPositionCheckingSix(player, 2, 3, 4, 7, 5, 9);
					break;
				case 2:
					temp = winningPositionCheckingFour(player, 1, 3, 5, 8);
					break;
				case 3:
					temp = winningPositionCheckingSix(player, 2, 1, 5, 7, 6, 9);
					break;
				case 4:
					temp = winningPositionCheckingFour(player, 1, 7, 5, 6);
					break;
				case 5:
					temp = winningPositionCheckingEight(player, 1, 9, 3, 7, 4, 6, 2, 8);
					break;
				case 6:
					temp = winningPositionCheckingFour(player, 3, 9, 4, 5);
					break;
				case 7:
					temp = winningPositionCheckingSix(player, 4, 1, 5, 3, 8, 9);
					break;
				case 8:
					temp = winningPositionCheckingFour(player, 2, 5, 7, 9);
					break;
				case 9:
					temp = winningPositionCheckingSix(player, 1, 5, 7, 8, 3, 6);
					break;
				default:
					break;
				}
				if (temp[0] > 0 && temp[1] == 2) {
					nextMove = temp;
					break;
				}

			}
			if (temp[0] < 0)
				nextMove[0] = -1;
		}
		return nextMove;
	}

	private int[] winningPositionCheckingSix(char player, int firstNum, int secondNum, int thirdNum, int fourthNum,
			int fifthNum, int sixthNum) {
		int[] location = { 0, 0 };
		if ((board[firstNum] == player || board[firstNum] == ' ')
				&& (board[secondNum] == player || board[secondNum] == ' ')) {
			if (board[firstNum] == ' ' && board[secondNum] == player) {
				location[0] = firstNum;
				location[1] = 2;
			} else if (board[firstNum] == player && board[secondNum] == ' ') {
				location[0] = secondNum;
				location[1] = 2;
			} else {
				location[0] = secondNum;
				location[1] = 1;
			}
		} else if ((board[fourthNum] == player || board[fourthNum] == ' ')
				&& (board[thirdNum] == player || board[thirdNum] == ' ')) {
			if (board[fourthNum] == ' ' && board[thirdNum] == player) {
				location[0] = fourthNum;
				location[1] = 2;
			}

			else if (board[fourthNum] == player && board[thirdNum] == ' ') {
				location[0] = thirdNum;
				location[1] = 2;
			} else {
				location[0] = fourthNum;
				location[1] = 1;
			}

		} else if ((board[fifthNum] == player || board[fifthNum] == ' ')
				&& (board[sixthNum] == player || board[sixthNum] == ' ')) {
			if (board[fifthNum] == ' ' && board[sixthNum] == player) {
				location[0] = fifthNum;
				location[1] = 2;
			}

			else if (board[fifthNum] == player && board[sixthNum] == ' ') {
				location[0] = sixthNum;
				location[1] = 2;
			} else {
				location[0] = sixthNum;
				location[1] = 1;
			}

		} else {
			location[0] = -1;
			location[1] = -1;
		}

		return location;
	}

	private int[] winningPositionCheckingFour(char player, int firstNum, int secondNum, int thirdNum, int fourthNum) {
		int[] location = { 0, 0 };
		if ((board[firstNum] == player || board[firstNum] == ' ')
				&& (board[secondNum] == player || board[secondNum] == ' ')) {
			if (board[firstNum] == ' ' && board[secondNum] == player) {
				location[0] = firstNum;
				location[1] = 2;
			} else if (board[firstNum] == player && board[secondNum] == ' ') {
				location[0] = secondNum;
				location[1] = 2;
			} else {
				location[0] = secondNum;
				location[1] = 1;
			}
		} else if ((board[fourthNum] == player || board[fourthNum] == ' ')
				&& (board[thirdNum] == player || board[thirdNum] == ' ')) {
			if (board[fourthNum] == ' ' && board[thirdNum] == player) {
				location[0] = fourthNum;
				location[1] = 2;
			}

			else if (board[fourthNum] == player && board[thirdNum] == ' ') {
				location[0] = thirdNum;
				location[1] = 2;
			} else {
				location[0] = fourthNum;
				location[1] = 1;
			}

		} else {
			location[0] = -1;
			location[1] = -1;
		}
		return location;
	}

	private int[] winningPositionCheckingEight(char player, int firstNum, int secondNum, int thirdNum, int fourthNum,
			int fifthNum, int sixthNum, int seventhNum, int eightNum) {
		int[] location = { 0, 0 };
		if ((board[firstNum] == player || board[firstNum] == ' ')
				&& (board[secondNum] == player || board[secondNum] == ' ')) {
			if (board[firstNum] == ' ' && board[secondNum] == player) {
				location[0] = firstNum;
				location[1] = 2;
			} else if (board[firstNum] == player && board[secondNum] == ' ') {
				location[0] = secondNum;
				location[1] = 2;
			} else {
				location[0] = secondNum;
				location[1] = 1;
			}
		} else if ((board[fourthNum] == player || board[fourthNum] == ' ')
				&& (board[thirdNum] == player || board[thirdNum] == ' ')) {
			if (board[fourthNum] == ' ' && board[thirdNum] == player) {
				location[0] = fourthNum;
				location[1] = 2;
			}

			else if (board[fourthNum] == player && board[thirdNum] == ' ') {
				location[0] = thirdNum;
				location[1] = 2;
			} else {
				location[0] = fourthNum;
				location[1] = 1;
			}

		} else if ((board[fifthNum] == player || board[fifthNum] == ' ')
				&& (board[sixthNum] == player || board[sixthNum] == ' ')) {
			if (board[fifthNum] == ' ' && board[sixthNum] == player) {
				location[0] = fifthNum;
				location[1] = 2;
			}

			else if (board[fifthNum] == player && board[sixthNum] == ' ') {
				location[0] = sixthNum;
				location[1] = 2;
			} else {
				location[0] = sixthNum;
				location[1] = 1;
			}

		} else if ((board[seventhNum] == player || board[seventhNum] == ' ')
				&& (board[eightNum] == player || board[eightNum] == ' ')) {
			if (board[seventhNum] == ' ' && board[eightNum] == player) {
				location[0] = seventhNum;
				location[1] = 2;
			}

			else if (board[seventhNum] == player && board[eightNum] == ' ') {
				location[0] = eightNum;
				location[1] = 2;
			} else {
				location[0] = eightNum;
				location[1] = 1;
			}

		} else {
			location[0] = -1;
			location[1] = -1;
		}
		return location;
	}

}
