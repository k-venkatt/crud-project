package com.crudoperations.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class CRUD{
	
	private List<Employee> list_emp = new ArrayList<Employee>();
	
	public int getSize() {
		return list_emp.size();
	}
	
	public void addEmployee(Employee e) {
		list_emp.add(e);
	}
	public void updateEmployee(int id,Employee e) {
		list_emp.add(id, e);
	}
	public Employee findEmployee(int i) {
		
		return list_emp.get(i-1);
		
	}
	public boolean deleteEmployee(int i) {
		Employee emp = list_emp.remove(i);
		if(emp != null) return true;
		else return false;
	}
	public List<Employee> findAllEmployee(){
		return list_emp;
	}
}
public class EmployeeDriver {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		CRUD crud = new CRUD();
		boolean iteration = true;
		
		int idcount = 1;
		
		while(iteration) {
			System.out.println("________________________________________________________");
			System.out.println("1.Add_Employee\n"+"2.Update_Employee\n"+"3.Find_Employee\n"+"4.Delete_Employee\n"+"5.Exit");
			System.out.println("________________________________________________________");
			System.out.println("Press any number from above lists");
			int option = s.nextInt();
			switch(option) {
			case 1:{
				
				
				System.out.println("Enter employee name:");
				String name = s.next();
				System.out.println("Enter employee age");
				int age=s.nextInt();
				System.out.println("Enter employee salary");
				double salary = s.nextDouble();
				System.out.println("Enter employee address");
				String address = s.next();
				System.out.println("Enter employee email");
				String email = s.next();
				
				Employee e = new Employee();
				
				e.setId(idcount++);
				e.setName(name);
				e.setAge(age);
				e.setSalary(salary);
				e.setAddress(address);
				e.setEmail(email);
				
				crud.addEmployee(e);
				System.out.println("Employee details successfully added");
				System.out.println("___________________");
				
				break;
			}
			case 2:{
				
				if(crud.getSize() != 0 ) {
					
					
						System.out.println("Enter employee id number starts from 1 ");
						int id = s.nextInt();
						Employee e ;
						if(id < crud.getSize()) {
							e = crud.findEmployee(id);
							
						}
						else {
							System.out.println("employee not available");
							break;
						}
							
					
//					int opt = s.nextInt();
					
					boolean iter = true;
					
					while(iter) {
						System.out.println("what do you want to update?\n"+"1.name\n"+"2.age\n"+"3.salary\n"+"4.address\n"+"5.email");
						int opt = s.nextInt();
						
						switch(opt) {
						case 1:{
							System.out.println("Enter updated name");
							String name = s.next();
							e.setName(name);
							iter=false;
							break;
						}
						case 2:{
							System.out.println("Enter updated age");
							int age = s.nextInt();
							e.setAge(age);
							iter=false;
							break;
						}
						case 3:{
							System.out.println("Enter updated salary");
							double salary = s.nextDouble();
							e.setSalary(salary);
							iter=false;
							break;
						}
						case 4:{
							System.out.println("Enter updated address");
							String address = s.next();
							e.setAddress(address);
							iter=false;
							break;
						}
						case 5:{
							System.out.println("Enter updated email");
							String email = s.next();
							e.setEmail(email);
							iter=false;
							break;
						}
						default:{
							System.out.println("Enter proper number");
							break;
						}
						
						}
					}
					crud.updateEmployee(id, e);
					System.out.println("Employee detail has been updated successfully");
					System.out.println("___________________");
				}
				else {
					System.out.println("Employee details empty first add employee details");
					System.out.println("___________________");
				}
				break;
			}
			case 3:{
				
				if(crud.getSize() != 0) {
					System.out.println("do you want to fetch one employee or all employee\n"+"1.one employee\n"+"2.all employee");
					System.out.println("Enter the option");
					int opt = s.nextInt();
					
					boolean iter = true;
					
					while(iter) {
						switch(opt) {
						case 1:{
							System.out.println("Enter employee id");
							int id = s.nextInt();
							if(id-1 <=crud.getSize()) {
							Employee e =  crud.findEmployee(id);
							System.out.println(id+" th employee details\n"+"_________________");
							System.out.println("Employee name: "+e.getName());
							System.out.println("Employee age: "+e.getAge());
							System.out.println("Employee salary: "+e.getSalary());
							System.out.println("Employee address: "+e.getAddress());
							System.out.println("Employee email: "+e.getEmail());
							
							System.out.println("_________________");
							}
							else System.out.println("employee not available");
							iter=false;
							break;
						}
						case 2:{
							
							List<Employee> list = crud.findAllEmployee();
							for(int i=0; i<list.size(); i++) {
								
								Employee e =  crud.findEmployee(i+1);
								System.out.println(i+" th employee details\n"+"_________________");
								System.out.println("Employee name: "+e.getName());
								System.out.println("Employee age: "+e.getAge());
								System.out.println("Employee salary: "+e.getSalary());
								System.out.println("Employee address: "+e.getAddress());
								System.out.println("Employee email: "+e.getEmail());
								
								System.out.println("___________________");
							}
							
							iter=false;
							break;
						}
						}
					}
				}
				else {
					System.out.println("Employee details empty first add employee details");
					System.out.println("___________________");
				}
				break;
			}
			case 4:{
				System.out.println("Enter employee id");
				int id = s.nextInt();
				if(crud.getSize() != 0 && id-1 < crud.getSize()) {
				
				boolean ans = crud.deleteEmployee(id-1);
				if(ans) System.out.println(id+" st row has been deleted");
				else System.out.println("The row is not available");
				}
				else {
					System.out.println("Employee details empty first add employee details");
					System.out.println("___________________");
				}
				break;
			}
			case 5:{
				System.out.println("Thank You.../\\");
				iteration = false;
				break;
			}
			default:{
				System.out.println("Press correct number");
				break;
			}
			}
			if(iteration) {
				System.out.println("Do you want continue press the number\n"+"1.Yes\n"+"2.No");
				int confirmnum = s.nextInt();
				if(confirmnum == 2) {
					System.out.println("Thank You...");
					System.out.println("_______________________");
					iteration=false; 
					break;
				} 
				
			}
		}
		
	}

}


