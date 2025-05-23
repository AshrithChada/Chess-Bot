# Chess-Bot
Building a Chess Bot that is capable of playing against a human user input with various difficulty levels

The idea is to calculate all the moves possible from a given situation and pick the best one from it,to do
it we use minimax algorithm and to optimise the search we use alpha beta pruning.

MINIMAX ALGORITHM:

let's assume a chess board is a 2D matrix of size 8*8, each box on a chessboard can be indexed using row
and column parameter of the 2D matrix.

Now since the level of importance for a piece varies, different pieces are assigned some points based on 
their value in a chess game, they can be found in White and Black classes in Main.java file.

By this way we can quantify the level of damage we can do in a move,for example our algorithm knows 
killing a queen is worth more than killing a rook and a knight since killing a queen can gain more points.

create a variable called points which tells us who has the upper hand in a game, the more positive the
variable 'points' is the more advantage white has (in terms of material).

Now we calculate 'points' for every move a white player can move in a single turn and all these possible 
scenarios with their respective 'points' are given to black player and all the possible black moves with 
their respective 'points' are given to white again , this process can be done until required number of 
times as assigned to the 'depth' variable.

Now we have a tree of possibilities with respective 'points' variable to it, where the first level denotes
white moves , the next level denotes the black moves and the next white and so on. If we are playing as a 
white player we pick the most 'points' possibility in the last level and the parent node is assigned the 
max points value, since all the parent nodes for a white move are black ,min points value and considered 
and given it to white.

So basically as a white player we try to increase the points and the opponent try to decrease the points and
the most 'points' case is considered the best move for white.
An ArrayList is used to store the points for each level in a tree, so each value of the ArrayList is given
as the input 'points' for the next level.

Now since this takes a lot of memory and time , alpha beta pruning is used to eliminate some of the cases
and still pick the best possibility.

ALPHA BETA PRUNING: