import java.util.Scanner;

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

    public void taxValue(String taxScheme) {
        System.out.println("===== Расчет налогов по схеме: " + taxScheme + " =====");

        for (Employee emp : employees) {
            double tax = 0;
            int salary = emp.getSalary();

            if (emp != null) {

                switch (taxScheme) {
                    case "PROPORTIONAL":
                        tax = salary * 0.13;
                        break;

                    case "PROGRESSIVE":
                        if (salary <= 150) {
                            tax = salary * 0.13;
                        } else if (salary <= 350) {
                            tax = salary * 0.17;
                        } else {
                            tax = salary * 0.21;
                        }
                        break;

                    default:
                        System.out.println("Ошибка неизвестная схема налога " + taxScheme);
                        return;
                }
            }
            System.out.println("Сотрудник: " + emp.getFullName() + " Зарплата: " + salary + " Налог: " + tax);
        }
    }

    public void departmentSalary(int numDeportment, double percent) {
        for (Employee emp : employees) {

            if (emp != null) {
                continue;
            }

            if (emp.getDepartment() != numDeportment) {
                continue;
            }

            double currentSalary = emp.getSalary();
            double updatedSalary = currentSalary + (currentSalary * percent / 100.0);

            emp.setSalary((int) updatedSalary);
        }
    }
}