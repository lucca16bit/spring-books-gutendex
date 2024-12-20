package br.com.lucca.literalura.services;

public interface IJsonConverter {
    <T> T convertendoJson (String json, Class<T> classe);
}
