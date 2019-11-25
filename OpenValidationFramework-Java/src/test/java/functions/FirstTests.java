package functions;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;


public class FirstTests {
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
    void first_with_string_array()
    {
        String[] input = {"Harry", "Hermione", "Ron"};
        String result = huml.FIRST(input);
        Assertions.assertEquals("Harry", result);
    }

    @Test
    void first_with_person_array_and_function()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);

        Person[] input = {p1, p2};
        Function<Person, Boolean> function = p -> p.married;
        boolean result = huml.FIRST(input, function);
        Assertions.assertFalse(result);
    }

    @Test
    void first_with_person_array_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.FIRST(input, 2);
        Assertions.assertEquals(result[0], p1);
        Assertions.assertEquals(result[1], p2);
    }
    
    @Test
    void first_with_person_array_and_function_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Function<Person, Integer> function = p -> p.age;
        Integer[] result = huml.FIRST(input, function, 2);
        Assertions.assertEquals(result[0], 24);
        Assertions.assertEquals(result[1], 42);
    }
    //array edge cases
    @Test
    void first_with_person_array_and_amount_that_is_bigger_than_the_array_size()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.FIRST(input, 4);
        Assertions.assertEquals(3, result.length);
    }


    @Test
    void first_with_person_array_and_amount_that_is_zero()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.FIRST(input, 0);
        Assertions.assertNull(result);
    }

    @Test
    void first_with_person_array_and_amount_that_is_negative()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.FIRST(input, -1);
        Assertions.assertNull(result);
    }

    //lists
    @Test
    void first_with_string_list()
    {
        List<String> input = new ArrayList<>(Arrays.asList("Harry", "Hermione", "Ron"));
        String result = huml.FIRST(input);
        Assertions.assertEquals("Harry", result);
    }

    @Test
    void first_with_person_list_and_function()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2));
        Function<Person, Boolean> function = p -> p.married;
        boolean result = huml.FIRST(input, function);
        Assertions.assertEquals(false, result);
    }

    @Test
    void first_with_person_list_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Person[] result = huml.FIRST(input, 2);
        Assertions.assertEquals(result[0], p1);
        Assertions.assertEquals(result[1], p2);
    }

    @Test
    void first_with_person_list_and_function_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Function<Person, Integer> function = p -> p.age;
        Integer[] result = huml.FIRST(input, function, 2);
        Assertions.assertEquals(result[0], 24);
        Assertions.assertEquals(result[1], 42);
    }
    
    @Test
    void first_with_int_list()
    {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        
        Integer[] res = huml.FIRST(input, 2);
        
        Assertions.assertEquals(res.length, 2);
        Assertions.assertEquals(res[0], 1);
        Assertions.assertEquals(res[1], 2);
    }

    @Test
    void first_with_int_array()
    {
        Integer[] input = new Integer[]{1,2,3};

        Integer[] res = huml.FIRST(input, 2);

        Assertions.assertEquals(res.length, 2);
        Assertions.assertEquals(res[0], 1);
        Assertions.assertEquals(res[1], 2);
    }

}
