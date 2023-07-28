package com.student.test.contolller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.test.entites.Student;
import com.student.test.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/registerStudent")
	public String registerStudentPage()
	{
		return "registerStudent";
	}
	
	@GetMapping("/viewStudents")
	public String allStudents(Model m)
	{
		List<String> of = List.of("A","B","C");
		Iterable<Student> allStudent = studentService.allStudent();
		m.addAttribute("students",allStudent);
		m.addAttribute("list", of);
		return "viewStudents";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, Model m)
	{
		Student s = studentService.getById(id);
		m.addAttribute("stu", s);
		return "updateStudent";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student student)
	{
		Student stu = studentService.update(student);
		System.out.println(stu);
		return "redirect:/viewStudents";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id)
	{
		studentService.deleteStudent(id);
		return "redirect:/viewStudents";
	}
	
	@PostMapping("/addStudent")
	public String registerStudent(@ModelAttribute Student student)
	{
		Student addStudent = studentService.addStudent(student);
		System.out.println(addStudent);
		return "redirect:/viewStudents";
	}
	
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
}
