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
	MemberMapper memberMapper;
	
	@RequestMapping("/member/pwdChk")
	public void pwdChk(@RequestBody String pwd,PrintWriter out) {
		System.out.println(pwd);
		out.write("dd");
	}
	
	@RequestMapping("/member/userdetail")
	public String userDetail(HttpSession session,Model model) {
		String userid = (String) session.getAttribute("userid");
		MemberDTO dto = memberMapper.getOne(userid);
		model.addAttribute("dto",dto);
		return "/member/userdetail";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}

	@RequestMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
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
	
	@ResponseBody
	@PostMapping("/member/joinOk")
	public void joinOk(@RequestBody MemberDTO dto, PrintWriter out) {
		memberMapper.registerMember(dto);
		out.print("suesss");
	}
	
	@RequestMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
}










