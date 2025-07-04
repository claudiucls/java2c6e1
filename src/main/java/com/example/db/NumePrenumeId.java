package com.example.db;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
//clasa care are coloanele ce vor constitui cheia compusa

/* Reguli pentru o cheie compusa:
        - sa suprascrie equals si hashCode
        - sa implementeze Serializable
 */
public class NumePrenumeId implements Serializable {

    private String nume;

    private String prenume;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NumePrenumeId that = (NumePrenumeId) o;
        return Objects.equals(nume, that.nume) && Objects.equals(prenume, that.prenume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume);
    }
}
