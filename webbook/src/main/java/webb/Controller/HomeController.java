package webb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webb.data.infData;
import webb.model.Sach;

@Controller
public class HomeController {
	private infData inf;
	@Autowired
	public HomeController(infData inf) {
		this.inf=inf;
	}
	@GetMapping("/")
	public String home(Model model) {
		List<Sach> list= inf.bookhot(1);
		model.addAttribute("list",list);
		List<Sach> truyentranh= inf.listname("Tryện tranh");
		model.addAttribute("truyentranh",truyentranh);
		List<Sach> khoahoc= inf.listname("Khoa học");
		model.addAttribute("khoahoc",khoahoc);
		List<Sach> vanhoc= inf.listname("Văn học");
		model.addAttribute("vanhoc",vanhoc);
		List<Sach> tieuthuyet= inf.listname("Tiểu thuyết");
		model.addAttribute("tieuthuyet",tieuthuyet);
		
		return "index";
	}
	
}
