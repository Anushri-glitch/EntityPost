package com.Anushka.entityPost.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tabl_entityPost")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class entityPost {
    @Id
    @Column(name="postId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    @Column(name="postTitle")
    private String postTitle;

    @Column(name="postDescription")
    private String postDescription;
}
