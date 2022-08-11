package webb.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webb.data.infData;
import webb.model.Cart;

@Controller
@RequestMapping("/cart")
public class ViewCart {
	private infData inf;
	@Autowired
	public ViewCart (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String viewcart(HttpSession ss, Model model) {
		String username= (String) ss.getAttribute("tendn");
		model.addAttribute("tendnn",username);
		List<Cart> list= inf.listcart(username);
		model.addAttribute("listcart",list);
		int sumT = 0;
		for(Cart cart: list) {
			sumT += cart.getTong();
		}
		model.addAttribute("sumT", sumT);
		return "cart";
	}
}
