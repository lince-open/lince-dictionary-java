package work.lince.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String min;

    @NotNull
    private String max;

    private Integer pattern;

    @NotNull
    private InternalType type;

}
