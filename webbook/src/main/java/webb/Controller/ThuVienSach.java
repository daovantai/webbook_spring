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
import webb.model.Sach;
import webb.model.TypeBook;



@Controller
@RequestMapping("/thuviensach")
public class ThuVienSach {
	private infData inf;
	@Autowired
	public ThuVienSach(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String thuvien(Model model,HttpSession ss) {
//		List<Sach> list= inf.listbook();
//		model.addAttribute("list",list);
		String name= (String) ss.getAttribute("tendn");
		model.addAttribute("tendnn",ss.getAttribute("tendn"));
		List<Sach> list= inf.bookhot(1);
		model.addAttribute("list",list);
		List<Sach> truyentranh= inf.listname("Tryện tranh");
		model.addAttribute("truyentranh",truyentranh);
		List<Sach> khoahoc= inf.listname("Khoa học");
		model.addAttribute("khoahoc",khoahoc);
		List<Sach> vanhoc= inf.listname("Văn học");
		model.addAttribute("vanhoc",vanhoc);
		List<Sach> tieuthuyet= inf.listname("Tiểu thuyết");
		model.addAttribute("tieuthuyet",tieuthuyet);
		
		List<TypeBook> listtype= inf.listtype();
		model.addAttribute("listtype",listtype);
		List<Cart> listsmall= inf.listcart(name);
		model.addAttribute("listsmall",listsmall);
		int total=0;
		int sumT = 0;
		for(Cart cart: listsmall) {
			total+=cart.getTong();
			sumT += 1;
			
		}
		model.addAttribute("total",total);
		model.addAttribute("sumT",sumT);
		return "thuviensach";
		
	}
}
