package hello;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class JobPosting {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String name;
    private String description;
    private String company;

    JobPosting() {}

    JobPosting(String name, String description, String company) {
        this.name = name;
        this.description = description;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }
}