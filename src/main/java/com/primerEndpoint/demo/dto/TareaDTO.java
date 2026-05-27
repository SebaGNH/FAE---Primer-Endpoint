package com.primerEndpoint.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "TareaDTO", description = "DTO para representar una tarea")
public class TareaDTO {

    @Schema(description = "id", name = "id")
    @JsonProperty("id")
    private String id;

    @Schema(description = "name", name = "name")
    @JsonProperty("name")
    private String name;

    @Schema(description = "description", name = "description")
    @JsonProperty("description")
    private String description;

    @Schema(description = "state", name = "state")
    @JsonProperty("state")
    private String state;

    @Schema(description = "isDone", name = "done")
    @JsonProperty("done")
    private boolean done;
}