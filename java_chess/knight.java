import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class knight extends chess_piece{
    public knight(chess_square square, boolean is_white){
        super(square,is_white);
        this.type = "knight";

        if (is_white){
            try (ZipFile zipFile = new ZipFile("chess-pieces.zip")) { 
            ZipEntry entry = zipFile.getEntry("white-knight.png"); 
            if (entry != null) {
                try (InputStream inputStream = zipFile.getInputStream(entry)) {
                    this.image = ImageIO.read(inputStream);
                }
            } else {
                System.err.println("Sprite image not found in the zip folder.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
        } else {
            try (ZipFile zipFile = new ZipFile("chess-pieces.zip")) { 
                ZipEntry entry = zipFile.getEntry("black-knight.png"); 
                if (entry != null) {
                    try (InputStream inputStream = zipFile.getInputStream(entry)) {
                        this.image = ImageIO.read(inputStream);
                    }
                } else {
                    System.err.println("Sprite image not found in the zip folder.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }  
    }

    public void knight_move1(){
        //down 1 left 2
        if (square.row() >= 2 && square.column() >= 3){
            if (!square.up(-1).right(-2).is_occupied()){
                move(-1,-2);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(-1).right(-2).occupied_with().is_white()){
                take(-1,-2);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(-1).right(-2).occupied_with().is_white()){
                take(-1,-2);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move2(){
        //down 2 left 1
        if (square.row() >= 3 && square.column() >= 2){
            if (!square.up(-2).right(-1).is_occupied()){
                move(-2,-1);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(-2).right(-1).occupied_with().is_white()){
                take(-2,-1);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(-2).right(-1).occupied_with().is_white()){
                take(-2,-1);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move3(){
        //up 1 left 2
        if (square.row() <= 7 && square.column() >= 3){
            if (!square.up(1).right(-2).is_occupied()){
                move(1,-2);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(1).right(-2).occupied_with().is_white()){
                take(1,-2);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(1).right(-2).occupied_with().is_white()){
                take(1,-2);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move4(){
        //up 2 left 1
        if (square.row() <= 6 && square.column() >= 2){
            if (!square.up(2).right(-1).is_occupied()){
                move(2,-1);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(2).right(-1).occupied_with().is_white()){
                take(2,-1);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(2).right(-1).occupied_with().is_white()){
                take(2,-1);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move5(){
        //up 1 right 2
        if (square.row() <= 7 && square.column() <= 6){
            if (!square.up(1).right(2).is_occupied()){
                move(1,2);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(1).right(2).occupied_with().is_white()){
                take(1,2);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(1).right(2).occupied_with().is_white()){
                take(1,2);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move6(){
        //up 2 right 1
        if (square.row() <= 6 && square.column() <= 7){
            if (!square.up(2).right(1).is_occupied()){
                move(2,1);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(2).right(1).occupied_with().is_white()){
                take(2,1);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(2).right(1).occupied_with().is_white()){
                take(2,1);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move7(){
        //down 2 right 1
        if (square.row() >= 3 && square.column() <= 7){
            if (!square.up(-2).right(1).is_occupied()){
                move(-2,1);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(-2).right(1).occupied_with().is_white()){
                take(-2,1);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(-2).right(1).occupied_with().is_white()){
                take(-2,1);
                System.out.println("Nx" + square.to_string());
            } else {
                System.out.println("invalid move");
            }
        } else {
            System.out.println("invalid move");
        }
    }

    public void knight_move8(){
        //down 1 right 2
        if (square.row() >= 2 && square.column() <= 6){
            if (!square.up(-1).right(2).is_occupied()){
                move(-1,2);
                System.out.println("N" + square.to_string());
            } else if (white && !square.up(-1).right(2).occupied_with().is_white()){
                take(-1,2);
                System.out.println("Nx" + square.to_string());
            } else if (!white && square.up(-1).right(2).occupied_with().is_white()){
                take(-1,2);
                System.out.println("Nx" + square.to_string());
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
        if (square.row() >= 2 && square.column() >= 3){
            kill_sight.add(square.up(-1).right(-2));
        } if (square.row() >= 3 && square.column() >= 2){
            kill_sight.add(square.up(-2).right(-1));
        } if (square.row() <= 7 && square.column() >= 3){
            kill_sight.add(square.up(1).right(-2));
        } if (square.row() <= 6 && square.column() >= 2){
            kill_sight.add(square.up(2).right(-1));
        } if (square.row() <= 7 && square.column() <= 6){
            kill_sight.add(square.up(1).right(2));
        } if (square.row() <= 6 && square.column() <= 7){
            kill_sight.add(square.up(2).right(1));
        } if (square.row() >= 3 && square.column() <= 7){
            kill_sight.add(square.up(-2).right(1));
        } if (square.row() >= 2 && square.column() <= 6){
            kill_sight.add(square.up(-1).right(2));
        }
        return kill_sight;
    }

}

