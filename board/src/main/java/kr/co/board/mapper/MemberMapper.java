package kr.co.board.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.board.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	//회원등록
	@Insert("insert into member(no,userid,username,pwd,email,zipcode,addr,addr_detail) "
			+ " values(s_member.nextval,#{dto.userid},#{dto.username},#{dto.pwd},#{dto.email},#{dto.zipcode}"
			+ " , #{dto.addr},#{dto.addr_detail})")
	int registerMember(@Param("dto")MemberDTO dto);
	
	//로그인 체크
	@Select("select count(*) from member where userid=#{param1} and pwd =#{param2}")
	int login(String userid,String pwd);
	
	
	//회원이름 조회
	@Select("select username from member where userid=#{param1}")
	String getUsername(String userId);
	
	//회원 단일 조회
	@Select("select * from member where userid=#{param1}")
	MemberDTO getOne(String userId);
	
	//비밀번호 수정
	@Update("update member set pwd=#{param1} where userid=#{param2}")
	int updatePwd(String pwd,String userId);
	
}
