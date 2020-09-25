public class Piece {

    private int color;
    public Coords position;

    public Piece(int x, int y)
    {
        position = new Coords(x, y);
        color = Color.Empty;
    }

    public Piece(int color, int x, int y) {
        this.color = color;
        position = new Coords(x, y);
    }

    public Piece(int color, Coords position)
    {
        this.color = color;
        this.position = position;
    }

    public void swap()
    {
    	if(color == Color.White) {
    		color = Color.Black;
    	}else {
    		color = Color.White;
    	}
  
    }

    public char getItem()
    {
    	if(color == Color.Empty) {
    		return '_';
    	}else if(color == Color.Black) {
    		return 'B';
    	}else if(color == Color.White) {
    		return 'W';
    	}
    	
        
        
        return 'E';
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public int getX()
    {
        return position.x;
    }

    public int getY()
    {
        return position.y;
    }
}
