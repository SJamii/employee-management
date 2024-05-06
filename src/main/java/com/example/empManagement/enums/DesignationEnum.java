package com.example.empManagement.enums;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Arrays;
import java.util.stream.Stream;

public enum DesignationEnum {
    Junior_Developer("Junior Software Engineer"),
    Assistant_Developer("Assistant Software Engineer"),
    Associate_Developer("Associate Software Engineer"),
    Senior_Developer("Senior Software Engineer"),
    Team_Lead("Team Lead");

    private String label;

    DesignationEnum(String label){this.label=label;}

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name();
    }

    public static Stream<DesignationEnum> stream() {
        return Arrays.stream(DesignationEnum.values());
    }

    public static JSONArray positionAsJsonArray() {
        JSONArray jsonArray = new JSONArray();
        DesignationEnum.stream().forEach(e ->
            jsonArray.add(
                    new JSONObject().accumulate("label", e.getLabel())
                            .accumulate("name",e.getName())));
        return jsonArray;
    }

}
