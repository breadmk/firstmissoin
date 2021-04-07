package kr.co.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.board.dto.MemberBoardDTO;

@Mapper
public interface AdminMemberMapper {
	
    //메일발송
	@Select("select email from member where no=#{param1}")
	String getEmail(int no);
	
	//메일발송 완료
	@Update("update member set state=1 where no=#{param1}")
	int updateState(int no);
	
	//회원 삭제
	@Delete("delete from member where no=#{param1}")
	int deleteMember(int no);
	
	//관리자 페이지 전체 회원조회
	@Select("select m.no,m.userid,m.username,m.email,m.addr,m.state,count(b.no) as count "
			+ " from board b,member m"
			+ " where b.name(+) = m.username"
			+ " group by m.no,m.userid,m.username,m.email,m.addr,m.state")
	List<MemberBoardDTO> getAll();
}
