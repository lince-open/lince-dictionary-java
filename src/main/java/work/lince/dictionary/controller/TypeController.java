package work.lince.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.lince.dictionary.model.Type;
import work.lince.dictionary.service.TypeService;

import java.util.List;

@RestController
@RequestMapping(path = "/types")
public class TypeController {

    @Autowired
    protected TypeService service;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Type findById(@PathVariable("id") final String id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Type> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Type create(@RequestBody @Validated Type body) {
        return service.saveOrUpdate(body);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Type update(@PathVariable("id") final String id, @RequestBody @Validated Type body) {
        body.setId(id);
        return service.saveOrUpdate(body);
    }

}