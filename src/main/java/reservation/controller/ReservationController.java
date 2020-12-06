package reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import reservation.dao.ReservationDao;
import reservation.model.City;
import reservation.model.Reservation;


@Controller
public class ReservationController {
	
	@Autowired
	ReservationDao dao;
	
	@RequestMapping("/resform")
	public String showRes(Model m) {
		
		m.addAttribute("command", new Reservation());
		
		List<City> city = dao.getCity();
		m.addAttribute("cityList", city);
		return "resform";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("res") Reservation res) {
		dao.save(res);
		return "redirect:/viewres";
	}

	@RequestMapping("/viewres")
	public String viewmap(Model m) {
		List<Reservation> res = dao.getEmployees();
		m.addAttribute("res", res);
		return "viewres";
	}
	
	@RequestMapping(value="/editres/{id}")
	public String editres(@PathVariable Long id, Model m) {
		Reservation res = dao.getResById(id);
		List<City> city = dao.getCity();
		m.addAttribute("cityList", city);
		m.addAttribute("command", res);

		return "editform";
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public String editsave(@ModelAttribute("res") Reservation res) {
		dao.update(res);
		return "redirect:/viewres";
	}
	
	@RequestMapping(value="/deleteres/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		dao.delete(id);
		return "redirect:/viewres";
	}

}
