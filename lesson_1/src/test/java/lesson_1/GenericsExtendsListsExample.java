package lesson_1;

import lesson_1.animals.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsExtendsListsExample {

    List<? extends Mammal> extendsMammalMammal = new ArrayList<Mammal>();
    List<? extends Mammal> extendsMammalDog = new ArrayList<Dog>();
    List<? extends Mammal> extendsMammalGreyhound = new ArrayList<Greyhound>();
    List<? extends Mammal> extendsMammalLabrador = new ArrayList<Labrador>();

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
    public void testExtendsDog(){
//        extendsMammalMammal.add();
        Mammal mammal = extendsMammalMammal.get(0);
        Animal animal = extendsMammalMammal.get(0);
        Labrador labrador = (Labrador) extendsMammalMammal.get(0);

    }

}
