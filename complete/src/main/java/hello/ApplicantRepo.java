package hello;

import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepo extends CrudRepository<Applicant, Long> {
}
