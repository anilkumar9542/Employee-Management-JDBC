package myPackage;

public class Query {
	static String insert = "insert into employee(id,name,email,salary) values (?,?,?,?)";
	static String update = "update employee set name = ? where id = ?";
	static String delete = "delete from employee where id =?";
	static String select = "select * from employee";
}
