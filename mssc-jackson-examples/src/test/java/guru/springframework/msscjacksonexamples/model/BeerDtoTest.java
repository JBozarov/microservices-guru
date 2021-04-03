package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest {


    @Autowired
    ObjectMapper objectMapper;


    @Test
    void testSerializedDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"9b10bf6b-0d1a-4436-bbaf-a15a50e4166a\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2021-04-03T10:21:58.3335302-05:00\",\"lastUpdatedDate\":\"2021-04-03T10:21:58.3355301-05:00\"}\n";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }


}