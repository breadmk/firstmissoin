package kr.co.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	
	//게시글 등록
	@Insert("insert into board(no,title,name,content,pwd,writedate) values(s_board.nextval,#{dto.title,jdbcType=VARCHAR},#{dto.name,jdbcType=VARCHAR},#{dto.content,jdbcType=VARCHAR},#{dto.pwd,jdbcType=VARCHAR},sysdate)")
	int register(@Param("dto") BoardDTO dto);
	
	//게시글 검색
	@Select("select no,title,name,writedate from board ${where} '%${keyword}%' order by no desc")
	List<BoardDTO> getAll(@Param("where")String where, @Param("keyword")String keyword);
	
	//게시글 단일 조회
	@Select("select * from board where no=#{param1}")
	BoardDTO getOne(int no);
	
	//게시글 삭제
	@Delete("delete from board where no=#{param1}")
	int deleteOk(int no);

	//게시글 수정
	@Update("update board set title=#{dto.title},name=#{dto.name},content=#{dto.content} where no=#{dto.no}")
	int update(@Param("dto") BoardDTO dto);
	
	//게시글 수정을 위한 비밀번호 조회
	@Select("select pwd from board where no=#{param1}")
	String getPwd(int no);
}
