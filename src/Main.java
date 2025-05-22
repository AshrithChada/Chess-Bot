public class Main extends Logic{

    public static void main(String args[]) {
        int[][] board=new int[8][8];
        board[1][2]=Black.queen;
        board[1][0]=Black.bishop;
        board[0][0]=Black.rook;
        board[2][1]=White.bishop;
        Pair maxIndex=new Pair(0,0);
        System.out.println(whiteMove(board,1,0,maxIndex,Integer.MIN_VALUE));

        /*
        for(int i=0;i<8;i++){
            board[1][i]=Black.pawn;
            board[6][i]=White.pawn;
        }
        R 0 0 0 0 0 0 0
        K 0 K 0 0 0 0 0
        0 B 0 0 0 0 0 0
        0 0 0 B 0 0 0 0
        0 0 0 0 R 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        board[0][0]=Black.rook;
        board[0][1]=Black.knight;
        board[0][2]=Black.bishop;
        board[0][3]=Black.queen;
        board[0][4]=Black.king;
        board[0][5]=Black.bishop;
        board[0][6]=Black.knight;
        board[0][7]=Black.rook;

        board[7][0]=White.rook;
        board[7][1]=White.knight;
        board[7][2]=White.bishop;
        board[7][3]=White.queen;
        board[7][4]=White.king;
        board[7][5]=White.bishop;
        board[7][6]=White.knight;
        board[7][7]=White.rook;
        0 0 0 0 0 0 0 0
        0 0 0 0 W 0 B 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        board[0][0]=Black.rook;
        board[0][1]=Black.knight;
        board[0][2]=Black.bishop;
        board[0][3]=Black.queen;
        board[0][4]=Black.king;
        board[0][5]=Black.bishop;
        board[0][6]=Black.knight;
        board[0][7]=Black.rook;

        board[7][0]=White.rook;
        board[7][1]=White.knight;
        board[7][2]=White.bishop;
        board[7][3]=White.queen;
        board[7][4]=White.king;
        board[7][5]=White.bishop;
        board[7][6]=White.knight;
        board[7][7]=White.rook; */
    }




}

class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class White{
    int material;
    White(int material){
        this.material=material;
    }
    static int king=1000;
    static int queen=90;
    static int rook=50;
    static int bishop=31;
    static int knight=29;
    static int pawn=10;
}

class Black{
    static int king=-1000;
    static int queen=-90;
    static int rook=-50;
    static int bishop=-31;
    static int knight=-29;
    static int pawn=-10;
}