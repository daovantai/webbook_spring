package webb.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class logout {
	@GetMapping
	public String dangxuat(HttpSession ss) {
		ss.removeAttribute("tendnn");
		return "redirect:/";
	}
}
