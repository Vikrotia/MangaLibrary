package utheryde.pet.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import utheryde.pet.project.models.Manga;

import java.util.List;

@Component
public class MangaDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public MangaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Manga manga) {
        jdbcTemplate.update("INSERT INTO Manga(title, author, year, count, order_count) VALUES (?,?,?,?,?)", manga.getTitle(),
                manga.getAuthor(), manga.getYear(), manga.getCount(), manga.getOrder_count());
    }

    public List<Manga> findTopMangas(int limit) {
        return jdbcTemplate.query("SELECT * FROM Manga ORDER BY order_count DESC LIMIT " + limit,
                new BeanPropertyRowMapper<>(Manga.class));
    }

    public Manga show(int id)  {
        return jdbcTemplate.query("SELECT * FROM Manga WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Manga.class))
                .stream().findAny().orElse(null);
    }

    public List<Manga> showAllMangas(){
        return jdbcTemplate.query("SELECT * FROM Manga", new BeanPropertyRowMapper<>(Manga.class));
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Manga WHERE id=?", id);
    }

    public void update(int id, Manga manga) {
        jdbcTemplate.update("UPDATE Manga SET title=?, author=?, year=?, count=?, order_count=? WHERE id=?",manga.getTitle(),
        manga.getAuthor(), manga.getYear(), manga.getCount(), manga.getOrder_count(), id);
    }
}
