package bjtu.edu.javaee.a2.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class User extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @NotEmpty(message = "Last Name is required.")
    @Size(min = 2, message = "Last Name must be at least 2 characters.")
    private String lastName;
    @NotEmpty(message = "First Name is required.")
    @Size(min = 2, message = "First Name must be at least 2 characters.")
    private String firstName;




    @NotEmpty(message = "password is required.")
    @Size(min = 8, message = "password must be at least 8 characters.")
    private String password;

    @Email
    private String email;
    @Column(name = "mobile_no")
    @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.")
    private String mobileNumber;
    @NotEmpty(message = "Address is required.")
    private String address;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
