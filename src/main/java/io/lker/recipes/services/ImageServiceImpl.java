package io.lker.recipes.services;

import io.lker.recipes.model.Recipe;
import io.lker.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    // Don't write images into filesystem, not good for java. Unlike PHP dudes.
    // Store images into Amazon S3? Database isn't best solution.
    // Want to roll this out anywhere
    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("I received a file.");

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);
        } catch (IOException e){
            //todo handle better
            log.error("ERROR ", e);
            e.printStackTrace();
        }

    }
}
