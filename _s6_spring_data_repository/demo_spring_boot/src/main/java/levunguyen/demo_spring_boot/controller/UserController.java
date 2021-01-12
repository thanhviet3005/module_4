package levunguyen.demo_spring_boot.controller;

import levunguyen.demo_spring_boot.model.Address;
import levunguyen.demo_spring_boot.model.User;
import levunguyen.demo_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public void createUser(){
        Address address = new Address();
        address.setStreet("nguyen tat thanh");
        address.setCity("da nang");
        User user = new User();
        user.setName("nguyen van a");
        user.setPhone("123456789");
        user.setId(1);
        user.setAddress(address);
        this.userService.save(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id){
        return this.userService.findById(id);
    }



}
