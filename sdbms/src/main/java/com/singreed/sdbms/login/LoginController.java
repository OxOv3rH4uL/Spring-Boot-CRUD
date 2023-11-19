package com.singreed.sdbms.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String home() {
		return "homePage";
	}
}
