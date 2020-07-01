/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.codeblog.repository;

import com.spring.codeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alexandre Junior
 */

// O JpaRepository já traz todos os metodos necessários para serem
// feitas as transações com o banco de dados.
public interface CodeblogRepository extends JpaRepository<Post, Long> {
    
}
