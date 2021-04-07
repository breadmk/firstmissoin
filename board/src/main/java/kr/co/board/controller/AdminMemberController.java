package kr.co.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.board.api.MailSend;
import kr.co.board.dto.MemberBoardDTO;
import kr.co.board.mapper.AdminMemberMapper;

@Controller
public class AdminMemberController {
	
	@Autowired
	private AdminMemberMapper adminMemberMapper;
	
	//메일 발송
		@RequestMapping("/member/email/{no}")
		public String emailSend(@PathVariable int no) throws Exception {
			
			String email = adminMemberMapper.getEmail(no);
			adminMemberMapper.updateState(no);
			MailSend ams = MailSend.getInstance();
			String subject = "[ezens] 회원가입을 축하드립니다.";
			String body= "안녕하세요 고객님\n" + "회원가입을 진심으로 축하드립니다.";
			ams.setEmail(email, subject, body);
			return "redirect:/member/admin";
		}
		
		//회원 탈퇴
		@RequestMapping("/member/admin/deleteOk/{no}")
		public String deleteOk(@PathVariable int no) {
			adminMemberMapper.deleteMember(no);
			return "redirect:/member/admin";
		}
		
		//회원목록 조회
		@RequestMapping("/member/admin")
		public String admin(Model model) {
		   List<MemberBoardDTO> list = adminMemberMapper.getAll();
		   model.addAttribute("list",list);
		   return "/member/memberlist";
		}
}
