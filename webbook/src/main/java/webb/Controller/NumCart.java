package webb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;

@Controller
@RequestMapping("/numCart")
public class NumCart {
	private infData inf;
	@Autowired
	public NumCart(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String numcart(@RequestParam(value = "id") int id, @RequestParam(value = "check") String check,@RequestParam(value = "idpro") String idpro) {
		if(check.equals("plus")) {
			inf.updateplusnum(id);;
		}
		else {
			inf.updateminusnum(id);;
		}
		int num= inf.getnumcart(id);
		int gia= inf.findbybook(idpro).getGia();
		int tong=num*gia;
		inf.updategia(id, tong);
		return "redirect:/cart";
	}

}
