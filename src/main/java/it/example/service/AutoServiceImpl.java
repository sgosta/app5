package it.example.service;

import it.example.dao.AutoDAO;
import it.example.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoServiceImpl implements AutoService{

    @Autowired
    private AutoDAO autoDAO;

    @Override
    public List<Auto> loadAutos() {
        return autoDAO.loadAutos();
    }

    @Override
    public void saveAuto(Auto auto) {
        autoDAO.saveAuto(auto);
    }

    @Override
    public Auto getAutoById(int id) {
        return autoDAO.getAutoById(id);
    }

    @Override
    public void deleteAuto(int id) {
        autoDAO.deleteAuto(id);
    }
}
