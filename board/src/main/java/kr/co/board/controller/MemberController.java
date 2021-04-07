package kr.co.board.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.board.dto.MemberDTO;
import kr.co.board.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	//비밀번호 변경
	@RequestMapping("/member/pwdChkOk")
	public void pwdChkOk(@RequestBody String pwd,PrintWriter out,HttpSession session) {
		String userId = (String) session.getAttribute("userid");
		String pwdOk = (String) session.getAttribute("pwdOk");
		if(pwdOk!=null) {
			memberMapper.updatePwd(pwd, userId);
			out.print("비밀번호가 변경되었습니다");
		}else {
			out.print("기존비밀번호를 확인하세요");
		}
	}
	
	//비밀번호 체크
	@RequestMapping("/member/pwdChk")
	public void pwdChk(@RequestBody String pwd,PrintWriter out,HttpSession session) {
		String userId = (String) session.getAttribute("userid");
		int count = memberMapper.login(userId, pwd);
		if(count==1) {
			out.write("비밀번호가 일치합니다.");
			session.setAttribute("pwdOk", "1");
		}else {
			out.write("비밀번호가 틀립니다.");
		}
	}
	
	//회원정보 조회
	@RequestMapping("/member/userdetail")
	public String userDetail(HttpSession session,Model model) {
		String userId = (String) session.getAttribute("userid");
		MemberDTO dto = memberMapper.getOne(userId);
		model.addAttribute("dto",dto);
		return "/member/userdetail";
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}

	//로그인 뷰
	@RequestMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	//로그인 완료
	@RequestMapping("/member/loginOk")
	public String loginOk(HttpServletRequest request,HttpSession session) {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		int count = memberMapper.login(userid, pwd);
		String username = memberMapper.getUsername(userid);
		if(count==1) {
			session.setAttribute("username",username);
			session.setAttribute("userid",userid);
			return "redirect:/list";
		}else {
			return "redirect:/member/login?chk=1";
		}
	}
	
	//회원 가입
	@ResponseBody
	@PostMapping("/member/joinOk")
	public void joinOk(@RequestBody MemberDTO dto, PrintWriter out) {
		memberMapper.registerMember(dto);
		out.print("suesss");
	}
	
	//회원 가입 뷰
	@RequestMapping("/member/join")
	public String join() {
		return "/member/join";
	}
}

