package it.example.dao;

import it.example.model.Auto;
import java.util.List;

public interface AutoDAO {

    List<Auto> loadAutos();
    void saveAuto(Auto auto);
    Auto getAutoById(int id);
    void deleteAuto(int id);

}