package webb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;

@Controller
@RequestMapping("/donebill")
public class DoneBill {
	private infData inf;
	@Autowired
	public DoneBill(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String donebill(@RequestParam(value = "id") String id) {
		inf.donebill(id);
		return "redirect:/listbill";
	}
}
