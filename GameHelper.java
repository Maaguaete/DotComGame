package dotcomgameHead1stJava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {

    int startRow, startColumn;
    String cell;
    boolean vector;
    ArrayList<String> Store = new ArrayList<>();

    ArrayList<String> placeTerrorist() {

        ArrayList<String> body = new ArrayList<>();
        outer: while(body.size()<3) {
            ranDOM();
            for (int i = 0; i < 3; i++) {

                if(vector) {  // true-> Make Vertical body, false-> Make Horizontal body.
                    if (startRow > 69) { // Make sure DotCom in range (A,B,C,D,E,F,G) of 7x7 Grid.
                        cell = (char) (startRow - i) + Integer.toString(startColumn);
                    } else
                        cell = (char) (startRow + i) + Integer.toString(startColumn);
                }else {
                    if (startColumn > 4) { // Make sure DotCom in range (1->7) of 7x7 Grid.
                        cell = ((char) startRow + Integer.toString(startColumn - i));
                    } else
                        cell = ((char) startRow + Integer.toString(startColumn + i));
                }

                if (Store.contains(cell)) {
                    body.clear();
                    continue outer;
                } else
                    body.add(cell);
            } // close for
        }
        Store.addAll(body);
        return body;
    }

    void ranDOM() { // Tạo 1 ô ko trùng lặp các ô trước
        do {
            // Row A,B,C,D,E,F,G correspond to ASCII values bwt 65-71 range.
            Random rd = new Random();
            vector = rd.nextBoolean();
            startRow = rd.nextInt(72-65)+65; // Max: 72 is Exclusive, Min: 65 is Inclusive.
            startColumn = rd.nextInt(8-1)+1; // Max: 8 is Exclusive, Min: 1 is Inclusive.
            cell = (char) startRow + Integer.toString(startColumn);
        } while (Store.contains(cell));
    }

    public String getUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pull the trigger: ");
        return sc.nextLine().toUpperCase();
    }
}
