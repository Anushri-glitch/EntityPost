package com.Anushka.entityPost.Dao;

import com.Anushka.entityPost.Model.entityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<entityPost, Integer> {
}
