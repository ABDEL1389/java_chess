import java.util.ArrayList;

public class queen extends chess_piece{
    public queen(chess_square square, boolean is_white){
        super(square,is_white);
        this.type = "queen";
    }

    public void queen_horizontal_move(int n){
        boolean eligible = true;
        if (square.column()+n<=8){
            for (int i=1; i<n; i++){
                if (square.right(i).is_occupied()){
                    eligible = false;
                } 
            } if (eligible){
                if (!square.right(n).is_occupied()){
                    move(0,n);
                    System.out.println("Q" + square.to_string());
                } else if (white && !square.right(n).occupied_with().is_white()){
                    take(0,n);
                    System.out.println("Qx" + square.to_string());
                } else if (!white && square.right(n).occupied_with().is_white()){
                    take(0,n);
                    System.out.println("Qx" + square.to_string());
                } else {
                    System.out.println("invalid move");
                }
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void queen_upwards_move(int n){
        boolean eligible = true;
        if (square.row()+n<=8){
            for (int i=1; i<n; i++){
                if (square.up(i).is_occupied()){
                    eligible = false;
                } 
            } if (eligible){
                if (!square.up(n).is_occupied()){
                    move(n, 0);
                    System.out.println("Q" + square.to_string());
                } else if (white && !square.up(n).occupied_with().is_white()){
                    take(n,0);
                    System.out.println("Qx" + square.to_string());
                } else if (!white && square.up(n).occupied_with().is_white()){
                    take(n,0);
                    System.out.println("Qx" + square.to_string());
                } else {
                    System.out.println("invalid move");
                }
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void queen_top_left_diagonal_move(int n){
        boolean eligible = true;
        if (square.row()+n<=8 && square.column()-n <=8){
            for (int i=1; i<n; i++){
                if (square.up(i).right(-i).is_occupied()){
                    eligible = false;
                } 
            } if (eligible){
                if (!square.up(n).right(-n).is_occupied()){
                    move(n, -n);
                    System.out.println("Q" + square.to_string());
                } else if (white && !square.up(n).right(-n).occupied_with().is_white()){
                    take(n,-n);
                    System.out.println("Qx" + square.to_string());
                } else if (!white && square.up(n).right(-n).occupied_with().is_white()){
                    take(n,-n);
                    System.out.println("Qx" + square.to_string());
                } else {
                    System.out.println("invalid move");
                }
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void queen_top_right_diagonal_move(int n){
        boolean eligible = true;
        if (square.row()+n<=8 && square.column()+n <=8){
            for (int i=1; i<n; i++){
                if (square.up(i).right(i).is_occupied()){
                    eligible = false;
                } 
            } if (eligible){
                if (!square.up(n).right(n).is_occupied()){
                    move(n, n);
                    System.out.println("Q" + square.to_string());
                } else if (white && !square.up(n).right(n).occupied_with().is_white()){
                    take(n,n);
                    System.out.println("Qx" + square.to_string());
                } else if (!white && square.up(n).right(n).occupied_with().is_white()){
                    take(n,n);
                    System.out.println("Qx" + square.to_string());
                } else {
                    System.out.println("invalid move");
                }
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
        for (int i=1; i<=(8-Math.max(square.column(),square.row())); i++){
            if (!square.up(i).right(i).is_occupied()){
                kill_sight.add(square.up(i).right(i));
            } else {
                kill_sight.add(square.up(i).right(i));
                break;
            }
        } for (int i=1; i<(Math.min(square.column(),square.row())); i++){
            if (!square.up(-i).right(-i).is_occupied()){
                kill_sight.add(square.up(-i).right(-i));
            } else {
                kill_sight.add(square.up(-i).right(-i));
                break;
            }
        } for (int i=1; i<=(8-Math.max(9-square.column(),square.row())); i++){
            if (!square.up(i).right(-i).is_occupied()){
                kill_sight.add(square.up(i).right(-i));
            } else {
                kill_sight.add(square.up(i).right(-i));
                break;
            }
        } for (int i=1; i<(Math.min(9-square.column(),square.row())); i++){
            if (!square.up(-i).right(i).is_occupied()){
                kill_sight.add(square.up(-i).right(i));
            } else {
                kill_sight.add(square.up(-i).right(i));
                break;
            }
        } for (int i=1; i<=(8-square.column()); i++){
            if (!square.right(i).is_occupied()){
                kill_sight.add(square.right(i));
            } else {
                kill_sight.add(square.right(i));
                break;
            }
        } for (int i=1; i<(square.column()); i++){
            if (!square.right(-i).is_occupied()){
                kill_sight.add(square.right(-i));
            } else {
                kill_sight.add(square.right(-i));
                break;
            }
        } for (int i=1; i<=(8-square.row()); i++){
            if (!square.up(i).is_occupied()){
                kill_sight.add(square.up(i));
            } else {
                kill_sight.add(square.up(i));
                break;
            }
        } for (int i=1; i<(square.row()); i++){
            if (!square.up(-i).is_occupied()){
                kill_sight.add(square.up(-i));
            } else {
                kill_sight.add(square.up(-i));
                break;
            }
        }
        return kill_sight;
    }
}

