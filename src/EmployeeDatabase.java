import java.util.ArrayList;
import java.util.List;

class Employee {
    private static int nextId = 0;

    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private double salary;

    public Employee(String lastName, String firstName, String middleName, String position, double salary) {
        this.id = nextId++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Фамилия: " + lastName +
                ", Имя: " + firstName +
                ", Отчество: " + middleName +
                ", Должность: " + position +
                ", Зарплата: " + salary;
    }
}
public class EmployeeDatabase {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(String lastName, String firstName, String middleName, String position, double salary) {
        Employee employee = new Employee(lastName, firstName, middleName, position, salary);
        employees.add(employee);
        System.out.println("Сотрудник добавлен в базу данных с ID: " + employee.getId());
    }

    public void selectAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void selectEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник с ID " + id + " не найден.");
    }

    public static void main(String[] args) {
        EmployeeDatabase database = new EmployeeDatabase();

        database.addEmployee("Иванов", "Маркус", "Маргаритович", "Слесарь", 50000);
        database.addEmployee("Петров", "Игорь", "Андреевич", "Механик", 60000);

        System.out.println("\nВсе сотрудники:");
        database.selectAllEmployees();

        System.out.println("\nСотрудник с ID=0:");
        database.selectEmployeeById(0);
    }
}
