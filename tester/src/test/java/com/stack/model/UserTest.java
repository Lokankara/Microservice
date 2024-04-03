package com.stack.model;

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
public class UserTest {

    @Test
    public void testUser() {
        User bob = new User("Bob", LocalDate.of(2024, 2, 2));
        User carl = new User("Carl", LocalDate.of(2025, 2, 2));
        User alice = new User("Alice", LocalDate.of(2023, 2, 2));
        User audi = new User("Audi", LocalDate.of(2020, 2, 2));

        List<User> list = new ArrayList<>();
        SortedSet<User> treeSet = new TreeSet<>();

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

        list.sort(Comparator.comparing(User::name));
        System.out.println("--------------Comparator.comparing--------------");
        print(list);
        System.out.println("--------------TreeSet--------------");
        print(treeSet);

        Iterator<User> iterator = treeSet.iterator();
        System.out.println(iterator.hasNext());
    }

    private static void print(Collection<User> list) {
        for (User user : list) {
            log.info(user.toString());
        }
    }
}
