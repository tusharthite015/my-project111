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
import com.enttribe.document.dao.impl.DocumentHistoryDaoImpl;
import com.enttribe.document.utils.MessageUtil;
import com.enttribe.utils.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.enttribe.document.TestApplication;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("local")
public class DocumentHistoryDaoTest {
    

    @Autowired
    private DocumentHistoryDaoImpl documentHistoryDao;

    @Test
    void testUpdateIsDeleted() {
        // Arrange
        Integer documentId = 1;
        // String queryString = "update " + ConfigUtil.DB_ALIAS + "DOCUMENT_HISTORY set DELETED = true where DOCUMENT_FK=:documentId ;";
        // Query query = getEntityManager().createNativeQuery(queryString).setParameter("documentId", documentId);

        documentHistoryDao.updateIsDeleted(documentId);
    }
    @Test
    void testUpdateIsDeleted_v2() {
        // Arrange
        Integer documentId = null;
        // String queryString = "update " + ConfigUtil.DB_ALIAS + "DOCUMENT_HISTORY set DELETED = true where DOCUMENT_FK=:documentId ;";
        // Query query = getEntityManager().createNativeQuery(queryString).setParameter("documentId", documentId);

        documentHistoryDao.updateIsDeleted(documentId);
    }
}
    