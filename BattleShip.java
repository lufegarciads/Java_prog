package Part_I;
import java.util.*;

public class Battleship {
	public static void main(String[] args) {
		//Instatiate scanner object
		Scanner input = new Scanner(System.in);

		//Setting common messages
		String invalidCoord = new String("Invalid coordinates. Choose different coordinates.");
		String repeatedCoord = new String("You already have a ship there. Choose different coordinates.");
		String alreadyfired = new String("You already fired on this spot. Choose different coordinates.");

		//Setting max coordinate values
		final int MAX_COORD = 5;
		final int MAX_SHIPS = 5;

		//Welcome message
		System.out.println("Welcome to Battleship!");

		//Instantiates and fills players boards
		char[][] playerOneBoard = new char[5][5];
		char[][] playerTwoBoard = new char[5][5];
		char[][] playerOneShotsBoard = new char[5][5];
		char[][] playerTwoShotsBoard = new char[5][5];

		for (int row = 0; row < playerOneBoard.length; row++) {
			for (int col = 0; col < playerOneBoard[row].length; col++) {
				playerOneBoard[row][col] = '-';
			}
		}
		for (int row = 0; row < playerTwoBoard.length; row++) {
			for (int col = 0; col < playerTwoBoard[row].length; col++) {
				playerTwoBoard[row][col] = '-';
			}
		}
		for (int row = 0; row < playerOneShotsBoard.length; row++) {
			for (int col = 0; col < playerOneShotsBoard[row].length; col++) {
				playerOneShotsBoard[row][col] = '-';
			}
		}
		for (int row = 0; row < playerTwoShotsBoard.length; row++) {
			for (int col = 0; col < playerTwoShotsBoard[row].length; col++) {
				playerTwoShotsBoard[row][col] = '-';
			}
		}

		//PLAYER 1 - SETUP PHASE
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

		for (int ships = 0; ships < MAX_SHIPS; ships++) {

			int playerOneShipXCoord = 0;
			int playerOneShipYCoord = 0;
			boolean validInput = false;

			do  {
				System.out.println("Enter ship " + (ships + 1) + " location:");

				if (input.hasNextInt()) {
					playerOneShipXCoord = input.nextInt();

					if (input.hasNextInt()) {
						playerOneShipYCoord = input.nextInt();

						if ((playerOneShipXCoord < MAX_COORD)
							&& (playerOneShipYCoord < MAX_COORD)) {

							if (playerOneBoard[playerOneShipXCoord][playerOneShipYCoord] == '-') {
								playerOneBoard[playerOneShipXCoord][playerOneShipYCoord] = '@';
								validInput = true;
							}
							else {
								System.out.println(repeatedCoord);
								input.nextLine();
							}
						}
						else {
							System.out.println(invalidCoord);
							input.nextLine();
						}
					}
				}
				else {
					System.out.println(invalidCoord);
					input.nextLine();
				}
			} while (!validInput);
		}
		printBattleShip(playerOneBoard);

		//PLAYER 1 SETUP COMPLETED

		for (int lineCounter = 0; lineCounter < 100; lineCounter++) {
			System.out.println("");
		}

		//PLAYER 2 - SETUP PHASE
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");

		for (int ships = 0; ships < MAX_SHIPS; ships++) {

			int playerTwoShipXCoord = 0;
			int playerTwoShipYCoord = 0;
			boolean validInput = false;

			do  {
				System.out.println("Enter ship " + (ships + 1) + " location:");

				if (input.hasNextInt()) {
					playerTwoShipXCoord = input.nextInt();

					if (input.hasNextInt()) {
						playerTwoShipYCoord = input.nextInt();

						if ((playerTwoShipXCoord < MAX_COORD)
							&& (playerTwoShipYCoord < MAX_COORD)) {

							if (playerTwoBoard[playerTwoShipXCoord][playerTwoShipYCoord] == '-') {
								playerTwoBoard[playerTwoShipXCoord][playerTwoShipYCoord] = '@';
								validInput = true;
							}
							else {
								System.out.println(repeatedCoord);
								input.nextLine();
							}
						}
						else {
							System.out.println(invalidCoord);
							input.nextLine();
						}
					}
				}
				else {
					System.out.println(invalidCoord);
					input.nextLine();
				}
			} while (!validInput);
		}
		printBattleShip(playerTwoBoard);
		System.out.println("");

		for (int lineCounter2 = 0; lineCounter2 < 100; lineCounter2++) {
			System.out.println("");
		}


	//PLAYER 2 SETUP COMPLETED
	//MATCH STARTS

		int playerOneShotXCoord = 0;
		int playerOneShotYCoord = 0;
		int playerTwoShotXCoord = 0;
		int playerTwoShotYCoord = 0;
		boolean validInputMatchP1 = false;
		boolean validInputMatchP2 = false;
		int numShipsShotP1 = 0;
		int numShipsShotP2 = 0;
		boolean winner = false;

		while (!winner) {
			do {
				System.out.println("Player 1, enter hit row/column:");
				validInputMatchP1 = false;

				if (input.hasNextInt()) {
					playerOneShotXCoord = input.nextInt();

					if (input.hasNextInt()) {
						playerOneShotYCoord = input.nextInt();

						if ((playerOneShotXCoord < MAX_COORD)
							&& (playerOneShotYCoord < MAX_COORD)) {

							if (playerTwoShotsBoard[playerOneShotXCoord][playerOneShotYCoord] == 'X'
								|| playerTwoShotsBoard[playerOneShotXCoord][playerOneShotYCoord] == 'O') {
								System.out.println(alreadyfired);
								input.nextLine();
							}
							else if (playerTwoBoard[playerOneShotXCoord][playerOneShotYCoord] == '@') {
								playerTwoShotsBoard[playerOneShotXCoord][playerOneShotYCoord] = 'X';
								playerTwoBoard[playerOneShotXCoord][playerOneShotYCoord] = 'X';
								System.out.println("PLAYER 1 HIT PLAYER 2'S SHIP!");
								printBattleShip(playerTwoShotsBoard);
								numShipsShotP2 += 1;
								validInputMatchP1 = true;
							}
							else if (playerTwoBoard[playerOneShotXCoord][playerOneShotYCoord] == '-') {
								playerTwoShotsBoard[playerOneShotXCoord][playerOneShotYCoord] = 'O';
								playerTwoBoard[playerOneShotXCoord][playerOneShotYCoord] = 'O';
								System.out.println("PLAYER 1 MISSED!");
								printBattleShip(playerTwoShotsBoard);
								validInputMatchP1 = true;
							}
						}
						else {
							System.out.println(invalidCoord);
							input.nextLine();
						}
					}
				}
				else {
					System.out.println(invalidCoord);
					input.nextLine();
				}
			} while (!validInputMatchP1);

			if (numShipsShotP2 == MAX_SHIPS) {
				winner = true;
				System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
				System.out.println("Final Boards:");
				printBattleShip(playerOneBoard);
				System.out.println("");
				printBattleShip(playerTwoBoard);
				break;
			}

			do {
				System.out.println("Player 2, enter hit row/column:");
				validInputMatchP2 = false;

				if (input.hasNextInt()) {
					playerTwoShotXCoord = input.nextInt();

					if (input.hasNextInt()) {
						playerTwoShotYCoord = input.nextInt();

						if ((playerTwoShotXCoord < MAX_COORD)
							&& (playerTwoShotYCoord < MAX_COORD)) {

							if (playerOneShotsBoard[playerTwoShotXCoord][playerTwoShotYCoord] == 'X'
								|| playerOneShotsBoard[playerTwoShotXCoord][playerTwoShotYCoord] == 'O') {
									System.out.println(alreadyfired);
									input.nextLine();
							}
							else if (playerOneBoard[playerTwoShotXCoord][playerTwoShotYCoord] == '@') {
								playerOneShotsBoard[playerTwoShotXCoord][playerTwoShotYCoord] = 'X';
								playerOneBoard[playerTwoShotXCoord][playerTwoShotYCoord] = 'X';
								System.out.println("PLAYER 2 HIT PLAYER 1'S SHIP!");
								printBattleShip(playerOneShotsBoard);
								numShipsShotP1 += 1;
								validInputMatchP2 = true;
							}
							else if (playerOneBoard[playerTwoShotXCoord][playerTwoShotYCoord] == '-') {
								playerOneShotsBoard[playerTwoShotXCoord][playerTwoShotYCoord] = 'O';
								playerOneBoard[playerTwoShotXCoord][playerTwoShotYCoord] = 'O';
								System.out.println("PLAYER 2 MISSED!");
								printBattleShip(playerOneShotsBoard);
								validInputMatchP2 = true;
							}
						}
						else {
							System.out.println(invalidCoord);
							input.nextLine();
						}
					}
				}
				else {
					System.out.println(invalidCoord);
					input.nextLine();
				}
			} while (!validInputMatchP2);

		if (numShipsShotP1 == MAX_SHIPS) {
			winner = true;
			System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
			System.out.println("Final Boards:");
			printBattleShip(playerOneBoard);
			System.out.println("");
			printBattleShip(playerTwoBoard);
			break;
		}
		}
	}

	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}
