package br.com.lucca.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter implements IJsonConverter {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertendoJson (String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
