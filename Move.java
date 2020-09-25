import java.util.ArrayList;

public class Move {

    private ArrayList<int[]> directions = new ArrayList<>();
    private int x, y;

    public Move(int x, int y)
    {
        this.x = x;
        this.y = y;
        directions.clear();
    }

    void insertDir (int[] dir){
        directions.add(dir);
    }

    public ArrayList<int[]> getDirections() {
        return directions;
    }

    public int getSize()
    {
        int c = 0;
        for(int[] i : directions)
        {
            c += i[2];
        }
        return c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
