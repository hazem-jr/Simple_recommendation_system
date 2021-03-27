package recommendationsystem;

public class Rating {

    private String item; // item being rating 
    private double value; // the item rating value 

    public Rating(String item, double value) {
        this.item = item;
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public double getValue() {
        return value;
    }

    // Returns a string of all the rating information
    public String toString() {
        return "[" + getItem() + ", " + getValue() + "]";
    }

    // Compare this rating vaue with another 
    public int compareTo(Rating another_Rating) {
        if (value < another_Rating.value) {
            return -1;
        } else if (value > another_Rating.value) {
            return 1;
        }

        return 0;
    }
}
