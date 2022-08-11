package webb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cart {
	private int idcart, gia,num,tong;
	private String username, idproduct, nameproduct,img;
}
