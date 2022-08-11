package webb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webb.data.infData;
import webb.model.TaiKhoan;

@Controller
@RequestMapping("/listuser")
public class ListUser {
	private infData inf;
	@Autowired
	public ListUser (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String listuser(Model model) {
		List<TaiKhoan> list= inf.listuser();
		model.addAttribute("list",list);
		
		return "listuser";
	}

}
