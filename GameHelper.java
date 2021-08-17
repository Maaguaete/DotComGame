package dotcomgameHead1stJava;

import java.util.ArrayList;

public class GameHelper {

    ArrayList< ArrayList<String> > DotCom = new ArrayList<>();
    ArrayList<String> Thao = new ArrayList<>();
    ArrayList<String> Nhan = new ArrayList<>();
    ArrayList<String> Huy = new ArrayList<>();
    ArrayList<String> Store = new ArrayList<>(); // make a Storage to check duplicated DotCom
    int startRow, startColumn;
    String cell;

    void setUpGame() {

        DotCom.add(Thao);
        DotCom.add(Nhan);
        DotCom.add(Huy);
        createBody();
        System.out.println(Thao+"\n"+Nhan+"\n"+Huy);
    }

    void ranDOM(){ // Tạo 1 ô ko trùng lặp các ô trước
        do {
            // Row A,B,C,D,E,F,G correspond to ASCII value bwt 65-71 range.
            startRow = (int) (Math.random() * (72 - 65) + 65); // random in range (not include max:72)
            startColumn = (int) (Math.random() * 7 + 1);
            cell = (char) startRow + Integer.toString(startColumn);
        }while (Store.contains(cell));
    }

    void createBody() {
        // Thao hitPoints
        ranDOM();
        for (int i = 0; i < 3; i++) {
            if (startRow > 69) { // Make sure DotCom in range (A,B,C,D,E,F,G) of 7x7 Grid.
                // Create this Object VERTICALLY.
                cell = (char) (startRow - i) + Integer.toString(startColumn);
            } else
                cell = (char) (startRow + i) + Integer.toString(startColumn);
            Thao.add(cell);
        }
        Store.addAll(Thao);

        // Nhan hitPoints
        outer: while(Nhan.size()<3) { // Loop until full-fill 1 DotCom.

            ranDOM();
            for (int i = 0; i < 3; i++) {
                // Create this Object HORIZONTALLY.
                if (startColumn > 4) { // Make sure DotCom in range (1->7) of 7x7 Grid.
                    cell = ((char) startRow + Integer.toString(startColumn - i));
                } else
                    cell = ((char) startRow + Integer.toString(startColumn + i));
                if (Store.contains(cell)) { // check duplicated cell of above.
                    Store.removeAll(Nhan); // Remove this object in Storage ArrayList.
                    Nhan.clear();
                    continue outer;
                } else
                    Nhan.add(cell);
            }
        }
        Store.addAll(Nhan);

        //Huy hitPoints
        outer2: while(Huy.size()<3) {
            ranDOM();
            for (int i = 0; i < 3; i++) {

                if (startColumn > 4) {
                    cell = ((char) startRow + Integer.toString(startColumn - i));
                } else
                    cell = ((char) startRow + Integer.toString(startColumn + i));

                if (Store.contains(cell)) {
                    Store.removeAll(Huy);
                    Huy.clear();
                    continue outer2;
                } else
                    Huy.add(cell);
            }
        }
    }

}

