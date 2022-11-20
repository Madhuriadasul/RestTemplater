package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/clemp")
public class EmpController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/all")
	public List<Emp> getAllEmp() {
		Emp e1 = new Emp();
		HttpEntity entity = new HttpEntity(e1);
		ResponseEntity res = restTemplate.exchange("http://localhost:9090/emp/all", HttpMethod.GET, entity, Emp.class);
		System.out.println(res.getBody().toString());
		return null;

	}

	@PostMapping("/save")
	public Emp saveEmp(@RequestBody Emp emp) {
		HttpEntity<Emp> entity = new HttpEntity<Emp>(emp);
		ResponseEntity res = restTemplate.exchange("http://localhost:9090/emp/save", HttpMethod.POST, entity,
				Emp.class);
		Emp e1 = (Emp) res.getBody();
		return e1;
	}

	@PutMapping("/update")
	public Emp updateEmp(@RequestBody Emp emp) {
		HttpEntity<Emp> entity = new HttpEntity<Emp>(emp);
		ResponseEntity res = restTemplate.exchange("http://localhost:9090/emp/update", HttpMethod.PUT, entity,
				Emp.class);
		Emp e1 = (Emp) res.getBody();
		return e1;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Integer id) {
		HttpEntity<Integer> entity = new HttpEntity<Integer>(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("id", id);

		ResponseEntity<String> res = restTemplate.exchange("http://localhost:9090/emp/delete/{id}", HttpMethod.DELETE,
				entity, String.class, map);

		System.out.println("responseEntity...." + res.toString());

		System.out.println("responseEntity..." + res.getBody());

		return res.getBody();

	}
}
