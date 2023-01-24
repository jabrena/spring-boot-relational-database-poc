package info.jab.ms.service.dto;

import java.time.LocalDateTime;

public record ActorDTO(
        Long actor_id,
        String first_name,
        String last_name,
        String last_update) { }
