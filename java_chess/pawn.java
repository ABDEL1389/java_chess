import java.util.ArrayList;

public class pawn extends chess_piece{
    public pawn(chess_square square, boolean is_white){
        super(square,is_white);
        this.type = "pawn";
    }
    public void single_push(){
        if (white && square.row() <= 7 && !square.up(1).is_occupied()){
            move(1,0);
            System.out.println(square.to_string());
        } else if (!white  && square.row() >= 2 && !square.up(-1).is_occupied()){
            move(-1,0);
            System.out.println(square.to_string());
        } else {
            System.out.println("invalid move");
        }
    }

    public void double_push(){
        if (white && square.row() == 2 && !square.up(1).is_occupied() && !square.up(2).is_occupied()){
            move(2, 0);
            System.out.println(square.to_string());
        } else if (!white  && square.row() == 7 && !square.up(-1).is_occupied() && !square.up(-2).is_occupied()){
            move(-2,0);
            System.out.println(square.to_string());
        } else {
            System.out.println("invalid move");
        }
    }

    public void pawn_take_left(){
        if (square.row()>=2 && square.row()<=7){
            if (white && !square.up(1).right(-1).occupied_with().is_white()){
                take(1,-1);
                System.out.println(square.up(-1).right(1).to_string().charAt(0) + "x" + square.to_string());
            } else if (!white && square.up(-1).right(-1).occupied_with().is_white()){
                take(-1,-1);
                System.out.println(Character.toString(square.up(1).right(1).to_string().charAt(0)) + "x" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        }
    }

    public void pawn_take_right(){
        if (square.row()>=2 && square.row()<=7){
            if (white && !square.up(1).right(1).occupied_with().is_white()){
                take(1,1);
                System.out.println(Character.toString(square.up(-1).right(-1).to_string().charAt(0)) + "x" + square.to_string());
            } else if (!white && square.up(-1).right(1).occupied_with().is_white()){
                take(-1,1);
                System.out.println(Character.toString(square.up(1).right(-1).to_string().charAt(0)) + "x" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        }
    }

    @Override
    public ArrayList<chess_square> kill_sight(){
        ArrayList<chess_square> kill_sight = new ArrayList<chess_square>();
        if (white){
            if (square.column()<8){
                kill_sight.add(square.up(1).right(1));
            } if (square.column()>1){
                kill_sight.add(square.up(1).right(-1));
            }
        } else {
            if (square.column()<8){
                kill_sight.add(square.up(-1).right(1));
            } if (square.column()>1){
                kill_sight.add(square.up(-1).right(-1));
            }
        }
        return kill_sight;
    }

    public ArrayList<chess_square> travel_sight(){
        ArrayList<chess_square> travel_sight = new ArrayList<chess_square>();
        if (white && square.row()==2){
            if (!square.up(1).is_occupied() && !square.up(2).is_occupied()){
                travel_sight.add(square.up(1));
                travel_sight.add(square.up(2));
            } else if (!square.up(1).is_occupied()){
                travel_sight.add(square.up(1));
            }
        } else if (white){
            if (!square.up(1).is_occupied()){
                travel_sight.add(square.up(1));
            }
        } else if (!white && square.row()==7){
            if (!square.up(-1).is_occupied() && !square.up(-2).is_occupied()){
                travel_sight.add(square.up(-1));
                travel_sight.add(square.up(-2));
            } else if (!square.up(-1).is_occupied()){
                travel_sight.add(square.up(-1));
            }
        } else {
            if (!square.up(-1).is_occupied()){
                travel_sight.add(square.up(-1));
            }
        } if (white && square.up(1).right(1).is_occupied_with_black()){
            travel_sight.add(square.up(1).right(1));
        } if (white && square.up(1).right(-1).is_occupied_with_black()){
            travel_sight.add(square.up(1).right(-1));
        } if (!white && square.up(-1).right(1).is_occupied_with_white()){
            travel_sight.add(square.up(-1).right(1));
        } if (!white && square.up(-1).right(-1).is_occupied_with_white()){
            travel_sight.add(square.up(-1).right(-1));
        } 
        return travel_sight;
    }

    public ArrayList<String> travel_sight2(){
        ArrayList<String> travel_sight = new ArrayList<String>();

        for (chess_square i: travel_sight()){
            travel_sight.add(i.to_string());
        }
        return travel_sight;
    }

    @Override
    public ArrayList<chess_square> valid_moves(){
        ArrayList<chess_square> moves = new ArrayList<chess_square>();
        final chess_square origin_square = square;
        for (chess_square position: travel_sight()){
            if (!position.is_occupied()){
                move(position);
                if (white && !chess_board.check_for_black()){
                    moves.add(position);
                }
                else if (!white && !chess_board.check_for_white()){
                    moves.add(position);
                }
            } else {
                if (white && position.is_occupied_with_black()){
                    if (take_is_valid(position)){
                        moves.add(position);
                    }
                } else if (!white && position.is_occupied_with_white()){
                    if (take_is_valid(position)){
                        moves.add(position);
                    }
                }
            }
            
        }
        if (square != origin_square){
            move(origin_square);
        }
        return moves;
    }
}