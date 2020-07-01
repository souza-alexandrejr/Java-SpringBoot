/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.codeblog.service.serviceImpl;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.service.CodeblogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A classe recebe a anotação de Service para mostrar para o Spring
 * que essa classe será um Bean administrado por ele, possibilitando
 * então a criação de pontos de injeção.
 * @author Alexandre Junior
 */

@Service
public class CodeblogServiceImpl implements CodeblogService {
    
    /* Cria um ponto de injeção no repository
    a fim de se poder utilizar as instancias contidas nele */
    @Autowired
    CodeblogRepository codeblogRepository;

    @Override
    public List<Post> findAll() {
        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return codeblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeblogRepository.save(post);
    }
    
}
