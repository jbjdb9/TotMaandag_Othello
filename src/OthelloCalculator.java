public class OthelloCalculator {

    // OthelloCalculator zorgt ervoor dat stenen worden omgedraaid als er een zet gedaan wordt
    // flipper vraagt via de klasse OthelloChecker of de zet kan en flipt de stenen vervolgens
    public static void flipper(int[]move, int color, int[][] board){
        if (OthelloChecker.north_checker(move, color, board)){
            north(move, color, board);
        }
        if (OthelloChecker.northeast_checker(move, color, board)){
            northeast(move, color, board);
        }
        if (OthelloChecker.east_checker(move, color, board)){
            east(move, color, board);
        }
        if (OthelloChecker.southeast_checker(move, color, board)){
            southeast(move, color, board);
        }
        if (OthelloChecker.south_checker(move, color, board)){
            south(move, color, board);
        }
        if (OthelloChecker.southwest_checker(move, color, board)){
            southwest(move, color, board);
        }
        if (OthelloChecker.west_checker(move, color, board)){
            west(move, color, board);
        }
        if (OthelloChecker.northwest_checker(move, color, board)){
            northwest(move, color, board);
        }
    }
    public static boolean calculator(int[]move, int color, int[][] board){
        return OthelloChecker.north_checker(move, color, board) || OthelloChecker.northeast_checker(move, color, board) || OthelloChecker.east_checker(move, color, board) || OthelloChecker.southeast_checker(move, color, board) || OthelloChecker.south_checker(move, color, board) || OthelloChecker.southwest_checker(move, color, board) || OthelloChecker.west_checker(move, color, board) || OthelloChecker.northwest_checker(move, color, board);
    }
    public static void north(int[]move, int color, int[][] board){
        //Flipt stenen in noordelijke richting
        int place = move[0];
        while(place != 0){
            if(color == board[place-1][move[1]]|| board[place-1][move[1]] == 0){
                break;
            }
            else{
                board[place-1][move[1]] = color;
                place--;
            }
        }
    }
    public static void northeast(int[]move, int color, int[][] board){
        //Flipt stenen in noordoostelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 0 && place_x != 7){
            if(color == board[place_y-1][place_x+1]|| board[place_y-1][place_x+1] == 0){
                break;
            }
            else{
                board[place_y-1][place_x+1] = color;
                place_y--;
                place_x++;
            }
        }
    }
    public static void east(int[]move, int color, int[][] board){
        //Flipt stenen in oostelijke richting
        int place = move[1];
        while(place != 7){
            if(color == board[move[0]][place+1]|| board[move[0]][place+1] == 0){
                break;
            }
            else{
                board[move[0]][place+1] = color;
                place++;
            }
        }
    }
    public static void southeast(int[]move, int color, int[][] board){
        //Flipt stenen in zuidoostelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 7 && place_x != 7){
            if(color == board[place_y+1][place_x+1]|| board[place_y+1][place_x+1] == 0){
                break;
            }
            else{
                board[place_y+1][place_x+1] = color;
                place_y++;
                place_x++;
            }
        }
    }
    public static void south(int[]move, int color, int[][] board){
        //Flipt stenen in zuidelijke richting
        int place = move[0];
        while(place != 7){
            if(color == board[place+1][move[1]]|| board[place+1][move[1]] == 0){
                break;
            }
            else{
                board[place+1][move[1]] = color;
                place++;
            }
        }
    }
    public static void southwest(int[]move, int color, int[][] board){
        //Flipt stenen in zuidwestelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 7 && place_x != 0){
            if(color == board[place_y+1][place_x-1]|| board[place_y+1][place_x-1] == 0){
                break;
            }
            else{
                board[place_y+1][place_x-1] = color;
                place_y++;
                place_x--;
            }
        }
    }
    public static void west(int[]move, int color, int[][] board){
        //Flipt stenen in westelijke richting
        int place = move[1];
        while(place != 0){
            if(color == board[move[0]][place-1]|| board[move[0]][place-1] == 0){
                break;
            }
            else{
                board[move[0]][place-1] = color;
                place--;
            }
        }
    }
    public static void northwest(int[]move, int color, int[][] board){
        //Flipt stenen in noordwestelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 0 && place_x != 0){
            if(color == board[place_y-1][place_x-1]|| board[place_y-1][place_x-1] == 0){
                break;
            }
            else{
                board[place_y-1][place_x-1] = color;
                place_y--;
                place_x--;
            }
        }
    }

}

