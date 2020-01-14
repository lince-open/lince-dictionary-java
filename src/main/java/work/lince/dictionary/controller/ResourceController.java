package work.lince.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import work.lince.commons.log.LogExecutionTime;
import work.lince.dictionary.model.Attribute;
import work.lince.dictionary.model.Resource;
import work.lince.dictionary.service.ResourceService;

import java.util.Collections;
import java.util.List;

@LogExecutionTime
@RestController
@RequestMapping(path = "/definitions/resources")
public class ResourceController {

    @Autowired
    protected ResourceService service;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Resource findById(@PathVariable("id") final String id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Resource> findAll() {
        return service.findAll();
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Resource createOrUpdate(@PathVariable("id") final String id, @RequestBody @Validated Resource body) {
        body.setId(id);
        return service.createOrUpdate(body);
    }

    @PutMapping("/{resourceId}/attributes/{attributeId}")
    @ResponseStatus(HttpStatus.OK)
    public Attribute saveOrUpdate(@PathVariable("resourceId") final String resourceId,
                                  @PathVariable("attributeId") final String attributeId,
                                  @RequestBody @Validated Attribute body) {
        body.setId(attributeId);
        return service.addAttribute(resourceId, body);
    }

    @GetMapping("/{resourceId}/attributes")
    @ResponseStatus(HttpStatus.OK)
    public List<Attribute> getAttributes(@PathVariable("resourceId") final String resourceId) {
        Resource resourceDefinition = service.findById(resourceId);
        if (CollectionUtils.isEmpty(resourceDefinition.getAttributes())) {
            return Collections.EMPTY_LIST;
        }
        return resourceDefinition.getAttributes();
    }

}