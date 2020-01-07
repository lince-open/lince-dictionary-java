package work.lince.dictionary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lince.commons.exception.NotFoundException;
import work.lince.dictionary.client.ResourceClientService;
import work.lince.dictionary.model.Type;

import java.util.List;

@Slf4j
@Service
public class TypeService {


    @Autowired
    protected ResourceClientService resourceClientService;

    public static final String KVS_RESOURCE_NAME = "DictionaryType";

    public Type saveOrUpdate(Type type) {
        return resourceClientService.save(KVS_RESOURCE_NAME, type.getId(), type);
    }

    public Type findById(String id) {
        return resourceClientService.find(KVS_RESOURCE_NAME, id);
//        return repository.findById(id)
//                .orElseThrow(() -> new NotFoundException());
    }

    public List<Type> findAll() {
//        return repository.findAll();
        return resourceClientService.find(KVS_RESOURCE_NAME);
    }

}