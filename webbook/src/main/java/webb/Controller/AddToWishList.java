package webb.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;
import webb.model.Sach;
import webb.model.WishList;

@Controller
@RequestMapping("/addwhishlist")
public class AddToWishList {
	private infData inf;
	@Autowired
	public AddToWishList (infData inf) {
		this.inf=inf;
	}
	@GetMapping
	public String addwishlist(@RequestParam(value = "id") String idsach, HttpSession ss) {
		WishList w= new WishList();
		Sach s= inf.findbybook(idsach);
		int id= inf.getidwishlist().getId();
		int idn=(id+1);
		String username= (String) ss.getAttribute("tendn");
		String tensach= s.getTensach();
		int sluong= s.getSluong();
		String img=s.getImg();
		int gia=s.getGia();
		w.setId(idn);
		w.setUsername(username);
		w.setTensach(tensach);
		w.setSluong(sluong);
		w.setImg(img);
		w.setGia(gia);
		w.setIdsach(idsach);
		if(inf.checkwishlist(username, idsach).isEmpty()) {
			inf.addwishlist(w);
		}
		else {
			return "redirect:/thuviensach";
		}
		return "redirect:/thuviensach";
	}
}
