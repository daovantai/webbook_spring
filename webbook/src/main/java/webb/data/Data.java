package webb.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import webb.model.Bill;
import webb.model.Cart;
import webb.model.Sach;
import webb.model.TaiKhoan;
import webb.model.TypeBook;
import webb.model.WishList;

@Repository
public class Data implements infData {
	private JdbcTemplate jdbc;
	
	@Autowired
	public Data (JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	private TaiKhoan mapRowToTaiKhoan(ResultSet rs, int rowNum) throws SQLException{
		TaiKhoan tk= new TaiKhoan();
		tk.setHoten(rs.getString("hoten"));
		tk.setTendn(rs.getString("tendn"));
		tk.setEmail(rs.getString("email"));
		tk.setSdt(rs.getInt("sdt"));
		tk.setMatkhau(rs.getString("matkhau"));
		tk.setImg(rs.getString("img"));
		return tk;
	}
	private Sach mapRowToBook(ResultSet rs, int rowNum) throws SQLException{
		Sach s= new Sach();
		s.setMasach(rs.getString("idsach"));
		s.setTensach(rs.getString("tensach"));
		s.setTacgia(rs.getString("tacgia"));
		s.setNxb(rs.getString("nxb"));
		s.setTheloai(rs.getString("theloai"));
		s.setTtrang(rs.getString("tinhtrang"));
		s.setSluong(rs.getInt("sluong"));
		s.setImg(rs.getString("img"));
		s.setHot(rs.getInt("hot"));
		s.setGia(rs.getInt("gia"));
		return s;
	}
	private Cart mapRowToCarts(ResultSet rs, int rowNum) throws SQLException {
		Cart carts = new Cart();
		carts.setIdcart(rs.getInt("idcart"));

		return carts;

	}
	private WishList mapRowToidWishList(ResultSet rs, int rowNum) throws SQLException {
		WishList s = new WishList();
		s.setId(rs.getInt("id"));

		return s;

	}
	private WishList mapRowToWishList(ResultSet rs, int rowNum) throws SQLException {
		WishList s = new WishList();
		s.setId(rs.getInt("id"));
		s.setUsername(rs.getString("username"));
		s.setTensach(rs.getString("tensach"));
		s.setSluong(rs.getInt("sluong"));
		s.setImg(rs.getString("img"));
		s.setGia(rs.getInt("gia"));
		s.setIdsach(rs.getString("idsach"));
		return s;
	}
	
	private Cart mapRowCart(ResultSet rs, int rowNum) throws SQLException{
		Cart cart= new Cart();
		cart.setIdcart(rs.getInt("idcart"));
		cart.setUsername(rs.getString("username"));
		cart.setIdproduct(rs.getString("idsach"));
		cart.setNameproduct(rs.getString("tensach"));
		cart.setGia(rs.getInt("gia"));
		cart.setImg(rs.getString("img"));
		cart.setNum(rs.getInt("num"));
		cart.setTong(rs.getInt("tong"));
		return cart;
	}
	private Bill mapRowToidBill(ResultSet rs, int rowNum) throws SQLException{
		Bill bill= new Bill();
		bill.setIdbill(rs.getInt("idbill"));
		return bill;
	}
	private Bill mapRowToBill(ResultSet rs, int rowNum) throws SQLException{
		Bill bill= new Bill();
		bill.setIdbill(rs.getInt("idbill"));
		bill.setUsername(rs.getString("username"));
		bill.setEmail(rs.getString("email"));
		bill.setSdt(rs.getInt("sdt"));
		bill.setCity(rs.getString("city"));
		bill.setAdd(rs.getString("address"));
		bill.setDate(rs.getString("datee"));
		bill.setTotal(rs.getInt("total"));
		return bill;
	}
	private TypeBook mapRowToTypeBook(ResultSet rs, int rowNum) throws SQLException{
		TypeBook type= new TypeBook();
		type.setIdtype(rs.getInt("id"));
		type.setType(rs.getString("type"));
		return type;
	}
	
	@Override
	public void addTaiKhoan(String hoten, String tendn, String email, int sdt, String matkhau) {
		jdbc.update("insert into taikhoan values(?,?,?,?,?)", hoten, tendn, email,sdt,matkhau);
		
	}
	@Override
	public List<TaiKhoan>  dangnhap(TaiKhoan tk) {
		
		return (List<TaiKhoan>) jdbc.query("select * from taikhoan where tendn=? and matkhau=?", this::mapRowToTaiKhoan,tk.getTendn(),tk.getMatkhau());
	}
	@Override
	public List<Sach> listbook() {
		
		return (List<Sach>) jdbc.query("select * from khosach", this::mapRowToBook);
	}
	@Override
	public List<TaiKhoan> check(String tendn) {
		
		return (List<TaiKhoan>) jdbc.query("select * from taikhoan where tendn=? ", this::mapRowToTaiKhoan,tendn);
	}
	@Override
	public List<Sach> bookhot(int hot) {
		
		return (List<Sach>) jdbc.query("select * from khosach where hot=?", this::mapRowToBook,hot);
	}
	@Override
	public List<Sach> listname(String theloai) {
		
		return (List<Sach>) jdbc.query("select * from khosach where theloai=?", this::mapRowToBook,theloai);
	}
	@Override
	public Cart getidcart() {
		
		return (Cart) jdbc.queryForObject("select idcart from cart ORDER BY 1 DESC limit 1", this::mapRowToCarts);
	}
	@Override
	public Sach findbybook(String masach) {
		
		return (Sach) jdbc.queryForObject("select * from khosach where idsach=? ", this::mapRowToBook, masach);
	}
	@Override
	public Cart savecart(Cart cart) {
		jdbc.update("insert into cart (idcart, username, idsach, tensach, gia,img,num,tong) values (?, ?, ?, ?, ?, ?,1,?)", cart.getIdcart(), cart.getUsername(),
				cart.getIdproduct(),cart.getNameproduct(), cart.getGia(),cart.getImg(),cart.getGia());

		return cart;
	}
	@Override
	public List<Cart> listcart(String username) {
		
		return (List<Cart>) jdbc.query("select * from cart where username=?", this::mapRowCart,username);
	}
	@Override
	public void deletecart(int id) {
		jdbc.update("delete from cart where idcart=?",id);
		
	}
	@Override
	public void updateplusnum(int id) {
		jdbc.update("update cart set num=num+1 where idcart=?", id);
		
	}
	@Override
	public void updateminusnum(int id) {
		jdbc.update("update cart set num=num-1 where idcart=?", id);
		
	}
	@Override
	public void updategia(int id, int gia) {
		jdbc.update("update cart set tong=? where idcart=?", gia, id);
		
	}
	@Override
	public Cart findbyidcart(int id) {
		
		return (Cart) jdbc.queryForObject("select * from cart where idcart=? ", this::mapRowCart, id);
	}
	
	private int mapRowToNumCart(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("num");

	}
	@Override
	public int getnumcart(int id) {
		
		return (int) jdbc.queryForObject("select num from cart where idcart=? ", this::mapRowToNumCart, id);
	}
	@Override
	public TaiKhoan findbyuser(String username) {
		
		return (TaiKhoan) jdbc.queryForObject("select * from taikhoan where tendn=?",this::mapRowToTaiKhoan,username);
	}
	@Override
	public Bill getIdBill() {
		return (Bill) jdbc.queryForObject("select idbill from bill ORDER BY 1 DESC limit 1", this::mapRowToidBill);
	}
	@Override
	public void addbill(Bill bill) {
		jdbc.update("insert into bill(idbill, username, email, sdt, city,address,datee,total) values(?,?,?,?,?,?,?,?)", bill.getIdbill(), bill.getUsername(), bill.getEmail(),bill.getSdt()
				,bill.getCity(),bill.getAdd(),bill.getDate(),bill.getTotal());
		
	}
	@Override
	public void updatebuybook(String id, int sluong) {
		jdbc.update("update khosach set sluong=sluong-? where idsach=?", sluong, id);
		
	}
	@Override
	public void deletecartbuy(String username) {
		jdbc.update("delete from cart where username=?",username);
		
	}
	@Override
	public void updatepass(String username, String mk) {
		jdbc.update("update taikhoan set matkhau=? where tendn=?", mk, username);
		
	}
	@Override
	public List<Bill> listbill() {
		
		return (List<Bill>) jdbc.query("select * from bill", this::mapRowToBill);
	}
	@Override
	public List<TaiKhoan> listuser() {
		
		return (List<TaiKhoan>) jdbc.query("select * from taikhoan", this::mapRowToTaiKhoan);
	}
	@Override
	public void deldeteuser(String id) {
		jdbc.update("delete from taikhoan where tendn=?",id);
		
	}
	@Override
	public void donebill(String idbill) {
		jdbc.update("delete from bill where idbill=?",idbill);
		
	}
	@Override
	public void deleteproduct(String idsach) {
		jdbc.update("delete from khosach where idsach=?",idsach);
		
	}
	@Override
	public void addbook(Sach sach) {
		
		jdbc.update("insert into khosach(idsach, tensach, tacgia, nxb, theloai,tinhtrang,sluong,img,hot,gia) values(?,?,?,?,?,?,?,?,?,?)", sach.getMasach(), sach.getTensach(), sach.getTacgia(),sach.getNxb()
				,sach.getTheloai(),1,sach.getSluong(),sach.getImg(),sach.getHot(),sach.getGia());
		
	}
	@Override
	public List<Sach> checkidbook(String id) {
		
		return (List<Sach>) jdbc.query("select * from khosach where idsach=?", this::mapRowToBook,id);
	}
	@Override
	public void updateproduct(Sach s, String id) {
		jdbc.update("update khosach set  tensach= ?, tacgia=?, nxb=?, theloai=?,sluong=?,img=?,hot=?,gia=? where idsach=?",  s.getTensach(), s.getTacgia(),s.getNxb()
				,s.getTheloai(),s.getSluong(),s.getImg(),s.getHot(),s.getGia(),id);
		
	}
	@Override
	public List<TypeBook> listtype() {
		
		return (List<TypeBook>) jdbc.query("select * from typebook", this::mapRowToTypeBook);
	}
	@Override
	public void addwishlist(WishList s) {
		jdbc.update("insert into wishlist(id, username, tensach, sluong, img,gia,idsach) values(?,?,?,?,?,?,?)", s.getId(), s.getUsername(), s.getTensach(),s.getSluong()
				,s.getImg(),s.getGia(),s.getIdsach());
		
	}
	@Override
	public WishList getidwishlist() {
		return (WishList) jdbc.queryForObject("select id from wishlist ORDER BY 1 DESC limit 1", this::mapRowToidWishList);
	}
	@Override
	public List<WishList> listwish(String username) {
		
		return (List<WishList>) jdbc.query("select * from wishlist where username=?", this::mapRowToWishList,username);
	}
	@Override
	public List<WishList> checkwishlist(String username, String idsach) {
		
		return (List<WishList>) jdbc.query("select * from wishlist where username=? and idsach=?", this::mapRowToWishList,username,idsach);
	}
	@Override
	public List<Cart> checkcart(String username, String idsach) {
		
		return (List<Cart>) jdbc.query("select * from cart where username=? and idsach=? ", this::mapRowCart,username,idsach);
	}
	@Override
	public void updatetrungcart(String username, String idsach) {
		jdbc.update("update cart set num=num+1 ,tong=tong+gia where username=? and idsach=?", username,idsach);
		
	}
	
	
	
	

}
