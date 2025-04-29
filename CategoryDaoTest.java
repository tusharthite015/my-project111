package com.enttribe.document.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.enttribe.core.generic.exceptions.application.BusinessException;
import com.enttribe.document.dao.impl.CategoryDaoImpl;
import com.enttribe.document.utils.MessageUtil;
import com.enttribe.utils.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.enttribe.document.TestApplication;
import com.enttribe.document.model.Category;
import java.util.List;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("local")
public class CategoryDaoTest {

  

    @Autowired
    private CategoryDaoImpl categoryDao;

    @Test
    void testGetCategory(){
        List<Category> categories = categoryDao.getCategory();
        assertNotNull(categories);
    }

    @Test
    void testGetCategoryByName(){
        Category category = categoryDao.getCategoryByName("Articles and Incorporation Documents");
        assertNotNull(category);
    }

    @Test
    void testGetCategoryByName_ThrowsBusinessException(){
        BusinessException businessException = assertThrows(BusinessException.class, () -> categoryDao.getCategoryByName("test"));
        assertEquals(MessageUtil.SOMETHING_WENT_WRONG, businessException.getMessage());
    }
    
    
}