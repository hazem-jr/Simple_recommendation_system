package recommendationsystem;
// class to make caculations f movies ratings like averge rating ..etc 

import java.io.IOException;
import java.util.ArrayList;

public class SecondRatings {

    private ArrayList<String[]> myMovies;
    private ArrayList<String[]> myRaters;

    public SecondRatings() throws IOException {
        // default constructor
        this("H:\\java\\Java course coursera\\StepOneStarterProgram\\data\\ratedmovies_short.csv", "H:\\java\\Java course coursera\\StepOneStarterProgram\\data\\ratings_short.csv");
    }

    public SecondRatings(String moviefile, String ratingsfile) throws IOException {

        FirstRatings FR = new FirstRatings();
        myMovies = FR.loadMovies(moviefile);
        myRaters = FR.loadRaters(ratingsfile);

    }

    public int getMovieSize() {
        return myMovies.size();
    }

    public int getRaterSize() {
        return myRaters.size();
    }

// this methos returns the average movie rating for 
//this ID if there are at least minimalRaters ratings    
    private double getAverageByID(String ID, int minimalRaters) {
        int ratingSum = 0, ratingNum = 0;

        for (String[] row : myRaters) {
            if (row[1].equals(ID)) {
                ratingNum++;
                ratingSum += Integer.parseInt(row[2]);
            }
        }
        if (ratingNum >= minimalRaters) {
           return (ratingSum / ratingNum) ;
        }
        return 0.0 ;
    }
}
