import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

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
                employeeCount++;
            }
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

    public void highSalaryDeportment(int numDeportment, int salary) {
        boolean empFound = false;

        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];

            if (emp != null) {
                if (emp.getDepartment() == numDeportment && emp.getSalary() > salary) {
                    System.out.println("ID сотрудника: " + emp.getId() + " ");
                    emp.printShortInfo();
                    empFound = true;

                    break;
                }
                if (empFound) {
                    System.out.println("В отделе " + numDeportment + " нет сотрудников с зарплатой выше " + salary);
                }
            }
        }
    }

    public void lowerSalaryWage(int wage, int employeeNumber) {
        System.out.println("===== Первые " + employeeNumber + " сотрудников с зарплатой меньше " + wage + " =====");

        int i = 0;
        int foundCound = 0;

        while (i < employees.length) {
            Employee emp = employees[i];

            if (emp != null) {
                if (emp.getSalary() < wage) {
                    System.out.println(emp);
                    foundCound++;

                    if (foundCound == employeeNumber) {
                        break;
                    }
                }
            }

            i++;
        }

        if (foundCound == 0) {
            System.out.println("Сотрудников с ззарплатой меньше " + wage + " не найдено");
        } else if (foundCound < employeeNumber) {
            System.out.println("Найдено всего " + foundCound + " из " + employeeNumber + " запрошенных");
        }
    }

    public boolean searchingForAnEmployeeBasedOnSalary(Employee salaryEmployees) {
        if (salaryEmployees == null) {
            return false;
        }

        for (Employee emp : employees) {
            if (emp != null) {

                if (Objects.equals(emp.getSalary(), salaryEmployees.getSalary())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean populatingEmployeeBook(Employee employeeNew) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                continue;
            }

            employees[i] = employeeNew;
            return true;
        }

        return false;
    }

    public Employee retrievingAnEmployeeById(int idEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == idEmployee) {
                return employees[i];
            }
        }
        return null;
    }
}