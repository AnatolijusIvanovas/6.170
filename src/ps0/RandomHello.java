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
        String[] greetings = new String[5];
        greetings[0] = "Hello World";
        greetings[1] = "Hola Mundo";
        greetings[2] = "Bonjour Monde";
        greetings[3] = "Hallo Welt";
        greetings[4] = "Ciao Mondo";
        return greetings[randomGenerator.nextInt(5)];
    }

}