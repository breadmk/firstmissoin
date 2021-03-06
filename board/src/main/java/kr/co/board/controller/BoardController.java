package kr.co.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board.dto.BoardDTO;
import kr.co.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//비밀번호 확인후 글 수정
	@RequestMapping("/board/updateOk")
	public String updateOk(BoardDTO dto) {
		int no = dto.getNo();
		String pwd = boardMapper.getPwd(no);
		if(pwd.equals(dto.getPwd())) {
			boardMapper.update(dto);	
			return "redirect:/board/content/"+no;
		}else {
			return "redirect:/board/update/"+no+"?chk=1";
		}
	}
	
	//글 수정을 위한 뷰
	@RequestMapping("/board/update/{no}")
	public String Update(@PathVariable int no, Model model) {
		BoardDTO dto = boardMapper.getOne(no);
		model.addAttribute("dto",dto);
		return "/board/update";
	}
	
	//글 삭제
	@RequestMapping("/board/deleteOk/{no}")
	public String deleteOk(@PathVariable int no) {
		boardMapper.deleteOk(no);
		return "redirect:/list";
	}
	
	//단일 글 조회
	@RequestMapping("/board/content/{no}")
	public String content(@PathVariable int no,Model model) {
		BoardDTO dto = boardMapper.getOne(no);
		model.addAttribute("dto",dto);
		return "/board/content";
	}
	
	//글 등록-2
	@RequestMapping("/board/registerOk")
	public String registerOk(BoardDTO dto) {
		boardMapper.register(dto);
		return "redirect:/list";
	}
	
	//글 등록 뷰-1
	@RequestMapping("/board/register")
	public String register() {
		return "board/register";
	}
	
	//전체 게시글 + 검색
	@RequestMapping("/list")
	public String index(Model model,HttpServletRequest request) {
		String searchOption = request.getParameter("searchOption");
		String keyword = request.getParameter("keyword");
		HashMap<String, String> search = new HashMap<>();
		search.put(searchOption, keyword);
		List<BoardDTO> list = new ArrayList<>();
		if(search.get(searchOption)==null)
			list = boardMapper.getAll("where writedate like","");
		else if (searchOption.equals("name"))
			list = boardMapper.getAll("where name like", keyword);
		else if (searchOption.equals("title"))
			list = boardMapper.getAll("where title like", keyword);
		model.addAttribute("list",list);
		return "/board/list";
	}
	
	
	
	
	
	
	
	
	
}
