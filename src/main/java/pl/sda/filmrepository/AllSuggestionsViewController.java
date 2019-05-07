package pl.sda.filmrepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/suggestion")
public class AllSuggestionsViewController {
    SuggestioRepository repository;

    public AllSuggestionsViewController(SuggestioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    String allSuggestions(Model model){
        model.addAttribute("suggestions", repository.findAll());
        return "suggestions";
    }
}
