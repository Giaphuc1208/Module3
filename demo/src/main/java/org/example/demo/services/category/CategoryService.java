package org.example.demo.services.category;

import org.example.demo.models.Category;
import org.example.demo.repositories.category.CategoryRepo;
import org.example.demo.repositories.category.ICategoryRepo;

import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryRepo categoryRepo = new CategoryRepo();
    @Override
    public List<Category> showAllCategories() {
        return categoryRepo.showAllCategories();
    }
}
