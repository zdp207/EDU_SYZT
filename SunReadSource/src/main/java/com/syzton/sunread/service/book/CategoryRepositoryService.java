package com.syzton.sunread.service.book;

import com.syzton.sunread.model.book.Category;
import com.syzton.sunread.repository.book.CategoryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jerry on 3/13/15.
 */
@Service
public class CategoryRepositoryService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) throws NotFoundException {
        return null;
    }

    @Transactional
    @Override
    public Category add(Category category) {


        category = categoryRepository.save(category);

        return category;
    }

    @Override
    public Category deleteById(Long id) {


        Category category = categoryRepository.findOne(id);
        categoryRepository.delete(id);


        return category;
    }
}