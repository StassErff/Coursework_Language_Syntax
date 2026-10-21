public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public EmployeeBook() {
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public double averageSalary() {
        int totalSalary = 0;
        int employeeCount = 0;
        boolean foundNull = false;

        for (Employee emp : employees) {
            if (emp != null) {
                totalSalary += emp.getSalary();

                if (foundNull) {
                    employeeCount++;
                }
            } else {
                foundNull = true;
            }
        }

        if (employeeCount == 0) {
            return 0.0;
        }

        return (double) totalSalary / employeeCount;
    }
}