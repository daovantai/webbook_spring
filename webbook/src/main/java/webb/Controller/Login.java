package webb.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;
import webb.model.Bill;
import webb.model.Cart;
import webb.model.TaiKhoan;

@Controller
@RequestMapping("/dangnhap")
public class Login {
	private infData inf;
	@Autowired
	public Login(infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String dn() {
		return "Dangnhap";
	}
	@PostMapping
	public String dangnhap(HttpSession ss,@RequestParam("tendn1") String tendn,@RequestParam("matkhau1") String matkhau,Model model) {
		TaiKhoan tk= new TaiKhoan();
		tk.setTendn(tendn);
		tk.setMatkhau(matkhau);
			if(tendn.equals("admin")&& matkhau.equals("123")){
				List<Bill> list= inf.listbill();
				model.addAttribute("list",list);
				return "admin";
			}
			else {
				
			
			if(inf.dangnhap(tk).isEmpty()) {
				model.addAttribute("mess","Sai tên đăng nhập hoặc mật khẩu");
				return "Dangnhap";
			}
			else {
				ss.setAttribute("tendn", tendn);
				model.addAttribute("tendnn",ss.getAttribute("tendn"));
				String name= (String) ss.getAttribute("tendn");
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
				return "user";
			}
			
		}
	}
	
}
