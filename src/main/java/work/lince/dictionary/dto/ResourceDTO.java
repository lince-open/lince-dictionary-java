package work.lince.dictionary.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDTO {

    private String id;

    @NotNull
    private String name;

    private String description;

    private List<ResourceAttributeDTO> attributes;

}
