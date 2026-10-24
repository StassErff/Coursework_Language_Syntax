

public class Main {
    public static void main(String[] args) {
        Employee[] initialEmployees = {new Employee("Попопв Поп Попович", 1, 250),
                new Employee("Жбанов Жбан Жбанович", 4, 340),
                new Employee("Китаев Китай Китаевич", 2, 420),
                new Employee("Степанов Степан Степанович", 1, 370),
                new Employee("Классов Класс Классович", 3, 75),
                new Employee("Персифалев Персифаль Персифалыч", 5, 100),
                new Employee("Тарелков Тарелка Тарелкович", 5, 450),
                new Employee("Сидоров Сидор Сидорович", 3, 150),
                new Employee("Козлов Козел Козлович", 4, 190),
                new Employee("Ибупрофенов Ибупрофен Ибупрофенович", 4, 207),
                new Employee("Лишнов Лишний Лишнинович", 2, 400)};

        EmployeeBook employeeBook = new EmployeeBook();

        for (Employee emp : initialEmployees) {
            boolean result = employeeBook.populatingEmployeeBook(emp);

            System.out.println("Добавление " + emp.getFullName() + ": " + (result ? "Успешно" : "Нет места"));
        }

        employeeBook.printAllEmployees();
        System.out.println("Среднее значение зарплат: " + employeeBook.averageSalary());

        employeeBook.taxValue("PROGRESSIVE");
        employeeBook.highSalaryDeportment(4, 250);
        employeeBook.lowerSalaryWage(250, 7);
        employeeBook.retrievingAnEmployeeById(5);
        employeeBook.departmentSalary(1, 15);
        employeeBook.searchingForAnEmployeeBasedOnSalary(450);
    }
}