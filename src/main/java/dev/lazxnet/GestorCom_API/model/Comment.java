package dev.lazxnet.GestorCom_API.model;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID unico del comentario", example = "1")
    private Long id;

    @Schema(description = "Contenido del Comentario", example = "¡Este es un comentario de ejemplo!")
    private String content;

    @Schema(description = "Autor del comentario", example = "Juan Perez")
    private String author;

    @Schema(description = "Fecha y Hora del Comentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Getters y Setters
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}