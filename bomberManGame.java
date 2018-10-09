import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class bomberManGame {
	
	static String[] detonate(int r, int c, String[] newgrid) {
		
		String[] detonatedgrid = new String[r];
		char[][] arr = new char[r][c];
		HashSet<String> bombset = new HashSet<String>();
		HashSet<String> spaceset = new HashSet<String>();
		
		for (int i = 0; i < r; i++) {
			arr[i] = newgrid[i].toCharArray();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'O') {
					bombset.add("" + i + j);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (bombset.contains("" + i + j)) {
					if (i == 0 && j - 1 >= 0) {
						arr[i][j - 1] = '.';
						spaceset.add(i + "" + (j - 1));
					}
					if (j == 0 && i - 1 >= 0) {
						arr[i - 1][j] = '.';
						spaceset.add((i - 1) + "" + j);
					}
					if (i == r - 1 && j + 1 < c) {
						arr[i][j + 1] = '.';
						spaceset.add(i + "" + (j + 1));
					}
					if (i + 1 < r && j == c - 1) {
						arr[i + 1][j] = '.';
						spaceset.add((i + 1) + "" + j);
					}
					if (i + 1 < r && j + 1 < c) {
						arr[i + 1][j] = '.';
						arr[i][j + 1] = '.';

						spaceset.add((i + 1) + "" + j);
						spaceset.add(i + "" + (j + 1));
					}
					if (i - 1 >= 0 && j - 1 >= 0) {
						arr[i - 1][j] = '.';
						arr[i][j - 1] = '.';

						spaceset.add((i - 1) + "" + j);
						spaceset.add(i + "" + (j - 1));
					}
					arr[i][j] = '.';
					spaceset.add("" + i + j);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!spaceset.contains("" + i + j)) {
					arr[i][j] = 'O';
				}
			}
		}

		for (int i = 0; i < r; i++) {
			detonatedgrid[i] = String.valueOf(arr[i]);
		}
		
		return detonatedgrid;
	}
	
	static String[] bomberMan(int n, String[] grid) {
		int r = grid.length;
		int c = grid[0].split("").length;
		String[] bombgrid = new String[r];

		// when bomberman fills the entire grid with bombs
		if (n % 2 == 0) {
			for (int i = 0; i < r; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < c; j++) {
					sb.append("O");
				}
				bombgrid[i] = sb.toString();
			}
			return bombgrid;
		}

		// when grid returns its original state
		if (n == 1)
			return grid;
		
		if (n % 4 == 1) {
			return detonate(r, c, detonate(r, c, grid));
		}
		else {
			return detonate(r, c, grid);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/vaishee/Desktop/test.txt"));

		String[] rcn = scanner.nextLine().split(" ");

		int r = Integer.parseInt(rcn[0]);

		int c = Integer.parseInt(rcn[1]);

		int n = Integer.parseInt(rcn[2]);

		String[] grid = new String[r];

		for (int i = 0; i < r; i++) {
			String gridItem = scanner.nextLine();
			grid[i] = gridItem;
		}

		String[] result = bomberMan(n, grid);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(result[i]);

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
