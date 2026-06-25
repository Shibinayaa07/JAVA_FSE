package deepskilling.week_1.algorithms;

public class Exercise04EmployeeManagement {
    static class Employee {
        private final int employeeId;
        private final String name;
        private final String position;
        private final double salary;

        Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return employeeId + " - " + name + ", " + position + ", salary=" + salary;
        }
    }

    static class EmployeeStore {
        private final Employee[] employees;
        private int size;

        EmployeeStore(int capacity) {
            employees = new Employee[capacity];
        }

        void add(Employee employee) {
            if (size == employees.length) {
                throw new IllegalStateException("Employee store is full");
            }
            employees[size++] = employee;
        }

        Employee search(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == employeeId) {
                    return employees[i];
                }
            }
            return null;
        }

        void traverse() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        boolean delete(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == employeeId) {
                    employees[i] = employees[size - 1];
                    employees[size - 1] = null;
                    size--;
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeStore store = new EmployeeStore(5);
        store.add(new Employee(1, "Anu", "Developer", 65000));
        store.add(new Employee(2, "Vikram", "Tester", 52000));
        System.out.println(store.search(1));
        store.delete(2);
        store.traverse();
        System.out.println("Array add at end is O(1), search/delete are O(n), traversal is O(n). Arrays have fixed size.");
    }
}
