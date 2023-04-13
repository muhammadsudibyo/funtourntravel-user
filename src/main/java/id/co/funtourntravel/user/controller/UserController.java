package id.co.funtourntravel.user.controller;

import id.co.funtourntravel.user.model.User;
import id.co.funtourntravel.user.model.dto.UserDTO;
import id.co.funtourntravel.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    private  final Logger log = LoggerFactory.getLogger(this.getClass());



    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List getAll(){
        return userService.getAllUser();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO addEmployee(@RequestBody UserDTO model){
        User user = new User();
        BeanUtils.copyProperties(model, user);
        userService.insert(user);
        return model;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") int id){
        User user = new User();
        user.setId(id);
        return userService.getUserById(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") int id){
        User user = new User();
        log.info("disni id nya = "+id);
        model.setId(id);
        userService.insert(user);
        return  model;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") int id){
        User user = new User();
        user.setId(id);
        userService.delete(user);
    }
}
