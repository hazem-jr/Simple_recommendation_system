
package recommendationsystem;

import java.io.IOException;


public class MovieRunnerAverage {
    public void printAverageRatings() throws IOException{
        
        SecondRatings SR = new SecondRatings() ;
        System.out.println(SR.getMovieSize()); 
        System.out.println(SR.getRaterSize()) ;
    } 
}
