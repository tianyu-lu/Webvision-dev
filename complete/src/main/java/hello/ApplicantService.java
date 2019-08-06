package hello;

import org.springframework.beans.factory.annotation.Autowired;

public class ApplicantService {

    private final ApplicantRepo applicantRepo;

    @Autowired
    public ApplicantService(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    public void editApplicant() {

    }

    public void apply() {

    }

    public void withdraw() {

    }
}
