package com.destructo.corona_tracker.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class IndiaStateDeserializer implements JsonDeserializer {
    @Override
    public ArrayList<IndiaStateModel> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        JsonObject jsonObject = json.getAsJsonObject();

        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        JsonArray stateArray = dataObject.getAsJsonArray("regional");

        ArrayList<IndiaStateModel> output = new ArrayList<>();

        for (int i=0; i<stateArray.size(); i++){
            JsonObject state = stateArray.get(i).getAsJsonObject();

            output.add(new IndiaStateModel(state.get("loc").getAsString(),
                    state.get("confirmedCasesIndian").getAsInt(),
                    state.get("confirmedCasesForeign").getAsInt(),
                    state.get("discharged").getAsInt(),
                    state.get("deaths").getAsInt(),
                    state.get("totalConfirmed").getAsInt()
            ));
        }

        return output;
    }
}
