import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class rook extends chess_piece{
    public rook(chess_square square, boolean is_white){
        super(square,is_white);
        this.type = "rook";

        if (is_white){
            try (ZipFile zipFile = new ZipFile("chess-pieces.zip")) { 
            ZipEntry entry = zipFile.getEntry("white-rook.png"); 
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
                ZipEntry entry = zipFile.getEntry("black-rook.png"); 
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

    public void rook_upwards_move(int n){
        boolean eligible = true;
        if (square.row()+n<=8){
            for (int i=1; i<n; i++){
                if (square.up(i).is_occupied()){
                    eligible = false;
                } 
            } if (eligible){
                if (!square.up(n).is_occupied()){
                    move(n, 0);
                    System.out.println("R" + square.to_string());
                } else if (white && !square.up(n).occupied_with().is_white()){
                    take(n,0);
                    System.out.println("Rx" + square.to_string());
                } else if (!white && square.up(n).occupied_with().is_white()){
                    take(n,0);
                    System.out.println("Rx" + square.to_string());
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

    public void rook_horizontal_move(int n){
        boolean eligible = true;
        if (square.column()+n<=8){
            for (int i=1; i<n; i++){
                if (square.right(i).is_occupied()){
                    eligible = false;
                } 
            } if (eligible){
                if (!square.right(n).is_occupied()){
                    move(0,n);
                    System.out.println("R" + square.to_string());
                } else if (white && !square.right(n).occupied_with().is_white()){
                    take(0,n);
                    System.out.println("Rx" + square.to_string());
                } else if (!white && square.right(n).occupied_with().is_white()){
                    take(0,n);
                    System.out.println("Rx" + square.to_string());
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
        for (int i=1; i<=(8-square.column()); i++){
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
