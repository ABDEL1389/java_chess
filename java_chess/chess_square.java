public class chess_square{
    private Character column;
    private int row;
    private Boolean is_occupied;
    private chess_piece occupied_with;

    public chess_square(Character columm, int roww){
        this.row = roww;
        this.column = columm;
        this.is_occupied = false;
        this.occupied_with = null;
    }

    public void occupy(){
        is_occupied = true;
    }

    public void occupy_with(chess_piece piece){
        occupied_with = piece;
        is_occupied = true;
    }

    public void unoccupy(){
        is_occupied = false;
        occupied_with = null;
    }

    public boolean is_occupied(){
        return is_occupied;
    }

    public boolean is_occupied_with_white(){
        if (is_occupied && !(occupied_with == null)){
            return (occupied_with.is_white());
        } else {
            return false;
        }
    }

    public boolean is_occupied_with_black(){
        if (is_occupied && !(occupied_with == null)){
            return (!occupied_with.is_white());
        } else {
            return false;
        }
    }

    public chess_piece occupied_with(){
        return occupied_with;
    }

    public int row(){
        return row;
    }

    public int column(){
        return ((int) column) - 96;
    }

    public String to_string(){
        return(Character.toString(column) + Integer.toString((row)));
    }

    public chess_square up(int n){
        for (chess_square i: chess_board.board.board_squares()){
            if ((i.row() == row + n) && (i.column() == (int) column - 96)){
                return i;
            } 
        } return chess_board.out_of_range;
    }

    public chess_square right(int n){
        for (chess_square i: chess_board.board.board_squares()){
            if ((i.row() == row) && (i.column() == (int) column - 96 + n)){
                return i;
            } 
        } return chess_board.out_of_range;
    }

    public int[] distance(chess_square destination){
        //returns (distance up, distance right)
        int upwards_distance = 0;
        int horizontal_distance = 2;
        for (int i=-7; i<=7; i++){
            if (i+row == destination.row()){
                upwards_distance = i;
            }
        }
        for (int i=-7; i<=7; i++){
            if ((i+column()) == destination.column()){
                horizontal_distance = i;
            }
        }
        int[] result = {upwards_distance, horizontal_distance};
        return result;
    }
}