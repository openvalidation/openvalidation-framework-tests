import org.bag.openvalidation.HUMLFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class GetArrayOfTests {
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

    @Test
    void get_array_of_with_empty_person_array_mapped_to_age()
    {
        Person[] input = new Person[0];
        Function<Person, Integer> mapper = p -> p.age;
        Integer[] result = huml.getArrayOf(input, mapper);

        Assertions.assertNull(result);
    }

    @Test
    void get_array_of_with_person_array_mapped_to_age()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        Person[] input = {p1, p2, p3};
        Function<Person, Integer> mapper = p -> p.age;
        Integer[] result = huml.getArrayOf(input, mapper);

        Assertions.assertEquals(24, result[0]);
        Assertions.assertEquals(42, result[1]);
        Assertions.assertEquals(38, result[2]);
    }
    
    @Test
    void get_array_of_with_empty_person_list_mapped_to_age()
    {
        List<Person> input = new ArrayList<>();
        Function<Person, Integer> mapper = p -> p.age;
        Integer[] result = huml.getArrayOf(input, mapper);

        Assertions.assertNull(result);
    }

    @Test
    void get_array_of_with_person_list_mapped_to_age()
    {
        Person p1 = new Person("Bob", 24, false);
        Person p2 = new Person("Ross", 42, true);
        Person p3 = new Person("Batman", 38, false);

        List<Person> input = new ArrayList<>(Arrays.asList(p1, p2, p3));
        Function<Person, Integer> mapper = p -> p.age;
        Integer[] result = huml.getArrayOf(input, mapper);

        Assertions.assertEquals(24, result[0]);
        Assertions.assertEquals(42, result[1]);
        Assertions.assertEquals(38, result[2]);
    }
}
