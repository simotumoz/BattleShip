package battleshipNew;

import java.util.Random;
import java.util.Scanner;

public class BattleShip {

	public static void printTitle() {
		System.out.println(
				" ________  ________  _________  _________  ___       _______   ________  ___  ___  ___  ________   \r\n"
						+ "|\\   __  \\|\\   __  \\|\\___   ___\\\\___   ___\\\\  \\     |\\  ___ \\ |\\   ____\\|\\  \\|\\  \\|\\  \\|\\   __  \\  \r\n"
						+ "\\ \\  \\|\\ /\\ \\  \\|\\  \\|___ \\  \\_\\|___ \\  \\_\\ \\  \\    \\ \\   __/|\\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\ \\  \\|\\  \\ \r\n"
						+ " \\ \\   __  \\ \\   __  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\    \\ \\  \\_|/_\\ \\_____  \\ \\   __  \\ \\  \\ \\   ____\\\r\n"
						+ "  \\ \\  \\|\\  \\ \\  \\ \\  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\____\\ \\  \\_|\\ \\|____|\\  \\ \\  \\ \\  \\ \\  \\ \\  \\___|\r\n"
						+ "   \\ \\_______\\ \\__\\ \\__\\   \\ \\__\\     \\ \\__\\ \\ \\_______\\ \\_______\\____\\_\\  \\ \\__\\ \\__\\ \\__\\ \\__\\   \r\n"
						+ "    \\|_______|\\|__|\\|__|    \\|__|      \\|__|  \\|_______|\\|_______|\\_________\\|__|\\|__|\\|__|\\|__|   \r\n"
						+ "                                                                 \\|_________|                      \r\n");

	}

	public static void printLine() {
		System.out.println("_________________________________________________________________________________");
		System.out.println();
	}

	public static void initBoard(int[][] board) {
		for (int row = 0; row < 7; row++)
			for (int column = 0; column < 7; column++)
				board[row][column] = -1;
	}

	public static void showBoard(int[][] board) {
		System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7");
		System.out.println();

		for (int row = 0; row < 7; row++) {
			System.out.print((row + 1) + "");
			for (int column = 0; column < 7; column++) {
				if (board[row][column] == -1) {
					System.out.print("\t" + "~");
				} else if (board[row][column] == 0) {
					System.out.print("\t" + "*");
				} else if (board[row][column] == 1) {
					System.out.print("\t" + "X");
				}

			}
			System.out.println();
		}

	}

	public static void initShipsCPU(int[][] ships) {
		Random random = new Random();

		for (int ship = 0; ship < 5; ship++) {
			ships[ship][0] = random.nextInt(7);
			ships[ship][1] = random.nextInt(7);

			for (int last = 0; last < ship; last++) {
				if ((ships[ship][0] == ships[last][0]) && (ships[ship][1] == ships[last][1]))
					do {
						ships[ship][0] = random.nextInt(7);
						ships[ship][1] = random.nextInt(7);
					} while ((ships[ship][0] == ships[last][0]) && (ships[ship][1] == ships[last][1]));
			}

		}
	}

