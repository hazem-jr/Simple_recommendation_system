package recommendationsystem;

import java.util.ArrayList;

public class Rater {

    String myId;
    ArrayList<Rating> myRatings; // for the rater's all ratings 

    Rater(String myId) {
        this.myId = myId;
        myRatings = new ArrayList<Rating>();
    }

// to create new rating and add it to myrating     
    public void addRating(String item, double rating) {

        myRatings.add(new Rating(item, rating));
    }

    public String getMyId() {
        return myId;
    }

    // check the item is exist or not 
    public boolean hasRating(String item) {
        for (int k = 0; k < myRatings.size(); k++) {
            if (myRatings.get(k).getItem().equals(item)) {
                return true;
            }   
        }
        return false;
    }

    // get the item rating  
    public double getRating(String item) {
        for (int k = 0; k < myRatings.size(); k++) {
            if (myRatings.get(k).getItem().equals(item)) {
                return myRatings.get(k).getValue();
            }
        }
        return -1;
    }

    public int getRatings() {
        return myRatings.size();
    }
    
    //return items rated 
    public ArrayList<String> getItemsRated() {
        ArrayList<String> itemsList = new ArrayList<String>();
        for (int i = 0; i < myRatings.size(); i++) {
            itemsList.add(myRatings.get(i).getItem());
        }
        return itemsList;
    }
}
