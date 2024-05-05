import java.util.ArrayList;

public class chess_board{
    ArrayList<chess_square> chess_squares;

    public static chess_square a1 = new chess_square('a', 1);
    public static chess_square b1 = new chess_square('b', 1);
    public static chess_square c1 = new chess_square('c', 1);
    public static chess_square d1 = new chess_square('d', 1);
    public static chess_square e1 = new chess_square('e', 1);
    public static chess_square f1 = new chess_square('f', 1);
    public static chess_square g1 = new chess_square('g', 1);
    public static chess_square h1 = new chess_square('h', 1);
    public static chess_square a2 = new chess_square('a', 2);
    public static chess_square b2 = new chess_square('b', 2);
    public static chess_square c2 = new chess_square('c', 2);
    public static chess_square d2 = new chess_square('d', 2);
    public static chess_square e2 = new chess_square('e', 2);
    public static chess_square f2 = new chess_square('f', 2);
    public static chess_square g2 = new chess_square('g', 2);
    public static chess_square h2 = new chess_square('h', 2);
    public static chess_square a3 = new chess_square('a', 3);
    public static chess_square b3 = new chess_square('b', 3);
    public static chess_square c3 = new chess_square('c', 3);
    public static chess_square d3 = new chess_square('d', 3);
    public static chess_square e3 = new chess_square('e', 3);
    public static chess_square f3 = new chess_square('f', 3);
    public static chess_square g3 = new chess_square('g', 3);
    public static chess_square h3 = new chess_square('h', 3);
    public static chess_square a4 = new chess_square('a', 4);
    public static chess_square b4 = new chess_square('b', 4);
    public static chess_square c4 = new chess_square('c', 4);
    public static chess_square d4 = new chess_square('d', 4);
    public static chess_square e4 = new chess_square('e', 4);
    public static chess_square f4 = new chess_square('f', 4);
    public static chess_square g4 = new chess_square('g', 4);
    public static chess_square h4 = new chess_square('h', 4);
    public static chess_square a5 = new chess_square('a', 5);
    public static chess_square b5 = new chess_square('b', 5);
    public static chess_square c5 = new chess_square('c', 5);
    public static chess_square d5 = new chess_square('d', 5);
    public static chess_square e5 = new chess_square('e', 5);
    public static chess_square f5 = new chess_square('f', 5);
    public static chess_square g5 = new chess_square('g', 5);
    public static chess_square h5 = new chess_square('h', 5);
    public static chess_square a6 = new chess_square('a', 6);
    public static chess_square b6 = new chess_square('b', 6);
    public static chess_square c6 = new chess_square('c', 6);
    public static chess_square d6 = new chess_square('d', 6);
    public static chess_square e6 = new chess_square('e', 6);
    public static chess_square f6 = new chess_square('f', 6);
    public static chess_square g6 = new chess_square('g', 6);
    public static chess_square h6 = new chess_square('h', 6);
    public static chess_square a7 = new chess_square('a', 7);
    public static chess_square b7 = new chess_square('b', 7);
    public static chess_square c7 = new chess_square('c', 7);
    public static chess_square d7 = new chess_square('d', 7);
    public static chess_square e7 = new chess_square('e', 7);
    public static chess_square f7 = new chess_square('f', 7);
    public static chess_square g7 = new chess_square('g', 7);
    public static chess_square h7 = new chess_square('h', 7);
    public static chess_square a8 = new chess_square('a', 8);
    public static chess_square b8 = new chess_square('b', 8);
    public static chess_square c8 = new chess_square('c', 8);
    public static chess_square d8 = new chess_square('d', 8);
    public static chess_square e8 = new chess_square('e', 8);
    public static chess_square f8 = new chess_square('f', 8);
    public static chess_square g8 = new chess_square('g', 8);
    public static chess_square h8 = new chess_square('h', 8);
    
    public static chess_square out_of_range = new chess_square('x', 0);
    
