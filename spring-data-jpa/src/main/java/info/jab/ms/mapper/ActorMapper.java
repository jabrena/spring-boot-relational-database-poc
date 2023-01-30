package info.jab.ms.mapper;

import com.jab.ms.openapi.actor.gen.model.ActorDto;
import info.jab.ms.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    @Mapping(target = "actorId", source = "actor_id")
    @Mapping(target = "firstName", source = "first_name")
    @Mapping(target = "lastName", source = "last_name")
    @Mapping(target = "lastUpdate", source = "last_update")
    ActorDto actorToActorDto(Actor a);

}
