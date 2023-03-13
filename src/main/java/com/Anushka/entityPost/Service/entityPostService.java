package com.Anushka.entityPost.Service;

import com.Anushka.entityPost.Dao.IPostRepository;
import com.Anushka.entityPost.Model.entityPost;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class entityPostService {

    @Autowired
    IPostRepository postRepository;

    public int savePost(entityPost post){
        entityPost postObject = postRepository.save(post);
        return postObject.getPostId();
    }

    public JSONArray getPost(String postId){
        JSONArray jsonArray = new JSONArray();
        if(null != postId && postRepository.findById(Integer.valueOf(postId)).isPresent()){
            entityPost post = postRepository.findById(Integer.valueOf(postId)).get();
            if(null != post){
                JSONObject postObject = setPost(post);
                jsonArray.put(postObject);
            }
        }
        else{
            List<entityPost> postList = postRepository.findAll();
            for(entityPost post : postList){
                JSONObject postObject = setPost(post);
                jsonArray.put(postObject);
            }
        }
        return jsonArray;
    }

    //This setPostObject Function is only for getPost Function
    private JSONObject setPost(entityPost post){
        JSONObject newUserObject = new JSONObject();

        newUserObject.put("postId", post.getPostId());
        newUserObject.put("postTitle", post.getPostTitle());
        newUserObject.put("postDesc", post.getPostDescription());

        return newUserObject;
    }
}
