package myPackage;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    public static void insertEmployee(Employee emp) throws SQLException {
        Connection con = DB.connect();
        String query = Query.insert;
        PreparedStatement ptm = con.prepareStatement(query);
        ptm.setInt(1, emp.getID());
        ptm.setString(2, emp.getName());
        ptm.setString(3, emp.getEmail());
        ptm.setInt(4, emp.getSalary());
        ptm.executeUpdate();
        ptm.close();
        con.close();
    }

    public static void updateEmployee(Employee emp) throws SQLException {
        Connection con = DB.connect();
        String query = Query.update;
        PreparedStatement ptm = con.prepareStatement(query);
        ptm.setString(1, emp.getName());
        ptm.setInt(2, emp.getID());
        ptm.executeUpdate();
        ptm.close();
        con.close();
    }

    public static void deleteEmployee(int id) throws SQLException {
        Connection con = DB.connect();
        String query = Query.delete;
        PreparedStatement ptm = con.prepareStatement(query);
        ptm.setInt(1, id);
        ptm.executeUpdate();
        ptm.close();
        con.close();
    }

    public static ArrayList<Employee> readEmployee() throws SQLException {
        ArrayList<Employee> empList = new ArrayList<>();
        Connection con = DB.connect();
        String query = Query.select;
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            int salary = rs.getInt("salary");
            Employee emp = new Employee(id, name, email, salary);
            empList.add(emp);
        }

        rs.close();
        stm.close();
        con.close();

        return empList;
    }
}
