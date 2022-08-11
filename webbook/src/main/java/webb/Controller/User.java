package webb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webb.data.infData;

@Controller
@RequestMapping("/user")
public class User {
	private infData inf;
	@Autowired
	public User (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String user() {
		return "user";
	}
}
