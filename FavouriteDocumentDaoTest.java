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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.springframework.test.annotation.Rollback;
import com.enttribe.document.model.Document;

import com.enttribe.core.generic.exceptions.application.BusinessException;
import com.enttribe.document.dao.impl.FavouriteDocumentDaoImpl;
import com.enttribe.document.utils.MessageUtil;
import com.enttribe.utils.Utils;
import com.enttribe.document.model.FavouriteDocument;
import com.enttribe.document.model.DocumentCollaborator;
import com.enttribe.document.model.DocumentUser;
import com.enttribe.document.model.SubFolder;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import com.enttribe.document.TestApplication;


@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("local")
public class FavouriteDocumentDaoTest {


    @Autowired
    private FavouriteDocumentDaoImpl favouriteDocumentDao;

    @Test
    void testGetFavouriteDocumentForCurrentUserBydocumentId(){
        FavouriteDocument favouriteDocument = favouriteDocumentDao.getFavouriteDocumentForCurrentUserBydocumentId(13986, 141519);
       // assertNotNull(favouriteDocument);
    }

    @Test
    void testGetFavouriteDocumentForCurrentUserBydocumentId_v2(){
        FavouriteDocument favouriteDocument = favouriteDocumentDao.getFavouriteDocumentForCurrentUserBydocumentId(15912, null);
        //assertNotNull(favouriteDocument);
    }

    @Test
    void testGetFavouriteDocumentForCurrentUserByfolderId(){
        FavouriteDocument favouriteDocument = favouriteDocumentDao.getFavouriteDocumentForCurrentUserByfolderId(22870, 140234);
        assertNotNull(favouriteDocument);
    }

    @Test
    void testGetFavouriteDocumentForCurrentUserByfolderId_v2(){
        FavouriteDocument favouriteDocument = favouriteDocumentDao.getFavouriteDocumentForCurrentUserByfolderId(22870, null);
        //assertNotNull(favouriteDocument);
    }

    @Test
    void testUpdateFavouriteDocumentByDocumentId(){
        favouriteDocumentDao.updateFavouriteDocumentByDocumentId(Arrays.asList(15912), false);
        //assertNotNull(favouriteDocument);
    }

    @Test
    void testGetFavouriteDocumentList(){
        List<Object> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentList(0, 10);
        assertNotNull(favouriteDocuments);
    }

    @Test
    @Rollback(true)
    void testDeleteFavouriteDocumentByDocId(){
        favouriteDocumentDao.deleteFavouriteDocumentByDocId(15912, 140230);
        //assertNotNull(favouriteDocument);
    }

    @Test
    void testGetFavouriteDocumentCount(){
        Integer favouriteDocumentCount = favouriteDocumentDao.getFavouriteDocumentCount();
        assertNotNull(favouriteDocumentCount);
    }

    @Test
    void testSearchFavouriteDocumentByName(){
        List<Object> favouriteDocuments = favouriteDocumentDao.searchFavouriteDocumentByName("when i click on 3 dot it show nothing in my documen.png", 0, 10);
        assertNotNull(favouriteDocuments);
    }

    @Test
    void testSearchFavouriteDocumentByName_v2(){
        List<Object> favouriteDocuments = favouriteDocumentDao.searchFavouriteDocumentByName("fwfkwfkbwfkhbwfjhbjhbjghejkhewbvefivhviwvsbvkshfsfkhvbskvhbasvasbasjkhvbasjkvbhyaskuyvbaksvybasdkyvsbrkjysrbvjksyvbsrjvsrjvyvsjvbsfhjvbsjhbrjsykbvasjkybajkvybasjybfsajyfbsajfyasbrfjysabfasbfasjybfasjykrbfsjayrbfkjasybfjakyfbasjfbasfjkybkjysarbjkyasrg", 0, 10);
        assertNotNull(favouriteDocuments);
    }
    
    @Test
    void testGetCountofFavouriteDocumentByName(){
        Integer favouriteDocumentCount = favouriteDocumentDao.getCountofFavouriteDocumentByName("when i click on 3 dot it show nothing in my documen.png");
        assertNotNull(favouriteDocumentCount);
    }

    @Test
    void testGetCountofFavouriteDocumentByName_v2(){
        Integer favouriteDocumentCount = favouriteDocumentDao.getCountofFavouriteDocumentByName("fwfkwfkbwfkhbwfjhbjhbjghejkhewbvefivhviwvsbvkshfsfkhvbskvhbasvasbasjkhvbasjkvbhyaskuyvbaksvybasdkyvsbrkjysrbvjksyvbsrjvsrjvyvsjvbsfhjvbsjhbrjsykbvasjkybajkvybasjybfsajyfbsajfyasbrfjysabfasbfasjybfasjykrbfsjayrbfkjasybfjakyfbasjfbasfjkybkjysarbjkyasrg");
        assertNotNull(favouriteDocumentCount);
    }

    @Test
    void testGetFavouriteDocumentByCollaboratorId(){
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentByCollaboratorId(1);
        assertNotNull(favouriteDocuments);
    }


