package webb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;

@Controller
@RequestMapping("/deleteuser")
public class DeleteUser {
	private infData inf;
	@Autowired
	public DeleteUser(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String deleteuser(@RequestParam(value = "id") String id) {
		inf.deldeteuser(id);
		return "redirect:/listuser";
	}

}
