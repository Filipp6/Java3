package lesson_1;

import lesson_1.animals.Animal;
import lesson_1.animals.Dog;
import lesson_1.animals.Mammal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsSuperListsExample {

    List<? super Mammal> superMammalMammal = new ArrayList<Mammal>();
    List<? super Mammal> superMammalAnimal = new ArrayList<Animal>();
    List<? super Mammal> superMammalObject = new ArrayList<Object>();

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
    public void testSuperDog(){
        superMammalMammal.add(new Dog());
        Object object = superMammalMammal.get(0);

        Animal animal = (Animal) superMammalMammal.get(0);


    }

}
