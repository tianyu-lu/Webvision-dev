package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobService {
    public HashMap<Long, JobPosting> jobs = new HashMap<>();

    public JobService() {
        setTestData();
    }

    public List<JobPosting> getJobs() {
//        if (maxResults >= jobs.size()) {
//            maxResults = jobs.size() - 1;
//        }
        ArrayList<JobPosting> jobPostings = new ArrayList<>(jobs.values());
        return jobPostings;
//        return jobPostings.subList(0, maxResults);
    }

    public void setTestData() {
        String[] jobTitles = new String[]{"Software Engineer", "Product Manager", "Data Scientist"};
        //TODO: cite this
        String[] jobDescriptions = new String[]{"Updates job knowledge by studying state-of-the-art development tools, programming techniques, and computing equipment; participating in educational opportunities; reading professional publications; maintaining personal networks; participating in professional organizations",
        "Recommends the nature and scope of present and future product lines by reviewing product specifications and requirements; appraising new product ideas and/or product or packaging changes.",
        "We are looking for a data scientist that will help us discover the information hidden in vast amounts of data, and help us make smarter decisions to deliver even better products. Your primary focus will be in applying data mining techniques, doing statistical analysis, and building high quality prediction systems integrated with our products."};
        String[] jobCompanies = new String[]{"Amazon", "Interac", "Persuda"};
        for (int i=0; i<3; i++){
            JobPosting job = new JobPosting(jobTitles[i], jobDescriptions[i], jobCompanies[i]);
            //TODO: getId() returns a null value here!
            jobs.put((long) i, job);
        }
    }

    public void getJobsFromDatabase() {

    }
}