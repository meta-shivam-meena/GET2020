import java.util.Collections;
import java.util.Comparator;

public class SortEmployeesByName {
	
	public static void sortEmployeesByName(EmployeeSet employees) {
		Collections.sort(employees.getEmployeeList(), new CompareEmployeesByName());
	}
	
	static class CompareEmployeesByName implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
}
