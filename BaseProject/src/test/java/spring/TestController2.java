package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController2 {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String load() {
		return "index";
	}
	
}
