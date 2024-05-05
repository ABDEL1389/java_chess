import java.util.ArrayList;
import java.util.Scanner;

public class java_chess{
    private static boolean white_turn = true;

    public static boolean game_active(){
        if (chess_board.checkmate_for_white()){
            System.out.println("Checkmate! White wins");
            return false;
        } else if (chess_board.checkmate_for_black()){
            System.out.println("Checkmate! Black wins");
            return false;
        } else if (stalemate()){
            System.out.println("Stalemate");
            return false;}
         else {
            return true;
        }
    }

    public static boolean stalemate(){
        ArrayList<chess_square> all_moves = new ArrayList<chess_square>();
        if (white_turn){
            for (chess_piece i: chess_board.white_pieces()){
                all_moves.addAll(i.valid_moves());
            } 
            if (!chess_board.check_for_black() && all_moves.size()==0){
                return true;
            } else {
                return false;
            }
        } else {
            for (chess_piece i: chess_board.black_pieces()){
                all_moves.addAll(i.valid_moves());
            }
            if (!chess_board.check_for_white() && all_moves.size()==0){
                return true;
            } else {
                return false;
            }
        }
    }

    public static void game(){
        Scanner scanner = new Scanner(System.in);
        while (game_active()){
            if (white_turn){
                ArrayList<chess_piece> available_pieces_to_move = new ArrayList<chess_piece>();
                for (chess_piece i:chess_board.white_pieces()){
                    if (i.valid_moves().size()>0){
                        available_pieces_to_move.add(i);
                    }
                }
                System.out.println("\nWhich piece would you like to move?");
                for (int i=1; i<=available_pieces_to_move.size(); i++){
                    System.out.println(Integer.toString(i)+". "+available_pieces_to_move.get(i-1).type()
                    + " on " + available_pieces_to_move.get(i-1).find().to_string());
                } 
                Integer number      = 0;
                while (true){
                    String input = scanner.nextLine();
                    try {
                        number = Integer.parseInt(input);
                        if (number>0 && number<=available_pieces_to_move.size()){
                            break;
                        } else {
                            System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(available_pieces_to_move.size()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(available_pieces_to_move.size()));
                    }
                } 
                chess_piece chosen_piece = available_pieces_to_move.get(number-1);
                System.out.println("\nWhere would you like to move this piece?");
                for (int i=1; i<= chosen_piece.valid_moves().size(); i++){
                    System.out.println(Integer.toString(i)+". "+ chosen_piece.valid_moves2().get(i-1));
                }
                while (true){
                    String input = scanner.nextLine();
                    try {
                        number = Integer.parseInt(input);
                        if (number>0 && number<=chosen_piece.valid_moves().size()){
                            break;
                        } else {
                            System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(chosen_piece.valid_moves().size()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(chosen_piece.valid_moves().size()));
                    }
                }
                chess_square destination = chosen_piece.valid_moves().get(number-1);
                if (chosen_piece.type().equals("white pawn") && destination.row() == 8){
                    if (destination.is_occupied()){
                        chosen_piece.take(destination);
                    } 
                    chosen_piece.taken();
                    chess_board.promoted_white_queens[chess_board.white_queens_promoted].set_square(destination);
                    destination.occupy_with(chess_board.promoted_white_queens[chess_board.white_queens_promoted]);
                    chess_board.white_queens_promoted += 1;
                } else if (chosen_piece.type().equals("white king") && (chosen_piece.find()==chess_board.e1) && destination==chess_board.g1){
                    chess_board.white_king.short_castle();
                } else if (chosen_piece.type().equals("white king") && (chosen_piece.find()==chess_board.e1) && destination==chess_board.c1){
                    chess_board.white_king.long_castle();
                } else if (destination.is_occupied()){
                    chosen_piece.take(destination);
                } else {
                    chosen_piece.move(destination);
                }
                white_turn = false;
            } else {
                ArrayList<chess_piece> available_pieces_to_move = new ArrayList<chess_piece>();
                for (chess_piece i:chess_board.black_pieces()){
                    if (i.valid_moves().size()>0){
                        available_pieces_to_move.add(i);
                    }
                }
                System.out.println("\nWhich piece would you like to move?");
                for (int i=1; i<=available_pieces_to_move.size(); i++){
                    System.out.println(Integer.toString(i)+". "+available_pieces_to_move.get(i-1).type()
                    + " on " + available_pieces_to_move.get(i-1).find().to_string());
                } 
                Integer number      = 0;
                while (true){
                    String input = scanner.nextLine();
                    try {
                        number = Integer.parseInt(input);
                        if (number>0 && number<=available_pieces_to_move.size()){
                            break;
                        } else {
                            System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(available_pieces_to_move.size()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(available_pieces_to_move.size()));
                    }
                } 
                chess_piece chosen_piece = available_pieces_to_move.get(number-1);
                System.out.println("\nWhere would you like to move this piece?");
                for (int i=1; i<= chosen_piece.valid_moves().size(); i++){
                    System.out.println(Integer.toString(i)+". "+ chosen_piece.valid_moves2().get(i-1));
                }
                while (true){
                    String input = scanner.nextLine();
                    try {
                        number = Integer.parseInt(input);
                        if (number>0 && number<=chosen_piece.valid_moves().size()){
                            break;
                        } else {
                            System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(chosen_piece.valid_moves().size()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input, enter a number from 1 to " + Integer.toString(chosen_piece.valid_moves().size()));
                    }
                }
                chess_square destination = chosen_piece.valid_moves().get(number-1);
                if (chosen_piece.type().equals("black pawn") && destination.row() == 1){
                    if (destination.is_occupied()){
                        chosen_piece.take(destination);
                    } 
                    chosen_piece.taken();
                    chess_board.promoted_black_queens[chess_board.black_queens_promoted].set_square(destination);
                    destination.occupy_with(chess_board.promoted_black_queens[chess_board.black_queens_promoted]);
                    chess_board.black_queens_promoted += 1;
                } else if (chosen_piece.type().equals("black king") && (chosen_piece.find()==chess_board.e8) && destination==chess_board.g8){
                    chess_board.black_king.short_castle();
                } else if (chosen_piece.type().equals("black king") && (chosen_piece.find()==chess_board.e8) && destination==chess_board.c8){
                    chess_board.black_king.long_castle();
                } else if (destination.is_occupied()){
                    chosen_piece.take(destination);
                } else {
                    chosen_piece.move(destination);
                }
                white_turn = true;
            }
        }scanner.close();
    }

    public static void main(String[] args){
        chess_board.board.setup();
        game();
        //chess_board.black_h_pawn.double_push();
        //chess_board.black_h_pawn.single_push();
        //chess_board.black_h_pawn.single_push();
        //chess_board.black_h_pawn.pawn_take_left();
        //chess_board.white_bishop2.bishop_top_left_diagonal_move(4);
        //chess_board.black_d_pawn.double_push();
        //System.out.println(chess_board.black_h_pawn.valid_moves2());
        //System.out.println(chess_board.c1.occupied_with().type());
        //System.out.println(chess_board.black_h_pawn.find().to_string());
        //new board_gui();
        
    }
}