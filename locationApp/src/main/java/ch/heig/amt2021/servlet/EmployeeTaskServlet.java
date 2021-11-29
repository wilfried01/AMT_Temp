package ch.heig.amt2021.servlet;

import ch.heig.amt2021.bean.EmplacementUtilisation;
import ch.heig.amt2021.bean.UserAccount;
import ch.heig.amt2021.bean.VehiculeUtilisation;
import ch.heig.amt2021.integration.*;
import ch.heig.amt2021.utils.AppUtils;
import ch.heig.amt2021.utils.DataDAO;
import ch.heig.amt2021.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeTask")
public class EmployeeTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private StationDAOLocal stationDAO;
    @Inject
    private EmplacementDAOLocal emplacementDAO;
    @Inject
    private VehiculeDAOLocal vehiculeDAO;
    @Inject
    private UtilisateurDAOLocal utilisateurDAO;
    @Inject
    private ClientDAOLocal clientDAO;
    @Inject
    private TrajetDAOLocal trajetDAO;

    public EmployeeTaskServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




        List<Vehicule> vehicules = vehiculeDAO.getVehiculeViaID();

        List<Client> clients = clientDAO.getClient();

        List<Trajet> trajets = trajetDAO.getTrajets();

        List<Station> stations = stationDAO.getStations();
        request.setAttribute("stations", stations);

        List<Emplacement> emplacements = emplacementDAO.getEmplacements();


        List<EmplacementUtilisation> emplacementsTotal = DataDAO.GenerationEmplacement(stations,emplacements,vehicules,trajets);
        List<EmplacementUtilisation> emplacementLibres = DataDAO.EmplacementLibre(emplacementsTotal);
        request.setAttribute("emplacementsLibres",emplacementLibres);

        List<VehiculeUtilisation> vehiculesTotal = DataDAO.GenerationVehicule(vehicules,trajets,clients);
        List<VehiculeUtilisation> vehiculeLibre = DataDAO.VehiculeLibre(vehiculesTotal);
        request.setAttribute("vehiculeLibre",vehiculeLibre);

        request.getRequestDispatcher("/WEB-INF/views/employeeTaskView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int numeroStationDepart = Integer.parseInt(request.getParameter("stationDepart"));
        int numeroStationArrive = Integer.parseInt(request.getParameter("stationArrive"));
        int numeroVehicule = Integer.parseInt(request.getParameter("voitureChoisit"));

        List<Vehicule> vehicules = vehiculeDAO.getVehiculeViaID();
        List<Trajet> trajets = trajetDAO.getTrajets();
        List<Station> stations = stationDAO.getStations();
        List<Emplacement> emplacements = emplacementDAO.getEmplacements();

        List<EmplacementUtilisation> emplacementsTotal = DataDAO.GenerationEmplacement(stations,emplacements,vehicules,trajets);
        List<EmplacementUtilisation> emplacementLibres = DataDAO.EmplacementLibre(emplacementsTotal);

        int noEmplacementDepart = DataDAO.idEmplacementLibre(emplacementLibres, numeroStationDepart, 0);
        int noEmplacementArrive = DataDAO.idEmplacementLibre(emplacementLibres, numeroStationArrive, noEmplacementDepart);

        UserAccount user = AppUtils.getLoginedUser(request.getSession());

        List<String> errors = new ArrayList<>();


        if(user.getSolde() <= 0){
            errors.add("Solde insufisant pour reserver un trajet");

        }
        if(user.getTrajetId() != 0){
            errors.add("Trajet déjà en cours");

        }
        if(noEmplacementDepart == 0 || noEmplacementArrive == 0){
            String test;
            if(noEmplacementDepart == 0) {
                errors.add("Pas d'emplacement pour la station de départ");
            }
            else {
                errors.add("Pas d'emplacement pour la station de départ");
            }



        }
        if(errors.size() == 0) {

            int userID = user.getId();

            trajetDAO.addTrajet(numeroVehicule, noEmplacementArrive, numeroStationArrive);

            Trajet trajet = trajetDAO.getTrajetViaVehicule(numeroVehicule);
            Vehicule vehicule = vehiculeDAO.getVehiculeViaID(numeroVehicule);

            String test2 = "Trajet reservé depuis la station: " + stations.get(numeroStationDepart).getAdresse() + " emplacement no " + noEmplacementDepart + " à la station: " + stations.get(numeroStationArrive).getAdresse() +
                    " emplacement no " + noEmplacementArrive + " Avec le vehicule " + vehicules.get(numeroVehicule).getCategorie() + " : "+  vehicules.get(numeroVehicule).getMatricule();
            request.setAttribute("message", test2);

            user.setTrajetId(trajet.getId()); // pour le changement en temps réel
            user.setTrajet(trajet);
            user.setVehicule(vehicule);

            clientDAO.setTrajet(trajet.getId(), user.getId());
            vehiculeDAO.setEmplacement(numeroVehicule, noEmplacementDepart, numeroStationDepart);
        }

        else{
            request.setAttribute("errorMessage12", errors);
        }


        doGet(request, response);
    }

}