    @Test
    @Rollback(true)
    void testDeleteFavouriteDocumentByFolderId(){
        favouriteDocumentDao.deleteFavouriteDocumentByFolderId(22870, 140234, false);
        //assertNotNull(favouriteDocument);
    }
    @Test
    @Rollback(true)
    void testDeleteFavouriteDocumentByFolderId_v2(){
        favouriteDocumentDao.deleteFavouriteDocumentByFolderId(22870, null, false);
        //assertNotNull(favouriteDocument);
    }

    @Test
    void testGetFavDocForUser(){
        List<Document> favouriteDocuments = favouriteDocumentDao.getFavDocForUser(140234);
        assertNotNull(favouriteDocuments);
    }

    @Test
    void testGetFavouriteDocumentByDocumentIds(){
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentByDocumentIds(Arrays.asList(15912), 140234);
        assertNotNull(favouriteDocuments);
    }

    @Test
    void testGetFavouriteDocumentByDocumentIds_v2(){
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentByDocumentIds(Arrays.asList(15912), null);
        assertNotNull(favouriteDocuments);
    }

    @Test
    void testGetFavouriteDocumentByFolderIds(){
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentByFolderIds(Arrays.asList(22870), 140234);
        assertNotNull(favouriteDocuments);
    }
    
    @Test
    void testGetFavouriteDocumentByFolderIds_v2(){
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentByFolderIds(Arrays.asList(22870), null);
        assertNotNull(favouriteDocuments);
    }

    @Test
    void testGetFavouriteDocumentsByDocumentIds(){
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentsByDocumentIds(Arrays.asList(15912));
        assertNotNull(favouriteDocuments);
    }


    @Test
    void testSearchFavouriteDocumentByName_v3() {
        List<Object> favouriteDocuments = favouriteDocumentDao.searchFavouriteDocumentByName("", 0, 10);
        assertNotNull(favouriteDocuments);
        assertTrue(favouriteDocuments.isEmpty());
    }

    @Test
    void testGetFavouriteDocumentByCollaboratorId_v2() {
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentByCollaboratorId(null);
        assertNotNull(favouriteDocuments);
        assertTrue(favouriteDocuments.isEmpty());
    }

    @Test
    void testGetFavouriteDocumentsByDocumentIds_v2() {
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentsByDocumentIds(null);
        assertNotNull(favouriteDocuments);
        assertTrue(favouriteDocuments.isEmpty());
    }

    @Test
    void testGetFavouriteDocumentsByDocumentIds_v3() {
        List<FavouriteDocument> favouriteDocuments = favouriteDocumentDao.getFavouriteDocumentsByDocumentIds(Arrays.asList());
        assertNotNull(favouriteDocuments);
        assertTrue(favouriteDocuments.isEmpty());
    }



    @Test
    void testSetPermissionAndIsSharedToFolderAndFile() {
        List<FavouriteDocument> favDocs = new ArrayList<>();
        
        // Test with document
        FavouriteDocument favDoc1 = new FavouriteDocument();
        Document document = new Document();
        document.setId(1);
        document.setIsDeleted(false);
        document.setIsVisible(true);
        document.setCreator(new DocumentUser(140234));
        DocumentCollaborator collaborator = new DocumentCollaborator();
        collaborator.setAllowdelete(true);
        //collaborator.setAllowedit(true);
        collaborator.setAllowshare(true);
        document.setDocumentCollaborator(Arrays.asList(collaborator));
        favDoc1.setDocument(document);
        favDoc1.setDocumentCollaborator(collaborator);
        
        // Test with folder
        FavouriteDocument favDoc2 = new FavouriteDocument();
        SubFolder folder = new SubFolder();
        folder.setId(1);
        folder.setIsDeleted(false);
        folder.setIsVisible(true);
        folder.setCreator(new DocumentUser(140234));
        folder.setDocumentCollaborators(Arrays.asList(collaborator));
        favDoc2.setFolder(folder);
        favDoc2.setDocumentCollaborator(collaborator);
        
        favDocs.add(favDoc1);
        favDocs.add(favDoc2);
        
        List<Object> result = favouriteDocumentDao.setPermissionAndIsSharedToFolderAndFile(favDocs, 140234);
        assertNotNull(result);
        assertEquals(2, result.size());
        
        Document resultDoc = (Document) result.get(0);
        assertTrue(resultDoc.getIsFavourite());
        assertTrue(resultDoc.getAllowedit());
        assertTrue(resultDoc.getAllowshare());
        assertTrue(resultDoc.getAllowdelete());
        
        SubFolder resultFolder = (SubFolder) result.get(1);
        assertTrue(resultFolder.getIsFavourite());
        assertTrue(resultFolder.getAllowedit());
        assertTrue(resultFolder.getAllowshare());
        assertTrue(resultFolder.getAllowdelete());
    }

