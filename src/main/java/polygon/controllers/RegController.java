package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.User;
import polygon.services.interfaces.RegService;

import javax.validation.Valid;

@Controller
public class RegController {
    @Autowired
    RegService regService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User modelUserRegAttr = new User();
        model.addAttribute("user", modelUserRegAttr);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid User user,
            BindingResult result,
            WebRequest request,
            Errors errors) {

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
