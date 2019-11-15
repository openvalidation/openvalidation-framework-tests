package functions;

import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class LastTests {
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
    void last_with_string_array()
    {
        String[] input = {"Harry", "Hermione", "Ron"};
        String result = huml.LAST(input);
        Assertions.assertEquals("Ron", result);
    }

    @Test
    void last_with_person_array_and_function()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);

        Person[] input = {p1, p2};
        Function<Person, Boolean> function = p -> p.married;
        boolean result = huml.LAST(input, function);
        Assertions.assertTrue(result);
    }

    @Test
    void last_with_person_array_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.LAST(input, 2);
        Assertions.assertEquals(result[0], p2);
        Assertions.assertEquals(result[1], p3);
    }
    
    @Test
    void last_with_person_array_and_function_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Function<Person, Integer> function = p -> p.age;
        Integer[] result = huml.LAST(input, function, 2);
        Assertions.assertEquals(result[0], 42);
        Assertions.assertEquals(result[1], 38);
    }
    //array edge cases
    @Test
    void last_with_person_array_and_amount_that_is_bigger_than_the_array_size()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.LAST(input, 4);
        Assertions.assertEquals(3, result.length);
    }

    @Test
    void last_with_person_array_and_amount_that_is_zero()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.LAST(input, 0);
        Assertions.assertNull(result);
    }

    @Test
    void last_with_person_array_and_amount_that_is_negative()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Person[] result = huml.LAST(input, -1);
        Assertions.assertNull(result);
    }

    //lists
    @Test
    void last_with_string_list()
    {
        List<String> input = new ArrayList<>(Arrays.asList("Harry", "Hermione", "Ron"));
        String result = huml.LAST(input);
        Assertions.assertEquals("Ron", result);
    }

    @Test
    void last_with_person_list_and_function()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2));
        Function<Person, Boolean> function = p -> p.married;
        boolean result = huml.LAST(input, function);
        Assertions.assertTrue(result);
    }

    @Test
    void last_with_person_list_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Person[] result = huml.LAST(input, 2);
        Assertions.assertEquals(result[0], p2);
        Assertions.assertEquals(result[1], p3);
    }

    @Test
    void last_with_person_list_and_function_and_amount()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Function<Person, Integer> function = p -> p.age;
        Integer[] result = huml.LAST(input, function, 2);
        Assertions.assertEquals(result[0], 42);
        Assertions.assertEquals(result[1], 38);
    }
}
