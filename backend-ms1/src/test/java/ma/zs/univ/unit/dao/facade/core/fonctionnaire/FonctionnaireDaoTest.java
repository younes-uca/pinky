package ma.zs.univ.unit.dao.facade.core.fonctionnaire;

import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import ma.zs.univ.dao.facade.core.fonctionnaire.FonctionnaireDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FonctionnaireDaoTest {

@Autowired
    private FonctionnaireDao underTest;

    @Test
    void shouldFindByCin(){
        String cin = "cin-1";
        Fonctionnaire entity = new Fonctionnaire();
        entity.setCin(cin);
        underTest.save(entity);
        Fonctionnaire loaded = underTest.findByCin(cin);
        assertThat(loaded.getCin()).isEqualTo(cin);
    }

    @Test
    void shouldDeleteByCin() {
        String cin = "cin-1";
        Fonctionnaire entity = new Fonctionnaire();
        entity.setCin(cin);
        underTest.save(entity);

        int result = underTest.deleteByCin(cin);

        Fonctionnaire loaded = underTest.findByCin(cin);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Fonctionnaire entity = new Fonctionnaire();
        entity.setId(id);
        underTest.save(entity);
        Fonctionnaire loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Fonctionnaire entity = new Fonctionnaire();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Fonctionnaire loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Fonctionnaire> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Fonctionnaire> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Fonctionnaire given = constructSample(1);
        Fonctionnaire saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Fonctionnaire constructSample(int i) {
		Fonctionnaire given = new Fonctionnaire();
        given.setCin("cin-"+i);
        given.setNom("nom-"+i);
        given.setPrenom("prenom-"+i);
        given.setUsername("username-"+i);
        given.setMail("mail-"+i);
        given.setCredentialsNonExpired(false);
        given.setEnabled(false);
        given.setAccountNonExpired(false);
        given.setAccountNonLocked(false);
        given.setPasswordChanged(false);
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        return given;
    }

}
