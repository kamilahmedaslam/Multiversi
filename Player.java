import java.util.ArrayList;

public class Player
{
    private int maxDepth;
    int player_color;

    public Player(int maxDepth, int player_color)
    {
        this.maxDepth = maxDepth;
        this.player_color = player_color;
    }

    public Board MiniMax(Board board, boolean prune)
    {
        if (player_color == Color.Black)
        {
            return max(new Board(board), Integer.MIN_VALUE, Integer.MAX_VALUE, 0, prune);
        }
        else
        {
            return min(new Board(board), Integer.MIN_VALUE, Integer.MAX_VALUE, 0, prune);
        }
    }

    public Board max(Board board, int a, int b, int depth, boolean prune)
    {
        if((board.isFinal()) || (depth == maxDepth))
        {
            return board;
        }
        ArrayList<Board> children = board.getChildren(Color.Black);
        if (children.isEmpty()) return board;
        Board maxBoard = children.get(0);
        for (Board child : children)
        {
            Board oppBoard = min(child, a, b, depth + 1, prune);
            if(oppBoard.value > maxBoard.value)
            {
                maxBoard = child;
            }
            else if(oppBoard.value == maxBoard.value)
            {
                maxBoard = child;
            }
            if(prune) {
            //AB Pruning
            	a = Integer.max(a, oppBoard.value);
            	if(b <= a)
            	{
            		break;
            	}
            }
        }
        return maxBoard;
    }

    public Board min(Board board, int a, int b, int depth, boolean prune)
    {
        if((board.isFinal()) || (depth == maxDepth))
        {
            return board;
        }
        ArrayList<Board> children = board.getChildren(Color.White);
        if (children.isEmpty()) return board;

        Board minBoard = children.get(0);
        for (Board child : children)
        {
            Board oppBoard = max(child, a, b, depth + 1, prune);
            if(oppBoard.value < minBoard.value)
            {
                minBoard = child;
            }
            else if(oppBoard.value == minBoard.value )
            {
                minBoard = child;
            }
            if(prune) {
            	//AB Pruning
            	b = Integer.min(b, oppBoard.value);
            	if(b <= a)
            	{
            		break;
            	}
            }
        }
        return minBoard;
    }

    public boolean isMyTurn(int c)
    {
        return player_color==c;
    }
}
