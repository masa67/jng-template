package example.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("/")
	public String home() {
		return "redirect:/index.html";
	}
}
