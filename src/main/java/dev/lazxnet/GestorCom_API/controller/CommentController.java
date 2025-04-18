package dev.lazxnet.GestorCom_API.controller;

import dev.lazxnet.GestorCom_API.Dtos.CommentRequest;
import dev.lazxnet.GestorCom_API.model.Comment;
import dev.lazxnet.GestorCom_API.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments")
@Tag(name = "GestorCom-API", description = "API para gestionar comentarios")
public class CommentController {


    private CommentService commentService;

    //inyeccion por constructor
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }



    @Operation(summary = "Obtener todos los comentarios", responses = {
            @ApiResponse(responseCode = "201", description = "Comentarios encontrados"),
            @ApiResponse(responseCode = "400", description = "Error al encontrar los comentarios")
    })
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }



    @Operation(summary = "Crear comentario", responses = {
            @ApiResponse(responseCode = "201", description = "Comentario creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Comment createComment(@RequestBody CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setAuthor(commentRequest.getAuthor());
        return commentService.createComment(comment);
    }



    @Operation(summary = "Obtener comentarios por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Comentario encontrado"),
            @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    })
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {

        return commentService.getCommentById(id);
    }



    @Operation(summary = "Editar un comentario")
    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @Valid @RequestBody CommentRequest commentRequest) {
        Comment comment = commentService.getCommentById(id);

        if (comment != null){
            comment.setContent(commentRequest.getContent());
            comment.setAuthor(commentRequest.getAuthor());
            return commentService.updateComment(id, comment);
        }
        return null;
    }



    @Operation(summary = "Eliminar un comentario", responses = {
            @ApiResponse(responseCode = "200", description = "Comentario eliminado correctamente"),
            @ApiResponse(responseCode = "500", description = "Comentario no encontrado (Error al eliminar)")
    })
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}