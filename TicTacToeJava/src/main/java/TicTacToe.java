import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[3][3];
        fillWithEmptyCharacters(matrix);
        printMatrix(matrix);

        char player = 'X';

        boolean winner = false;
        boolean gameOver = false;
        do {
            addValue(scanner, matrix, player);
            printMatrix(matrix);
            winner = isWinner(matrix, player);
            gameOver = didGameOver(matrix);

            if (winner) {
                System.out.println("Wineeeeeeeeeeer " + player);
            }

            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }

        } while (!winner && !gameOver);


            if(gameOver) {
                System.out.println("Game Oveeeeeeeeeer");
                System.out.println("No one winssssssss");
            }


    }

    private static boolean didGameOver(char[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] != 'X' && matrix[i][j] != 'O') {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isWinner(char[][] matrix, char player) {
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == player && matrix[i][1] == player && matrix[i][2] == player) {
                return true;
            }
        }

        for (int j=0; j<matrix[0].length; j++) {
            if (matrix[0][j] == player && matrix[1][j] == player && matrix[2][j] == player) {
                return true;
            }
        }

        if (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player) {
            return true;
        }

//        boolean v = true;
//        for (int d=0; d<matrix.length; d++) {
//            if (matrix[d][d] != player) {
//                v = false;
//            }
//        }
//        if (v) {
//            return true;
//        }

        if (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player) {
            return true;
        }

        return false;
    }

    public static void addValue(Scanner scanner,char[][] matrix, char player){
        int row;
        int column;
        boolean valid;
        do{
            int[] input = getInput(scanner, player);
             row = input[0];
             column = input[1];
             valid = isValidValue(matrix, row, column);

             if(!valid){
                 System.out.println();
                 printMatrix(matrix);
                 System.out.println();
                 System.out.println("Wrong place!");

             }

        }while(!valid);


            matrix[row][column] = player;

    }

    public static boolean isValidValue(char[][] matrix, int row, int column){
        return matrix[row][column] == ' ';
    }

    public static int [] getInput(Scanner scanner, char player){

        int row=0;
        int column=0;

        do {

            System.out.println("Enter a row (0, 1, or 2) for player " + player + ": ");
            row = scanner.nextInt();

            if (row<0 || row>2){
                System.out.println("Insert a number from 0 to 2");
            }

        }while(row<0 || row>2);

        do {

            System.out.println("Enter a column (0, 1, or 2) for player " + player + ": ");
            column = scanner.nextInt();

            if (column<0 || column>2){
                System.out.println("Insert a number from 0 to 2");
            }

        }while(column<0 || column>2);

//        System.out.println("Enter a row (0, 1, or 2) for player " + player + ": ");
//        int row = scanner.nextInt();
//
//        System.out.println("Enter a colum (0, 1, or 2) for player " + player + ": ");
//        int colum = scanner.nextInt();

        return new int[]{row, column};
    }

    public static void fillWithEmptyCharacters(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }

        }
    }

    public static void printMatrix(char[][] matrix){
        System.out.println("-------------");
        for(int i = 0; i < matrix.length; i++) {

            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " | ");

            }
            System.out.println();
            System.out.println("-------------");


        }

    }



}
