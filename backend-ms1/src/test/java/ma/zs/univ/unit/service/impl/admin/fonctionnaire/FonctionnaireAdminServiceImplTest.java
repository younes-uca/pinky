package ma.zs.univ.unit.service.impl.admin.fonctionnaire;

import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import ma.zs.univ.dao.facade.core.fonctionnaire.FonctionnaireDao;
import ma.zs.univ.service.impl.admin.fonctionnaire.FonctionnaireAdminServiceImpl;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class FonctionnaireAdminServiceImplTest {

    @Mock
    private FonctionnaireDao repository;
    private AutoCloseable autoCloseable;
    private FonctionnaireAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FonctionnaireAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFonctionnaire() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFonctionnaire() {
        // Given
        Fonctionnaire toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFonctionnaire() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFonctionnaireById() {
        // Given
        Long idToRetrieve = 1L; // Example Fonctionnaire ID to retrieve
        Fonctionnaire expected = new Fonctionnaire(); // You need to replace Fonctionnaire with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Fonctionnaire result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Fonctionnaire constructSample(int i) {
		Fonctionnaire given = new Fonctionnaire();
        given.setId(id);
        given.setCin("cin-"+i);
        given.setCin(cin);
        given.setNom("nom-"+i);
        given.setNom(nom);
        given.setPrenom("prenom-"+i);
        given.setPrenom(prenom);
        given.setUsername("username-"+i);
        given.setUsername(username);
        given.setMail("mail-"+i);
        given.setMail(mail);
        given.setCredentialsNonExpired(false);
        given.setCredentialsNonExpired(credentialsNonExpired);
        given.setEnabled(false);
        given.setEnabled(enabled);
        given.setAccountNonExpired(false);
        given.setAccountNonExpired(accountNonExpired);
        given.setAccountNonLocked(false);
        given.setAccountNonLocked(accountNonLocked);
        given.setPasswordChanged(false);
        given.setPasswordChanged(passwordChanged);
        given.setUsername("username-"+i);
        given.setUsername(username);
        given.setPassword("password-"+i);
        given.setPassword(password);
        return given;
    }

}
