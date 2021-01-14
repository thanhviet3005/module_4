package c0920g1.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 5, max = 45, message = "From 5-45 character")    // thay cho dong chu mac dinh cua spring boot khi nhap vao khong dung kieu quy dinh
    private String firstName;


    @NotEmpty
    @Size(min = 5, max = 45, message = "From 5-45 character")
    private String lastName;

    @Min(value = 18, message = "Greater than or equal 18")
    private int age;

    private String phoneNumber;
    private String email;

    public User() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
        //sdt la 10-11 so, bat dau bang so 0, cac con so chi tu 1-9
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber","phoneNumber.empty");
        if(phoneNumber.length()>11 || phoneNumber.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        //validate email, ex: abc@abc.abc
        String email = user.getEmail();
        if(!email.matches("^\\w+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)$")){
            errors.rejectValue("email", "email.matches");
        }
//        if(user.getAge()<18){
//            errors.rejectValue("age", "ageNotEnough");
//        }


    }

//__+__+__+__+__+__+__+__+__+__+__
}
