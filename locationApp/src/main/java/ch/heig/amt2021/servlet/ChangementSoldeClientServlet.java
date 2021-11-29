package ch.heig.amt2021.servlet;

import ch.heig.amt2021.bean.UserAccount;
import ch.heig.amt2021.integration.*;
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

@WebServlet("/changementSoldeClient")
public class ChangementSoldeClientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private UtilisateurDAOLocal utilisateurDAO;
    @Inject
    private ClientDAOLocal clientDAO;
    @Inject
    private AdministateurDAOLocal administrateurDAO;
    @Inject
    private VehiculeDAOLocal vehiculeDAO;
    @Inject
    private TrajetDAOLocal trajetDAO;


    public ChangementSoldeClientServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ch.heig.amt2021.model.Utilisateur> utilisateurs = utilisateurDAO.getUtilisateurs();
        List<Client> clients = clientDAO.getClient();
        List<Administrateur> administrateurs = administrateurDAO.getAdmin();
        List<Trajet> trajets = trajetDAO.getTrajets();
        List<Vehicule> vehicules = vehiculeDAO.getVehiculeViaID();

        List<UserAccount> listUser = DataDAO.listUtilisateursDetail(utilisateurs,clients,administrateurs,trajets,vehicules);
        List<UserAccount> listClient = DataDAO.listClient(listUser, clients);

        request.setAttribute("listUser", listClient);

        request.getRequestDispatcher("/WEB-INF/views/changementSoldeClientView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Utilisateur> utilisateurs = utilisateurDAO.getUtilisateurs();
        List<Client> clients = clientDAO.getClient();
        List<Administrateur> administrateurs = administrateurDAO.getAdmin();
        List<Trajet> trajets = trajetDAO.getTrajets();
        List<Vehicule> vehicules = vehiculeDAO.getVehiculeViaID();

        List<UserAccount> listUser = DataDAO.listUtilisateursDetail(utilisateurs,clients,administrateurs,trajets,vehicules);
        List<UserAccount> listClient = DataDAO.listClient(listUser, clients);

        int utilisateur_idNewSolde = Integer.parseInt(request.getParameter("clientNum"));
        String newSolde = request.getParameter("solde");

        float solde = 0;

        UserAccount utilisateurChangeSolde = DataDAO.getUserViaId(listUser, utilisateur_idNewSolde);

        List<String> errors = new ArrayList<>();

        if(newSolde == null || newSolde.trim().equals("")){
            errors.add("Le nouveau solde doit être renseigné");
        }
        else{
            try {
                solde = Float.parseFloat(newSolde);
            } catch (NumberFormatException e ){
                errors.add("Les kilometres doivent être numérique");
            }
        }

        if(errors.size() == 0) {

            clientDAO.setSolde(solde, utilisateurChangeSolde.getId());

            errors.add( "Le client numéro " +  utilisateur_idNewSolde + " avec le login " + utilisateurChangeSolde.getUserName()
                    + " nouveau solde " + solde);
        }

        request.setAttribute("errors", errors);

        doGet(request, response);
    }
}
