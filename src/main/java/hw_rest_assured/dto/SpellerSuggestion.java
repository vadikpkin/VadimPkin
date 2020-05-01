package hw_rest_assured.dto;


import lombok.Data;

import java.util.List;

@Data
public class SpellerSuggestion {
    private String code;
    private String pos;
    private String row;
    private String col;
    private String len;
    private String word;
    private List<String> s;
}
