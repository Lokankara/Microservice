package com.stack.model.company;

public class EmployeeUtils {
    private EmployeeUtils() {
    }

    public static Employee findEmployeeByName(
            Employee[] employees,
            String name) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(name)) {
                return employee;
            }
        }
        return new Employee();
    }

    public static Employee findEmployeeBySubstring(
            Employee[] employees,
            String substring) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().contains(substring)) {
                return employee;
            }
        }
        return new Employee();
    }

    public static double calculateTotalSalary(Employee[] employees) {
        double amount = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                return 0;
            }
            amount += employee.getSalary();
        }
        return amount;
    }

    public static double findMinimumSalary(Employee[] employees) {
        double min = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee == null) {
                return 0;
            }
            min = swapMin(employee.getSalary(), min);
        }
        return min;
    }

    public static double findMaximumSalary(Employee[] employees) {
        double max = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee == null) {
                return 0;
            }
            max = swapMax(employee.getSalary(), max);
        }
        return max;
    }

    public static int findMinSubordinates(Manager[] managers) {
        int min = Integer.MAX_VALUE;
        for (Manager manager : managers) {
            if (manager == null) {
                return 0;
            }
            int subordinates = manager.getSubordinates();
            if (subordinates < 0) {
                return 0;
            }
            min = swapMin(subordinates, min);
        }
        return min;
    }

    public static int findMaxSubordinates(Manager[] managers) {
        int max = Integer.MIN_VALUE;
        for (Manager manager : managers) {
            if (manager == null) {
                return 0;
            }
            max = swapMax(manager.getSubordinates(), max);
        }
        return max;
    }

    public static double findMaxAllowance(Manager[] managers) {
        double max = Double.MIN_VALUE;
        for (Manager manager : managers) {
            if (manager == null) {
                return 0;
            }
            max = swapMax(getAllowance(manager), max);
        }
        return max;
    }

    public static double findMinAllowance(Manager[] managers) {
        double min = Double.MAX_VALUE;
        for (Manager manager : managers) {
            if (manager == null) {
                return 0;
            }
            min = swapMin(getAllowance(manager), min);
        }
        return min;
    }

    private static double getAllowance(Manager manager) {
        return manager.getSalary() - manager.getBaseSalary();
    }

    private static <T extends Comparable<T>> T swapMin(T value, T min) {
        if (value.compareTo(min) < 0) {
            min = value;
        }
        return min;
    }

    private static <T extends Comparable<T>> T swapMax(T value, T max) {
        if (value.compareTo(max) > 0) {
            max = value;
        }
        return max;
    }
}
