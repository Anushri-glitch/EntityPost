package com.Anushka.entityPost.Controller;

import com.Anushka.entityPost.Model.entityPost;
import com.Anushka.entityPost.Service.entityPostService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/entityPost")
public class EntityPostController {
    @Autowired
    entityPostService postService;

    @PostMapping(value="/entity")
    public ResponseEntity<String> savePost(@RequestBody String postData){
        entityPost post = setPost(postData);
        int postId = postService.savePost(post);
        return new ResponseEntity<>("user saved with Id - " + postId, HttpStatus.CREATED);
    }

    @GetMapping("/getPost")
    public ResponseEntity<String> getPost(@Nullable @RequestParam String postId){
        JSONArray userDetails = postService.getPost(postId);
        return new ResponseEntity(userDetails.toString(), HttpStatus.OK);
    }

    private entityPost setPost(String postData) {
        JSONObject jsonObject = new JSONObject(postData);
        entityPost post = new entityPost();

        post.setPostId(jsonObject.getInt("postId"));
        post.setPostTitle(jsonObject.getString("postTitle"));
        post.setPostDescription(jsonObject.getString("postDesc"));

        return post;
    }
}
