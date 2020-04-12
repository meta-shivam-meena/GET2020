public class Q1 {
	
	public static void main(String[] args) {
		EmployeeSet employees = new EmployeeSet();
		employees.add(new Employee(1359, "Shivam", "abc"));
		employees.add(new Employee(1362, "Tanmay", "abc"));
		employees.add(new Employee(1360, "Shikher", "abc"));
		employees.add(new Employee(1358, "Lovendra", "abc"));
		employees.add(new Employee(1355, "Gaurav", "abc"));
		employees.add(new Employee(1361, "Ayush", "abc"));
		System.out.println(employees.getEmployeeList());
		
		SortEmployeesById.sortEmployeesById(employees);
		System.out.println(employees.getEmployeeList());
		
		SortEmployeesByName.sortEmployeesByName(employees);
		System.out.println(employees.getEmployeeList());
	}
	
}
