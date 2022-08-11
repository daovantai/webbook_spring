package webb.Controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webb.data.infData;

import webb.model.TaiKhoan;

@Controller
@RequestMapping("/infor")
public class ProFile {
	private infData inf;
	@Autowired
	public ProFile(infData inf) {
		this.inf=inf;
	}
	
	@GetMapping
	public String profile(HttpSession ss, Model model) {
		String name=(String) ss.getAttribute("tendn");
		model.addAttribute("tendnn",name);
		
		
		TaiKhoan tk= inf.findbyuser(name);
		String hoten=tk.getHoten();
		model.addAttribute("hoten",hoten);
		int sdt= tk.getSdt();
		model.addAttribute("sdt",sdt);
		String email=tk.getEmail();
		model.addAttribute("email",email);
		String matkhau=tk.getMatkhau();
		model.addAttribute("matkhau",matkhau);
		String img=tk.getImg();
		model.addAttribute("img",img);
		return "profile";
	}
	@PostMapping
	public String updatepass(HttpSession ss,@RequestParam("doimk") String doimk,Model model,RedirectAttributes rA) {
		String name=(String) ss.getAttribute("tendn");
		TaiKhoan tk= inf.findbyuser(name);
		String matkhau=tk.getMatkhau();
		if(doimk.equals(matkhau)) {
			rA.addFlashAttribute("mess", "Mật khẩu trùng mật khẩu cũ");
		}
		else {
		inf.updatepass(name, doimk);
		rA.addFlashAttribute("mess", "Đổi mật khẩu thành công");
		}
		return "redirect:/infor";
	}

}
