import java.util.*;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
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
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                '}';
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;
    private int currentId;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.currentId = 1; // 初始ID从1开始
    }

    // 添加员工并自动生成ID
    public void addEmployee(String name, int age) {
        for (int i = 0; i < employees.size(); i++) {
            String name_former = employees.get(i).getName();
            if (Objects.equals(name, name_former)){
                return;
            }
        }
        employees.add(new Employee(currentId++, name, age));
    }

    // 根据名字删除员工
    public void deleteEmployee(String name) {
        employees.removeIf(e -> e.getName().equals(name));
    }

    // 打印所有员工信息
    public void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            Collections.sort(employees);
            System.out.println("Employees list:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Print All Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee age: ");
                    int age = scanner.nextInt();
                    ems.addEmployee(name, age);
                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.print("Enter employee name to delete: ");
                    String deleteName = scanner.nextLine();
                    ems.deleteEmployee(deleteName);
                    System.out.println("Employee deleted if existed.");
                    break;

                case 3:
                    ems.printAllEmployees();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
