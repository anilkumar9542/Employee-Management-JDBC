package myPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do { 
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee Name");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    int salary = sc.nextInt();

                    Employee emp = new Employee(id, name, email, salary);
                    try {
                        EmployeeDAO.insertEmployee(emp);
                        System.out.println("Inserted Successfully.");
                    } catch (Exception e) {
                        System.out.println("Error inserting employee.");
                        e.printStackTrace();
                    }
                    break;

                case 2: // Update
                    System.out.print("Enter Employee ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    Employee updatedEmp = new Employee(upId, newName, "", 0);
                    try {
                        EmployeeDAO.updateEmployee(updatedEmp);
                        System.out.println("Updated Successfully.");
                    } catch (Exception e) {
                        System.out.println("Error updating employee.");
                        e.printStackTrace();
                    }
                    break;

                case 3: // Delete
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    try {
                        EmployeeDAO.deleteEmployee(delId);
                        System.out.println("Deleted Successfully.");
                    } catch (Exception e) {
                        System.out.println("Error deleting employee.");
                        e.printStackTrace();
                    }
                    break;

                case 4: // Read
                    try {
                        ArrayList<Employee> empList = EmployeeDAO.readEmployee();
                        if (empList.isEmpty()) {
                            System.out.println("No employee records found.");
                        } else {
                            for (Employee e : empList) {
                                System.out.println(e);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading employees.");
                        e.printStackTrace();
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
