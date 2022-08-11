package webb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webb.data.infData;
import webb.model.Sach;


@Controller
@RequestMapping("/listproduct")
public class ListProduct {
	private infData inf;
	@Autowired
	public ListProduct(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String listproduct(Model model) {
		List<Sach> list= inf.listbook();
		model.addAttribute("list",list);
		
		return "listproduct";
	}
}
