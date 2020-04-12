import java.util.Collections;
import java.util.Comparator;

public class SortEmployeesById {
	
	public static void sortEmployeesById(EmployeeSet employees) {
		Collections.sort(employees.getEmployeeList(), new CompareEmployeesById());
	}
	
	static class CompareEmployeesById implements Comparator<Employee> {
		
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getId() - o2.getId();
		}
		
	}
}
