package ch6.mathandlogic.implementations;

import java.util.Random;

/**
 * In the new post-apocalyptic world, the world queen is desperately concerned about the birth rate. Therefore,
 * she decrees that all families should ensure that they have one girl or else they face massive fines. If all families
 * abide by this policy-that is, they have continue to have children until they have one girl, at which point they
 * immediately stop-what will the gender ratio of the new generation be? (Assume that the odds of someone having a boy or
 * a girl on any given pregnancy is equal.) Solve this out logically and then write a computer simulation of it.
 * 
 * @author Aditya Srinivasan
 *
 */
public class TheApocalypse {
    
    public static void sim(double pg, double pb, int iter) {
        if((pg + pb) != 1 || pg < 0 || pb < 0 || pg > 1 || pb > 1) {
            throw new IllegalArgumentException("Probabilities must be in range (0, 1) and exhaustive.");
        }
        Random r = new Random();
        long numGirls = 0;
        long numBoys = 0;
        for(int i = 0; i < iter; i++) {
            for(;;) {
                double random = r.nextDouble();
                if(0 < random && random < pg) {
                    numGirls++;
                    break;
                } else {
                    numBoys++;
                }
            }
        }
        System.out.println(String.format("Number of girls: %d\nNumber of boys:  %d\nRatio (b:g):     %f", numGirls, numBoys, ((double)numBoys)/numGirls));
    }

    public static void main(String[] args) {
        sim(0.67, 0.33, 100000);
    }
    
}
