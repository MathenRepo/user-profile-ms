package com.user.micro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ErrorController {
	
	@GetMapping("/error")
	public ModelAndView errorPage() {
		
		return new ModelAndView("error");
	}


}
