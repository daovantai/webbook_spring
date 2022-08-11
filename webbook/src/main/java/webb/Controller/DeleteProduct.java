package webb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;

@Controller
@RequestMapping("/deletepro")
public class DeleteProduct {
	private infData inf;
	@Autowired
	public DeleteProduct(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String deletepro(@RequestParam(value = "id") String id) {
		inf.deleteproduct(id);
		return "redirect:/listproduct";
	}
}
