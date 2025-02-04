package dev.lazxnet.GestorCom_API.service;

import dev.lazxnet.GestorCom_API.model.Comment;
import dev.lazxnet.GestorCom_API.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Obtener todos los comentarios
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // Crear un comentario
    public Comment createComment(Comment comment) {
        comment.setCreatedAt(new Date()); // Asignar la fecha actual al crear el comentario
        return commentRepository.save(comment);
    }

    // Obtener comentario por ID
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    // Actualizar un comentario
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null) {
            comment.setContent(commentDetails.getContent());
            comment.setAuthor(commentDetails.getAuthor());
            return commentRepository.save(comment);
        }
        return null;
    }

    // Eliminar un comentario
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}