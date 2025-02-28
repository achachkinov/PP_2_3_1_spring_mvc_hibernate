package web.controller;

import web.models.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Отображение списка пользователей
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    // Добавление пользователя
    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String lastName, @RequestParam String age) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(lastName);
		user.setAge(age);
        userService.save(user);
        return "redirect:/";
    }

    // Обновление пользователя
    @PostMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String lastName, @RequestParam String age) {
        User user = userService.findById(id);
        user.setFirstName(name);
        user.setLastName(lastName);
		user.setAge(age);
        userService.updateUser(user);
        return "redirect:/";
    }

    // Удаление пользователя
    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}