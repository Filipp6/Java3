package lesson_1;

import lesson_1.animals.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyGenericsTest {

            /*
            Object
              |
            Animal
              |
            Mammal
              |
             Dog
          /        \
          |        |
    Greyhound     Labrador
             */


    @Test
    public void testCopy(){

//        List<? extends Dog> src = new ArrayList<Greyhound>();
//        List<? super Mammal> dest = new ArrayList<Animal>();

//        Collections.copy(dest, src);

        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
//        mammals.add(new Dog());

        Collections.copy(animals, dogs);


    }
}
