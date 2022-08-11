package webb.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webb.data.infData;
import webb.model.Cart;

@Controller
@RequestMapping("/addcart")
public class AddToCart {
	private infData inf;
	@Autowired
	public AddToCart (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String addtocart(@RequestParam(value = "id") String idsach,HttpSession ss,Model model,RedirectAttributes rA) {
		String name= (String) ss.getAttribute("tendn");
		int slc= inf.findbybook(idsach).getSluong();
		int idcart= inf.getidcart().getIdcart();
		int gia= inf.findbybook(idsach).getGia();
		String tensach= inf.findbybook(idsach).getTensach();
		String img=inf.findbybook(idsach).getImg();
		if(slc>0) {
			if(inf.checkcart(name, idsach).isEmpty()) {
				Cart cart= new Cart();
				cart.setIdcart(idcart+1);
				cart.setIdproduct(idsach);
				cart.setUsername(name);
				cart.setNameproduct(tensach);
				cart.setGia(gia);
				cart.setImg(img);
				inf.savecart(cart);
				rA.addFlashAttribute("mess", "Thêm vào giỏ hàng thành công");
			}
			else {
				inf.updatetrungcart(name, idsach);
			}
			
		}
		else {
			rA.addFlashAttribute("mess","Sản phẩm tạm thời hết hàng ");
			return "redirect:/thuviensach";
		}
		return "redirect:/thuviensach";
	}
}
