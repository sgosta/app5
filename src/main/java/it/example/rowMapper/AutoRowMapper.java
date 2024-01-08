package it.example.rowMapper;

import it.example.model.Auto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoRowMapper implements RowMapper<Auto> {

    @Override
    public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Auto auto = new Auto();

        auto.setId(rs.getInt("id"));
        auto.setMarca(rs.getString("marca"));
        auto.setModello(rs.getString("modello"));
        auto.setCilindrata(rs.getDouble("cilindrata"));
        auto.setCavalli(rs.getDouble("cavalli"));
        auto.setCoppia(rs.getDouble("coppia"));
        auto.setColore(rs.getString("colore"));

        return auto;
    }
}
