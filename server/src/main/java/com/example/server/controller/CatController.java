package com.example.server.CatController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CatController {

    @GetMapping("/cat")
    public String cat(Model model) {
        model.addAttribute("catName", "Podo");
        return "cat";
    }

    @GetMapping("/person")
    public String person (@RequestParam("name") String name, @RequestParam(value = "age", required = false) Integer age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "person";

        // http://localhost:81/person?name=podo&age=1
    }

    @GetMapping("/student")
    @ResponseBody
    public Student student(@RequestParam("name") String name, @RequestParam("major") String major, @RequestParam(value = "hakbun", required = false) Integer hakbun) {
        
        Student student = new Student();
        student.setName(name);
        student.setMajor(major);
        student.setHakbun(hakbun);

        return student;
    }

    static class Student {

        private String name;
        private String major;
        private Integer Hakbun;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getHakbun() {
		return this.Hakbun;
	}

	public void setHakbun(Integer Hakbun) {
		this.Hakbun = Hakbun;
	}
    }
}
