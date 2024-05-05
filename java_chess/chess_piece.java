import java.util.ArrayList;

public abstract class chess_piece{
    chess_square square;
    Boolean active;
    Boolean white;
    String type;

    public chess_piece(chess_square square, boolean is_white){
        this.square = square;
        this.active = true;
        this.white = is_white;
    }

    public void taken(){
        square.unoccupy();
        active = false;
        square = null;
    }

    public void set_square(chess_square new_square){
        active = true;
        square = new_square;
        new_square.occupy_with(this);
    }

    public void set_inactive(){
        active = false;
    }

    public chess_square find(){
        return square;   
    }

    public boolean is_white(){
        return white;
    }

    public boolean is_active(){
        return active;
    }

    public String type(){
        if (white){
            return ("white " + type);
        } else {
            return ("black " + type);
        }
    }

    public abstract ArrayList<chess_square> kill_sight();

    public ArrayList<String> kill_sight2(){
        ArrayList<String> kill_sight = new ArrayList<String>();
        for (chess_square i: kill_sight()){
            kill_sight.add(i.to_string());
        }
        return kill_sight;
    }

    public ArrayList<chess_square> valid_moves(){
        ArrayList<chess_square> moves = new ArrayList<chess_square>();
        final chess_square origin_square = square;
        for (chess_square position: kill_sight()){
            if (white && !position.is_occupied()){
                move(position);
                if (!chess_board.check_for_black()){
                    moves.add(position);
                }
            } else if (white && position.is_occupied_with_black()){
                if (take_is_valid(position)){
                    moves.add(position);
                }
            } else if (!white && !position.is_occupied_with_black()){
                move(position);
                if (!chess_board.check_for_white()){
                    moves.add(position);
                }
            } else if (!white && position.is_occupied_with_white()){
                if (take_is_valid(position)){
                    moves.add(position);
                }
            }
        }
        if (square != origin_square){
            move(origin_square);
        }
        return moves;
    }

    public ArrayList<String> valid_moves2(){
        ArrayList<String> travel_sight = new ArrayList<String>();
        for (chess_square i: valid_moves()){
        travel_sight.add(i.to_string());
        }
        return travel_sight;
    }

    public void move(int up, int right){
        square.up(up).right(right).occupy_with(square.occupied_with());
        square.unoccupy();
        square = square.up(up).right(right);
    }

    public void move(chess_square destination){
        int[] distance = square.distance(destination);
        
        move(distance[0], distance[1]);
    }    

    public void take(int up,int right){
        square.up(up).right(right).occupied_with().taken();
        square.up(up).right(right).occupy_with(square.occupied_with());
        square.unoccupy();
        square = square.up(up).right(right);
    }

    public void take(chess_square destination){
        int[] distance = square.distance(destination);
        take(distance[0], distance[1]);
    }

    public boolean take_is_valid(chess_square destination){
        boolean is_valid = false;
        if (white && destination.is_occupied_with_black()){
            final chess_square current_square = square;
            final chess_piece taken_piece = destination.occupied_with();
            take(destination);
            if (!chess_board.check_for_black()){
                is_valid = true;
            }
            move(current_square);
            taken_piece.set_square(destination);
            destination.occupy_with(taken_piece);
        } else if (!white && destination.is_occupied_with_white()){
            final chess_square current_square = square;
            final chess_piece taken_piece = destination.occupied_with();
            take(destination);
            if (!chess_board.check_for_white()){
                is_valid = true;
            }
            move(current_square);
            taken_piece.set_square(destination);
            destination.occupy_with(taken_piece);
        }
        return is_valid;
    }
}