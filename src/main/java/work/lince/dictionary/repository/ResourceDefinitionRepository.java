package work.lince.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.lince.dictionary.model.ResourceDefinition;

import java.util.Optional;

public interface ResourceDefinitionRepository extends JpaRepository<ResourceDefinition, Long> {

    Optional<ResourceDefinition> findByExternalCode(String externalCode);

}

