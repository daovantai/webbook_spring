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
import webb.model.TaiKhoan;

@Controller
@RequestMapping("/checkout")
public class CheckOut {
	private infData inf;
	@Autowired
	public CheckOut (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String checkot(HttpSession ss, Model model) {
		String name=(String) ss.getAttribute("tendn");
		model.addAttribute("tendnn",name);
		List<Cart> list= inf.listcart(name);
		model.addAttribute("listcart",list);
		int sumT = 0;
		for(Cart cart: list) {
			sumT += cart.getTong();
		}
		model.addAttribute("sumT", sumT);
		TaiKhoan tk= inf.findbyuser(name);
		int sdt= tk.getSdt();
		model.addAttribute("sdt",sdt);
		String email=tk.getEmail();
		model.addAttribute("email",email);
		return "checkout";
	}
}
