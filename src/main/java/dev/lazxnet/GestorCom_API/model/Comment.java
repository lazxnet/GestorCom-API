package dev.lazxnet.GestorCom_API.model;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID unico del comentario", example = "1")
    private Long id;

    @Schema(description = "Contenido del Comentario", example = "¡Este es un comentario de ejemplo!")
    private String content;

    @Schema(description = "Autor del comentario", example = "Juan Perez")
    private String author;


    // Getters y Setters (los de Auditable ya están heredados)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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