import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Board mainBoard;

    public static int current_color = Color.Black;

    public static void main(String[] args) throws java.lang.InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int length;
        System.out.println("Choose the grid level: (1 or 2) ");
        System.out.println("1. 4x4");
        System.out.println("2. 8x8\n>>> ");
        choice =  scanner.nextInt();
        
        System.out.println("Choose your opponent: (1 - 4)");
        System.out.println("1. Random");
        System.out.println("2. Minimax");
        System.out.println("3. AB Minimax");
        System.out.println("4. H Minimax\n>>> ");

		int choice2 = scanner.nextInt();
        if(choice == 1) {
        	length = 4;
        }else {
        	length = 8;
        }
        if(choice2 == 1) {
        	rand(length);
        }else if(choice2 == 2) {
        	Mini(length);
        }else if(choice2 == 3) {
        	abMini(length);
        	
        }else if(choice2 == 4) {
        	hMini(length);
        }
     

    
    }

    public static void abMini(int length)
    {
        Scanner scanner = new Scanner(System.in);
        Player HumanPlayer, AIPlayer;
        
        boolean prune = true;

        System.out.print("Choose your colour: \nBlack plays first\nPress 'F' to play first\nOr press any other button to play second\n>>> ");
        String ans = scanner.nextLine();

        int depth = GetDepth();

        mainBoard = new Board(length);
        mainBoard.printUI();

        if (ans.equals("F") || ans.equals("f"))
        {
            HumanPlayer = new Player(depth,Color.Black);
            AIPlayer = new Player(depth,Color.White);
        }
        else
        {
            HumanPlayer = new Player(depth,Color.White);
            AIPlayer = new Player(depth,Color.Black);
        }

        int r = (length*length)-1;

        while(!mainBoard.isFinal() )
        {
            if (HumanPlayer.isMyTurn(current_color))
            {
                System.out.println("It's player's turn: ");
                r--;
                ArrayList<Move> myMoves = mainBoard.avaliableMoves(current_color);

                if (myMoves.isEmpty()) System.out.println("No available move for you");
                else
                {
                    System.out.print("Select a move: ");
                    for (int i = 0; i < myMoves.size(); i++)
                    {
                        System.out.print("Option " + (i + 1) + " : (" + (myMoves.get(i).getX() + 1) + ", " + intToLetter((myMoves.get(i).getY() + 1)) + ") ");
                    }
                    System.out.print("\n>>> ");
                    mainBoard.makeMove(mainBoard, myMoves.get(scanner.nextInt() - 1), current_color);
                }
            }
            else
            {
                mainBoard = AIPlayer.MiniMax(mainBoard, prune);
                r--;
            }
            mainBoard.printUI();
            System.out.println("Current score is: " + mainBoard.getScore());
            current_color = 3-current_color;
            
            if(r <= 0) {
            
            	break;
            }
            
        }
    }


    public static void Mini(int length)
    {
        Scanner scanner = new Scanner(System.in);
        Player HumanPlayer, AIPlayer;
        
        boolean prune = false;

        System.out.print("Choose your colour: \nBlack plays first\nPress 'F' to play first\nOr press any other button to play second\n>>> ");
        String ans = scanner.nextLine();

        int depth = (Integer.MAX_VALUE);

        mainBoard = new Board(length);
        mainBoard.printUI();

        if (ans.equals("F") || ans.equals("f"))
        {
            HumanPlayer = new Player(depth,Color.Black);
            AIPlayer = new Player(depth,Color.White);
        }
        else
        {
            HumanPlayer = new Player(depth,Color.White);
            AIPlayer = new Player(depth,Color.Black);
        }
        int r = (length*length)-1;

        while(!mainBoard.isFinal() )
        {
            if (HumanPlayer.isMyTurn(current_color))
            {
                System.out.println("It's player's turn: ");
                r--;
                ArrayList<Move> myMoves = mainBoard.avaliableMoves(current_color);

                if (myMoves.isEmpty()) System.out.println("No available move for you");
                else
                {
                    System.out.print("Select a move: ");
                    for (int i = 0; i < myMoves.size(); i++)
                    {
                        System.out.print("Option " + (i + 1) + " : (" + (myMoves.get(i).getX() + 1) + ", " + intToLetter((myMoves.get(i).getY() + 1)) + ") ");
                    }
                    System.out.print("\n>>> ");
                    mainBoard.makeMove(mainBoard, myMoves.get(scanner.nextInt() - 1), current_color);
                }
            }
            else
            {
                mainBoard = AIPlayer.MiniMax(mainBoard, prune);
                r--;
            }
            mainBoard.printUI();
            System.out.println("Current score is: " + mainBoard.getScore());
            current_color = 3-current_color;
            
            if(r <= 0) {
            
            	break;
            }
            
        }
    }


    public static void hMini(int length)
    {
        Scanner scanner = new Scanner(System.in);
        Player HumanPlayer, AIPlayer;
        
        boolean prune = false;

        System.out.print("Choose your colour: \nBlack plays first\nPress 'F' to play first\nOr press any other button to play second\n>>> ");
        String ans = scanner.nextLine();

        int depth = GetDepth();

        mainBoard = new Board(length);
        mainBoard.printUI();

        if (ans.equals("F") || ans.equals("f"))
        {
            HumanPlayer = new Player(depth,Color.Black);
            AIPlayer = new Player(depth,Color.White);
        }
        else
        {
            HumanPlayer = new Player(depth,Color.White);
            AIPlayer = new Player(depth,Color.Black);
        }
        int r = (length*length)-1;

        while(!mainBoard.isFinal() )
        {
            if (HumanPlayer.isMyTurn(current_color))
            {
                System.out.println("It's player's turn: ");
                r--;
                ArrayList<Move> myMoves = mainBoard.avaliableMoves(current_color);

                if (myMoves.isEmpty()) System.out.println("No available move for you");
                else
                {
                    System.out.print("Select a move: ");
                    for (int i = 0; i < myMoves.size(); i++)
                    {
                        System.out.print("Option " + (i + 1) + " : (" + (myMoves.get(i).getX() + 1) + ", " + intToLetter((myMoves.get(i).getY() + 1)) + ") ");
                    }
                    System.out.print("\n>>> ");
                    mainBoard.makeMove(mainBoard, myMoves.get(scanner.nextInt() - 1), current_color);
                }
            }
            else
            {
                mainBoard = AIPlayer.MiniMax(mainBoard, prune);
                r--;
            }
            mainBoard.printUI();
            System.out.println("Current score is: " + mainBoard.getScore());
            current_color = 3-current_color;
            
            if(r <= 0) {
            
            	break;
            }
            
        }
    }

    public static void rand(int length)
    {
        Scanner scanner = new Scanner(System.in);
        Player HumanPlayer, AIPlayer;
        
        boolean prune = false;

        System.out.print("Choose your colour: \nBlack plays first\nPress 'F' to play first\nOr press any other button to play second\n>>> ");
        String ans = scanner.nextLine();
        //depth is one so first thing that shows up is what the machine plays
        int depth = 1;

        mainBoard = new Board(length);
        mainBoard.printUI();

        if (ans.equals("F") || ans.equals("f"))
        {
            HumanPlayer = new Player(depth,Color.Black);
            AIPlayer = new Player(depth,Color.White);
        }
        else
        {
            HumanPlayer = new Player(depth,Color.White);
            AIPlayer = new Player(depth,Color.Black);
        }
        int r = (length*length)-1;

        while(!mainBoard.isFinal() )
        {
            if (HumanPlayer.isMyTurn(current_color))
            {
                System.out.println("It's player's turn: ");
                r--;
                ArrayList<Move> myMoves = mainBoard.avaliableMoves(current_color);

                if (myMoves.isEmpty()) System.out.println("No available move for you");
                else
                {
                    System.out.print("Select a move: ");
                    for (int i = 0; i < myMoves.size(); i++)
                    {
                        System.out.print("Option " + (i + 1) + " : (" + (myMoves.get(i).getX() + 1) + ", " + intToLetter((myMoves.get(i).getY() + 1)) + ") ");
                    }
                    System.out.print("\n>>> ");
                    mainBoard.makeMove(mainBoard, myMoves.get(scanner.nextInt() - 1), current_color);
                }
            }
            else
            {
                mainBoard = AIPlayer.MiniMax(mainBoard, prune);
                r--;
            }
            mainBoard.printUI();
            System.out.println("Current score is: " + mainBoard.getScore());
            current_color = 3-current_color;
            
            if(r <= 0) {
            
            	break;
            }
            
        }
         
    }

    

    public static int GetDepth()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter depth\n>>> ");
        return scanner.nextInt();
    }

    public static char intToLetter(int x) {
        char[] array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G','H' };
        return array[x-1];
    }
}