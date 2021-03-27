package recommendationsystem;

import java.io.IOException;

public class RecommendationSystem {

    public static void main(String[] args) throws IOException {
    FirstRatings first = new FirstRatings() ;
//    first.testLoadMovies();
//    first.testLoadRaters();
    MovieRunnerAverage MRA =  new MovieRunnerAverage() ;
    MRA.printAverageRatings();
    
    System.out.println(-32 % 26) ;

    }
    
}
