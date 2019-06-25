package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/trial")
public class TrialController {

	@RequestMapping("/hello")
	String Hello() {
		return "hello";
	}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String getDynamicUriValue(@PathVariable String id) {
        //System.out.println("ID is " + id);
        return "------"+id;
    }

    
    @RequestMapping(value="/string", method = RequestMethod.POST)
    String newEmployee(@RequestBody String newString) {
       return newString;
    }
}
