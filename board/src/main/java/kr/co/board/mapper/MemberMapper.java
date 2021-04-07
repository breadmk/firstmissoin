package kr.co.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.board.dto.MemberBoardDTO;
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
	
	@Update("update member set pwd=#{param1} where userid=#{param2}")
	int updatePwd(String pwd,String userid);
	
	@Select("select m.no,m.userid,m.username,m.email,m.addr,count(b.no) as count "
			+ " from board b,member m"
			+ " where b.name(+) = m.username"
			+ " group by m.no,m.userid,m.username,m.email,m.addr")
	List<MemberBoardDTO> getAll();
	
}
