package webb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Bill {
	private int idbill, total,sdt;
	private String email, add, city, date, username;
}
