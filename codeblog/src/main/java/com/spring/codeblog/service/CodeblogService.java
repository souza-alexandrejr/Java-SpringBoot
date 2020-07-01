/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.codeblog.service;

import com.spring.codeblog.model.Post;
import java.util.List;

/**
 *
 * @author Alexandre Junior
 */
public interface CodeblogService {
    
    // Método que retorna uma lista de posts
    List<Post> findAll();
    
    // Método que faz uma busca de um post pelo seu ID
    Post findById(long id);
    
    // Método que salva um post no banco de dados
    Post save(Post post);
}
