package it.example.controllers;

import it.example.model.Auto;
import it.example.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //Il Controller è SOLO il Presentation layer dei vari endpoints, la logica è affidata al DAO, chiamato dal service
public class AutoController {

//GET => User richiede info -> View -> Controller -> Service -> DAO -> DB
//POST => User inserisce info nel db -> Redirect a una View di sicurezza con GetMapping(PRG)
    @Autowired
    private AutoService autoService;

    @GetMapping("/")
    public ModelAndView showAutos() {
        ModelAndView mv = new ModelAndView();
        List<Auto> loadedAutos = autoService.loadAutos();
        mv.addObject("loadedAutos",loadedAutos);
        mv.setViewName("list_autos");

        return mv;
    }

    @GetMapping("/add_auto")
    public String addAuto(@ModelAttribute("auto") Auto auto) {
        return "add_auto";
    }
//PRG Pattern => POST -> creazione da parte dell'utente => REDIRECT -> spostare l'utente in una
//url di GET per evitare i refresh => GET -> qualsiasi refresh non ha effetti sul db
    @PostMapping("/save_auto")
    public String saveAuto(Auto auto) {
        autoService.saveAuto(auto);

        return "redirect:/";
    }

    @GetMapping("/update_auto")
    public ModelAndView updateAuto(@RequestParam("id")int id) {
        ModelAndView mv = new ModelAndView();
        Auto autoById = autoService.getAutoById(id);
        mv.addObject(autoById);
        mv.setViewName("add_auto");

        return mv;
    }

    @GetMapping("/delete_auto")
    public String deleteAuto(@RequestParam("id")int id) {
        autoService.deleteAuto(id);

        return "redirect:/";
    }

    @GetMapping("/search_auto")
    public ModelAndView searchAuto(@RequestParam("searchText") String text) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("loadedAutos", autoService.searchAuto(text));
            mv.setViewName("list_autos");

            return mv;
    }

    @GetMapping("/reset")
    public String resetTable() {
        autoService.resetTable();

        return "redirect:/";
    }

    @GetMapping("/sort")
    public ModelAndView sortTable(@RequestParam("sortCol")String sortCol, @RequestParam("sort")String sort) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("loadedAutos", autoService.sortTable(sortCol, sort));
        mv.setViewName("list_autos");

        return mv;
    }
}
