using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenValidationFramework_CSharp;
using OpenValidationFramework_CSharp.Model;

namespace FrameworkTests.Functions
{
    [TestClass]
    public class LastTests
    {
        private HUMLFramework _huml = new HUMLFramework();

        [TestMethod]
        public void Last_numbersInList_1()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() {1, 2, 3, 4, 5, 6};

            Assert.AreEqual(huml.LAST(nums, 1).Length, 1);
            Assert.AreEqual(huml.LAST(nums, 1).FirstOrDefault(), 6);
        }

        [TestMethod]
        public void Last_numbersInList_3()
        {
            HUMLFramework huml = new HUMLFramework();
            List<int> nums = new List<int>() {1, 2, 3, 4, 5, 6};

            Assert.AreEqual(huml.LAST(nums, 3).Length, 3);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(0), 4);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(1), 5);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(2), 6);
        }

        [TestMethod]
        public void LAST_numbersInArray_3()
        {
            HUMLFramework huml = new HUMLFramework();
            int[] nums = new int[] {1, 2, 3, 4, 5, 6};

            Assert.AreEqual(huml.LAST(nums, 3).Length, 3);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(0), 4);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(1), 5);
            Assert.AreEqual(huml.LAST(nums, 3).ElementAt(2), 6);
        }

        [TestMethod]
        public void last_with_string_array()
        {
            string[] input = {"Peter", "Paul", "Marry"};
            string result = _huml.LAST(input);
            Assert.AreEqual("Marry", result);
        }

        [TestMethod]
        public void last_with_person_array_and_function()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);

            Person[] input = {p1, p2};
            Func<Person, Boolean> func = p => p.married;
            Person result = _huml.LAST(input, func);
            Assert.AreEqual(p2, result);
        }

        [TestMethod]
        public void last_with_person_array_and_amount()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);
            Person p3 = new Person("Batman", 38, false);

            Person[] input = {p1, p2, p3};
            Person[] result = _huml.LAST(input, 2);
            Assert.AreEqual(result[0], p2);
            Assert.AreEqual(result[1], p3);
        }

        //array edge cases
        [TestMethod]
        public void last_with_person_array_and_amount_that_is_bigger_than_the_array_size()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);
            Person p3 = new Person("Batman", 38, false);

            Person[] input = {p1, p2, p3};
            Person[] result = _huml.LAST(input, 4);
            Assert.AreEqual(3, result.Length);
        }

        [TestMethod]
        public void last_with_person_array_and_amount_that_is_zero()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);
            Person p3 = new Person("Batman", 38, false);

            Person[] input = {p1, p2, p3};
            Person[] result = _huml.LAST(input, 0);
            Assert.IsNotNull(result);
        }

        [TestMethod]
        public void last_with_person_array_and_amount_that_is_negative()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);
            Person p3 = new Person("Batman", 38, false);

            Person[] input = {p1, p2, p3};
            Person[] result = _huml.LAST(input, -1);
            Assert.IsNotNull(result);
        }

        //lists
        [TestMethod]
        public void last_with_string_list()
        {
            List<string> input = new List<string>()
            {
                "Harry", "Hermione", "Ron"
            };
            String result = _huml.LAST(input);
            Assert.AreEqual("Ron", result);
        }

        [TestMethod]
        public void last_with_person_list_and_function()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);

            List<Person> input = new List<Person>() {p1, p2};
            Func<Person, Boolean> function = p => p.married;
            Person result = _huml.LAST(input, function);
            Assert.AreEqual(result, p2);
        }

        [TestMethod]
        public void last_with_person_list_and_amount()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);
            Person p3 = new Person("Batman", 38, false);

            List<Person> input = new List<Person>() {p1, p2, p3};
            Person[] result = _huml.LAST(input, 2);
            Assert.AreEqual(result[0], p2);
            Assert.AreEqual(result[1], p3);
        }

        [TestMethod]
        public void last_with_person_list_and_function_and_amount()
        {
            Person p1 = new Person("Bob", 24, false);
            Person p2 = new Person("Ross", 42, true);
            Person p3 = new Person("Batman", 38, false);

            List<Person> input = new List<Person>() {p1, p2, p3};
            Func<Person, bool> function = p => p.age > 25;
            Person[] result = _huml.LAST(input, function, 2);
            Assert.AreEqual(result[0], p2);
            Assert.AreEqual(result[1], p3);
        }
    }
}