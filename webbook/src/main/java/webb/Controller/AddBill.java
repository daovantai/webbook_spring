package webb.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webb.data.infData;
import webb.model.Bill;
import webb.model.Cart;

@Controller
@RequestMapping("/addbill")
public class AddBill {
	private infData inf;
	@Autowired
	public AddBill(infData inf) {
		this.inf=inf;
	}
	@PostMapping
	public String addbill(@RequestParam("name") String username,@RequestParam("email") String email,@RequestParam("city") String city,@RequestParam("sdt") int sdt,@RequestParam("add") String add) {
		Bill bill= new Bill();
		List<Cart> list= inf.listcart(username);
		int tong=0;
		for(Cart cart:list) {
			  tong+= cart.getGia();
		}
		int idb = inf.getIdBill().getIdbill();
		bill.setIdbill(idb+1);
		
		bill.setUsername(username);
		bill.setEmail(email);
		bill.setSdt(sdt);
		bill.setCity(city);
		bill.setAdd(add);
		bill.setTotal(tong);
		
		
		for(Cart cart:list) {
			inf.updatebuybook(cart.getIdproduct(), cart.getNum());
		}
		Date datee = new Date();
        String ngayMua = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime());
		bill.setDate(ngayMua);
		inf.addbill(bill);
		inf.deletecartbuy(username);
		
		return "redirect:/checkout";
	}
}
