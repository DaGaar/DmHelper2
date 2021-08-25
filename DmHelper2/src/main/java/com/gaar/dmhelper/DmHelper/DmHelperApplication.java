package com.gaar.dmhelper.DmHelper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class DmHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmHelperApplication.class, args);
	}
	
	@GetMapping
	public String index() {
		return "index.html";
	}
}