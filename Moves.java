public class Moves{
    boolean whiteKingMoved=false;
    boolean blackKingMoved=false;

    static int move(int[][] board,Pair start,Pair end){
        int temp=board[end.i][end.j];
        board[end.i][end.j]=board[start.i][start.j];
        board[start.i][start.j]=0;
        return -temp;

    }

    boolean check(int[][] board,Pair king){
        return true;
    }



    boolean castling(int[][] board,Pair king,Pair rook){
        if((Math.abs(king.i-rook.i)==2 || Math.abs(king.i-rook.i)==3) && king.j!=rook.j) return false;

        if(board[king.i][king.j]==White.king && whiteKingMoved==false){
            if(king.i==4 && king.j==7 && rook.i==0 && rook.j==7){
                if(board[1][7]==0 && board[2][7]==0 && board[3][7]==0){
                    int temp=board[0][7];
                    board[0][7]=board[3][7];
                    board[3][7]=temp;
                    return true;
                }
            }
            if(king.i==4 && king.j==7 && rook.i==7 && rook.j==7){
                if(board[5][7]==0 && board[6][7]==0){
                    int temp=board[7][7];
                    board[7][7]=board[4][7];
                    board[4][7]=temp;
                    return true;
                }
            }
        }

        if(board[king.i][king.j]==Black.king && blackKingMoved==false){
            if(king.i==4 && king.j==0 && rook.i==0 && rook.j==0){
                if(board[0][1]==0 && board[0][2]==0 && board[0][3]==0){
                    int temp=board[0][0];
                    board[0][0]=board[4][0];
                    board[4][0]=temp;
                    return true;
                }
            }
            if(king.i==4 && king.j==7 && rook.i==7 && rook.j==7){
                if(board[5][7]==0 && board[6][7]==0){
                    int temp=board[7][7];
                    board[7][7]=board[4][7];
                    board[4][7]=temp;
                    return true;
                }
            }
        }
        return false;
    }

}