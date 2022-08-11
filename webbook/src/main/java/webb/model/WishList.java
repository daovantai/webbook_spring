package webb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WishList {
	private int id,sluong,gia;
	private String username,tensach,img,idsach;
}
