package hello;

import org.springframework.data.repository.CrudRepository;

public interface CurrentUserRepo extends CrudRepository<Applicant, Long> {
}
