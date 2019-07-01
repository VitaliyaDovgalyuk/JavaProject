package com.cheese.cheese;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class AppController {
	
	@Autowired
	private GifService gifService;

	@RequestMapping(value = {"/home", "/"})
	public String viewHomePage(Model model) {
		Gif gif = new Gif();
		model.addAttribute("gif", gif);
		return "index";
	}
	@RequestMapping(value = "/about")
	public String viewAboutPage(Model model) {
		return "AboutUs";
	}
	@RequestMapping(value = "/contact")
		public String viewContacts(Model model) {
			return "Contacts";
			
	}
	@RequestMapping("/show")
	public String viewDB(Model model) {
		List<Gif> listGifs = gifService.listAll();
		model.addAttribute("listGifs", listGifs);
		return "ShowDB";
	}
	@RequestMapping("/new")
	public String showNewGifForm(Model model) {
		Gif gif = new Gif();
		model.addAttribute("gif", gif);
		return "NewEntry";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveGif(@ModelAttribute("gif") Gif gif) {
		gifService.save(gif);
		return "redirect:/home";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditGifForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("EditGif");
		
		Gif gif = gifService.get(id);
		mav.addObject("gif", gif);
		return mav;
}
	@RequestMapping("/delete/{id}")
	public String deleteGif(@PathVariable(name = "id") Long id) {
		gifService.delete(id);
	return "redirect:/show";
	
	}
	
	@RequestMapping("/delete/all")
	public String deleteAllGif() {
		gifService.deleteAll();
	return "redirect:/show";
	
	}
}
