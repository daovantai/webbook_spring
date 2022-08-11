package webb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webb.data.infData;
import webb.model.Bill;

@Controller
@RequestMapping("/listbill")
public class ListBill {
	private infData inf;
	@Autowired
	public ListBill(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String listbill(Model model) {
		List<Bill> list= inf.listbill();
		model.addAttribute("list",list);
		return "admin";
	}
}
