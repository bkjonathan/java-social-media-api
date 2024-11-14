package com.thomas.social_media_api.repositories;

import com.thomas.social_media_api.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String > {
}
