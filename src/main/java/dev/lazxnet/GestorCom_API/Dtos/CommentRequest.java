package dev.lazxnet.GestorCom_API.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public class CommentRequest {

    @Schema(description = "Contenido del comentario", example = "Este es un comentario de prueba")
    private String content;

    @Schema(description = "Autor del comentario", example = "Lazxnet")
    private String author;

    // Getters y Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
