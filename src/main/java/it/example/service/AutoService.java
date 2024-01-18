package it.example.service;

import it.example.model.Auto;
import java.util.List;

public interface AutoService {

    List<Auto> loadAutos();
    void saveAuto(Auto auto);
    Auto getAutoById(int id);
    void deleteAuto(int id);
    List<Auto> searchAuto(String text);

    void resetTable();
}
