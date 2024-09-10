import java.util.*;

class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    // 添加员工
    public void addEmployee(String name, int age) {
        employees.add(new Employee(name, age));
    }

    // 删除员工
    public void deleteEmployee(String name) {
        employees.removeIf(e -> e.getName().equals(name));
    }

    // 打印所有员工信息
    public void printAllEmployees() {
        Collections.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // 添加员工 A, B, C
        ems.addEmployee("A", 25);
        ems.addEmployee("B", 30);
        ems.addEmployee("C", 22);

        // 删除员工 B
        ems.deleteEmployee("B");

        // 添加员工 A, D
        ems.addEmployee("A", 28);
        ems.addEmployee("D", 35);

        // 打印所有员工信息
        ems.printAllEmployees();
    }
}
