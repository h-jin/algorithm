package algorithm;

public class sudoSolver {
	
	 public void solveSudoku(char[][] board) {
	        if(board == null || board.length==0) return;
	        solve(board);
	    }
	    
	    public boolean solve(char [][]board){
	        int len = board.length;
	        for(int i = 0; i<len; i++){
	            for(int j = 0; j<len; j++){
	                if(board[i][j]=='.'){
	                    for(char ch = '1'; ch<='9'; ch++ ){
	                        if(valid(board, i, j, ch)){
	                            board[i][j]=ch;
	                            if(solve(board)) return true;
	                            else board[i][j] = '.';
	                        }
	                    }
	                    return false;
	                    
	                }
	                
	            }
	        }
	        return true;
	    }
	    
	    public boolean valid(char [][] board, int row, int col, char ch){
	        
	        for(int m = 0; m<9; m++){
	            if(board[m][col] != '.' && board[m][col] == ch) return false; 
	            if(board[row][m] != '.' && board[row][m] == ch) return false; 
	            if(board[3 * (row/ 3) + m / 3][ 3 * (col / 3) + m % 3] != '.' && 
	            board[3 * (row / 3) + m / 3][3 * (col / 3) + m % 3] == ch) return false; //check 3*3 grid
	        }
	        return true;
	        
	    }

}
