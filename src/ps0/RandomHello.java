package ps0;

import java.util.Random;

/**
 * RandomHello selects a random greeting to display to the user.
 */
public class RandomHello {

    /**
     * @effects uses a RandomHello object to print a random greeting to the console
     */
    public static void main(String args) {
        RandomHello randomHello = new RandomHello();
        System.out.println(randomHello.sayHello());
    }

    /**
     * @return a random greeting from a list of five different greetings.
     */
    public String sayHello() {
        Random randomGenerator = new Random();
        return "";
    }

}