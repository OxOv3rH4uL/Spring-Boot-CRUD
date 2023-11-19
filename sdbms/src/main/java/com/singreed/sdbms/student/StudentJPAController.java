package com.singreed.sdbms.student;

import java.util.List;
import java.util.Optional;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.MvcNamespaceUtils;

@Controller
public class StudentJPAController {
	
	StudentJPARepository repository;
	
	
	
	@Autowired
	public StudentJPAController(StudentJPARepository repository) {
		super();
		this.repository = repository;
	}
	



	@RequestMapping(value = "students" , method = RequestMethod.GET)
	public String home(ModelMap map) {
		List<Student> list = repository.findAll();
		map.addAttribute("stud", list);
		return "listStudentPage";
	}
	
	@RequestMapping(value="search" , method = RequestMethod.GET)
	public String searchStudent(@RequestParam String name , ModelMap map) {
		List<Student> findStudent = repository.findByName(name);
		map.put("stud",findStudent);
		return "listStudentPage";
	}
	
	@RequestMapping(value="add-student" ,method = RequestMethod.GET)
	public String gotoAddStudent(ModelMap map) {
		
		map.put("stud",new Student(0, "", "","",""));
		return "AddStudentPage";
	}
	
	@RequestMapping(value = "add-student", method= RequestMethod.POST)
	public String addStudent(Student stud, ModelMap map) {
		map.addAttribute("stud",stud);
		repository.save(stud);
		return "redirect:students";
	}
	
	@RequestMapping("delete-student")
	public String deleteStudent(@RequestParam String id , ModelMap map) {
		repository.deleteById(Integer.parseInt(id));
		return "redirect:students";
	}
	
	@RequestMapping(value = "update-student" , method = RequestMethod.GET)
	public String updateStudent(@RequestParam int id , ModelMap map) {
		Optional<Student> optionalStudent = repository.findById(id);

	    if (optionalStudent.isPresent()) {
	        Student upstud = optionalStudent.get();
	        map.addAttribute("stud", upstud);
	    } else {
	        map.addAttribute("stud", new Student());
	    }

	    return "updateStudent";
	}
	
	@RequestMapping(value="update-student" , method=RequestMethod.POST)
	public String afterUpdate(ModelMap map , Student stud) {
		map.addAttribute("stud",stud);
		repository.save(stud);
		return "redirect:students";
	}
}
