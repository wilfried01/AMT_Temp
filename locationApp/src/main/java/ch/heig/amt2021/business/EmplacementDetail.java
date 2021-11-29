package ch.heig.amt2021.business;

import ch.heig.amt2021.model.Emplacement;
import ch.heig.amt2021.model.Station;
import ch.heig.amt2021.model.Vehicule;

import java.util.List;

public class EmplacementDetail {

    String adresse;
    int numero;
    boolean libre = true;
    Vehicule vehicule;

    public EmplacementDetail(List<Station> stations, List<Emplacement> emplacements, List<Vehicule> vehicules) {



    }
}
