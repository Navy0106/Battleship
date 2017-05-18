import java.util.Scanner;

public class Battleship {
	
	static int[][] gameBoard1 = new int[10][10];
	static int[][] gameBoard2 = new int[10][10];
	static int[][] pawns1 = new int [10][10];
	static int[][] pawns2 = new int [10][10];
	static int r = 0;
	static int c = 0;
	static Scanner scnr = new Scanner(System.in);
	static int ships1 = 5;
	static int ships2 = 5;
	static int shipCount1 = 0;
	static int shipCount2 = 0;
	static int hintRow = 0;
	static int hintCol = 0;
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Game of Battleship!");
		setBoard1();
		setBoard2();
		showBoard1(gameBoard1);
		showBoard2(gameBoard2);
		setShips1(pawns1);
		setShips2(pawns2);
		for (int i = 0; i <= 100; ++i) {
			shoot1(pawns2, gameBoard2);
			if (ships2 == 0) {
				System.out.println("Congratulations! Player 1 wins!");
				break;
			}
			shoot2(pawns1, gameBoard1);
			if (ships1 == 0) {
				System.out.println("Congratulations! Player 2 wins!");
				break;
			}
			showBoard1(gameBoard1);
			showBoard2(gameBoard2);
		}
		System.out.println("GAME OVER!");
	}
	
	
	
	
	
	
	
	
	
	
	public static void setBoard1() {
		for (r = 0; r < 10; ++r) {
			for (c = 0; c < 10; ++c) {
				gameBoard1[r][c] = 0;
			}
		}
	}
	
	public static void setBoard2() {
		for (r = 0; r < 10; ++r) {
			for (c = 0; c < 10; ++c) {
				gameBoard2[r][c] = 0;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void showBoard1(int gameBoard1[][]) {
		System.out.println("");
		System.out.println("");
		System.out.println("                       Player 1's Board");
		System.out.print("  ");
		for (int i = 1; i <= 10; ++i) {
			System.out.print("     " + i);
		}
		System.out.println("");	     
		for (r = 0; r < 10; ++r) {   
			if (r < 9) {
				System.out.print(r + 1 + "      ");  
			}
			if (r == 9) {
				System.out.print(r + 1 + "     ");
			}
			for (c = 0; c < 10; ++c) {
				if (gameBoard1[r][c] == 0) {
					System.out.print("~" + "     ");
				}
				else if (gameBoard1[r][c] == -1) {
					System.out.print("O" + "     ");
				}
				else if (gameBoard1[r][c] == 1) {
					System.out.print("X" + "     ");
				}
			}
			System.out.println("");
			System.out.println("");
		}
		System.out.println("");
	}
	
	
	
	
	
	public static void showBoard2(int gameBoard2[][]) {
		System.out.println("                       Player 2's Board");
		System.out.print("  ");
		for (int i = 1; i <= 10; ++i) {
			System.out.print("     " + i);
		}
		System.out.println("");
		for (r = 0; r < 10; ++r) {
			if (r < 9) {
				System.out.print(r + 1 + "      ");  
			}
			if (r == 9) {
				System.out.print(r + 1 + "     ");
			}
			for (c = 0; c < 10; ++c) {
				if (gameBoard2[r][c] == 0) {
					System.out.print("~" + "     ");
				}
				else if (gameBoard2[r][c] == -1) {
					System.out.print("O" + "     ");
				}
				else if (gameBoard2[r][c] == 1) {
					System.out.print("X" + "     ");
				}
			}
			System.out.println("");
			System.out.println("");
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void setShips1(int pawns1[][]) {
		System.out.println("");
		System.out.println("Time for player 1 to enter his ships, player 2 please step away.");
		System.out.println("You will enter the coordinates (values 1-10) for five different ships. Please follow the prompts.");
		System.out.println("");
		for (r = 0; r < 10; ++r) {
			for (c = 0; c < 10; ++c) {
				pawns1[r][c] = 0;
			}
		}
		for (int i = 1; i <= 5; ++i) {
			System.out.println("Enter ship #" + i + " row: ");
			int shipRow1 = scnr.nextInt() - 1;
			if ((shipRow1 < 0) || (shipRow1 > 9)) {
				System.out.print("Ship is out of grid coordinates. Please enter an appropriate value: ");
				shipRow1 = scnr.nextInt() - 1;
			}
			System.out.println("Enter ship #" + i + " column: ");
			int shipCol1 = scnr.nextInt() - 1;
			if ((shipCol1 < 0) || (shipCol1 > 9)) {
				System.out.print("Ship is out of grid coordinates. Please enter an appropriate value: ");
				shipCol1 = scnr.nextInt() - 1;
			}
			if (pawns1[shipRow1][shipCol1] == 1) {
				System.out.println("Ship is a duplicate. Please renter this ship's coordinates.");
				i = i - 1;
			}
			if (pawns1[shipRow1][shipCol1] != 1) {
				pawns1[shipRow1][shipCol1] = 1;
			}
		}
		System.out.println("Your ships have been placed.");
		for (int p = 0; p <= 50; ++p) {
			System.out.println("");
		}
	}
	
	
	
	
	
	public static void setShips2(int pawns2[][]) {
		System.out.println("");
		System.out.println("Time for player 2 to enter his ships, player 1 please step away.");
		System.out.println("You will enter the coordinates (values 1 -10) for five different ships. Please follow the prompts.");
		System.out.println("");
		for (r = 0; r < 10; ++r) {
			for (c = 0; c < 10; ++c) {
				pawns2[r][c] = 0;
			}
		}
		for (int i = 1; i <= 5; ++i) {
			System.out.println("Enter ship #" + i + " row: ");
			int shipRow2 = scnr.nextInt() - 1;
			if ((shipRow2 < 0) || (shipRow2 > 9)) {
				System.out.print("Ship is out of grid coordinates. Please enter an appropriate value: ");
				shipRow2 = scnr.nextInt() - 1;
			}
			System.out.println("Enter ship #" + i + " column: ");
			int shipCol2 = scnr.nextInt() - 1;
			if ((shipCol2 < 0) || (shipCol2 > 9)) {
				System.out.print("Ship is out of grid coordinates. Please enter an appropriate value: ");
				shipCol2 = scnr.nextInt() - 1;
			}
			if (pawns2[shipRow2][shipCol2] == 1) {
				System.out.println("Ship is a duplicate. Please renter this ship's coordinates.");
				i = i - 1;
			}
			if (pawns2[shipRow2][shipCol2] != 1) {
				pawns2[shipRow2][shipCol2] = 1;
			}
		}
		System.out.println("Your ships have been placed.");
		for (int p = 0; p <= 50; ++p) {
			System.out.println("");
		}
	}
		
	
	
	
	
	
	
	
	
	
	public static void shoot1(int pawns2[][], int gameBoard2[][]) {
		System.out.println("");
		System.out.println("Player 1, enter shot trajectory.  Enter shot row: ");
		int shotRow1 = scnr.nextInt() - 1;
		if ((shotRow1 < 0) || (shotRow1 > 9)) {
			System.out.print("Shot is out of grid coordinates. Please enter an appropriate value: ");
			shotRow1 = scnr.nextInt() - 1;
		}
		System.out.println("Enter shot column: ");
		int shotCol1 = scnr.nextInt() - 1;
		if ((shotCol1 < 0) || (shotCol1 > 9)) {
			System.out.print("Shot is out of grid coordinates. Please enter an appropriate value: ");
			shotCol1 = scnr.nextInt() - 1;
		}
		System.out.println("");
		if (pawns2[shotRow1][shotCol1] == 0) {
			gameBoard2[shotRow1][shotCol1] = -1;
			System.out.println("");
			System.out.println("The shot has missed. Player 2's turn.");
			System.out.println("");
			hintCol = 0;
			hintRow = 0;
			for (r = 0; r < 10; ++r) {
				if (pawns2[r][shotCol1] == 1) {
					++hintCol;
				}
			}
			for (c = 0; c < 10; ++c) {
				if (pawns2[shotRow1][c] == 1) {
					++hintRow;
				}
			}
			System.out.println("There are " + hintCol + " ship(s) in this columm.");
			System.out.println("There are " + hintRow + " ship(s) in this row.");
			System.out.println("");
		}			
		if (pawns2[shotRow1][shotCol1] == 1) {
			gameBoard2[shotRow1][shotCol1] = 1;
			System.out.println("");
			System.out.println("The shot has hit.  Player 2's turn.");
			System.out.println("");
			--ships2;
		}
	}
	
	
	
	
	
	public static void shoot2(int pawns1[][], int gameBoard1[][]) {
		System.out.println("");
		System.out.println("Player 2, enter shot trajectory.  Enter shot row: ");
		int shotRow2 = scnr.nextInt() - 1;
		if ((shotRow2 < 0) || (shotRow2 > 9)) {
			System.out.print("Shot is out of grid coordinates. Please enter an appropriate value: ");
			shotRow2 = scnr.nextInt() - 1;
		}
		System.out.println("Enter shot column: ");
		int shotCol2 = scnr.nextInt() - 1;
		if ((shotCol2 < 0) || (shotCol2 > 9)) {
			System.out.print("Shot is out of grid coordinates. Please enter an appropriate value: ");
			shotCol2 = scnr.nextInt() - 1;
		}
		System.out.println("");
		if (pawns1[shotRow2][shotCol2] == 0) {
			gameBoard1[shotRow2][shotCol2] = -1;
			System.out.println("");
			System.out.println("The shot has missed. Player 1's turn.");
			System.out.println("");
			hintRow = 0;
			hintCol = 0;
			for (r = 0; r < 10; ++r) {
				if (pawns1[r][shotCol2] == 1) {
					++hintCol;
				}
			}
			for (c = 0; c < 10; ++c) {
				if (pawns1[shotRow2][c] == 1) {
					++hintRow;
				}
			}
			System.out.println("There are " + hintCol + " ship(s) in this columm.");
			System.out.println("There are " + hintRow + " ship(s) in this row.");
			System.out.println("");
		}			
		if (pawns1[shotRow2][shotCol2] == 1) {
			gameBoard1[shotRow2][shotCol2] = 1;
			System.out.println("");
			System.out.println("The shot has hit.  Player 1's turn.");
			System.out.println("");
			--ships1;
		}
	}	
}