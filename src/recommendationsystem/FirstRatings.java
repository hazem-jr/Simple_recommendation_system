package recommendationsystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVReader;

public class FirstRatings {

    /*
    //  Method to load CSV file of movies  
    public ArrayList<Movie> loadMovies(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Movie> Movies = new ArrayList();
        // Start reading from line number 2 
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
        //Read the file lines 
//        String[] records = null;
        Movies = (ArrayList<Movie>) reader.readAll();
//        while ((records = reader.readNext()) != null) {
//            if (records != null) {
//                Movies.add((Movie) Arrays.asList(records));
//            }
//        }

        return Movies;
    }
     */
// I changed this method to arraylist<String[]> becouse of the runtime error 

    public ArrayList<String[]> loadMovies(String fileName) throws FileNotFoundException, IOException {
        ArrayList<String[]> Movies = new ArrayList();
        // Start reading from line number 2 
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
        Movies = (ArrayList<String[]>) reader.readAll();

        return Movies;
    }

    // to load raters file  
    public ArrayList<String[]> loadRaters(String fileName) throws FileNotFoundException, IOException {
        ArrayList<String[]> Raters = new ArrayList();
        // Start reading from line number 2 
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
        Raters = (ArrayList<String[]>) reader.readAll();

        return Raters;
    }

    public void testLoadMovies() throws IOException {
        // ArrayList<Movie> moviesList = new ArrayList<Movie>();
        //Local Declarations 
        ArrayList<String[]> moviesList = new ArrayList<>();
        String[] rowData;

        int comedyCount = 0, timeCount = 0;

        String dirName = "", mostDir = "";
        int filmsCount = 0, mostCount = 0;

        moviesList = loadMovies("H:\\java\\Java course coursera\\StepOneStarterProgram\\data\\ratedmoviesfull.csv");
        System.out.println(moviesList.size());

        for (String[] Row : moviesList) {
//            System.out.println(Arrays.toString(Row))  
            rowData = Row;
            if (rowData[4].contains("Comedy")) {
                comedyCount++;
            }
            if (Integer.parseInt(rowData[6]) > 150) {   //  films time 
                timeCount++;
            }
            // calculate the most number of films by one director 
            dirName = rowData[5];
            for (String[] find : moviesList) {
                if (dirName.equals(find[5])) {
                    filmsCount++;
                }
            }
            if (filmsCount > mostCount) {
                mostCount = filmsCount;
                mostDir = dirName;
            }
            filmsCount = 0;
            dirName = "";
        }

        System.out.println("Comedy Count = " + comedyCount);
        System.out.println("Films more than 150 Count = " + timeCount);
        System.out.println("Direcor direct most number of films = " + mostDir + " No of films = " + mostCount);

    }

    public void testLoadRaters() throws IOException {
//        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        ArrayList<String[]> ratersList = new ArrayList<>();
        int rater193 = 0, movie1798709 = 0;
        String raterID = "", mostRater = "";
        int ratingCount = 0, mostCount = 0;

        ratersList = loadRaters("H:\\java\\Java course coursera\\StepOneStarterProgram\\data\\ratings.csv");
        System.out.println(ratersList.size());
        Rating rating1;
        Rater rater1;
        for (String[] Row : ratersList) {
            //System.out.println(Arrays.toString(Row));
            if (Row[0].equals("193")) {
                rater193++;
            }
            if (Row[1].equals("1798709")) {
                movie1798709++;
            }

            rating1 = new Rating(Row[1], Double.parseDouble(Row[2])); // add item with its rate 
//            System.out.println(rating1.toString());
            rater1 = new Rater(Row[0]);                              // rater id 
            rater1.addRating(Row[1], Double.parseDouble(Row[2]));

            // calculate the most number of films by one director 
            raterID = Row[0];
            for (String[] find : ratersList) {
                if (raterID.equals(find[0])) {
                    ratingCount++;
                }
            }
            if (ratingCount > mostCount) {
                mostCount = ratingCount;
                mostRater = raterID;
            }
            ratingCount = 0;
            raterID = "";

        }
        System.out.println("rater - 193 all ratings  =  " + rater193);
        System.out.println("movie - 1798709 all ratings  =  " + movie1798709);
        System.out.println("Rater gives most number of ratings = " + mostRater + " No of films = " + mostCount);

    }
}
