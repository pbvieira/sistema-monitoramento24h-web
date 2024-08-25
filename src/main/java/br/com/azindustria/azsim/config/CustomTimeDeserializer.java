package br.com.azindustria.azsim.config;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomTimeDeserializer extends JsonDeserializer<Date> {

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        String timeString = jsonParser.getText();

        if (timeString == null || timeString.isEmpty()) {
            return null;
        }

        LocalDate currentDate = LocalDate.now();
        LocalTime parsedTime = LocalTime.parse(timeString, timeFormatter);
        LocalDateTime dateTime = LocalDateTime.of(currentDate, parsedTime);
        ZoneId zoneId = ZoneId.of("America/Brasilia");
        return Date.from(dateTime.atZone(zoneId).toInstant());
    }
}
