package work.lince.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.lince.dictionary.model.Resource;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, String> {

}

