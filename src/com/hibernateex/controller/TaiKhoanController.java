package com.hibernateex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hibernateex.entities.TaiKhoan;

@Controller
public class TaiKhoanController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(ModelMap mm) {
		mm.put("tk", new TaiKhoan());
		return "login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute(value="tk") TaiKhoan tk, ModelMap mm,HttpSession session)
	{
		if(tk.getUsername().equals("tri") && tk.getPassword().equals("123"))
		{
			session.setAttribute("username", tk.getUsername());
			return "welcome";
		}
		else
		{
			mm.put("message", "Tai khoan khong hop le<br>");
			return "login";
		}
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session)
	{
		session.removeAttribute("username");
		return "redirect:login";
	}
}
