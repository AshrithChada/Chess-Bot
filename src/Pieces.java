import java.util.ArrayList;
import java.util.Map;

import static java.nio.file.Files.move;

public class Pieces extends Moves{

    static void rook(int[][] board, Pair p,ArrayList<Pair> index,ArrayList<Pair> piece,ArrayList<Integer> val,int points){
        boolean a=true,b=true,c=true,d=true;
        boolean wh=false,bl=false;
        if(board[p.i][p.j]>0) wh=true;
        else bl=true;

        for(int k=1;k<8;k++){
            if(p.i-k>=0){
                if(a){
                    if((wh && board[p.i-k][p.j]<=0)||(bl && board[p.i-k][p.j]>=0)) {
                        piece.add(p);
                        index.add(new Pair(p.i-k,p.j));
                        val.add(points-board[p.i-k][p.j]);
                    }
                }
                if(board[p.i-k][p.j]!=0 ) a=false;
            }
            if(p.j-k>=0){
                if(b){
                    if((wh && board[p.i][p.j-k]<=0)||(bl && board[p.i][p.j-k]>=0)) {
                        piece.add(p);
                        index.add(new Pair(p.i, p.j-k));
                        val.add(points - board[p.i][p.j-k]);
                    }
                }
                if(board[p.i][p.j-k]!=0) b=false;
            }
            if(p.i+k<8){
                if(c){
                    if((wh && board[p.i+k][p.j]<=0)||(bl && board[p.i+k][p.j]>=0)){
                        piece.add(p);
                        index.add(new Pair(p.i+k,p.j));
                        val.add(points-board[p.i+k][p.j]);
                    }
                }
                if(board[p.i+k][p.j]!=0) c=false;
            }
            if(p.j+k<8){
                if(d){
                    if((wh && board[p.i][p.j+k]<=0)||(bl && board[p.i][p.j+k]>=0)){
                        piece.add(p);
                        index.add(new Pair(p.i, p.j+k));
                        val.add(points - board[p.i][p.j+k]);
                    }
                }
                if(board[p.i][p.j+k]!=0) d=false;
            }
        }
    }

    static void knight(int[][] board, Pair p,ArrayList<Pair> index,ArrayList<Pair> piece,ArrayList<Integer> val,int points){
        boolean wh=false,bl=false;
        if(board[p.i][p.j]==White.knight) wh=true;
        else bl=true;
        int[][] moves={{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        for(int k=0;k<8;k++){
            if(p.i+moves[k][0]>=0 && p.i+moves[k][0]<8 && p.j+moves[k][1]>=0 && p.j+moves[k][1]<8){
                if((wh && board[p.i+moves[k][0]][p.j+moves[k][1]]<=0)||(bl&&board[p.i+moves[k][0]][p.j+moves[k][1]]>=0)){
                    piece.add(p);
                    index.add(new Pair(p.i+moves[k][0],p.j+moves[k][1]));
                    val.add(points-board[p.i+moves[k][0]][p.j+moves[k][1]]);
                }
            }
        }
    }

    static void bishop(int[][] board, Pair p,ArrayList<Pair> index,ArrayList<Pair> piece,ArrayList<Integer> val,int points){
        boolean a=true,b=true,c=true,d=true;
        boolean wh=false,bl=false;
        if(board[p.i][p.j]>0 ) wh=true;
        else bl=true;
        for(int k=1;k<8;k++) {
            if (p.i - k >= 0 && p.j - k >= 0) {
                if (a)
                    if ((wh && board[p.i - k][p.j - k] <= 0) || (bl && board[p.i - k][p.j - k] >= 0)) {
                        piece.add(p);
                        index.add(new Pair((p.i - k), (p.j - k)));
                        val.add(points - board[(p.i - k)][(p.j - k)]);
                    }
                if (board[p.i - k][p.j - k] != 0) a = false;
            }

            if (p.i - k >= 0 && p.j + k < 8) {
                if (b)
                    if ((wh && board[p.i - k][p.j + k] <= 0) || (bl && board[p.i - k][p.j + k] >= 0)) {
                        piece.add(p);
                        index.add(new Pair((p.i - k),(p.j + k)));
                        val.add(points - board[(p.i - k)][(p.j + k)]);
                    }
                if (board[p.i - k][p.j + k] != 0) b = false;
            }

            if (p.i + k < 8 && p.j - k >= 0) {
                if (c)
                    if ((wh && board[p.i + k][p.j - k] <= 0) || (bl && board[p.i + k][p.j - k] >= 0)) {
                        piece.add(p);
                        index.add(new Pair((p.i + k), (p.j - k)));
                        val.add(points - board[(p.i + k)][(p.j - k)]);
                    }
                if (board[p.i + k][p.j - k] != 0) c = false;
            }

            if (p.i + k < 8 && p.j + k < 8) {
                if (d) {
                    if ((wh && board[p.i + k][p.j + k] <= 0) || (bl && board[p.i + k][p.j + k] >= 0)) {
                        piece.add(p);
                        index.add(new Pair((p.i + k), (p.j + k)));
                        val.add(points - board[(p.i + k)][(p.j + k)]);
                    }
                }
                if (board[p.i + k][p.j + k] != 0) d = false;
            }
        }
    }

    static void queen(int[][] board,Pair p,ArrayList<Pair> index,ArrayList<Pair> piece,ArrayList<Integer> val,int points){
        rook(board,p,index,piece,val,points);
        bishop(board,p,index,piece,val,points);
    }

    static void king(int[][] board,Pair p,ArrayList<Pair> index,ArrayList<Integer> val,int points){
        boolean wh=false,bl=false;
        if(board[p.i][p.j]==White.king) wh=true;
        else bl=true;
        int[][] moves={{1,0},{0,1},{1,1},{1,-1},{0,-1},{-1,0},{-1,-1},{-1,1}};
        for(int k=0;k<8;k++){
            if(p.i+moves[k][0]>=0 && p.i+moves[k][0]<8 && p.j+moves[k][1]>=0 && p.j+moves[k][1]<8){
                if((wh && board[p.i+moves[k][0]][p.j+moves[k][1]]<=0)||(bl && board[p.i+moves[k][0]][p.j+moves[k][1]]>=0)){
                    index.add(new Pair(p.i+moves[k][0],p.j+moves[k][1]));
                    val.add(points-board[p.i+moves[k][0]][p.j+moves[k][1]]);
                }
            }
        }
    }


    int pawn(int[][] board,Pair p){
        if(board[p.i][p.j]==White.pawn){
            if(p.i>0 && p.j>0){
                if(board[p.i-1][p.j-1]<0){
                    //algorithm
                }
            }

            if(p.i>1 && p.j<7){
                if(board[p.i-1][p.j+1]<0){
                    //algorithm
                }
            }

            if(p.j==6){
                //ALGORITHM
            }
        }

        if(board[p.i][p.j]==Black.pawn){
            if(p.i<7 && p.j<7){
                if(board[p.i+1][p.j+1]>0){
                    //algorithm
                }
            }
            if(p.i>0 && p.j<7){
                if(board[p.i-1][p.j+1]>0){
                    //algorithm
                }
            }

            if(p.j==2){
                //ALGORITHM
            }
        }
        return 0;
    }
}