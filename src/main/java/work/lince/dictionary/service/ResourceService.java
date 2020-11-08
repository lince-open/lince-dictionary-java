package work.lince.dictionary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lince.commons.exception.NotFoundException;
import work.lince.dictionary.model.Attribute;
import work.lince.dictionary.model.Resource;
import work.lince.dictionary.repository.AttributeRepository;
import work.lince.dictionary.repository.ResourceRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ResourceService {

    @Autowired
    protected ResourceRepository repository;

    @Autowired
    protected AttributeRepository attributeRepository;

    public Resource createOrUpdate(Resource definition) {
        Optional<Resource> resourceDefinition = repository.findById(definition.getId());
        return resourceDefinition.isPresent() ? this.update(resourceDefinition.get(), definition) : this.create(definition);
    }

    protected Resource create(Resource definition) {
        definition.setAttributes(null);
        return repository.save(definition);
    }

    protected Resource update(Resource definition, Resource definitionNew) {
        definition.setName(definitionNew.getName());
        definition.setDescription(definitionNew.getDescription());
        return repository.save(definition);
    }

    public Attribute addAttribute(String externalCode, Attribute resourceAttribute) {
        Resource resourceDefinition = this.findById(externalCode);
        Attribute resourceAttributeDefinition = attributeRepository.save(resourceAttribute);
        resourceDefinition.getAttributes().add(resourceAttributeDefinition);
        repository.save(resourceDefinition);
        return resourceAttributeDefinition;
    }

    public Resource findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public List<Resource> findAll() {
        return repository.findAll();
    }

}