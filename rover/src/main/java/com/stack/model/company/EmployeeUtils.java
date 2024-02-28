package com.stack.model.company;

public class EmployeeUtils {
    private EmployeeUtils() {
    }

    public static BaseEmployee findEmployeeByName(
            BaseEmployee[] employees,
            String name) {
        for (BaseEmployee employee : employees) {
            if (employee != null && employee.getName().equals(name)) {
                return employee;
            }
        }
        return new Employee(0, "", Gender.UNKNOWN);
    }

    public static BaseEmployee findEmployeeBySubstring(
            BaseEmployee[] employees,
            String substring) {
        for (BaseEmployee employee : employees) {
            if (employee != null && employee.getName().contains(substring)) {
                return employee;
            }
        }
        return new Employee(0, "", Gender.UNKNOWN);
    }

    public static double calculateTotalSalary(BaseEmployee[] employees) {
        double amount = 0;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            amount += employee.getSalary();
        }
        return amount;
    }

    public static double findMinimumSalary(BaseEmployee[] employees) {
        double min = Double.MAX_VALUE;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            min = swapMin(employee.getSalary(), min);
        }
        return min;
    }

    public static double findMaximumSalary(BaseEmployee[] employees) {
        double max = Double.MIN_VALUE;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            max = swapMax(employee.getSalary(), max);
        }
        return max;
    }

    public static int findMinSubordinates(BaseEmployee[] employees) {
        int min = Integer.MAX_VALUE;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            int subordinates = employee.getSubordinates();
            if (subordinates < 0) {
                return 0;
            }
            min = swapMin(subordinates, min);
        }
        return min;
    }

    public static int findMaxSubordinates(BaseEmployee[] employees) {
        int max = Integer.MIN_VALUE;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            max = swapMax(employee.getSubordinates(), max);
        }
        return max;
    }

    public static double findMaxAllowance(BaseEmployee[] employees) {
        double max = Double.MIN_VALUE;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            max = swapMax(getAllowance(employee), max);
        }
        return max;
    }

    public static double findMinAllowance(BaseEmployee[] employees) {
        double min = Double.MAX_VALUE;
        for (BaseEmployee employee : employees) {
            if (employee == null) {
                return 0;
            }
            min = swapMin(getAllowance(employee), min);
        }
        return min;
    }

    private static double getAllowance(BaseEmployee employee) {
        return employee.getSalary() - employee.getBaseSalary();
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
