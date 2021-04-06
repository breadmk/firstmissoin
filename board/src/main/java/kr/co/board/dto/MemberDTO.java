package kr.co.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

	private int no;
	private String userid,username,pwd,email,zipcode,addr,addr_detail;
}
