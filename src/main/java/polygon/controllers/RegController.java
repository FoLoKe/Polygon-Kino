package polygon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.User;
import polygon.services.interfaces.RegService;

@Controller
public class RegController {
    private final RegService regService;

    public RegController(RegService regService) {
        this.regService = regService;
    }

    @GetMapping(value = "/registration")
    public String showRegistrationForm(Model model) {
        User modelUserRegAttr = new User();
        model.addAttribute("user", modelUserRegAttr);

        return "registration";
    }

    @PostMapping(value = "/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") User user,
            BindingResult result) {

        if(user.getUsername().isEmpty()) {
            result.rejectValue("username", "message.regError", "Укажите имя пользователя");
        }

        if (regService.userExists(user.getUsername())) {
            result.rejectValue("username", "message.regError","Имя пользователя уже занято");
        }

        if(user.getPassword().isEmpty()) {
            result.rejectValue("password", "message.regError", "Укажите пароль");
        }

        if (user.getEmail().isEmpty() || !regService.validateEmail(user.getEmail())) {
            result.rejectValue("email", "message.regError","Почта не верна или пуста");
        }

        if (regService.emailExists(user.getEmail())) {
            result.rejectValue("email", "message.regError","Почта уже занята");
        }

        if(!result.hasErrors()) {
            regService.registerNewUserAccount(user);
        }

        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", user);
        }
        else {
            return new ModelAndView("redirect:/");
        }
    }
}
