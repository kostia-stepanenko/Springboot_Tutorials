package com.oreilly.demo.dao;

import com.oreilly.demo.entities.Officer;
import com.oreilly.demo.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OfficerRepositoryTest {

    @Autowired
    private OfficerRepository dao;

    @Autowired
    private JdbcTemplate template;


    private List<Integer> ids(){
        return template.query("select id from officers",(rs,num) -> rs.getInt("id"));
    }
    @Test
    public void save() {
        Officer officer = new Officer(null, Rank.ENSIGN,"Wesley", "Crusher");
        officer = dao.save(officer);
        assertNotNull(officer.getId());
    }

    @Test
    void findByIdThatExists() {
        ids().forEach(id ->{
            System.out.println("Testing findById with ID: " + id);
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id,officer.get().getId());
        });
    }


    @Test
    void findByIdThatDoesNotExists() {
        assertThat(ids()).doesNotContain(999);
        Optional<Officer> officer = dao.findById(999);
        assertFalse(officer.isPresent());
    }

    @Test
    void findAll() {
        List<String> dbNames = dao.findAll().stream().map(Officer::getLastName).toList();
        assertThat(dbNames).containsAll(List.of(
                "Kirk","Maxwell","Picard","Freeman","Burnham","Sisko"));
    }

    @Test
    void count() {
        assertEquals(ids().size(), dao.count());
    }

    @Test
    void delete() {
        ids().forEach(id ->{
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            dao.delete(officer.get());
        });
        assertEquals(0,dao.count());
    }

    @Test
    void existsById() {
        ids().forEach(id -> assertTrue(dao.existsById(id)));
    }
}
