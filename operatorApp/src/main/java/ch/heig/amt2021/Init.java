package ch.heig.amt2021;

import ch.heig.amt2021.integration.*;
import ch.heig.amt2021.model.*;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;

public class Init {
    public static void main (String ... args) throws NamingException {

        Properties environnement = new Properties();
        environnement.put(INITIAL_CONTEXT_FACTORY, "fish.payara.ejb.rest.client.RemoteEJBContextFactory");
        environnement.put(PROVIDER_URL, "http://localhost:8080/ejb-invoker");

        InitialContext ejbRemoteContext = new InitialContext(environnement);
        /*
            System.out.println("Ajouter les fichiers de scripts");
            InitDAORemote initDAO = (InitDAORemote) ejbRemoteContext.lookup("java:global/locationApp/InitDAO!ch.heig.amt2021.integration.InitDAORemote");

            try {
                initDAO.executeScriptSqlFile("Bonjour");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        */
        StationDAORemote stationDAORemote = (StationDAORemote) ejbRemoteContext.lookup("java:global/locationApp/StationDAO!ch.heig.amt2021.integration.StationDAORemote");
//        EmplacementDAORemote emplacementDAORemote = (EmplacementDAORemote) ejbRemoteContext.lookup("java:global/locationApp/EmplacementDAO!ch.heig.amt2021.integration.EmplacementDAORemote");
//        VehiculeDAORemote vehiculeDAORemote = (VehiculeDAORemote) ejbRemoteContext.lookup("java:global/locationApp/VehiculeDAO!ch.heig.amt2021.integration.VehiculeDAORemote");
//        UtilisateurDAORemote utilisateurDAORemote = (UtilisateurDAORemote) ejbRemoteContext.lookup("java:global/locationApp/UtilisateurDAO!ch.heig.amt2021.integration.UtilisateurDAORemote");
//        TrajetDAORemote trajetDAORemote = (TrajetDAORemote) ejbRemoteContext.lookup("java:global/locationApp/TrajetDAO!ch.heig.amt2021.integration.TrajetDAORemote");
//        ClientDAORemote clientDAORemote = (ClientDAORemote) ejbRemoteContext.lookup("java:global/locationApp/ClientDAO!ch.heig.amt2021.integration.ClientDAORemote");
//        AdministrateurDAORemote administrateurDAORemote = (AdministrateurDAORemote) ejbRemoteContext.lookup("java:global/locationApp/AdministrateurDAO!ch.heig.amt2021.integration.AdministrateurDAORemote");
//        PrixDAORemote prixDAORemote = (PrixDAORemote) ejbRemoteContext.lookup("java:global/locationApp/PriceDAO!ch.heig.amt2021.integration.PriceDAORemote");

        stationDAORemote.create();
//        emplacementDAORemote.create();
//        vehiculeDAORemote.create();
//        utilisateurDAORemote.create();
//        trajetDAORemote.create();
//        clientDAORemote.create();
//        administrateurDAORemote.create();
//        prixDAORemote.create();

        List<String> stationAdresses = Arrays.asList("Rue du lac 6", "Rue du Milieu 18", "Route de lausanne 10", "Rue de l'industrie 14", "Rue d'orbe 51");
        for (String s : stationAdresses) {
            stationDAORemote.add(new Station(s));
        }
/*
        List<Pair<Integer, Integer>> emplacements = Arrays.asList (
                Pair.with(1, 1), Pair.with(2, 1), Pair.with(3, 1), Pair.with(4, 1), Pair.with(5, 1),
                Pair.with(6, 1), Pair.with(7, 1), Pair.with(8, 1), Pair.with(9, 1), Pair.with(10, 1),
                Pair.with(11, 1), Pair.with(12, 1), Pair.with(13, 1), Pair.with(14, 1),  Pair.with(15, 1),
                Pair.with(16, 1), Pair.with(1, 2), Pair.with(2, 2), Pair.with(3, 2), Pair.with(4, 2),
                Pair.with(5, 2), Pair.with(6, 2), Pair.with(7, 2), Pair.with(8, 2), Pair.with(9, 2), Pair.with(10, 2),
                Pair.with(1, 3), Pair.with(2, 3), Pair.with(3, 3), Pair.with(4, 3), Pair.with(5, 3), Pair.with(6, 3),
                Pair.with(7, 3), Pair.with(8, 3), Pair.with(9, 3), Pair.with(10, 3), Pair.with(11, 3), Pair.with(12, 3),
                Pair.with(13, 3), Pair.with(14, 3), Pair.with(15, 3), Pair.with(16, 3), Pair.with(17, 3), Pair.with(18, 3),
                Pair.with(1, 4), Pair.with(2, 4), Pair.with(3, 4), Pair.with(4, 4), Pair.with(5, 4), Pair.with(6, 4),
                Pair.with(7, 4), Pair.with(8, 4), Pair.with(9, 4), Pair.with(10, 4), Pair.with(11, 4), Pair.with(12, 4),
                Pair.with(13, 4), Pair.with(14, 4), Pair.with(1, 5), Pair.with(2, 5), Pair.with(3, 5), Pair.with(4, 5),
                Pair.with(5, 5), Pair.with(6, 5), Pair.with(7, 5), Pair.with(8, 5), Pair.with(9, 5), Pair.with(10, 5),
                Pair.with(11, 5), Pair.with(12, 5), Pair.with(13, 5), Pair.with(14, 5), Pair.with(15, 5), Pair.with(16, 5),
                Pair.with(17, 5), Pair.with(18, 5), Pair.with(19, 5), Pair.with(20, 5));

        for(Pair<Integer, Integer> p : emplacements) {
            emplacementDAORemote.add(new Emplacement(p.getValue0(), p.getValue1()));
        }

        List<Quartet<String, Integer, Integer, String>> vehicles = Arrays.asList(
                Quartet.with("VD 364 263", 1, 1, "MOTO"), Quartet.with("VD 536 245", 2, 1, "BERLINE"),
                Quartet.with("VD 873 422", 3, 1, "BERLINE"), Quartet.with("VD 969 142", 4, 1, "MOTO"),
                Quartet.with("VD 153 758", 5, 1, "FOURGON"), Quartet.with("VD 542 436", 1, 2, "BERLINE"),
                Quartet.with("VD 211 738", 2, 2, "BERLINE"), Quartet.with("VD 532 374", 3, 2, "BERLINE"),
                Quartet.with("VD 645 555", 4, 2, "MOTO"), Quartet.with("VD 786 588", 5, 2, "MOTO"),
                Quartet.with("VD 873 041", 6, 2, "MOTO"), Quartet.with("VD 176 591", 7, 2, "FOURGON"),
                Quartet.with("VD 793 272", 8, 2, "FOURGON"), Quartet.with("VD 635 242", 13, 3, "BERLINE"),
                Quartet.with("VD 436 502", 14, 3, "BERLINE"), Quartet.with("VD 825 332", 15, 3, "MOTO"),
                Quartet.with("VD 645 322", 16, 3, "FOURGON"), Quartet.with("VD 245 153", 17, 3, "FOURGON"),
                Quartet.with("VD 421 482", 18, 3, "FOURGON"), Quartet.with("VD 587 428", 9, 4, "BERLINE"),
                Quartet.with("VD 921 351", 10, 4, "MOTO"), Quartet.with("VD 921 118", 11, 4, "BERLINE"),
                Quartet.with("VD 268 402", 12, 4, "FOURGON"), Quartet.with("VD 008 276", 13, 4, "FOURGON"),
                Quartet.with("VD 241 522", 14, 4, "BERLINE"), Quartet.with("VD 291 853", 6, 5, "BERLINE"),
                Quartet.with("VD 458 635", 12, 5, "FOURGON"), Quartet.with("VD 426 529", 7, 5, "BERLINE"),
                Quartet.with("VD 652 288", 8, 5, "MOTO"), Quartet.with("VD 425 321", 9, 5, "MOTO"),
                Quartet.with("VD 577 929", 10, 5, "FOURGON"), Quartet.with("VD 894 303", 5, 5, "FOURGON"),
                Quartet.with("VD 318 843", 14, 1, "FOURGON"), Quartet.with("VD 894 263", 15, 1, "BERLINE"),
                Quartet.with("VD 436 502", 16, 1, "BERLINE")
        );
        *//*
            for (Quartet<String, Integer, Integer, String> q: vehicles) {
                vehiculeDAORemote.add(new Vehicule(q.getValue0(), q.getValue1(), q.getValue2(), q.getValue3()));
            }
        *//*

        List<Pair<String, String>> utilisateurs = Arrays.asList(
                Pair.with("Warren", "AMT123"),
                Pair.with("Boris", "AMTabc"),
                Pair.with("Jessamine", "AMTABC"),
                Pair.with("Rowan", "AMTAbc"),
                Pair.with("Chava", "AMTaBC")
        );

        for (Pair<String, String> p: utilisateurs) {
            utilisateurDAORemote.add(new Utilisateur(p.getValue0(), p.getValue1()));
        }

        List<Sextet<Integer, Integer, Integer, Integer, Integer, Float>> trajets = Arrays.asList(
                Sextet.with(1, 1, 1, 5, 0, 0.0F),
                Sextet.with(2, 12, 7, 2, 0, 0.0F),
                Sextet.with(3, 6, 7, 4, 154, 79.80F)
        );

        for(Sextet<Integer, Integer, Integer, Integer, Integer, Float> s: trajets) {
            trajetDAORemote.add(new Trajet(s.getValue0(), s.getValue1(), s.getValue2(), s.getValue3(), s.getValue4(), s.getValue5()));
        }

        List<Triplet<Integer, Integer, Float>> clients = Arrays.asList(
                Triplet.with(2, 2, 0.0F),
                Triplet.with(3, 1, 25.0F),
                Triplet.with(5, 3, 8.80F)
        );

        for(Triplet<Integer, Integer, Float> t: clients) {
            clientDAORemote.add(new Client(t.getValue0(), t.getValue1(), t.getValue2()));
        }

        List<Integer> administrateurs = Arrays.asList(1, 4);
        for (Integer i : administrateurs) {
            administrateurDAORemote.add(new Administrateur(i));
        }

        List<Quartet<String, Float, Float, Float>> prices = Arrays.asList(
                Quartet.with("BERLINE", 2.95F, 2.60F, 2.30F),
                Quartet.with("MOTO", 1.70F, 1.50F, 1.50F),
                Quartet.with("FOURGON", 3.60F, 3.00F, 2.80F)
        );

        for(Quartet<String, Float, Float, Float> q: prices) {
            prixDAORemote.add(new Prix(q.getValue0(), q.getValue1(), q.getValue2(), q.getValue3()));
        }*/
    }
}
