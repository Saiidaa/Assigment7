
import java.io.Serializable;

public class User implements Serializable {

    String email;
    String password;
    String ppassword;
    String name;
    String gender;
    int age;
    String city;
    public User(String email, String password, String ppassword, String name,
                String gender, int age, String city) {
        super();
        this.email = email;
        this.password = password;
        this.ppassword = ppassword;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }
    public User()
    {

    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPpassword() {
        return ppassword;
    }
    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


}