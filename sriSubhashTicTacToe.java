import java.util.Scanner;
import java.util.Arrays;
public class sriSubhashTicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] board = new String[3][3];
        boolean finalresult = false;
        String opt = "";// for checking whether the user wants to continue the program
        int sign = 1;// for shifting the chances alternatively
        do {
            for (int i = 0; i < 3; ++i)// making the 2D array empty
            {
                for (int j = 0; j < 3; ++j) {
                    board[i][j] = "-";
                }
            }
            finalresult = false;
            System.out.println("\n Welcome to the game (Tic-Tac-Toe)..! ");
            sign = 1;
            System.out.println("\n Pls start playing = ");
            for (int i = 0; i < 6; ++i) {
                int x = 0, y = 0;
                if (sign == 1) {
                    System.out.println("\n");
                    display(board);
                    System.out.println("\n Now its X's turn: ");
                    System.out.println("\nPls input the actual x and y coordinates (0,1,2) where you want to place the X   (followed by a space in between) = ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if (x < 3 && y < 3 && x >= 0 && y >= 0)
                        update(x, y, board, "X");
                    else
                        System.out.println("\n Pls enter a valid value. Hence the program stopped working = ");
                    sign *= -1;
                    if (winner(board) == 0) {
                        System.out.println("\n X won this time.");
                        break;
                    } else if (winner(board) == -1 && i == 5) {
                        System.out.println("\n Its a draw this time . ");
                    }
                } else if (sign == -1) {
                    System.out.println("\n");
                    display(board);
                    System.out.println("\n Now its O's turn : ");
                    System.out.println("\nPls input the actual x and y coordinates (0,1,2) where you want to place the O (followed by a space in between) = ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if (x < 3 && y < 3 && x >= 0 && y >= 0)
                        update(x, y, board, "O");
                    else
                        System.out.println("\n Pls enter a valid value. Hence the program stopped working = ");
                    sign *= -1;
                    if (winner(board) == 1) {
                        System.out.println("\n O won this time. ");
                    } else if (winner(board) == -1 && i == 5) {
                        System.out.println("\n Its a draw this time. ");
                    }
                }
            }

            System.out.println("\n Do you want to start a new match (y/n) = ");
            opt = input.next();
        } while (opt.equals("y"));
    }

    public static void display(String[][] board1) {
        for (int i = 0; i < board1.length; ++i) {
            for (int j = 0; j < board1[i].length; ++j) {
                if (j > 0 && j < (board1[i].length)) {
                    System.out.print("|");
                }
                System.out.print(" " + board1[i][j] + " ");
                if (j == (board1.length - 1))
                    System.out.println("\n------------");
            }

        }
    }

    public static void update(int a, int b, String[][] board2, String ab) {
        if (board2[a][b] != "-")
            System.out.println("\n This value is already taken. Hence  the program stopped. Pls re-start the program.");
        else
            board2[a][b] = ab;
    }

    public static int winner(String[][] board3) {

        boolean result = false;
        int fresult = -1; // final result
        int counterxh = 0, counterxv = 0, a = 0;// counter variable for x ( with h-horizontal & v-vertical) & a- for checking a draw
        int counteroh = 0, counterov = 0;// counter variable for O( with h-horizontal & v-vertical)
        for (int i = 0; i < board3.length; ++i) {
            counterxh = 0;
            counterxv = 0;
            counteroh = 0;
            counterov = 0;
            for (int j = 0; j < board3[i].length; ++j) {
                if (board3[i][j].equals("X"))// to check the horizontal X values
                {
                    ++counterxh;
                } else if (board3[i][j].equals("O"))// to check the horizontal O values
                {
                    ++counteroh;
                }
                if (board3[j][i].equals("X"))// to check the vertical X values
                {
                    ++counterxv;
                } else if (board3[j][i].equals("O"))// to check the vertical O values
                {
                    ++counterov;
                }
                if (counterxv == 3 || counterxh == 3)// to decide the winner
                {
                    fresult = 0;
                    ++a;//System.out.println("\n X won this time. ");++a;
                    break;
                } else if (counterov == 3 || counteroh == 3) {
                    fresult = 1;
                    ++a;//System.out.println("\n O won this time. ");++a;
                    break;
                }


            }
        }

        int counterdlrx = 0, counterdrlx = 0;// counter variable for diagonal from top-left to bottom-right (x values) & from bottom-left to top-right.
        int counterdlro = 0, counterdrlo = 0;
        for (int i = 0; i < board3.length; ++i) {
            for (int j = 0; j < board3.length; ++j) {
                if (i == j && board3[i][j].equals("X"))// to check the diagonal values from top-left to bottom-right
                    ++counterdlrx;
                else if (i == j && board3[i][j].equals("O"))
                    ++counterdlro;
                if ((((i - j == 2) || (j - i == 2)) || (i == 1 && j == 1)) && board3[i][j].equals("X"))// to check the diagonal values from bottom-left to top-right
                    ++counterdrlx;
                else if ((((i - j == 2) || (j - i == 2)) || (i == 1 && j == 1)) && board3[i][j].equals("O"))
                    ++counterdrlo;
            }
        }
        if (counterdlrx == 3 || counterdrlx == 3) {
            fresult = 0;
            ++a;
        }
        //System.out.println("\n X won this time. ");++a;}
        else if (counterdlro == 3 || counterdrlo == 3) {
            fresult = 1;
            ++a;
            //System.out.println("\n O won this time. ");
            ++a;
        }
        if (a == 0)
            fresult = -1;
        return fresult;


    }
}
