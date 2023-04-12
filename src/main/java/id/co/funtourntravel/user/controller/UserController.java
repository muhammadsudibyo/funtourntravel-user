package id.co.funtourntravel.user.controller;

import id.co.funtourntravel.user.model.User;
import id.co.funtourntravel.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/id")
    public @ResponseBody User getUserId(@RequestParam("id") int id){
        User user = new User();
        user.setId(id);
        return userService.getUserById(user);
    }

    @GetMapping("/all")
    public @ResponseBody List getAll(){
        return userService.getAllUser();
    }



    @GetMapping("/update")
    public String updateUser(@RequestParam("userId") String userId,
                                 @RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password){
        User user = new User();
        user.setName(name);
        user.setUserId(userId);
        user.setEmail(email);
        user.setPassword(password);
        return userService.update(user);

    }

    @GetMapping("/insert")
    public String insertUser(@RequestParam("userId") String userId,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password){
        User user = new User();
        user.setName(name);
        user.setUserId(userId);
        user.setEmail(email);
        user.setPassword(password);
        userService.insert(user);
        return backToIndex();
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return backToIndex();
    }

    public String backToIndex(){
        //return "your transaction has ben executed";
        return "redirect:/user/all";
    }
}
