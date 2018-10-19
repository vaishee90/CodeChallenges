
public class BoggleBoard {
	static boolean wordExists(char[][] board, String word) {
		int k = 0;

		if (board.length == 0 || board[0].length == 0)
			return false;

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (k < word.length()) {
					if (board[i][j] == word.charAt(k)) {
						if(!isWordInNeighbor(i, j, k, board, visited, word)) {
							if(i == board.length - 1 && j == board[0].length - 1)
								return false;
						}	
						else
							return true;
					}
				}
			}
		}
		return false;
	}

	static boolean isWordInNeighbor(int row, int col, int idx, char[][] board, boolean[][] visited, String word) {
		for(int i=row-1;i<=row+1 && i<board.length;i++) {
			for(int j=col-1;j<=col+1 && j<board.length;j++) {
				if(i>=0 && j>=0 && !visited[i][j] && idx <= word.length()) {
					
					if(board[i][j] == word.charAt(idx)) {
						visited[row][col] = false;
						visited[i][j] = true;
						
						if(idx == word.length() - 1)
							return true;
						
						if(!isWordInNeighbor(i, j, idx+1, board, visited, word)) {
							if(i == row+1 && j == col+1)
								return false;
						}	
						else
							return true;
					}
					visited[i][j] = false;	
				}
				
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = {  { 'G', 'I', 'Z', 'A' }, 
							{ 'U', 'E', 'K', 'G' }, 
							{ 'Q', 'S', 'E', 'C' }, 
							{ 'U', 'E', 'N', 'Z' } };

		System.out.println(wordExists(board, "EEEEEEE") ? "yes" : "no");
	}
}
