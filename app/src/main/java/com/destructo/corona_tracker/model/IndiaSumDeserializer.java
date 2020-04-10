package com.destructo.corona_tracker.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class IndiaSumDeserializer implements JsonDeserializer {
    @Override
    public IndiaSummaryModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        JsonObject summaryObject = dataObject.getAsJsonObject("summary");

        return new IndiaSummaryModel(summaryObject.get("total").getAsInt(),
                summaryObject.get("confirmedCasesIndian").getAsInt(),
                summaryObject.get("confirmedCasesForeign").getAsInt(),
                summaryObject.get("discharged").getAsInt(),
                summaryObject.get("deaths").getAsInt());
    }
}
