package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import hw_jdi.entities.MetalsAndColorsData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class JsonParser {

    public static List<MetalsAndColorsData> readData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = mapper.getTypeFactory();
        try {
            File json = new File("src/test/resources/metalsAndColors.json");
            MapLikeType mapType =
                    factory.constructMapLikeType(Map.class, String.class, MetalsAndColorsData.class);
            Map<String,MetalsAndColorsData> map = mapper.readValue(json, mapType);
            return  new ArrayList<MetalsAndColorsData>(map.values());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
