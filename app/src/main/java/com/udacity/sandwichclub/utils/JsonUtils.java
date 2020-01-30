package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject object = new JSONObject(json);

            String mainName = object.getJSONObject("name").getString("mainName");
            JSONArray alsoKnown = object.getJSONObject("name").getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();

            for (int i = 0; i < alsoKnown.length(); i++) {
                alsoKnownAsList.add(alsoKnown.getString(i));
            }

            String placeOfOrigin = object.getString("placeOfOrigin");
            String description = object.getString("description");
            String image = object.getString("image");

            JSONArray ingredients = object.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();

            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            Sandwich sandwich = new Sandwich(
                    mainName
                    , alsoKnownAsList
                    , placeOfOrigin
                    , description
                    , image
                    , ingredientsList);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
