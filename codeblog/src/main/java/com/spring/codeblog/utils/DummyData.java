/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexandre Junior
 */
@Component
public class DummyData {
    
    // Cria um ponto de injeção do repository
    @Autowired
    CodeblogRepository codeblogRepository;
    
    // Deixar comentado após inserção desses dados de exemplo no BD.
    // @PostConstruct
    public void savePosts() {
        
        List<Post> postList = new ArrayList<>();
        
        Post post1 = new Post();
        post1.setAutor("Michelli Brito");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tincidunt ullamcorper sapien ut faucibus. Quisque vehicula metus sed felis varius laoreet. Nullam vestibulum molestie erat, eleifend egestas nunc placerat ac. Vivamus ultricies interdum porttitor. Donec laoreet sem nisl, vitae ullamcorper neque finibus at. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sagittis odio interdum maximus elementum. Nam ut vestibulum sapien, eget porta sapien.");
        
        Post post2 = new Post();
        post2.setAutor("Alexandre Jr.");
        post2.setData(LocalDate.now());
        post2.setTitulo("API REST");
        post2.setTexto("Sed molestie feugiat turpis sit amet cursus. Sed hendrerit posuere tortor sit amet condimentum. Morbi scelerisque magna eu hendrerit feugiat. In maximus vitae felis quis consectetur. Mauris non odio magna. Ut eu facilisis enim. Aenean et ex ac risus facilisis ultrices eget quis mauris. Morbi faucibus ipsum vel dolor ultricies, ac ultricies mi commodo. Donec eu bibendum purus, sed dignissim tellus. Maecenas elementum mauris eu arcu ornare, id interdum ipsum hendrerit. Phasellus non sem scelerisque, mollis lacus sed, feugiat ex. Cras in enim ac ex porta consectetur.");
        
        postList.add(post1);
        postList.add(post2);
        
        for (Post post : postList) {
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
    
    
    
    
}
