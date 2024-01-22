package it.example.model;

import java.util.Objects;
//Entity Object, Domain Object, Business Object che mappa attraverso il Mapper i campi del db in sé
public class Auto {

    private int id;
    private String marca;
    private String modello;
    private Double cilindrata;
    private Double cavalli;
    private Double coppia;
    private String colore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Double cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Double getCavalli() {
        return cavalli;
    }

    public void setCavalli(Double cavalli) {
        this.cavalli = cavalli;
    }

    public Double getCoppia() {
        return coppia;
    }

    public void setCoppia(Double coppia) {
        this.coppia = coppia;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id == auto.id && cilindrata == auto.cilindrata && cavalli == auto.cavalli && coppia == auto.coppia && Objects.equals(marca, auto.marca) && Objects.equals(modello, auto.modello) && Objects.equals(colore, auto.colore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modello, cilindrata, cavalli, coppia, colore);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cilindrata=" + cilindrata +
                "cc, cavalli=" + cavalli +
                "cv, coppia=" + coppia +
                "Nm, colore='" + colore + '\'' +
                "}\n";
    }
}


