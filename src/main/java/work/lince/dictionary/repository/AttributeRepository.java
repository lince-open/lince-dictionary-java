package work.lince.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.lince.dictionary.model.Attribute;
import work.lince.dictionary.model.Resource;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, String> {

}

