package work.lince.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.lince.dictionary.model.AttributeDefinition;

public interface AttributeDefinitionRepository extends JpaRepository<AttributeDefinition, Long> {

}

