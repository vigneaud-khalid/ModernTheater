package theatre.controleurs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
	@RequestMapping(value = {"/index"})
	public String afficherHome() {
		return "accueil";
	}
}