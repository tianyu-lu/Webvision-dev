package hello;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<JobPosting, Long> {
}
