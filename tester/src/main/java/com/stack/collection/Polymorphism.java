package com.stack.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Polymorphism {
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> dictionary = new HashMap<>();
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            dictionary.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                      .add(entry.getKey());
        }
        return dictionary;
    }

    public Set<Student> retrainStudents(
            List<Student> list1, List<Student> list2) {
        Set<Student> common = new HashSet<>(list1);
        common.retainAll(list2);
        return common;
    }

    public List<Employee> getMaxEmployees(List<Employee> workers) {

        if (workers == null) {
            throw new NullPointerException();
        }
        if (workers.isEmpty()) {
            return new ArrayList<>();
        }

        List<Employee> uniqueEmployees = new ArrayList<>();

        int maxExpManager = getMaxExperience(workers, true);
        int maxExpEmployee = getMaxExperience(workers, false);

        BigDecimal maxPaymentManager = getMaxPayment(workers, true);
        BigDecimal maxPaymentEmployee = getMaxPayment(workers, false);

        List<Employee> employees =
                workers.stream().filter(e -> e != null && e.getName() != null)
                       .collect(Collectors.toCollection(ArrayList::new));

        Comparator<Employee> comparator =
                Comparator.comparing(Employee::getName)
                          .thenComparing(Employee::getExperience)
                          .thenComparing(Employee::getBasePayment);

        for (Employee e : employees) {
            if (!uniqueEmployees.contains(e) && (
                    (isManager(e) && (e.getExperience() == maxExpManager || e.getBasePayment().equals(maxPaymentManager)))
                    || (!isManager(e) && (e.getExperience() == maxExpEmployee || e.getBasePayment().equals(maxPaymentEmployee))))) {
                uniqueEmployees.add(e);
            }
        }

        uniqueEmployees.sort(comparator);
        return uniqueEmployees;
    }

    private int getMaxExperience(List<Employee> workers, boolean isManager) {

        int maxExp = 0;
        for (Employee e : workers) {
            if (hasManager(isManager, e)) {
                maxExp = Math.max(maxExp, e.getExperience());
            }
        }
        return maxExp;
    }

    private BigDecimal getMaxPayment(List<Employee> workers, boolean isManager) {

        BigDecimal maxPayment = BigDecimal.valueOf(Double.MIN_VALUE);
        for (Employee e : workers) {
            if (hasManager(isManager, e)) {
                maxPayment = maxPayment.max(e.getBasePayment());
            }
        }
        return maxPayment;
    }

    private boolean isManager(Employee employee) {
        return employee instanceof Manager;
    }

    private boolean hasManager(boolean isManager, Employee e) {
        return e != null && (isManager && isManager(e) || (!isManager && !isManager(e)));
    }
}
