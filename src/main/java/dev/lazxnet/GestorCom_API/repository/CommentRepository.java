package dev.lazxnet.GestorCom_API.repository;

import dev.lazxnet.GestorCom_API.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Spring Data JPA provee métodos CRUD automáticos (save, findAll, findById, deleteById, etc.).
}