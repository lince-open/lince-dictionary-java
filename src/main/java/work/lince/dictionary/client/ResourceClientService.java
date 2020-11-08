package work.lince.dictionary.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import work.lince.dictionary.model.Type;

import java.util.List;

@FeignClient(value = "lince-resources", url = "http://localhost:50001/resources")
public interface ResourceClientService {

    @RequestMapping(method = RequestMethod.PUT, value = "/{resourceName}/{resourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Type save(@PathVariable("resourceName") String resourceName, @PathVariable("resourceId") String resourceId
            , @RequestBody Type body);

    @RequestMapping(method = RequestMethod.GET, value = "/{resourceName}/{resourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Type find(@PathVariable("resourceName") String resourceName, @PathVariable("resourceId") String resourceId);

    @RequestMapping(method = RequestMethod.GET, value = "/{resourceName}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Type> find(@PathVariable("resourceName") String resourceName);


}