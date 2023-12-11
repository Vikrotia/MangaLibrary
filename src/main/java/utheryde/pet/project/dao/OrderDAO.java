package utheryde.pet.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import utheryde.pet.project.models.Manga;
import utheryde.pet.project.models.Order;
import utheryde.pet.project.models.Person;

import java.util.List;

@Component
public class OrderDAO {
   private final JdbcTemplate jdbcTemplate;

   @Autowired
    public OrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> findNewOrders(int limit) {
        return jdbcTemplate.query("SELECT * FROM Orders ORDER BY orderDate DESC LIMIT ?",
                new Object[]{limit}, new BeanPropertyRowMapper<>(Order.class));
    }

//    public Person findPersonById(Long personId) {
//        String sql = "SELECT * FROM Person WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{personId}, new BeanPropertyRowMapper<>(Person.class));
//    }
//    public Manga findMangaById(Long mangaId) {
//        String sql = "SELECT * FROM Manga WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{mangaId}, new BeanPropertyRowMapper<>(Manga.class));
//    }
}
