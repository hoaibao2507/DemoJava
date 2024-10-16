package survey.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public Object profile(HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie:cookies) {
			if (cookie.getName().equals("token")) {
				if (cookie.getValue().equals("67890")) {
					model.addAttribute("name", "Duong Nguyen Hoai Bao");
					return "auth/profile";
				}
			}
		}
		return new RedirectView("/ltweb5");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> frmData, Model model, HttpServletResponse response) {
		if(frmData.get("username").equals("hoaibao") && frmData.get("pw").equals("12345")) {
			System.out.println("Dang nhap thanh cong");
			
			model.addAttribute("name", "Duong Nguyen Hoai Bao");
			
			Cookie cookie = new Cookie("token", "67890");
			cookie.setMaxAge(60 * 60);
			cookie.setPath("/ltweb5");
			response.addCookie(cookie);
			
			
			return "auth/profile";
		}
		return "auth/error";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public RedirectView logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("token", "");
		cookie.setMaxAge(0);
		cookie.setPath("/ltweb5");
		response.addCookie(cookie);
		return new RedirectView("/ltweb5");
	}
}
