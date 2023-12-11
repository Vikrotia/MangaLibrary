package utheryde.pet.project.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utheryde.pet.project.dao.MangaDAO;
import utheryde.pet.project.dao.OrderDAO;
import utheryde.pet.project.dao.PersonDAO;
import utheryde.pet.project.models.Manga;
import utheryde.pet.project.models.Person;

@Controller
@RequestMapping("/manga_lib")
public class AppController {

    private final MangaDAO mangaDAO;
    private final PersonDAO personDAO;
    private final OrderDAO orderDAO;

    @Autowired
    public AppController(MangaDAO mangaDAO, PersonDAO personDAO, OrderDAO orderDAO) {
        this.mangaDAO = mangaDAO;
        this.personDAO = personDAO;
        this.orderDAO = orderDAO;
    }

    @GetMapping("")
    public String full(Model model) {
        model.addAttribute("manga", mangaDAO.findTopMangas(5));
        model.addAttribute("person", personDAO.findTopActivePerson(5));
        model.addAttribute("order", orderDAO.findNewOrders(5));
        return "mangaLib/full";
    }
    @GetMapping("manga/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("manga", mangaDAO.show(id));
        return "mangaLib/manga_show";
    }

    @GetMapping("/manga")
    public String AllMangas( Model model){
        model.addAttribute("manga", mangaDAO.showAllMangas());
        return "mangaLib/all_mangas";
    }

    @GetMapping("manga/new")
    public String newManga(Model model){
        model.addAttribute("manga", new Manga());
        return "mangaLib/manga_new";
    }

    @PostMapping("/manga")
    public String create(@ModelAttribute("manga")  @Valid Manga manga) {
        mangaDAO.save(manga);
        return "redirect:/manga_lib/manga";
    }

    @DeleteMapping("/manga/{id}")
    public String delete(@PathVariable("id") int id){
        mangaDAO.delete(id);
        return "redirect:/manga_lib/manga";
    }

    @GetMapping("/manga/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("manga", mangaDAO.show(id));
        return "/mangaLib/edit_manga";
    }

    @PatchMapping ("/manga/{id}")
    public String update(@ModelAttribute("manga") @Valid Manga manga, @PathVariable("id") int id) {
        mangaDAO.update(id, manga);
        return "redirect:/manga_lib/manga";
    }
}
