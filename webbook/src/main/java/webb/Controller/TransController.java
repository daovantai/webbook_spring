package webb.Controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TransController {
	
	
	@GetMapping("/test")
	public String test() {
		return "header";
	}
	@GetMapping("/admin")
	public String testa() {
		return "admin";
	}
	
	
}
