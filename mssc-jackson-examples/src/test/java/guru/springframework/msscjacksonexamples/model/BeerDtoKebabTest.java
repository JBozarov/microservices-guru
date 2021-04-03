package guru.springframework.msscjacksonexamples.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Test
    void testKebabCase () throws JsonProcessingException {

        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }

    @Test
    void testDeserializeKebabCase() throws IOException {

        String jsonKebab = "{\"id\":\"0da5d8e4-f345-4a3d-a57f-1806815aeb0a\",\"beer-name\":\"BeerName\",\"beer-style\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"created-date\":\"2021-04-03T16:08:12.3896373-05:00\",\"last-updated-date\":\"2021-04-03T16:08:12.390642-05:00\"}\n";

        BeerDto dto = objectMapper.readValue(jsonKebab, BeerDto.class);

        System.out.println(dto);

    }
}
