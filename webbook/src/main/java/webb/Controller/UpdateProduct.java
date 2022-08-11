package webb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webb.data.infData;
import webb.model.Sach;
import webb.model.TypeBook;

@Controller
@RequestMapping("/updatepro")
public class UpdateProduct {
	private infData inf;
	@Autowired
	public UpdateProduct (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String viewupdate(@RequestParam("id") String id,Model model) {
		Sach s= inf.findbybook(id);
		model.addAttribute("s",s);
		List<TypeBook> list= inf.listtype();
		model.addAttribute("list",list);
		return "viewupdatepro";
	}
	@PostMapping
	public String updatepro(@RequestParam("tensach") String tensach,@RequestParam("tacgia") String tacgia,
			@RequestParam("nxb") String nxb,@RequestParam("theloai") String theloai,@RequestParam("sluong") int sluong,
			@RequestParam("anh") String anh,@RequestParam("hot") int hot,@RequestParam("gia") int gia, Model model,@RequestParam("code") String code,RedirectAttributes rA) {
		Sach s= new Sach();
		
		s.setTensach(tensach);
		s.setTacgia(tacgia);
		s.setNxb(nxb);
		s.setTheloai(theloai);
		s.setSluong(sluong);
		s.setImg(anh);
		s.setHot(hot);
		s.setGia(gia);
		boolean check=true;
		if(check==true) {
			inf.updateproduct(s, code);
		}
		
		else {
			Sach b= inf.findbybook(code);
			model.addAttribute("s",b);
			model.addAttribute("mess","Mã sách đã tồn tại");
			return "viewupdatepro";
		}
		
		return "redirect:/listproduct";
	}
	
}
