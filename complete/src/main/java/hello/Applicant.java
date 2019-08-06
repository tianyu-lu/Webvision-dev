package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Applicant {
    // Part of User superclass
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String usertype;
    private ArrayList<String> messages;

    private ArrayList<Long> applied;
    private ArrayList<Long> applying;
//    private ArrayList<Long> applications;
//    private ArrayList<Long> documents;

    protected Applicant() {}

    public Applicant(String username, String password, String usertype) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.messages = new ArrayList<>();
        this.applied = new ArrayList<>();
        this.applying = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public ArrayList<Long> getApplied() {
        return applied;
    }

    public void setApplied(ArrayList<Long> applied) {
        this.applied = applied;
    }

    public ArrayList<Long> getApplying() {
        return applying;
    }

    public void setApplying(ArrayList<Long> applying) {
        this.applying = applying;
    }
}
