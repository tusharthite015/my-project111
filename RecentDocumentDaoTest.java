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
import org.springframework.test.annotation.Rollback;

import com.enttribe.core.generic.exceptions.application.BusinessException;
import com.enttribe.document.dao.impl.RecentDocumentDaoImpl;
import com.enttribe.document.utils.MessageUtil;
import com.enttribe.utils.Utils;
import com.enttribe.document.model.RecentDocument;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.enttribe.document.TestApplication;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("local")
public class RecentDocumentDaoTest {
    

    @Autowired
    private RecentDocumentDaoImpl recentDocumentDao;

    @Test
    void testGetRecentDocumentByCreatorAndDocumentID(){
        RecentDocument recentDocument = recentDocumentDao.getRecentDocumentByCreatorAndDocumentID(7596, 140234);
        //assertNotNull(recentDocument);
    }


    @Test
    void testGetRecentDocumentCount(){
        Integer count = recentDocumentDao.getRecentDocumentCount(140234);
        assertNotNull(count);
    }

    @Test
    void testGetRecentDocumentCount_ThrowsBusinessException(){
        Integer count = recentDocumentDao.getRecentDocumentCount(235432);
        assertEquals(0, count);
    }

    @Test
    void testGetRecentDocumentList(){
        List<RecentDocument> recentDocuments = recentDocumentDao.getRecentDocumentList(0, 10, 140234);
        assertNotNull(recentDocuments);
    }

    @Test
    void testGetRecentDocumentList_v2(){
        List<RecentDocument> recentDocuments = recentDocumentDao.getRecentDocumentList(0, null, 140234);
        assertNotNull(recentDocuments);
    }

    @Test
    void testDeleteOrRestoreRecentDocument(){
        recentDocumentDao.deleteOrRestoreRecentDocument(Arrays.asList(7596), false);
        //assertNotNull(recentDocuments);
    }

    @Test
    void testGetRecentDocumentByDocumentIds(){
        List<RecentDocument> recentDocuments = recentDocumentDao.getRecentDocumentByDocumentIds(Arrays.asList(7596), 140234);
        assertNotNull(recentDocuments);
    }

    @Test
    void testGetRecentDocumentByDocumentIds_v2(){
        List<RecentDocument> recentDocuments = recentDocumentDao.getRecentDocumentByDocumentIds(Arrays.asList(7596), null);
        assertNotNull(recentDocuments);
    }

    @Test
    @Rollback(true)
    void testDeleteRecentDocument(){
        recentDocumentDao.deleteRecentDocument(Arrays.asList(7596), 140234);
        //assertNotNull(recentDocuments);
    }

    @Test 
    @Rollback(true)
    void testDeleteRecentDocument_v2(){
        recentDocumentDao.deleteRecentDocument(Arrays.asList(7596), null);
        //assertNotNull(recentDocuments);
    }

    

}