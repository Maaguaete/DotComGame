package dotcomgameHead1stJava;

import java.util.ArrayList;

public class Terrorist {

    private ArrayList<String> locationCells = new ArrayList<>(3);
    private String name;

    public void setLocationCells(ArrayList<String> loc){
        this.locationCells = loc;
    }

    public void setName(String n){
        name = n;
    }

    ArrayList<String> getLocationCells(){
        return locationCells;
    }

    public String checkEach(String userGuess){

        String result = "Oops...Miss!";
        int index = locationCells.indexOf(userGuess);
        // index = -1 when there's no userGuess in locationCells ArrayList.
        if(index >=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "Kill";
                System.out.println(name+" is a death corpse now! ");
            } else {
                result = "Hit";
                System.out.println(result+" "+name);
            }
        } // close if

        return result;
    } // close method checkEach()

}

