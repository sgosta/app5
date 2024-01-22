package it.example.dao;

import it.example.model.Auto;
import java.util.List;

public interface AutoDAO {

    List<Auto> loadAutos();
    void saveAuto(Auto auto);
    Auto getAutoById(int id);
    void deleteAuto(int id);
    List<Auto> searchAuto(String text);
    void resetTable();
    List<Auto> sortTable(String sortCol, String sort);
}
