import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class WhereTests {
    private HUMLFramework huml = new HUMLFramework();
    
    private class Person
    {
        String name;
        int age;
        boolean married;

        Person(String name, int age, boolean married)
        {
            this.name = name;
            this.age = age;
            this.married = married;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    married == person.married &&
                    Objects.equals(name, person.name);
        }
    }

    //arrays
    @Test
    void where_with_empty_person_array_and_always_true_predicate()
    {
        Person[] input = new Person[0];
        Predicate<Person> predicate = p -> true;
        Person[] result = huml.where(input, predicate);

        Assertions.assertNull(result);
        //Assertions.assertNotEquals(result, null);
        //Assertions.assertEquals(input.length, result.length);
    }

    @Test
    void where_with_person_array_and_always_true_predicate()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);

        Person[] input = {p1, p2};
        Predicate<Person> predicate = p -> true;
        Person[] result = huml.where(input, predicate);
        Assertions.assertEquals(input.length, result.length);
    }

    @Test
    void where_with_person_array_and_filtering_predicate()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Predicate<Person> predicate = p -> !p.married;
        Person[] result = huml.where(input, predicate);
        
        Assertions.assertEquals(input[0], result[0]);
        Assertions.assertEquals(input[2], result[1]);
    }
    
    @Test
    void where_with_person_array_and_always_true_predicate_retains_order()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Predicate<Person> predicate = p -> true;
        Person[] result = huml.where(input, predicate);
        Assertions.assertEquals(input[0], result[0]);
        Assertions.assertEquals(input[1], result[1]);
        Assertions.assertEquals(input[2], result[2]);
    }
    
    
    //lists
    @Test
    void where_with_empty_person_list_and_always_true_predicate()
    {
        List<Person> input = new ArrayList<>();
        Predicate<Person> predicate = p -> true;
        Person[] result = huml.where(input, predicate);

        Assertions.assertNull(result);
        //Assertions.assertEquals(input.size(), result.length);
    }

    @Test
    void where_with_person_list_and_always_true_predicate()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2));
        Predicate<Person> predicate = p -> true;
        Person[] result = huml.where(input, predicate);
        Assertions.assertEquals(input.size(), result.length);
    }

    @Test
    void where_with_person_list_and_filtering_predicate()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Predicate<Person> predicate = p -> !p.married;
        Person[] result = huml.where(input, predicate);
        
        Assertions.assertEquals(input.get(0), result[0]);
        Assertions.assertEquals(input.get(2), result[1]);
    }
    
    @Test
    void where_with_person_list_and_always_true_predicate_retains_order()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Predicate<Person> predicate = p -> true;
        Person[] result = huml.where(input, predicate);
        Assertions.assertEquals(input.get(0), result[0]);
        Assertions.assertEquals(input.get(1), result[1]);
        Assertions.assertEquals(input.get(2), result[2]);
    }
}
