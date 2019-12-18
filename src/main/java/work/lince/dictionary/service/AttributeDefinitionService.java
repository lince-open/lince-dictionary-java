package work.lince.dictionary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lince.commons.exception.NotFoundException;
import work.lince.dictionary.model.AttributeDefinition;
import work.lince.dictionary.repository.AttributeDefinitionRepository;

import java.util.List;

@Slf4j
@Service
public class AttributeDefinitionService {

    @Autowired
    protected AttributeDefinitionRepository repository;

    public AttributeDefinition update(AttributeDefinition definition) {
        return repository.save(definition);
    }

    public AttributeDefinition create(AttributeDefinition definition) {
        definition.setId(null);
        return repository.save(definition);
    }

    public AttributeDefinition findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public List<AttributeDefinition> findAll() {
        return repository.findAll();
    }

}