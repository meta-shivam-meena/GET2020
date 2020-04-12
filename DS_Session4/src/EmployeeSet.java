import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeSet{
	private Set<Integer> employeeIds = new HashSet<Integer>();
	private List<Employee> employees = new ArrayList<Employee>();
	
	public boolean add(Employee employee) {
		if (employeeIds.contains(employee.getId())) {
			return false;
		} else {
			employeeIds.add(employee.getId());
			employees.add(employee);
			return true;
		}
	}
	
	public List<Employee> getEmployeeList() {
		return employees;
	}
}
