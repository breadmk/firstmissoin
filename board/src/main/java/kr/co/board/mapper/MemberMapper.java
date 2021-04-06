package kr.co.board.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.board.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	@Insert("insert into member(no,userid,username,pwd,email,zipcode,addr,addr_detail) "
			+ " values(s_member.nextval,#{dto.userid},#{dto.username},#{dto.pwd},#{dto.email},#{dto.zipcode}"
			+ " , #{dto.addr},#{dto.addr_detail})")
	int registerMember(@Param("dto")MemberDTO dto);
	
	@Select("select count(*) from member where userid=#{param1} and pwd =#{param2}")
	int login(String userid,String pwd);
	
	@Select("select username from member where userid=#{param1}")
	String getUsername(String userid);
	
	@Select("select * from member where userid=#{param1}")
	MemberDTO getOne(String userid);
	
}