	public static void initShipsPlayer(int[][] ships) {

		Scanner input = new Scanner(System.in);

		for (int ship = 0; ship < 5; ship++) {

			int tempRow = 0;

			try {
				System.out.print("> Insert the row in which you want to place the ship : ");
				tempRow = input.nextInt();
				if (!(tempRow > 0 && tempRow <= 7)) {
					System.out.println("Invalid input ");
					System.out.print("> Insert the row in which you want to place the ship : ");
					tempRow = input.nextInt();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			ships[ship][0] = tempRow;

			int tempCol = 0;

			try {
				System.out.print("> Insert the column in which you want to place the ship : ");
				tempCol = input.nextInt();
				if (!(tempCol > 0 && tempCol <= 7)) {
					System.out.println("Invalid input");
					System.out.print("> Insert the column in which you want to place the ship : ");
					tempCol = input.nextInt();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}

			ships[ship][1] = tempCol;

			for (int last = 0; last < ship; last++) {
				if ((ships[ship][0] == ships[last][0]) && (ships[ship][1] == ships[last][1]))
					do {
						System.out.println("Full slot, re-insert values ");

						try {
							System.out.print("> Insert the row in which you want to place the ship : ");
							tempRow = input.nextInt();
							if (!(tempRow > 0 && tempRow <= 7)) {
								System.out.println("Invalid input ");
								System.out.print("> Insert the row in which you want to place the ship : ");
								tempRow = input.nextInt();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						ships[ship][0] = tempRow;

						try {
							System.out.print("> Insert the column in which you want to place the ship : ");
							tempCol = input.nextInt();
							if (!(tempCol > 0 && tempCol <= 7)) {
								System.out.println("Invalid input");
								System.out.print("> Insert the column in which you want to place the ship : ");
								tempCol = input.nextInt();
							}
						} catch (Exception e) {

							e.printStackTrace();
						}

						ships[ship][1] = tempCol;
					} while ((ships[ship][0] == ships[last][0]) && (ships[ship][1] == ships[last][1]));
			}

		}
	}

	public static void playerShoot(int[] shoot) {
		Scanner input = new Scanner(System.in);
		int tempInputToVerify = 0;
		try {
			System.out.print("> Row: ");
			tempInputToVerify = input.nextInt();
			if (!(tempInputToVerify > 0 && tempInputToVerify <= 7)) {
				System.out.println("Invalid input");
				System.out.print("> Row: ");
				tempInputToVerify = input.nextInt();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		shoot[0] = tempInputToVerify;
		shoot[0]--;

		try {
			System.out.print("> Column: ");
			tempInputToVerify = input.nextInt();

			if (!(tempInputToVerify > 0 && tempInputToVerify <= 7)) {
				System.out.println("Invalid input");
				System.out.print("> Column: ");
				tempInputToVerify = input.nextInt();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		shoot[1] = tempInputToVerify;
		shoot[1]--;

	}

	public static void CPUShoot(int[] shoot) {
		Random random = new Random();

		int rowGuessedByCPU = random.nextInt(7);
		System.out.println("Row guessed by the CPU: " + rowGuessedByCPU);
		shoot[0] = rowGuessedByCPU;
		shoot[0]--;

		int columnGuessedByCPU = random.nextInt(7);
		System.out.println("Column guessed by the CPU: " + columnGuessedByCPU);
		shoot[1] = columnGuessedByCPU;
		shoot[1]--;

	}

	public static boolean hit(int[] shoot, int[][] ships) {

		for (int ship = 0; ship < ships.length; ship++) {
			if (shoot[0] == ships[ship][0] && shoot[1] == ships[ship][1]) {
				System.out.printf("You hit an enemy ship located in (%d,%d)\n", shoot[0] + 1, shoot[1] + 1);
				return true;
			}
		}
		return false;
	}

	public static void hint(int[] shoot, int[][] ships, int attempt) {
		int row = 0, column = 0;

		for (int line = 0; line < ships.length; line++) {
			if (ships[line][0] == shoot[0])
				row++;
			if (ships[line][1] == shoot[1])
				column++;
		}

		System.out.printf("\nHint %d: \nShips in Row %d -> %d ships\n" + "Ships in Column %d -> %d ships\n", attempt,
				shoot[0] + 1, row, shoot[1] + 1, column);
	}

	public static void changeboard(int[] shoot, int[][] ships, int[][] board) {
		if (hit(shoot, ships))
			board[shoot[0]][shoot[1]] = 1;
		else
			board[shoot[0]][shoot[1]] = 0;
	}

	public static void printFinalCreditsForPlayer(int attempts) {
		System.out.println("\n\n\n You've destroyed the five enemy ships in " + attempts + " attempts");
	}

	public static void printFinalCreditsForCPU(int attempts) {
		System.out.println("\n\n\n The CPU destroyed your five ships in " + attempts + " attempts");
	}

	public static void main(String[] args) {

		int[][] CPUboard = new int[7][7];
		int[][] playerBoard = new int[7][7];

		int[][] CPUShips = new int[5][2];
		int[][] playerShips = new int[5][2];

		int[] playerShoot = new int[2];
		int attempts = 0, shotHit = 0;

		int[] CPUShoot = new int[2];
		int CPUAttempts = 0, CPUShotHit = 0;

		printTitle();

		initBoard(CPUboard);
		initBoard(playerBoard);

		initShipsCPU(CPUShips);

		System.out.println("Player, place your five ships: ");
		System.out.println();
		showBoard(playerBoard);
		System.out.println();
		initShipsPlayer(playerShips);

		System.out.println();

		do {

			printLine();
			System.out.println("CPU Board: ");
			showBoard(CPUboard);
			printLine();
			playerShoot(playerShoot);
			attempts++;

			if (hit(playerShoot, CPUShips)) {
				hint(playerShoot, CPUShips, attempts);
				shotHit++;
			} else
				hint(playerShoot, CPUShips, attempts);

			changeboard(playerShoot, CPUShips, CPUboard);

			printLine();
			System.out.println("Your Board: ");
			showBoard(playerBoard);
			printLine();
			CPUShoot(CPUShoot);
			CPUAttempts++;

			if (hit(CPUShoot, playerShips)) {
				CPUShotHit++;
			}

			changeboard(CPUShoot, playerShips, playerBoard);

		} while (shotHit != 5 || CPUShotHit != 5);

		if (shotHit != 5) {
			printFinalCreditsForPlayer(attempts);
		} else if (CPUShotHit != 5) {
			printFinalCreditsForCPU(attempts);
		}

		showBoard(CPUboard);
		showBoard(playerBoard);
	}

}
