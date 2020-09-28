package pl.karol.shortenerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pl.karol.shortenerapp.service.UrlServiceImpl;

@RestController
@RequestMapping
public class URLController {

	private UrlServiceImpl urlService;

	@Autowired
	public URLController(UrlServiceImpl theUrlService) {
		urlService = theUrlService;
	}

	@RequestMapping(value = "/link/{id}", method = RequestMethod.GET)
	public ModelAndView getLongUrl(@PathVariable String id) {
	    return new ModelAndView("redirect:" + urlService.getLongUrl(id));
	}


	@PostMapping("/link")  // shorter annotation that GET above
	public String addUrl(@RequestBody String longUrl) {
		return urlService.makeBoxUrl(longUrl);
	}
}
