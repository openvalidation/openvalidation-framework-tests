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
    
    //region List as Object
    @Test
    void last_int_list_as_object()
    {
        Object input = new ArrayList<Integer>();
        ((List<Integer>)input).add(1);
        ((List<Integer>)input).add(2);
        ((List<Integer>)input).add(3);

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Integer);
        Assertions.assertEquals((Integer)res, 3);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_int_list_as_object_with_amount()
    {
        Object input = new ArrayList<Integer>();
        ((List<Integer>)input).add(1);
        ((List<Integer>)input).add(2);
        ((List<Integer>)input).add(3);

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Integer[]);
        Assertions.assertEquals(((Integer[])res).length, 2);
        Assertions.assertEquals(((Integer[])res)[0], 2);
        Assertions.assertEquals(((Integer[])res)[1], 3);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_byte_list_as_object()
    {
        Object input = new ArrayList<Byte>();
        ((List<Byte>)input).add(Byte.valueOf("1"));
        ((List<Byte>)input).add(Byte.valueOf("2"));
        ((List<Byte>)input).add(Byte.valueOf("3"));

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Byte);
        Assertions.assertEquals((Byte)res, Byte.valueOf("3"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_byte_list_as_object_with_amount()
    {
        Object input = new ArrayList<Byte>();
        ((List<Byte>)input).add(Byte.valueOf("1"));
        ((List<Byte>)input).add(Byte.valueOf("2"));
        ((List<Byte>)input).add(Byte.valueOf("3"));

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Byte[]);
        Assertions.assertEquals(((Byte[])res).length, 2);
        Assertions.assertEquals(((Byte[])res)[0], Byte.valueOf("2"));
        Assertions.assertEquals(((Byte[])res)[1], Byte.valueOf("3"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_short_list_as_object()
    {
        Object input = new ArrayList<Short>();
        ((List<Short>)input).add(Short.valueOf("1"));
        ((List<Short>)input).add(Short.valueOf("2"));
        ((List<Short>)input).add(Short.valueOf("3"));

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Short);
        Assertions.assertEquals((Short)res, Short.valueOf("3"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_short_list_as_object_with_amount()
    {
        Object input = new ArrayList<Short>();
        ((List<Short>)input).add(Short.valueOf("1"));
        ((List<Short>)input).add(Short.valueOf("2"));
        ((List<Short>)input).add(Short.valueOf("3"));

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Short[]);
        Assertions.assertEquals(((Short[])res).length, 2);
        Assertions.assertEquals(((Short[])res)[0], Short.valueOf("2"));
        Assertions.assertEquals(((Short[])res)[1], Short.valueOf("3"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_long_list_as_object()
    {
        Object input = new ArrayList<Long>();
        ((List<Long>)input).add(1L);
        ((List<Long>)input).add(2L);
        ((List<Long>)input).add(3L);

        Object res = huml.LAST(input);


        Assertions.assertTrue(res instanceof Long);
        Assertions.assertEquals((Long)res, 3L);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_long_list_as_object_with_amount()
    {
        Object input = new ArrayList<Long>();
        ((List<Long>)input).add(1L);
        ((List<Long>)input).add(2L);
        ((List<Long>)input).add(3L);

        Object res = huml.LAST(input, 2);


        Assertions.assertTrue(res instanceof Long[]);
        Assertions.assertEquals(((Long[])res).length, 2);
        Assertions.assertEquals(((Long[])res)[0], 2L);
        Assertions.assertEquals(((Long[])res)[1], 3L);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_float_list_as_object()
    {
        Object input = new ArrayList<Float>();
        ((List<Float>)input).add(1f);
        ((List<Float>)input).add(2f);
        ((List<Float>)input).add(3f);

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Float);
        Assertions.assertEquals((Float)res, 3f);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_float_list_as_object_with_amount()
    {
        Object input = new ArrayList<Float>();
        ((List<Float>)input).add(1f);
        ((List<Float>)input).add(2f);
        ((List<Float>)input).add(3f);

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Float[]);
        Assertions.assertEquals(((Float[])res).length, 2);
        Assertions.assertEquals(((Float[])res)[0], 2f);
        Assertions.assertEquals(((Float[])res)[1], 3f);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_double_list_as_object()
    {
        Object input = new ArrayList<Double>();
        ((List<Double>)input).add(1d);
        ((List<Double>)input).add(2d);
        ((List<Double>)input).add(3d);

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Double);
        Assertions.assertEquals((Double)res, 3d);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_double_list_as_object_with_amount()
    {
        Object input = new ArrayList<Double>();
        ((List<Double>)input).add(1d);
        ((List<Double>)input).add(2d);
        ((List<Double>)input).add(3d);

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Double[]);
        Assertions.assertEquals(((Double[])res).length, 2);
        Assertions.assertEquals(((Double[])res)[0], 2d);
        Assertions.assertEquals(((Double[])res)[1], 3d);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_char_list_as_object()
    {
        Object input = new ArrayList<Character>();
        ((List<Character>)input).add('a');
        ((List<Character>)input).add('b');
        ((List<Character>)input).add('c');

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Character);
        Assertions.assertEquals((Character)res, 'c');
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_char_list_as_object_with_amount()
    {
        Object input = new ArrayList<Character>();
        ((List<Character>)input).add('a');
        ((List<Character>)input).add('b');
        ((List<Character>)input).add('c');

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Character[]);
        Assertions.assertEquals(((Character[])res).length, 2);
        Assertions.assertEquals(((Character[])res)[0], 'b');
        Assertions.assertEquals(((Character[])res)[1], 'c');
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_boolean_list_as_object()
    {
        Object input = new ArrayList<Boolean>();
        ((List<Boolean>)input).add(true);
        ((List<Boolean>)input).add(false);
        ((List<Boolean>)input).add(false);

        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Boolean);
        Assertions.assertEquals(res, false);
    }

    @SuppressWarnings("unchecked")
    @Test
    void last_boolean_list_as_object_with_amount()
    {
        Object input = new ArrayList<Boolean>();
        ((List<Boolean>)input).add(true);
        ((List<Boolean>)input).add(false);
        ((List<Boolean>)input).add(false);

        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Boolean[]);
        Assertions.assertEquals(((Boolean[])res).length, 2);
        Assertions.assertEquals(((Boolean[])res)[0], false);
        Assertions.assertEquals(((Boolean[])res)[1], false);
    }
    //endregion

    //region primitive arrays
    @Test
    void last_primitive_boolean_array_as_object()
    {
        Object input = new boolean[]{true,true,false};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Boolean);
        Assertions.assertEquals(res, false);
    }

    @Test
    void last_primitive_boolean_array_as_object_with_amount()
    {
        Object input = new boolean[]{true,true,false};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Boolean[]);
        Assertions.assertEquals(((Boolean[])res).length, 2);
        Assertions.assertEquals(((Boolean[])res)[0], true);
        Assertions.assertEquals(((Boolean[])res)[1], false);
    }

    @Test
    void last_primitive_byte_array_as_object()
    {
        Object input = new byte[]{1,2,3};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Byte);
        Assertions.assertEquals((Byte)res, Byte.valueOf("3"));
    }

    @Test
    void last_primitive_byte_array_as_object_with_amount()
    {
        Object input = new byte[]{1,2,3};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Byte[]);
        Assertions.assertEquals(((Byte[])res).length, 2);
        Assertions.assertEquals(((Byte[])res)[0], Byte.valueOf("2"));
        Assertions.assertEquals(((Byte[])res)[1], Byte.valueOf("3"));
    }

    @Test
    void last_primitive_short_array_as_object()
    {
        Object input = new short[]{1,2,3};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Short);
        Assertions.assertEquals((Short)res, Short.valueOf("3"));
    }

    @Test
    void last_primitive_short_array_as_object_with_amount()
    {
        Object input = new short[]{1,2,3};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Short[]);
        Assertions.assertEquals(((Short[])res).length, 2);
        Assertions.assertEquals(((Short[])res)[0], Short.valueOf("2"));
        Assertions.assertEquals(((Short[])res)[1], Short.valueOf("3"));
    }

    @Test
    void last_primitive_int_array_as_object()
    {
        Object input = new int[]{1,2,3};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Integer);
        Assertions.assertEquals((Integer)res, 3);
    }

    @Test
    void last_primitive_int_array_as_object_with_amount()
    {
        Object input = new int[]{1,2,3};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Integer[]);
        Assertions.assertEquals(((Integer[])res).length, 2);
        Assertions.assertEquals(((Integer[])res)[0], 2);
        Assertions.assertEquals(((Integer[])res)[1], 3);
    }

    @Test
    void last_primitive_long_array_as_object()
    {
        Object input = new long[]{1L, 2L, 3L};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Long);
        Assertions.assertEquals((Long)res, 3L);
    }

    @Test
    void last_primitive_long_array_as_object_with_amount()
    {
        Object input = new long[]{1L, 2L, 3L};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Long[]);
        Assertions.assertEquals(((Long[])res).length, 2);
        Assertions.assertEquals(((Long[])res)[0], 2L);
        Assertions.assertEquals(((Long[])res)[1], 3L);
    }

    @Test
    void last_primitive_float_array_as_object()
    {
        Object input = new float[]{1f,2f,3f};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Float);
        Assertions.assertEquals((Float)res, 3f);
    }

    @Test
    void last_primitive_float_array_as_object_with_amount()
    {
        Object input = new float[]{1f,2f,3f};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Float[]);
        Assertions.assertEquals(((Float[])res).length, 2);
        Assertions.assertEquals(((Float[])res)[0], 2f);
        Assertions.assertEquals(((Float[])res)[1], 3f);
    }

    @Test
    void last_primitive_double_array_as_object()
    {
        Object input = new double[]{1d,2d,3d};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Double);
        Assertions.assertEquals((Double)res, 3d);
    }

    @Test
    void last_primitive_double_array_as_object_with_amount()
    {
        Object input = new double[]{1d,2d,3d};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Double[]);
        Assertions.assertEquals(((Double[])res).length, 2);
        Assertions.assertEquals(((Double[])res)[0], 2d);
        Assertions.assertEquals(((Double[])res)[1], 3d);
    }

    @Test
    void last_primitive_char_array_as_object()
    {
        Object input = new char[]{'a','b','c'};
        Object res = huml.LAST(input);

        Assertions.assertTrue(res instanceof Character);
        Assertions.assertEquals((Character) res, 'c');
    }

    @Test
    void last_primitive_char_array_as_object_with_amount()
    {
        Object input = new char[]{'a','b','c'};
        Object res = huml.LAST(input, 2);

        Assertions.assertTrue(res instanceof Character[]);
        Assertions.assertEquals(((Character[])res).length, 2);
        Assertions.assertEquals(((Character[])res)[0], 'b');
        Assertions.assertEquals(((Character[])res)[1], 'c');
    }
    //endregion
}
