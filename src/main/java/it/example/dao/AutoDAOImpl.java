package it.example.dao;

import it.example.model.Auto;
import it.example.rowMapper.AutoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AutoDAOImpl implements AutoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Auto> loadAutos() {
        return jdbcTemplate.query("SELECT * FROM autos ORDER BY id", new AutoRowMapper());
    }

    @Override
    public void saveAuto(Auto auto) {
        Auto auto1 = getAutoById(auto.getId());
        String insert_sql = "INSERT INTO autos (modello, marca, cilindrata, cavalli, coppia, colore) VALUES (?, ?, ?, ?, ?, ?)";
        String update_sql = "UPDATE autos SET modello = ?, marca = ?, cilindrata = ?, cavalli = ?, coppia = ?, colore = ? WHERE id = " + auto.getId();
        Object[] sqlParams = { auto.getModello(),
                auto.getMarca(),
                auto.getCilindrata(),
                auto.getCavalli(),
                auto.getCoppia(),
                auto.getColore() };
        if(auto1 == null) {
            jdbcTemplate.update(insert_sql, sqlParams);
        } else {
            jdbcTemplate.update(update_sql, sqlParams);
        }
    }

    @Override
    public Auto getAutoById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM autos WHERE id = ?", new AutoRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void deleteAuto(int id) {
        jdbcTemplate.update("DELETE FROM autos WHERE id= ?", id);
    }

    @Override
    public List<Auto> searchAuto(String text) {
        text = "%"+text+"%";
        Object[] sqlParams = {text,text,text,text,text,text};
        try {
            return jdbcTemplate.query("SELECT * FROM autos WHERE LOWER(marca) LIKE LOWER(?) OR LOWER(modello) LIKE LOWER(?) OR " +
                    "LOWER(CAST(cilindrata AS VARCHAR)) LIKE LOWER(?) OR " +
                    "LOWER(CAST(cavalli AS VARCHAR)) LIKE LOWER(?) OR " +
                    "LOWER(CAST(coppia AS VARCHAR)) LIKE LOWER(?) OR " +
                    "LOWER(colore) LIKE LOWER(?) ORDER BY id", new AutoRowMapper(), sqlParams);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void resetTable() {
        jdbcTemplate.update("TRUNCATE TABLE public.autos");
    }

    @Override
    public List<Auto> sortTable(String sortCol, String sort) {
        try {
            return jdbcTemplate.query("SELECT * FROM autos ORDER BY "+sortCol+" "+sort, new AutoRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
