package webb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;
import webb.model.Sach;
import webb.model.TypeBook;

@Controller
@RequestMapping("/formaddpro")
public class FormAddProduct {
	private infData inf;
	@Autowired
	public FormAddProduct (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String formadd(Model model) {
		List<TypeBook> list= inf.listtype();
		model.addAttribute("list",list);
		return "formaddproduct";
	}
	@PostMapping
	public String addpro(@RequestParam("ms") String ms,@RequestParam("tensach") String tensach,@RequestParam("tacgia") String tacgia,
			@RequestParam("nxb") String nxb,@RequestParam("theloai") String theloai,@RequestParam("sluong") int sluong,
			@RequestParam("anh") String anh,@RequestParam("hot") int hot,@RequestParam("gia") int gia, Model model) {
		Sach s= new Sach();
		s.setMasach(ms);
		s.setTensach(tensach);
		s.setTacgia(tacgia);
		s.setNxb(nxb);
		s.setTheloai(theloai);
		s.setSluong(sluong);
		s.setImg(anh);
		s.setHot(hot);
		s.setGia(gia);
		if(inf.checkidbook(ms).isEmpty()) {
			inf.addbook(s);
			model.addAttribute("mess","Thêm sách thành công");
			return "redirect:/listproduct";
		}
		else {
			model.addAttribute("mess","Mã sách đã tồn tại");
			return "formaddproduct";
		}
		
	}
}
