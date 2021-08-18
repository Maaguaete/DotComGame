package dotcomgameHead1stJava;

import java.util.ArrayList;

public class TerroristGame {

    private int numGuess=0;
    private ArrayList<Terrorist> terroristGang = new ArrayList<>();
    private GameHelper helper = new GameHelper();

    public static void main(String[] args){

        TerroristGame game = new TerroristGame();
        game.setUpGame();
        game.startPlaying();
        game.finishGame();

    }

    private void setUpGame(){

        Terrorist one = new Terrorist();
        Terrorist two = new Terrorist();
        Terrorist three = new Terrorist();
        one.setName("Banana_the_Stinson");
        two.setName("Taliban_the_Mindfulness");
        three.setName("Matthew_the_Rambo");
        terroristGang.add(one);
        terroristGang.add(two);
        terroristGang.add(three);

        System.out.println("""
                
                Your goal is to kill the most dangerous terrorist Gangs. Here are their Aliases:
                "Banana_the_Stinson", "Taliban_the_Mindfulness" and "Mathew_the_Rambo".
                Try to shoot them all to death in the fewest number of bullets.
                
                ------------------*** Guidance ***------------------
                The shooting area is a 7x7 grid with:
                7 rows equivalent to A, B, C, D, E, F, G characters,
                7 columns: 1, 2, 3, 4, 5, 6, 7. Ex: A1, B2, C3 ,ect.
                Don't shoot out of the square, save your bullets!
                \s""");

        for(Terrorist each: terroristGang){
            ArrayList<String> newLocation = helper.placeTerrorist();
            each.setLocationCells(newLocation);
            System.out.println(each.getLocationCells());
        }
    }

    private void startPlaying(){

        while(!terroristGang.isEmpty()){
            String userGuess = helper.getUserInput();
            checkUserGuess(userGuess);
        }
    }

    private void checkUserGuess(String userGuess)
    {
        numGuess++;
        String result = "Oops...Miss!";
        for(Terrorist each: terroristGang) { // Scan Each guy in the Gang.

            result= each.checkEach(userGuess);

            if (result.equals("Hit")) {
                break;
            }
            if (result.equals("Kill")) {
                terroristGang.remove(each);
                break;
            }
        } // close for
        if(result.equals("Oops...Miss!")) {
            System.out.println(result);
        }
    } // close method

    private void finishGame(){

        System.out.print("""
                
                -------------------- *** END GAME *** --------------------
                Those people are safe now! All of the terrorists are dead!
                You helped this area becoming peaceful again.\s
                """);
        if(numGuess<12){
            System.out.printf("Excellent shooting skill with only %d shots! Unbelievable!\n",numGuess);
        } else if(numGuess<15){
            System.out.printf("Good lads! %d shots to kill them all! Come and grab a beer!\n",numGuess);
        } else if(numGuess<17){
            System.out.printf("That's okay with %d shots! But you could try harder!\n",numGuess);
        }else
            System.out.printf("Luckily you survived! %d bullets wasted, you took total %d shots,you know?\n",
                    (numGuess-9),numGuess);
    }
}