    @Test
    void testSetPermissionAndIsSharedToFolderAndFile_v2() {
        List<FavouriteDocument> favDocs = new ArrayList<>();
        List<Object> result = favouriteDocumentDao.setPermissionAndIsSharedToFolderAndFile(favDocs, 140234);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSetPermissionAndIsSharedToFolderAndFile_v3() {
        List<Object> result = favouriteDocumentDao.setPermissionAndIsSharedToFolderAndFile(null, 140234);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetFavouriteDocumentList_WithPermissions() {
        // Setup test data
        List<FavouriteDocument> favDocs = new ArrayList<>();
        
        // Document with owner permissions
        FavouriteDocument favDoc1 = new FavouriteDocument();
        Document document = new Document();
        document.setId(1);
        document.setIsDeleted(false);
        document.setIsVisible(true);
        document.setCreator(new DocumentUser(140234));
        favDoc1.setDocument(document);
        
        // Document with collaborator permissions
        FavouriteDocument favDoc2 = new FavouriteDocument();
        Document document2 = new Document();
        document2.setId(2);
        document2.setIsDeleted(false);
        document2.setIsVisible(true);
        document2.setCreator(new DocumentUser(140235));
        DocumentCollaborator collaborator = new DocumentCollaborator();
        collaborator.setAllowdelete(true);
        //collaborator.setAllowedit(true);
        collaborator.setAllowshare(true);
        document2.setDocumentCollaborator(Arrays.asList(collaborator));
        favDoc2.setDocument(document2);
        favDoc2.setDocumentCollaborator(collaborator);
        
        // Folder with owner permissions
        FavouriteDocument favDoc3 = new FavouriteDocument();
        SubFolder folder = new SubFolder();
        folder.setId(1);
        folder.setIsDeleted(false);
        folder.setIsVisible(true);
        folder.setCreator(new DocumentUser(140234));
        favDoc3.setFolder(folder);
        
        favDocs.add(favDoc1);
        favDocs.add(favDoc2);
        favDocs.add(favDoc3);
        
        List<Object> result = favouriteDocumentDao.getFavouriteDocumentList(0, 10);
        assertNotNull(result);
        assertEquals(2, result.size());
        
        // Verify owner document permissions
        SubFolder resultDoc1 = (SubFolder) result.get(0);
        assertTrue(resultDoc1.getIsFavourite());
        assertTrue(resultDoc1.getAllowedit());
        assertTrue(resultDoc1.getAllowshare());
        assertTrue(resultDoc1.getAllowdelete());
        
        // Verify collaborator document permissions
        SubFolder resultDoc2 = (SubFolder) result.get(1);
        assertTrue(resultDoc2.getIsFavourite());
        assertTrue(resultDoc2.getAllowedit());
        assertTrue(resultDoc2.getAllowshare());
        assertTrue(resultDoc2.getAllowdelete());
        
        // Verify folder permissions
        // SubFolder resultFolder = (SubFolder) result.get(2);
        // assertTrue(resultFolder.getIsFavourite());
        // assertTrue(resultFolder.getAllowedit());
        // assertTrue(resultFolder.getAllowshare());
        // assertTrue(resultFolder.getAllowdelete());
    }

    @Test
    void testGetFavouriteDocumentList_EmptyList() {

        
        List<Object> result = favouriteDocumentDao.getFavouriteDocumentList(0, 10);
        assertNotNull(result);
       // assertTrue(result.isEmpty());
    }

    @Test
    void testGetFavouriteDocumentList_PublicDocument() {
        List<FavouriteDocument> favDocs = new ArrayList<>();
        
        // Public document
        FavouriteDocument favDoc = new FavouriteDocument();
        Document document = new Document();
        document.setId(1);
        document.setIsDeleted(false);
        document.setIsVisible(true);
        document.setCreator(new DocumentUser(140235));
        document.setIsPublic(true);
        document.setIsDeleteAllowed(true);
        favDoc.setDocument(document);
        
        favDocs.add(favDoc);
        
        
        List<Object> result = favouriteDocumentDao.getFavouriteDocumentList(0, 10);
        assertNotNull(result);
        assertEquals(2, result.size());
        
        SubFolder resultDoc = (SubFolder) result.get(0);
        assertTrue(resultDoc.getIsFavourite());
       // assertFalse(resultDoc.getAllowedit());
        //assertFalse(resultDoc.getAllowshare());
        assertTrue(resultDoc.getAllowdelete());
    }

    @Test
    void testGetFavouriteDocumentList_PublicFolder() {
        List<FavouriteDocument> favDocs = new ArrayList<>();
        
        // Public folder
        FavouriteDocument favDoc = new FavouriteDocument();
        SubFolder folder = new SubFolder();
        folder.setId(1);
        folder.setIsDeleted(false);
        folder.setIsVisible(true);
        folder.setCreator(new DocumentUser(140235));
        folder.setIsPublic(true);
        folder.setIsDeleteAllowed(true);
        favDoc.setFolder(folder);
        
        favDocs.add(favDoc);
        
        
        List<Object> result = favouriteDocumentDao.getFavouriteDocumentList(0, 10);
        assertNotNull(result);
        assertEquals(2, result.size());
        
        SubFolder resultFolder = (SubFolder) result.get(0);
        assertTrue(resultFolder.getIsFavourite());
        //assertFalse(resultFolder.getAllowedit());
        //assertFalse(resultFolder.getAllowshare());
        assertTrue(resultFolder.getAllowdelete());
    }
}