package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping
    public String getAuthors(Model model) {

        // Find all authors in our author table and add that to our model.
        model.addAttribute("authors", authorRepository.findAll());

        // Return the authors/list thymeleaf template view we've now implemented.
        return "authors/list";
    }
}
