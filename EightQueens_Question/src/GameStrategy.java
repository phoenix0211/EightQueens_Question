public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		
		return cellId % 8;
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		return cellId / 8;
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		for(int i=0; i<8; i++) {
			if(placedQueens[row][i]) {
				return false;
			}
		}
		
		for(int i=0; i<8; i++) {
			if(placedQueens[i][col]) {
				return false;
			}
		}
		
		int i = row, j = col;
		while(i >= 0 && j >= 0) {
			if(placedQueens[i--][j--])
				return false;
		}
		i = row; j = col;
		while(i < 8 && j < 8) {
			if(placedQueens[i++][j++])
				return false;
		}
		
		i = row; j = col;
		while(i >= 0 && j < 8) {
			if(placedQueens[i--][j++])
				return false;
		}
		i = row; j = col;
		while(i < 8 && j >= 8) {
			if(placedQueens[i++][j--])
				return false;
		}
		
		placedQueens[row][col] = true;
		numQueens++;
		
		return isValid;
	}
}














