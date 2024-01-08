package it.example.dao;

import it.example.model.Auto;
import it.example.rowMapper.AutoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
}
