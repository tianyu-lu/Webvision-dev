package hello;

import org.springframework.data.repository.CrudRepository;

public interface JobApplicationRepo extends CrudRepository<JobApplication, Long> {
}
