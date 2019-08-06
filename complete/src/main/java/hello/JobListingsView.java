package hello;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringComponent
@UIScope
@Route(JobListingsView.NAME)
public class JobListingsView extends VerticalLayout {
    public static final String NAME = "jobListings";

    private final JobRepository jobRepository;
    private ArrayList<JobPosting> jobPostings;

    private ArrayList<JobCard> cards = new ArrayList<>();

    @Autowired
    public JobListingsView(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
        setTestData();
        for (JobPosting posting : jobRepository.findAll()) {
            cards.add(new JobCard("com/vaadin/example/spring/image.jpg", posting));
        }
        VerticalLayout cardsView = new VerticalLayout();
        for (JobCard card : cards) {
            cardsView.add(card);
        }
        add(cardsView);
    }

    public void setTestData() {
        String[] jobTitles = new String[]{"Software Engineer", "Product Manager", "Data Scientist"};
        //TODO: cite this
        String[] jobDescriptions = new String[]{"Updates job knowledge",
                "Recommends the nature and scope",
                "We are looking for a data scientist"};
        String[] jobCompanies = new String[]{"Amazon", "Interac", "Persuda"};
        for (int i=0; i<3; i++){
            JobPosting job = new JobPosting(jobTitles[i], jobDescriptions[i], jobCompanies[i]);

            jobRepository.save(job);
        }
    }
}
