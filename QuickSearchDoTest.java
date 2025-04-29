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

import java.util.Arrays;

import com.enttribe.core.generic.exceptions.application.BusinessException;
import com.enttribe.document.dao.impl.DocumentSystemConfigurationDaoImpl;
import com.enttribe.document.utils.MessageUtil;
import com.enttribe.utils.Utils;
import com.enttribe.document.dao.impl.QuickSearchDaoImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import com.enttribe.document.model.DocumentUser;
import com.enttribe.document.model.QuickSearch;
import com.enttribe.document.wrapper.ShareTypeWrapper;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.enttribe.document.TestApplication;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("local")
public class QuickSearchDoTest {
    

    @Autowired
    private QuickSearchDaoImpl quickSearchDao;

    @Test
    void testSearchFoldersAndFileCreatedByUser(){
        List<Object> quickSearch = quickSearchDao.searchFoldersAndFileCreatedByUser("demo", 140234, 0, 10, true);
        assertNotNull(quickSearch);
    }

    @Test
    void testSearchFoldersAndFileCreatedByUser_v2(){
        List<Object> quickSearch = quickSearchDao.searchFoldersAndFileCreatedByUser(null, 140234, 0, 10, true);
        assertNotNull(quickSearch);
    }

    // @Test
    // void testGetQuickSearch(){
    //     DocumentUser documentUser = new DocumentUser();
    //     documentUser.setUserId(140234);
    //     ShareTypeWrapper shareTypeWrapper = new ShareTypeWrapper("role", null, documentUser, null, null);
    //     QuickSearch quickSearch = quickSearchDao.getQuickSearch(22870, null, shareTypeWrapper);
    //     assertNotNull(quickSearch);
    // }   

    // @Test
    // void testGetQuickSearch_v2(){
    //     ShareTypeWrapper shareTypeWrapper = new ShareTypeWrapper("role", null, null, "role", null);
    //     QuickSearch quickSearch = quickSearchDao.getQuickSearch(null, 15912, shareTypeWrapper);
    //     assertNotNull(quickSearch);
    // }

    // @Test
    // void testGetQuickSearch_v3(){
    //     ShareTypeWrapper shareTypeWrapper = new ShareTypeWrapper("workgroup", null, null, null, "workgroup");
    //     QuickSearch quickSearch = quickSearchDao.getQuickSearch(22870, 15912, shareTypeWrapper);
    //     assertNotNull(quickSearch);
    // }

    @Test
    void testGetQuickSearchListByDocumentIds(){
        List<QuickSearch> quickSearch = quickSearchDao.getQuickSearchListByDocumentIds(Arrays.asList(22870, 15912));
        assertNotNull(quickSearch);
    }

    @Test
    void testQuickSearchFiles(){
        List<Object> quickSearch = quickSearchDao.quickSearchFiles("demo", "pdf", null, 140234, 0, 10, null, "test");
        assertNotNull(quickSearch);
    }



    
    
}
    