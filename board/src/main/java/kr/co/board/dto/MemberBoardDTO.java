package kr.co.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberBoardDTO {

	private int no,count;
	private String name,userid,username,pwd,email,zipcode,addr,addr_detail;
	
	
}
