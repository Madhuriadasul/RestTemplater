package com;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")

public class EmpController {

	@Autowired
	EmpRepository empRepository;

	@GetMapping("/all")
	public List<Emp> getAllEmp() {
		List<Emp> empList = empRepository.findAll();
		return empList;

	}

	@PostMapping("/save")
	public Emp saveEmpIntoDB(@RequestBody Emp emp) {
		Emp empEntity = empRepository.save(emp);
		return empEntity;
	}

	@PutMapping("/update")
	public Emp updateEmp(@RequestBody Emp emp) {
		Optional<Emp> empentity = empRepository.findById(emp.getId());
		Emp emp1 = empentity.get();

		// if (!emp.getEmpType().equals(emp1.getEmpType())) {
		// emp1.setEmpType(emp.getEmpType());
		// }

		if (!emp.getName().equals(emp1.getName())) {
			emp1.setName(emp.getName());
		}
		if (!emp.getAddress().equals(emp1.getAddress())) {
			emp1.setAddress(emp.getAddress());
		}
		if (!emp.getSal().equals(emp1.getSal())) {
			emp1.setSal(emp.getSal());
		}
		Emp empEntity = empRepository.save(emp1);
		return empEntity;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		System.out.println("id...." + id);
		empRepository.deleteById(id);
		return "record deleted";
	}

}
