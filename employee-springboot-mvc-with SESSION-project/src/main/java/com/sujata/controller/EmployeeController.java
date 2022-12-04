package com.sujata.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePaySlip;
import com.sujata.model.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/menu")
	public ModelAndView menuPageController() {
		return new ModelAndView("index");
	}
	//=============================================================
	
	
	
	//===== Controllers for Delete=================================
	@RequestMapping("/deleteEmpPage")
	public ModelAndView deletePageController() {
		return new ModelAndView("InputIdForDelete");
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployeeController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		int eId=Integer.parseInt(request.getParameter("empId"));
		String message=null;
		if(employeeService.deleteEmployee(eId))
			message="Employee Deleted with ID "+eId;
		else
			message="Employee with ID "+eId+" doesnot exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	//==============================================================
	
	
	
	//=============Controllers for increment Salary==================
	
	@RequestMapping("/incrementSalaryPage")
    public ModelAndView incrementSalaryPageController() {
        return new ModelAndView("InputIdForIncrement");
    }

	
	@RequestMapping("/incrementSalary")
	public ModelAndView incrementSalaryController(HttpServletRequest request) {
		
		ModelAndView modelAndView=new ModelAndView();
		
		int eId=Integer.parseInt(request.getParameter("empId"));
		
		 int increment = Integer.parseInt(request.getParameter("increment"));
		
		String message=null;
		
		if(employeeService.incrementSalary(eId, increment))
			message="Salary increased for employee with ID "+ eId+" by "+increment;
		else
			  message="Employee with ID "+eId+" does not exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	//================================================================
	
	
	
	//=============Controller for List all Employees==================
	@RequestMapping("/showAll")
    public ModelAndView getAllEmployeesController() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Collection<Employee> empList = employeeService.getAllEmployees();
		
		modelAndView.addObject("employees", empList);
		
		modelAndView.setViewName("ShowAllEmployees");
		
		
		return modelAndView;
    }
	//===================================================================
	
	
	
	//=============Controllers for Search Employee By ID==================
	@RequestMapping("/searchEmployeeByIDInputPage")
	public ModelAndView searchEmployeeByIDInputPageController() {
		return new ModelAndView("InputIdForSearch");
	}
	
	@RequestMapping("/searchEmployeeByID")
	public ModelAndView searchEmployeeById(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		int id=Integer.parseInt(request.getParameter("empId"));
		
		Employee employee = employeeService.searchEmployeeById(id);
		
		if(employee != null) {
			
			modelAndView.addObject("employee", employee);
			modelAndView.setViewName("ShowEmployee");
			
		} else {
			
			modelAndView.addObject("message", "Employee with ID "+id+" does not exist");
			modelAndView.setViewName("Output");
			
		}
		
		return modelAndView;
	}
	//=============================================================
	
	
	//=============Controllers for Search Employee By Department Name==================
		@RequestMapping("/searchEmployeeByDepartmentInputPage")
		public ModelAndView searchEmployeeByDepartmentInputPageController() {
			return new ModelAndView("InputDepartmentForSearch");
			
		}
		
		@RequestMapping("/searchEmployeeByDepartment")
		public ModelAndView searchEmployeeByDepartmentController(HttpServletRequest request) {
			
			ModelAndView modelAndView = new ModelAndView();
			
			String deptt = request.getParameter("department");
			
			List<Employee> empList = employeeService.getEmployeesByDepartment(deptt);
			
			if(empList.size() > 0) {
				
				modelAndView.addObject("employees", empList);
				modelAndView.setViewName("ShowAllEmployees");
				
			} else {
				modelAndView.setViewName("Output");
				modelAndView.addObject("message", "No Employee works in department " + deptt);
				
			}
			
			return modelAndView;
		}
		//=============================================================
		
		
		
		//=============Controllers for Search Employee By Designation==================
				@RequestMapping("/searchEmployeeByDesignationInputPage")
				public ModelAndView searchEmployeeByDesignationInputPageController() {
					return new ModelAndView("InputDesignationForSearch");
					
				}
				
				@RequestMapping("/searchEmployeeByDesignation")
				public ModelAndView searchEmployeeByDesignationController(HttpServletRequest request) {
					
					ModelAndView modelAndView = new ModelAndView();
					
					String desig = request.getParameter("designation");
					
					List<Employee> empList = employeeService.searchByDesignation(desig);
					
					if(empList.size() > 0) {
						
						modelAndView.addObject("employees", empList);
						modelAndView.setViewName("ShowAllEmployees");
						
					} else {
						modelAndView.setViewName("Output");
						modelAndView.addObject("message", "No Employee works with designation " + desig);
						
					}
					
					return modelAndView;
				}	
				//=============================================================
				
		
		
	
	//=============Controller for add Employees==================
	
	@RequestMapping("/addNewEmployeePage")
    public ModelAndView addNewEmployeePageController() {
//        return new ModelAndView("InputIdForAddingEmployee");
		
		return new ModelAndView("InputIdForAddingEmployee", "emp", new Employee());
    }

	@RequestMapping("/addNewEmployee")
//	public ModelAndView addNewEmployeeController(HttpServletRequest request) {
	public ModelAndView addEmployeeController(@ModelAttribute("emp") Employee newEmployee,@RequestParam("doj") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		
		ModelAndView modelAndView = new ModelAndView();
		
//		Employee newEmployee = new Employee();
//		
//		int eId = Integer.parseInt(request.getParameter("empId"));
//        String name = request.getParameter("name");
//        String designation = request.getParameter("designation");
//        String department = request.getParameter("department");
//        double salary = Double.parseDouble(request.getParameter("salary"));
//        LocalDate doj = LocalDate.parse(request.getParameter("doj"));
        
        String message = null;
        
//        newEmployee.setEmpId(eId);
//        newEmployee.setEmpName(name);
//        newEmployee.setEmpDesignation(designation);
//        newEmployee.setEmpDepartment(department);
//        newEmployee.setEmpSalary(salary);
        newEmployee.setDateOfJoining(date);
        
        if(employeeService.addEmployee(newEmployee))
        	message = "Employee with ID " + newEmployee.getEmpId() + " is added";
        else
        	message = "Employee with ID " + newEmployee.getEmpId() + " already exists";
        
        
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");

		return modelAndView;
	}
	//=============================================================
	
	
	
	//===== Controllers for Delete Employee by Name=================================
		@RequestMapping("/deleteEmpByNamePage")
		public ModelAndView deleteEmpByNamePageController() {
			return new ModelAndView("InputIdForDeleteEmpByName");
		}
		
		@RequestMapping("/deleteEmpByName")
		public ModelAndView deleteEmpByNameController(HttpServletRequest request) {
			
			ModelAndView modelAndView=new ModelAndView();

				String name = request.getParameter("name");
			
			String message=null;
			
			if(employeeService.deleteEmployeeByName(name))
				message="Employee with Name "+ name + " is deleted";
			else
				message="Employee with Name"+ name +" doesnot exist";
			
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
			
			return modelAndView;
		}
		//==============================================================
		
		
		//===== Controllers for Generate Payslip=================================
		@RequestMapping("/generatePayslipIdInputPage")
		public ModelAndView generatePayslipIdInputPageController() {
			return new ModelAndView("InputIdForPayslip");
		}
		
		
		@RequestMapping("/generatePayslip")
		public ModelAndView generatePayslip(HttpServletRequest request) {
			ModelAndView modelAndView=new ModelAndView();
			int id=Integer.parseInt(request.getParameter("empId"));
			
			EmployeePaySlip paySlip=employeeService.generatePaySlip(id);
			if(paySlip!=null) {
				modelAndView.addObject("paySlip", paySlip);
				modelAndView.setViewName("ShowPayslip");
			}
			else {
				modelAndView.addObject("message", "Employee with ID "+id+" does not exist");
				modelAndView.setViewName("Output");
			}
			
			return modelAndView;
		}
		
	
}
