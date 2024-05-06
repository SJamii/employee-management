package com.example.empManagement.enums;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Arrays;
import java.util.stream.Stream;

public enum GenderEnum {
    male("Male"),
    female("Female");

    private String label;

    GenderEnum(String label) {this.label=label;}
    public String getLabel() {
        return label;
    }

    public String getName() {
        return name();
    }

    public static Stream<GenderEnum> stream() {
        return Arrays.stream(GenderEnum.values());
    }

    public static JSONArray genderAsJsonArray() {
        JSONArray jsonArray = new JSONArray();
        GenderEnum.stream().forEach(e ->
                jsonArray.add(
                        new JSONObject().accumulate("label", e.getLabel())
                                .accumulate("name",e.getName())));
        return jsonArray;
    }

}
