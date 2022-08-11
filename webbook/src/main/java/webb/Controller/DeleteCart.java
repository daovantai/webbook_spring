package webb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;

@Controller
@RequestMapping("/deletecart")
public class DeleteCart {
	private infData inf;
	@Autowired
	public DeleteCart(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String deletecart(@RequestParam(value = "id") int id) {
		inf.deletecart(id);
		return "redirect:/cart";
	}
}
