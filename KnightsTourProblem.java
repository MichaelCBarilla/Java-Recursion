
public class KnightsTourProblem {
	static int firstRow = 4;		static int firstCol = 0;				//Starting point
	
	static int [][] rowColIncrement = new int[8][2];				//Move set
	
	static int nRows = 5;			static int nCols = 5;				//Number of columns and rows
																								//on the board
	
	static int [][] board = new int[nRows][nCols];					//Representation of the board
	
	
	
	public static void main(String[] args) {
		
		boolean success;
		
		//Column										//Row
		rowColIncrement[0][0] = 2;		rowColIncrement[0][1] = -1;
		rowColIncrement[1][0] = 1;		rowColIncrement[1][1] = -2;
		rowColIncrement[2][0] = -1;		rowColIncrement[2][1] = -2;
		rowColIncrement[3][0] = -2;		rowColIncrement[3][1] = -1;
		rowColIncrement[4][0] = -2;		rowColIncrement[4][1] = 1;
		rowColIncrement[5][0] = -1;		rowColIncrement[5][1] = 2;
		rowColIncrement[6][0] = 1;		rowColIncrement[6][1] = 2;
		rowColIncrement[7][0] = 2;		rowColIncrement[7][1] = 1;
		
		board[firstRow][firstCol] = 1;
		success = makeNextDecision(1, firstRow, firstCol);
		if (success == true) {
			for (int i = 0; i < nRows; i++) {
				System.out.println();
				for (int j = 0; j < nCols; j++) {
					System.out.print(board[i][j] + "\t");
				}
			}
		}
	}
	
	public static boolean makeNextDecision(int lastMoveNumber,
																		   int fromRow, int fromCol) {
		int thisMoveNumber = lastMoveNumber + 1;
		int numberOfChoices = 8;
		int choiceNumber = 0;
		boolean atGoal = false;
		
		while (atGoal == false && choiceNumber < numberOfChoices) {
			int row = nextChoiceRow(choiceNumber, fromRow);
			int col = nextChoiceColumn(choiceNumber, fromCol);
			if (thisDecisionChoiceIsValid(row, col)) {
				recordThisDecisionChoice(row, col, thisMoveNumber);
				if (goalHasBeenReached(thisMoveNumber))
					atGoal = true;
				else {
					atGoal = makeNextDecision(thisMoveNumber, row, col);
					if (atGoal == false) 		//Has to backtrack
						unrecordThisDecisionChoice(row, col);					
				}
			}
			choiceNumber++;
		}
		return atGoal;
	}
	
	public static boolean thisDecisionChoiceIsValid(int row, int column) {
		if (row >= 0 && row < nRows &&
			column >= 0 && column < nCols &&
			board[row][column] == 0)
			return true;
		else
			return false;
	}
	
	public static int nextChoiceRow(int choiceNumber, int fromRow) {
		int nextRow;
		nextRow = fromRow + rowColIncrement[choiceNumber][1];
		return nextRow;
	}
	
	public static int nextChoiceColumn(int choiceNumber, int fromColumn) {
		int nextColumn;
		nextColumn = fromColumn + rowColIncrement[choiceNumber][0];
		return nextColumn;
	}
	
	public static void recordThisDecisionChoice(int row, int column, int thisMoveNumber) {
		board[row][column] = thisMoveNumber;
	}
	
	public static void unrecordThisDecisionChoice(int row, int column) {
		board[row][column] = 0;
	}
	
	public static boolean goalHasBeenReached(int thisMoveNumber) {
		if (thisMoveNumber == nRows * nCols)
			return true;
		else
			return false;
	}
	
}