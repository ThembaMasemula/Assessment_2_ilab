package PageObjects;

import java.io.PrintStream;
import java.util.Random;

public class RandomNum {

    public class RandomPhoneNumGenerator {

        
        public static void randomGen(){

            
            Random rand = new Random ();

            PrintStream rn = System.out.printf("%d%d%d %03d %04d", rand.nextInt(0), rand.nextInt(8), rand.nextInt(8), rand.nextInt(8), rand.nextInt(656), rand.nextInt(10000));


        }
    }
}
