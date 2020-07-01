/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.codeblog.controller;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Deve-se definir essa classe como controller para que o Spring
 * gerencie essa classe como um Bean.
 * @author Alexandre Junior
 */
@Controller
public class CodeblogController {
    
    // Ponto de injeção da Classe CodeblogService a fim de utilizar os métodos lá definidos.
    @Autowired
    CodeblogService codeblogService;
    
    /* Retorna tanto o post (Model) e a tela HTML renderizada (View),
    após a definição de qual método HTTP (get) e da URL. */
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
        
    }
    
    /* Retorna o post completo, com detalhes. */
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);
        return mv;
        
    }
    
    /* Retorna um formulário para inserir um novo post. */
    @RequestMapping(value="/newpost", method=RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }
    
    /* Salva as informações inseridas no formulário no BD, 
    verificando através do @Valid se os campos satisfazem às
    restrições inseridas no Model. */
    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            // Insere mensagem de erros
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }
}
