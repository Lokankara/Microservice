package com.stack.collection;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PolymorphismTest {

    private Polymorphism myUtils;
    List<Employee> workers = Arrays.asList(
            new Employee("Ivan", 10, new BigDecimal("3000.00")),
            new Manager("Petro", 10, new BigDecimal("3000.00"), 1.5),
            new Employee("Stepan", 8, new BigDecimal("4000.00")),
            new Employee("Andriy", 7, new BigDecimal("3500.00")),
            new Employee("Ihor", 5, new BigDecimal("4500.00")),
            new Manager("Vasyl", 8, new BigDecimal("2000.00"), 2.0)
    );

    List<Employee> expected = Arrays.asList(
            new Employee("Ivan", 10, new BigDecimal("3000.00")),
            new Manager("Petro", 10, new BigDecimal("3000.00"), 1.5),
            new Employee("Ihor", 5, new BigDecimal("4500.00"))
    );

    @BeforeMethod
    void setUp() {
        myUtils = new Polymorphism();
    }

    @Test
    public void testCreateNotebook() {
        Map<String, String> phones = new HashMap<>();
        phones.put("0967654321", "Petro");
        phones.put("0677654321", "Petro");
        phones.put("0501234567", "Ivan");
        phones.put("0970011223", "Stepan");
        phones.put("0631234567", "Ivan");

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("Petro", Arrays.asList("0967654321", "0677654321"));
        expected.put("Ivan", Arrays.asList("0501234567", "0631234567"));
        expected.put("Stepan", List.of("0970011223"));
        Map<String, List<String>> actual = myUtils.createNotebook(phones);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCommonStudents() {
        List<Student> list1 = Arrays.asList(
                new Student(1, "Ivan"),
                new Student(2, "Petro"),
                new Student(3, "Stepan")
        );
        List<Student> list2 = Arrays.asList(
                new Student(1, "Ivan"),
                new Student(3, "Stepan"),
                new Student(4, "Andriy")
        );

        Set<Student> expected = new HashSet<>(Arrays.asList(
                new Student(1, "Ivan"),
                new Student(3, "Stepan")
        ));

        Set<Student> actual = myUtils.retrainStudents(list1, list2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLargestEmployees() {
        List<Employee> actual = myUtils.getMaxEmployees(workers);
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testDuplicateExperience() {
        List<Employee> actual = myUtils.getMaxEmployees(workers);
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testEmptyList() {
        List<Employee> workers = new ArrayList<>();
        List<Employee> expected = new ArrayList<>();
        List<Employee> actual = myUtils.getMaxEmployees(workers);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNullEmployee() {
        List<Employee> workers = Arrays.asList(
                new Employee("Ivan", 10, new BigDecimal("3000.00")),
                null,
                new Employee("Stepan", 8, new BigDecimal("4000.00"))
        );
        myUtils.getMaxEmployees(workers);
    }

    @Test
    public void testUniqueSize() {
        List<Employee> result = myUtils.getMaxEmployees(workers);
        Assert.assertEquals(3, result.size());
    }
}
