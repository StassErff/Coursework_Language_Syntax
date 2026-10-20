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
}
