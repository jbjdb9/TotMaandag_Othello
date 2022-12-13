public class OthelloCalculator {

    // OthelloCalculator zorgt ervoor dat stenen worden omgedraaid als er een zet gedaan wordt
    // flipper vraagt via de klasse OthelloChecker of de zet kan en flipt de stenen vervolgens
    public static void flipper(int[]move, int color){
        if (OthelloChecker.north_checker(move, color)){
            north(move, color);
        }
        if (OthelloChecker.northeast_checker(move, color)){
            northeast(move, color);
        }
        if (OthelloChecker.east_checker(move, color)){
            east(move, color);
        }
        if (OthelloChecker.southeast_checker(move, color)){
            southeast(move, color);
        }
        if (OthelloChecker.south_checker(move, color)){
            south(move, color);
        }
        if (OthelloChecker.southwest_checker(move, color)){
            southwest(move, color);
        }
        if (OthelloChecker.west_checker(move, color)){
            west(move, color);
        }
        if (OthelloChecker.northwest_checker(move, color)){
            northwest(move, color);
        }
    }
    public static boolean calculator(int[]move, int color){
        return OthelloChecker.north_checker(move, color) || OthelloChecker.northeast_checker(move, color) || OthelloChecker.east_checker(move, color) || OthelloChecker.southeast_checker(move, color) || OthelloChecker.south_checker(move, color) || OthelloChecker.southwest_checker(move, color) || OthelloChecker.west_checker(move, color) || OthelloChecker.northwest_checker(move, color);
    }
    public static void north(int[]move, int color){
        //Flipt stenen in noordelijke richting
        int place = move[0];
        while(place != 0){
            if(color == OthelloBoard.board[place-1][move[1]]|| OthelloBoard.board[place-1][move[1]] == 0){
                break;
            }
            else{
                OthelloBoard.board[place-1][move[1]] = color;
                place--;
            }
        }
    }
    public static void northeast(int[]move, int color){
        //Flipt stenen in noordoostelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 0 && place_x != 7){
            if(color == OthelloBoard.board[place_y-1][place_x+1]|| OthelloBoard.board[place_y-1][place_x+1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y-1][place_x+1] = color;
                place_y--;
                place_x++;
            }
        }
    }
    public static void east(int[]move, int color){
        //Flipt stenen in oostelijke richting
        int place = move[1];
        while(place != 7){
            if(color == OthelloBoard.board[move[0]][place+1]|| OthelloBoard.board[move[0]][place+1] == 0){
                break;
            }
            else{
                OthelloBoard.board[move[0]][place+1] = color;
                place++;
            }
        }
    }
    public static void southeast(int[]move, int color){
        //Flipt stenen in zuidoostelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 7 && place_x != 7){
            if(color == OthelloBoard.board[place_y+1][place_x+1]|| OthelloBoard.board[place_y+1][place_x+1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y+1][place_x+1] = color;
                place_y++;
                place_x++;
            }
        }
    }
    public static void south(int[]move, int color){
        //Flipt stenen in zuidelijke richting
        int place = move[0];
        while(place != 7){
            if(color == OthelloBoard.board[place+1][move[1]]|| OthelloBoard.board[place+1][move[1]] == 0){
                break;
            }
            else{
                OthelloBoard.board[place+1][move[1]] = color;
                place++;
            }
        }
    }
    public static void southwest(int[]move, int color){
        //Flipt stenen in zuidwestelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 7 && place_x != 0){
            if(color == OthelloBoard.board[place_y+1][place_x-1]|| OthelloBoard.board[place_y+1][place_x-1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y+1][place_x-1] = color;
                place_y++;
                place_x--;
            }
        }
    }
    public static void west(int[]move, int color){
        //Flipt stenen in westelijke richting
        int place = move[1];
        while(place != 0){
            if(color == OthelloBoard.board[move[0]][place-1]|| OthelloBoard.board[move[0]][place-1] == 0){
                break;
            }
            else{
                OthelloBoard.board[move[0]][place-1] = color;
                place--;
            }
        }
    }
    public static void northwest(int[]move, int color){
        //Flipt stenen in noordwestelijke richting
        int place_x = move[1];
        int place_y = move[0];
        while(place_y != 0 && place_x != 0){
            if(color == OthelloBoard.board[place_y-1][place_x-1]|| OthelloBoard.board[place_y-1][place_x-1] == 0){
                break;
            }
            else{
                OthelloBoard.board[place_y-1][place_x-1] = color;
                place_y--;
                place_x--;
            }
        }
    }

}

