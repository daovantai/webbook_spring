package webb.data;

import java.util.List;

import webb.model.Bill;
import webb.model.Cart;
import webb.model.Sach;
import webb.model.TaiKhoan;
import webb.model.TypeBook;
import webb.model.WishList;

public interface infData {
	
	void addTaiKhoan(String hoten,String tendn,String email,int sdt,String matkhau);
	List<TaiKhoan> dangnhap(TaiKhoan tk);
	List<Sach> listbook();
	List<TaiKhoan> check(String tendn);
	List<Sach> bookhot(int hot);
	List<Sach> listname(String theloai);
	Cart getidcart();
	Cart findbyidcart(int id);
	Sach findbybook(String masach);
	Cart savecart(Cart cart);
	List<Cart> listcart(String username);
	void deletecart(int id);
	void updateplusnum(int id);
	void updateminusnum(int id);
	void updategia(int id, int gia);
	int getnumcart(int id);
	TaiKhoan findbyuser(String username);
	Bill getIdBill();
	void addbill(Bill bill);
	void updatebuybook(String id, int sluong);
	void deletecartbuy(String username);
	void updatepass(String username,String mk);
	List<Bill> listbill();
	List<TaiKhoan> listuser();
	void deldeteuser(String id);
	void donebill(String idbill);
	void deleteproduct(String idsach);
	void addbook(Sach sach);
	List<Sach> checkidbook(String id);
	void updateproduct(Sach s, String id);
	List<TypeBook> listtype();
	void addwishlist(WishList w);
	WishList getidwishlist();
	List<WishList> listwish(String username);
	List<WishList> checkwishlist(String username,String idsach);
	List<Cart> checkcart(String username, String idsach);
	void updatetrungcart(String username,String idsach);
	
}
