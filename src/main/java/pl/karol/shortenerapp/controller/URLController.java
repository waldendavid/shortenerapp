package pl.karol.shortenerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.karol.shortenerapp.service.UrlServiceImpl;

@Controller
public class URLController {

	private UrlServiceImpl urlService;

	@Autowired
	public URLController(UrlServiceImpl theUrlService) {
		urlService = theUrlService;
	}
	
	@GetMapping("/")
	public String getIndex(Model model) {
		String longUrlString = new String();
		model.addAttribute("longUrl", longUrlString);
		return "index";
	}

	@RequestMapping(value = "/link/{id}", method = RequestMethod.GET)
	public ModelAndView getLongUrl(@PathVariable String id) {
		return new ModelAndView("redirect:" + urlService.getLongUrl(id));
	}

	@PostMapping("/link") // shorter annotation that GET above
	public String addUrl(@ModelAttribute String longUrl, Model model
	// ,@RequestBody String longUrl
	) {
		model.addAttribute("shortUrl", urlService.makeBoxUrl("LongUrl"));
		// return urlService.makeBoxUrl(longUrl);
		return "hello";

	}
}
