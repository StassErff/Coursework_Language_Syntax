import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;
    private static int countId;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = id;
        this.id = countId++;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
