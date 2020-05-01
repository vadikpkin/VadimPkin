package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw_jdi.entities.MetalsAndColorsData;
import hw_rest_assured.dto.SpellerDataEntity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class JsonParser {

    private static final String PATH = "src/test/resources/metalsAndColors.json";

    private JsonParser() {
    }

    public static List<MetalsAndColorsData> readData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = mapper.getTypeFactory();
        try {
            File json = new File(PATH);
            MapLikeType mapType =
                    factory.constructMapLikeType(Map.class, String.class, MetalsAndColorsData.class);
            Map<String,MetalsAndColorsData> map = mapper.readValue(json, mapType);
            return  new ArrayList<MetalsAndColorsData>(map.values());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static List<SpellerDataEntity> readData(String path) {
        String content = readLineByLine(path);
        Type listType = new TypeToken<List<SpellerDataEntity>>() {}.getType();
        return new Gson().fromJson(content, listType);
    }

    private static String readLineByLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
