package L4_June19;

public class Backtracking {

	public static void main(String[] args) {

		// nqueen(new boolean[4][4], 0, "");
		// pattern(0, 0, 5);
		int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		boolean res = sudokuSolver(board, 0, 0);

		if (res)
			display(board);
		else {
			System.out.println("not possible");
		}

		// nKnights(new boolean[4][4], 0, 0, "", 0);

	}

	public static void display(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void nqueen(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				nqueen(board, row + 1, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {

		int r = row - 1;
		int c = col;

		// vertically up
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}

			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		return true;

	}

	public static void pattern(int row, int col, int n) {

		if (row == n) {
			return;
		}

		if (col == n) {
			System.out.println();
			pattern(row + 1, 0, n);
			return;
		}

		System.out.print("*");
		pattern(row, col + 1, n);

	}

	public static boolean sudokuSolver(int[][] board, int row, int col) {

		if (row == board.length) {
			return true;
		}

		if (col == board[0].length) {
			return sudokuSolver(board, row + 1, 0);
		}

		if (board[row][col] != 0) {
			return sudokuSolver(board, row, col + 1);
		}

		for (int num = 1; num <= 9; num++) {

			if (isItSafe(board, row, col, num)) {
				board[row][col] = num;
				boolean res = sudokuSolver(board, row, col + 1);
				if (res) {
					return true;
				}

				board[row][col] = 0;
			}
		}

		return false;
	}

	public static boolean isItSafe(int[][] board, int row, int col, int num) {

		return isItSafeRow(board, row, num) && isItSafeCol(board, col, num) && isItSafeGrid(board, row, col, num);
	}

	public static boolean isItSafeRow(int[][] board, int row, int num) {

		for (int col = 0; col < board[0].length; col++) {
			if (board[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCol(int[][] board, int col, int num) {

		for (int row = 0; row < board.length; row++) {
			if (board[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeGrid(int[][] board, int row, int col, int num) {

		int rsp = row - (row % 3);
		int csp = col - (col % 3);

		for (int r = rsp; r < rsp + 3; r++) {
			for (int c = csp; c < csp + 3; c++) {
				if (board[r][c] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public static void nKnights(boolean[][] board, int row, int col, String asf, int kpsf) {

		if (kpsf == board.length) {
			System.out.println(asf);
			return;
		}

		for (int c = col; c < board[0].length; c++) {

			board[row][c] = true;
			nKnights(board, row, c + 1, asf + "{" + row + "-" + c + "}", kpsf + 1);
			board[row][c] = false;
		}

		for (int r = row + 1; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = true;
				nKnights(board, r, c + 1, asf + "{" + r + "-" + c + "}", kpsf + 1);
				board[r][c] = false;
			}
		}

	}

}
