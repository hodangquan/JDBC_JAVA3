/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.List;
import model.Category;
import repository.CategoryRepository;
import java.sql.*;

/**
 *
 * @author hodangquan
 */
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }

    public List<Category> layAllCategory() {
        try {
            return categoryRepository.layDSCategory();
        } catch (Exception e) {
        }
        return null;
    }

    public Category layIdByName(String name) throws SQLException {
        return categoryRepository.getByCategoryName(name);
    }
}