    public chess_board(){
        this.chess_squares = new ArrayList<chess_square>();
        chess_squares.add(a1); chess_squares.add(a2); chess_squares.add(a3); chess_squares.add(a4);
        chess_squares.add(a5); chess_squares.add(a6); chess_squares.add(a7); chess_squares.add(a8);
        chess_squares.add(b1); chess_squares.add(b2); chess_squares.add(b3); chess_squares.add(b4);
        chess_squares.add(b5); chess_squares.add(b6); chess_squares.add(b7); chess_squares.add(b8);
        chess_squares.add(c1); chess_squares.add(c2); chess_squares.add(c3); chess_squares.add(c4);
        chess_squares.add(c5); chess_squares.add(c6); chess_squares.add(c7); chess_squares.add(c8);
        chess_squares.add(d1); chess_squares.add(d2); chess_squares.add(d3); chess_squares.add(d4);
        chess_squares.add(d5); chess_squares.add(d6); chess_squares.add(d7); chess_squares.add(d8);
        chess_squares.add(e1); chess_squares.add(e2); chess_squares.add(e3); chess_squares.add(e4);
        chess_squares.add(e5); chess_squares.add(e6); chess_squares.add(e7); chess_squares.add(e8);
        chess_squares.add(f1); chess_squares.add(f2); chess_squares.add(f3); chess_squares.add(f4);
        chess_squares.add(f5); chess_squares.add(f6); chess_squares.add(f7); chess_squares.add(f8);
        chess_squares.add(g1); chess_squares.add(g2); chess_squares.add(g3); chess_squares.add(g4);
        chess_squares.add(g5); chess_squares.add(g6); chess_squares.add(g7); chess_squares.add(g8);
        chess_squares.add(h1); chess_squares.add(h2); chess_squares.add(h3); chess_squares.add(h4);
        chess_squares.add(h5); chess_squares.add(h6); chess_squares.add(h7); chess_squares.add(h8);
    }

    public ArrayList<chess_square> board_squares(){
        return chess_squares;
    }

    public static chess_board board = new chess_board();
    
    //creating the white pieces
    public static pawn white_a_pawn = new pawn(a2, true);
    public static pawn white_b_pawn = new pawn(b2,true);
    public static pawn white_c_pawn = new pawn(c2, true);
    public static pawn white_d_pawn = new pawn(d2, true);
    public static pawn white_e_pawn = new pawn(e2, true);
    public static pawn white_f_pawn = new pawn(f2, true);
    public static pawn white_g_pawn = new pawn(g2, true);
    public static pawn white_h_pawn = new pawn(h2, true);
    public static rook white_rook1 = new rook(a1,true);
    public static knight white_knight1 = new knight(b1,true);
    public static bishop white_bishop1 = new bishop(c1, true);
    public static queen white_queen = new queen(d1, true);
    public static king white_king = new king(e1, true);
    public static bishop white_bishop2 = new bishop(f1, true);
    public static knight white_knight2 = new knight(g1, true);
    public static rook white_rook2 = new rook(h1, true);
    
    //creating the black pieces
    public static pawn black_a_pawn = new pawn(a7, false);
    public static pawn black_b_pawn = new pawn(b7, false);
    public static pawn black_c_pawn = new pawn(c7, false);
    public static pawn black_d_pawn = new pawn(d7, false);
    public static pawn black_e_pawn = new pawn(e7, false);
    public static pawn black_f_pawn = new pawn(f7, false);
    public static pawn black_g_pawn = new pawn(g7, false);
    public static pawn black_h_pawn = new pawn(h7, false);
    public static rook black_rook1 = new rook(a8,false);
    public static knight black_knight1 = new knight(b8,false);
    public static bishop black_bishop1 = new bishop(c8, false);
    public static queen black_queen = new queen(d8, false);
    public static king black_king = new king(e8, false);
    public static bishop black_bishop2 = new bishop(f8, false);
    public static knight black_knight2 = new knight(g8, false);
    public static rook black_rook2 = new rook(h8, false);
        
