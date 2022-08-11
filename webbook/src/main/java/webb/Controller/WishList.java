package webb.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webb.data.infData;

@Controller
@RequestMapping("/wishlist")
public class WishList {
	private infData inf;
	@Autowired
	public WishList (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String wishlist(Model model,HttpSession ss) {
		String username= (String) ss.getAttribute("tendn");
		List<webb.model.WishList> list= inf.listwish(username);
		model.addAttribute("list",list);
		return "wishlist";
	}
}
