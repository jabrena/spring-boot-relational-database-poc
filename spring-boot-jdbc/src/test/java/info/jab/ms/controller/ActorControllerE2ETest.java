package info.jab.ms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jab.ms.openapi.gen.model.ActorDto;
import info.jab.ms.commons.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ActorControllerE2ETest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public record ActorDTO(
            Long actor_id,
            String first_name,
            String last_name,
            String last_update) { }

    @Test
    public void should_return_all_actors() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/actors";

        //When
        ResponseEntity<List<ActorDto>> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().size()).isGreaterThan(0);
    }

    @Test
    public void should_add_a_new_actor() throws JsonProcessingException {

        //Given
        String address = "http://localhost:" + port + "/api/v1/actors";

        //When
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        //TODO Review this tests
        ActorDTO actor = new ActorDTO(null, "Demo", "Demo2", LocalDateTime.now().toString());

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(actor);

        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        ResponseEntity<ActorDTO> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.POST,
                        requestEntity,
                        ActorDTO.class
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().actor_id()).isNotNull();
    }

    @Test
    public void should_return_one_actor() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/actors/1";

        //When
        ResponseEntity<ActorDto> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.GET,
                        null,
                        ActorDto.class
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().getActorId()).isNotNull();
    }

    @Test
    public void should_not_return_one_actor() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/actors/999";

        //When
        ResponseEntity<ActorDto> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.GET,
                        null,
                        ActorDto.class
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void should_remove_one_actor() throws JsonProcessingException {

        //Given
        ActorDTO initialActor = new ActorDTO(null, "Curro", "Jimenez", LocalDateTime.now().toString());
        ActorDTO newActor = addOneActorForTesting(initialActor);
        System.out.println(newActor);
        String address = "http://localhost:" + port + "/api/v1/actors/" + newActor.actor_id();

        //When
        ResponseEntity<Void> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.DELETE,
                        null,
                        Void.class
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    private ActorDTO addOneActorForTesting(ActorDTO actorToAdd) throws JsonProcessingException {
        //Given
        String address = "http://localhost:" + port + "/api/v1/actors";

        //When
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(actorToAdd);

        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        ResponseEntity<ActorDTO> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.POST,
                        requestEntity,
                        ActorDTO.class
                );

        return result.getBody();
    }

    @Test
    public void should_update_one_actor() throws JsonProcessingException {

        //Given
        ActorDTO initialActor = new ActorDTO(null, "Curro", "Jimenez", LocalDateTime.now().toString());
        ActorDTO actorAdded = addOneActorForTesting(initialActor);
        System.out.println(actorAdded);
        String address = "http://localhost:" + port + "/api/v1/actors/" + actorAdded.actor_id();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ActorDTO actorDataToUpgrade = new ActorDTO(null, "Currito", "Jimenez", LocalDateTime.now().toString());
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(actorDataToUpgrade);

        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        //When
        ResponseEntity<ActorDTO> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.PUT,
                        requestEntity,
                        ActorDTO.class
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().first_name()).isEqualTo("Currito");
    }

    @Test
    public void should_not_update_an_unknown_actor() throws JsonProcessingException {

        //Given
        String address = "http://localhost:" + port + "/api/v1/actors/999";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ActorDTO actorDataToUpgrade = new ActorDTO(null, "Currito", "Jimenez", LocalDateTime.now().toString());
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(actorDataToUpgrade);

        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        //When
        ResponseEntity<ActorDTO> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.PUT,
                        requestEntity,
                        ActorDTO.class
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