    public static ArrayList<chess_piece> white_pieces(){
        ArrayList<chess_piece> white_pieces = new ArrayList<chess_piece>();
        if (white_a_pawn.is_active()){
            white_pieces.add(white_a_pawn);
        } if (white_b_pawn.is_active()){
            white_pieces.add(white_b_pawn);
        } if (white_c_pawn.is_active()){
            white_pieces.add(white_c_pawn);
        } if (white_d_pawn.is_active()){
            white_pieces.add(white_d_pawn);
        } if (white_e_pawn.is_active()){
            white_pieces.add(white_e_pawn);
        } if (white_f_pawn.is_active()){
            white_pieces.add(white_f_pawn);
        } if (white_g_pawn.is_active()){
            white_pieces.add(white_g_pawn);
        } if (white_h_pawn.is_active()){
            white_pieces.add(white_h_pawn);
        } if (white_bishop1.is_active()){
            white_pieces.add(white_bishop1);
        } if (white_bishop2.is_active()){
            white_pieces.add(white_bishop2);
        } if (white_knight1.is_active()){
            white_pieces.add(white_knight1);
        } if (white_knight2.is_active()){
            white_pieces.add(white_knight2);
        } if (white_rook1.is_active()){
            white_pieces.add(white_rook1);
        } if (white_rook2.is_active()){
            white_pieces.add(white_rook2);
        } if (white_queen.is_active()){
            white_pieces.add(white_queen);
        } if (promoted_white_queen1.is_active()){
            white_pieces.add(promoted_white_queen1);
        } if (promoted_white_queen2.is_active()){
            white_pieces.add(promoted_white_queen2);
        } if (promoted_white_queen3.is_active()){
            white_pieces.add(promoted_white_queen3);
        } if (promoted_white_queen4.is_active()){
            white_pieces.add(promoted_white_queen4);
        } if (promoted_white_queen5.is_active()){
            white_pieces.add(promoted_white_queen5);
        } white_pieces.add(white_king);
        return white_pieces;
    } 

    public static ArrayList<chess_piece> black_pieces(){
        ArrayList<chess_piece> black_pieces = new ArrayList<chess_piece>();
        if (black_a_pawn.is_active()){
            black_pieces.add(black_a_pawn);
        } if (black_b_pawn.is_active()){
            black_pieces.add(black_b_pawn);
        } if (black_c_pawn.is_active()){
            black_pieces.add(black_c_pawn);
        } if (black_d_pawn.is_active()){
            black_pieces.add(black_d_pawn);
        } if (black_e_pawn.is_active()){
            black_pieces.add(black_e_pawn);
        } if (black_f_pawn.is_active()){
            black_pieces.add(black_f_pawn);
        } if (black_g_pawn.is_active()){
            black_pieces.add(black_g_pawn);
        } if (black_h_pawn.is_active()){
            black_pieces.add(black_h_pawn);
        } if (black_bishop1.is_active()){
            black_pieces.add(black_bishop1);
        } if (black_bishop2.is_active()){
            black_pieces.add(black_bishop2);
        } if (black_knight1.is_active()){
            black_pieces.add(black_knight1);
        } if (black_knight2.is_active()){
            black_pieces.add(black_knight2);
        } if (black_rook1.is_active()){
            black_pieces.add(black_rook1);
        } if (black_rook2.is_active()){
            black_pieces.add(black_rook2);
        } if (black_queen.is_active()){
            black_pieces.add(black_queen);
        } if (promoted_black_queen1.is_active()){
            black_pieces.add(promoted_black_queen1);
        } if (promoted_black_queen2.is_active()){
            black_pieces.add(promoted_black_queen2);
        } if (promoted_black_queen3.is_active()){
            black_pieces.add(promoted_black_queen3);
        } if (promoted_black_queen4.is_active()){
            black_pieces.add(promoted_black_queen4);
        } if (promoted_black_queen5.is_active()){
            black_pieces.add(promoted_black_queen5);
        } black_pieces.add(black_king);
        return black_pieces;
    }

    public static ArrayList<chess_square> white_kill_view(){
        ArrayList<chess_square> white_kill_view = new ArrayList<chess_square>();
        for (chess_piece piece: white_pieces()){
            for (chess_square square: piece.kill_sight()){
                if (!white_kill_view.contains(square)){
                    white_kill_view.add(square);
                }
            }
        } return white_kill_view;
    }

    public static ArrayList<String> white_kill_view2(){
        ArrayList<String> white_kill_view = new ArrayList<String>();
        for (chess_piece piece: white_pieces()){
            for (String square: piece.kill_sight2()){
                if (!white_kill_view.contains(square)){
                    white_kill_view.add(square);
                }
            }
        } return white_kill_view;
    }

    public static ArrayList<chess_square> black_kill_view(){
        ArrayList<chess_square> black_kill_view = new ArrayList<chess_square>();
        for (chess_piece piece: black_pieces()){
            for (chess_square square: piece.kill_sight()){
                if (!black_kill_view.contains(square)){
                    black_kill_view.add(square);
                }
            }
        } return black_kill_view;
    }

