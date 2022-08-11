package webb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaiKhoan {
	private String hoten;
	private String tendn;
	private String email;
	private int sdt;
	private String matkhau,img;
	
	
}
