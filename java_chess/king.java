import java.util.ArrayList;

public class king extends chess_piece{
    public king(chess_square square, boolean is_white){
        super(square,is_white);
        this.type = "king";
    }

    public void king_upwards_move(){
        if (square.row()<=7){
            if (!square.up(1).is_occupied()){
                move(1,0);
                System.out.println("K" + square.to_string());
            } else if ((white && square.up(1).occupied_with().is_white()) || (!white && !square.up(1).occupied_with().is_white())){
                take(1,0);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }


    public void king_downwards_move(){
        if (square.row()>=2){
            if (!square.up(-1).is_occupied()){
                move(-1,0);
                System.out.println("K" + square.to_string());
            } else if ((white && square.up(-1).occupied_with().is_white()) || (!white && !square.up(-1).occupied_with().is_white())){
                take(-1,0);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void king_right_move(){
        if (square.column()<=7){
            if (!square.right(1).is_occupied()){
                move(0,1);
                System.out.println("K" + square.to_string());
            } else if ((white && square.right(1).occupied_with().is_white()) || (!white && !square.right(1).occupied_with().is_white())){
                take(0,1);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void king_left_move(){
        if (square.column()>=2){
            if (!square.right(-1).is_occupied()){
                move(0,-1);
                System.out.println("K" + square.to_string());
            } else if ((white && square.right(-1).occupied_with().is_white()) || (!white && !square.right(-1).occupied_with().is_white())){
                take(0,-1);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void king_top_right_move(){
        if (square.column()<=7 && square.row()<=7){
            if (!square.right(1).up(1).is_occupied()){
                move(1,1);
                System.out.println("K" + square.to_string());
            } else if ((white && square.up(1).right(1).occupied_with().is_white()) || (!white && !square.up(1).right(1).occupied_with().is_white())){
                take(1,1);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void king_top_left_move(){
        if (square.column()>=2 && square.row()<=7){
            if (!square.right(-1).up(1).is_occupied()){
                move(1,-1);
                System.out.println("K" + square.to_string());
            } else if ((white && square.up(1).right(-1).occupied_with().is_white()) || (!white && !square.up(1).right(-1).occupied_with().is_white())){
                take(1,-1);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void king_down_right_move(){
        if (square.column()<=7 && square.row()>=2){
            if (!square.right(1).up(-1).is_occupied()){
                move(-1,1);
                System.out.println("K" + square.to_string());
            } else if ((white && square.up(-1).right(1).occupied_with().is_white()) || (!white && !square.up(-1).right(1).occupied_with().is_white())){
                take(-1,1);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void king_down_left_move(){
        if (square.column()>=2 && square.row()>=2){
            if (!square.right(-1).up(-1).is_occupied()){
                move(-1,-1);
                System.out.println("K" + square.to_string());
            } else if ((white && square.up(-1).right(-1).occupied_with().is_white()) || (!white && !square.up(-1).right(-1).occupied_with().is_white())){
                take(-1,-1);
                System.out.println("Kx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void short_castle(){
        if (white && square == chess_board.e1 && square.right(3).is_occupied() && !square.right(1).is_occupied()){
            if ((square.right(3).occupied_with().type().equals("white rook")) && !square.right(1).is_occupied()){
                square.right(3).occupied_with().move(0,-2);
                move(0,2);
                System.out.println("O-O");
            } else {
                System.out.println("invalid move");
            }
        } else if (!white && square == chess_board.e8 && square.right(3).is_occupied() && !square.right(1).is_occupied()){
            if ((square.right(3).occupied_with().type().equals("black rook")) && !square.right(1).is_occupied()){
                square.right(3).occupied_with().move(0,-2);
                move(0,2);
                System.out.println("O-O");
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void long_castle(){
        if (white && square == chess_board.e1 && square.right(-4).is_occupied() && !square.right(-1).is_occupied()){
            if ((square.right(-4).occupied_with().type().equals("white rook")) && !square.right(-2).is_occupied() && !square.right(-3).is_occupied()){
                square.right(-4).occupied_with().move(0,3);
                move(0,-2);
                System.out.println("O-O-O");
            } else {
                System.out.println("invalid move");
            }
        } else if (!white && square == chess_board.e8 && square.right(-4).is_occupied() && !square.right(-1).is_occupied()){
            if ((square.right(-4).occupied_with().type().equals("black rook")) && !square.right(-2).is_occupied() && !square.right(-3).is_occupied()){
                square.right(-4).occupied_with().move(0,3);
                move(0,-2);
                System.out.println("O-O-O");
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    @Override
    public ArrayList<chess_square> kill_sight(){
        ArrayList<chess_square> kill_sight = new ArrayList<chess_square>();
        if (square.row() >= 2 && square.column() >= 2){
            kill_sight.add(square.up(-1).right(-1));
        } if (square.column() >= 2){
            kill_sight.add(square.right(-1));
        } if (square.row() <= 7 && square.column() >= 2){
            kill_sight.add(square.up(1).right(-1));
        } if (square.row() <= 7){
            kill_sight.add(square.up(1));
        } if (square.row() <= 7 && square.column() <= 7){
            kill_sight.add(square.up(1).right(1));
        } if (square.column() <= 7){
            kill_sight.add(square.right(1));
        } if (square.row() >= 2 && square.column() <= 7){
            kill_sight.add(square.up(-1).right(1));
        } if (square.row() >= 2){
            kill_sight.add(square.up(-1));
        }
        return kill_sight;
    }

    @Override
    public ArrayList<chess_square> valid_moves(){
        ArrayList<chess_square> moves = new ArrayList<chess_square>();
        final chess_square origin_square = square;
        for (chess_square position: kill_sight()){
            if (white && !position.is_occupied_with_white()){
                move(position);
                if (!chess_board.check_for_black()){
                    moves.add(position);
                }
            } else if (!white && !position.is_occupied_with_black()){
                move(position);
                if (!chess_board.check_for_white()){
                    moves.add(position);
                }
            }
        }
        if (square != origin_square){
            move(origin_square);
        }
        //for castling
        ArrayList<chess_square> black_vision = new ArrayList<chess_square>();
        ArrayList<chess_square> white_vision = new ArrayList<chess_square>();
        for (chess_piece i: chess_board.black_pieces()){
            black_vision.addAll(i.kill_sight());
        }
        for (chess_piece i: chess_board.white_pieces()){
            white_vision.addAll(i.kill_sight());
        }
        if (white && square == chess_board.e1 && square.right(3).is_occupied() && !square.right(1).is_occupied()){
            if ((square.right(3).occupied_with().type().equals("white rook")) && !square.right(1).is_occupied()){
                 if (!black_vision.contains(chess_board.f1)&&!black_vision.contains(chess_board.g1)){
                    moves.add(chess_board.g1);
                }
            }
        } else if (white && square == chess_board.e1 && square.right(-4).is_occupied() && !square.right(-1).is_occupied()){
            if ((square.right(-4).occupied_with().type().equals("white rook")) && !square.right(-2).is_occupied() && !square.right(-3).is_occupied()){
                if (!black_vision.contains(chess_board.c1)&&!black_vision.contains(chess_board.d1)){
                    moves.add(chess_board.c1);
                }
            }
        } else if (!white && square == chess_board.e8 && square.right(3).is_occupied() && !square.right(1).is_occupied()){
            if ((square.right(3).occupied_with().type().equals("black rook")) && !square.right(1).is_occupied()){
                moves.add(chess_board.g8);
            }
        } else if (!white && square == chess_board.e8 && square.right(-4).is_occupied() && !square.right(-1).is_occupied()){
            if ((square.right(-4).occupied_with().type().equals("black rook")) && !square.right(-2).is_occupied() && !square.right(-3).is_occupied()){
                moves.add(chess_board.c8);
            }
        }
        return moves;
    }
}