    public static ArrayList<String> black_kill_view2(){
        ArrayList<String> black_kill_view = new ArrayList<String>();
        for (chess_piece piece: black_pieces()){
            for (String square: piece.kill_sight2()){
                if (!black_kill_view.contains(square)){
                    black_kill_view.add(square);
                }
            }
        } return black_kill_view;
    }

    public static boolean check_for_white(){
        if (white_kill_view().contains(black_king.find())){
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkmate_for_white(){
        ArrayList<chess_square> all_moves = new ArrayList<chess_square>();
        if (check_for_white()){
            for (chess_piece i: chess_board.black_pieces()){
                all_moves.addAll(i.valid_moves());
            } if (all_moves.size() == 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkmate_for_black(){
        ArrayList<chess_square> all_moves = new ArrayList<chess_square>();
        if (check_for_black()){
            for (chess_piece i: chess_board.white_pieces()){
                all_moves.addAll(i.valid_moves());
            } if (all_moves.size() == 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean check_for_black(){
        if (black_kill_view().contains(white_king.find())){
            return true;
        } else {
            return false;
        }
    }

    
    public static queen promoted_white_queen1 = new queen(null, true);
    public static queen promoted_white_queen2 = new queen(null, true);
    public static queen promoted_white_queen3 = new queen(null, true);
    public static queen promoted_white_queen4 = new queen(null, true);
    public static queen promoted_white_queen5 = new queen(null, true);
    
    public static int white_queens_promoted = 0;

    public static queen[] promoted_white_queens ={promoted_white_queen1,promoted_white_queen1,
        promoted_white_queen1, promoted_white_queen1, promoted_white_queen1};

    public static queen promoted_black_queen1 = new queen(null, false);
    public static queen promoted_black_queen2 = new queen(null, false);
    public static queen promoted_black_queen3 = new queen(null, false);
    public static queen promoted_black_queen4 = new queen(null, false);
    public static queen promoted_black_queen5 = new queen(null, false);
    
    public static int black_queens_promoted = 0;

    public static queen[] promoted_black_queens ={promoted_black_queen1,promoted_black_queen1,
        promoted_black_queen1, promoted_black_queen1, promoted_black_queen1};

    public void setup(){
        a2.occupy_with(white_a_pawn);
        b2.occupy_with(white_b_pawn);
        c2.occupy_with(white_c_pawn);
        d2.occupy_with(white_d_pawn);
        e2.occupy_with(white_e_pawn);
        f2.occupy_with(white_f_pawn);
        g2.occupy_with(white_g_pawn);
        h2.occupy_with(white_h_pawn);
        a1.occupy_with(white_rook1);
        b1.occupy_with(white_knight1);
        c1.occupy_with(white_bishop1);
        d1.occupy_with(white_queen);
        e1.occupy_with(white_king);
        f1.occupy_with(white_bishop2);
        g1.occupy_with(white_knight2);
        h1.occupy_with(white_rook2);

        a7.occupy_with(black_a_pawn);
        b7.occupy_with(black_b_pawn);
        c7.occupy_with(black_c_pawn);
        d7.occupy_with(black_d_pawn);
        e7.occupy_with(black_e_pawn);
        f7.occupy_with(black_f_pawn);
        g7.occupy_with(black_g_pawn);
        h7.occupy_with(black_h_pawn);
        a8.occupy_with(black_rook1);
        b8.occupy_with(black_knight1);
        c8.occupy_with(black_bishop1);
        d8.occupy_with(black_queen);
        e8.occupy_with(black_king);
        f8.occupy_with(black_bishop2);
        g8.occupy_with(black_knight2);
        h8.occupy_with(black_rook2);  
        
        promoted_white_queen1.set_inactive();
        promoted_white_queen2.set_inactive();
        promoted_white_queen3.set_inactive();
        promoted_white_queen4.set_inactive();
        promoted_white_queen5.set_inactive();

        promoted_black_queen1.set_inactive();
        promoted_black_queen2.set_inactive();
        promoted_black_queen3.set_inactive();
        promoted_black_queen4.set_inactive();
        promoted_black_queen5.set_inactive();
    }    
}