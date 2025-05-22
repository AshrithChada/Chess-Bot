import java.util.*;

public class Logic extends Pieces {
    static int whiteMove(int[][] board,int depth,int points,Pair maxIndex,int max){
        ArrayList<Integer> val=new ArrayList<>();
        ArrayList<Pair> index=new ArrayList<>();
        ArrayList<Pair> piece=new ArrayList<>();
        Pair rookPos=new Pair(-1,-1);
        Pair knightPos=new Pair(-1,-1);
        Pair bishopPos=new Pair(-1,-1);
        Pair queenPos=new Pair(-1,-1);

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]==White.rook){
                    rookPos.i=i;
                    rookPos.j=j;
                    rook(board,rookPos,index,piece,val,points);
                }
                else if(board[i][j]==White.knight){
                    knightPos.i=i;
                    knightPos.j=j;
                    knight(board,knightPos,index,piece,val,points);
                }
                else if(board[i][j]==White.bishop){
                    bishopPos.i=i;
                    bishopPos.j=j;
                    bishop(board,bishopPos,index,piece,val,points);
                }
                else if(board[i][j]==White.queen){
                    queenPos.i=i;
                    queenPos.j=j;
                    queen(board,queenPos,index,piece,val,points);
                }
            }
        }

        for(int i=0;i<piece.size();i++){
            System.out.println(piece.get(i).i+","+piece.get(i).j+"  "+index.get(i).i+","+index.get(i).j+"  "+val.get(i));
        }

        for(int k=0;k<val.size();k++){
            int t=val.get(k);
            if(depth!=3){
                int[][] tempboard=new int[8][8];
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        tempboard[i][j]=board[i][j];
                    }
                }
                System.out.println(move(tempboard,new Pair(piece.get(k).i,piece.get(k).j),new Pair(index.get(k).i,index.get(k).j)));
                for(int i=0;i<3;i++) {
                    for (int j=0;j<3;j++) {
                        System.out.print(tempboard[i][j]+" ");
                    }
                    System.out.println();
                }
                val.set(k,blackMove(tempboard,depth+1,t,maxIndex,max));
            }
        }
        max=val.get(0);
        if(depth==1){
            for(int k=0;k<val.size();k++) {
                if(val.get(k)>max){
                    max=val.get(k);
                    maxIndex=index.get(k);
                }
                System.out.println(index.get(k).i + "," + index.get(k).j + "  " + val.get(k));
            }
            System.out.println(val.size());
        }
        System.out.println(maxIndex.i+" "+maxIndex.j);
        return max;
    }

    static int blackMove(int[][] board,int depth,int points,Pair maxIndex,int min){
        ArrayList<Pair> piece=new ArrayList<>();
        ArrayList<Integer> val=new ArrayList<>();
        ArrayList<Pair> index=new ArrayList<>();
        Pair rookPos=new Pair(0,0);
        Pair knightPos=new Pair(-1,-1);
        Pair bishopPos=new Pair(-1,-1);
        Pair queenPos=new Pair(-1,-1);

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]==Black.rook){
                    rookPos.i=i;
                    rookPos.j=j;
                    rook(board,rookPos,index,piece,val,points);
                }
                else if(board[i][j]==Black.knight){
                    knightPos.i=i;
                    knightPos.j=j;
                    knight(board,knightPos,index,piece,val,points);
                }
                else if(board[i][j]==Black.bishop){
                    bishopPos.i=i;
                    bishopPos.j=j;
                    bishop(board,bishopPos,index,piece,val,points);
                }
                else if(board[i][j]==Black.queen){
                    queenPos.i=i;
                    queenPos.j=j;
                    queen(board,queenPos,index,piece,val,points);
                }
            }
        }
        for(int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                //System.out.print(board[i][j]+" ");
            }
            //System.out.println();
        }


        min=val.get(0);
        for(int k=0;k<val.size();k++){
            int t=val.get(k);
            // int[][] tempboard=board;

            // move(tempboard,new Pair(piece.get(k).i,piece.get(k).j),new Pair(index.get(k).i,index.get(k).j));
            // val.set(k,whiteMove(tempboard,depth+1,t,maxIndex,min));
            if(val.get(k)<min){
                min = val.get(k);
                maxIndex=index.get(k);
            }
        }
        return min;
    }
}