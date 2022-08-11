package webb.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;

@Controller
@RequestMapping("/dangki")
public class AddAccout {
	private infData inf;
	@Autowired
	public AddAccout(infData inf) {
		this.inf=inf;
	}
	@PostMapping
	public String dangki(@RequestParam("hoten") String hoten, @RequestParam("tendn") String tendn, @RequestParam("email") String email,@RequestParam("sdt") int sdt,@RequestParam("matkhau") String matkhau,@RequestParam("nlmk") String nlmk,Model model) {
		
		if(inf.check(tendn).isEmpty()) {
			if(nlmk.equals(matkhau)) {
				
				inf.addTaiKhoan(hoten, tendn, email, sdt, matkhau);
				model.addAttribute("messs","Đăng ký thành công");
				return "Dangnhap";
			}
			else {
				model.addAttribute("mess","nhập lại mật khẩu chính xác");
				return "dangki";
			}
		}
		

		else {
			model.addAttribute("mess","Tên đăng nhập đã tồn tại");
			return "dangki";
		}
		
	}
}
