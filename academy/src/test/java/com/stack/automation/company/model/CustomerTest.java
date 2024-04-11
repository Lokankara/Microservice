package com.stack.automation.company.model;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Slf4j
public class CustomerTest {

    @Test
    public void testUser() {
        Customer bob = new Customer("Bob", LocalDate.of(2024, 2, 2));
        Customer carl = new Customer("Carl", LocalDate.of(2025, 2, 2));
        Customer alice = new Customer("Alice", LocalDate.of(2023, 2, 2));
        Customer audi = new Customer("Audi", LocalDate.of(2020, 2, 2));

        List<Customer> list = new ArrayList<>();
        SortedSet<Customer> treeSet = new TreeSet<>();

        list.add(bob);
        list.add(carl);
        list.add(alice);
        list.add(audi);

        treeSet.add(bob);
        treeSet.add(carl);
        treeSet.add(alice);
        treeSet.add(audi);

        Collections.sort(list);

        System.out.println("--------------Collections.sort--------------");
        print(list);

        list.sort(Comparator.comparing(Customer::name));
        System.out.println("--------------Comparator.comparing--------------");
        print(list);
        System.out.println("--------------TreeSet--------------");
        print(treeSet);

        Iterator<Customer> iterator = treeSet.iterator();
        System.out.println(iterator.hasNext());
    }

    private static void print(Collection<Customer> list) {
        for (Customer customer : list) {
            log.info(customer.toString());
        }
    }
}
