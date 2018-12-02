package com.yuan.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;

public final class JsonUtil {
    private static ObjectMapper MAPPER;
    private static Gson GSON;

    private JsonUtil() {
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return GSON.fromJson(json, clazz);
    }

    public static <T> T fromJson(String json, TypeReference<?> typeReference) throws IOException {
        return typeReference.getType().equals(String.class)? (T) json :MAPPER.readValue(json, typeReference);
    }

    public static <T> T fromJsonByGoogle(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    public static <T> T fromJsonByGoogle(String json, TypeToken<?> type) {
        return GSON.fromJson(json, type.getType());
    }

    public static <T> String toJsonByGoogle(T src) {
        return GSON.toJson(src);
    }

    public static <T> String toJson(T src) {
        return GSON.toJson(src);
    }

    public static <T> String toJson(T src, JsonSerialize.Inclusion inclusion) throws IOException {
        if(src instanceof String) {
            return (String)src;
        } else {
            ObjectMapper customMapper = generateMapper(inclusion);
            return customMapper.writeValueAsString(src);
        }
    }

    public static <T> String toJson(T src, ObjectMapper mapper) throws IOException {
        return null != mapper?(src instanceof String?(String)src:mapper.writeValueAsString(src)):null;
    }

    public static ObjectMapper mapper() {
        return MAPPER;
    }

    private static ObjectMapper generateMapper(JsonSerialize.Inclusion inclusion) {
        ObjectMapper customMapper = new ObjectMapper();
        customMapper.setSerializationInclusion(inclusion);
        customMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        customMapper.configure(Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
        customMapper.configure(Feature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        customMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return customMapper;
    }

    static {
        MAPPER = generateMapper(JsonSerialize.Inclusion.ALWAYS);
        GSON = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
    }
}