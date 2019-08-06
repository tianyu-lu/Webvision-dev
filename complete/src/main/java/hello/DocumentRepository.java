package hello;

import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<byte[], String> {
}
