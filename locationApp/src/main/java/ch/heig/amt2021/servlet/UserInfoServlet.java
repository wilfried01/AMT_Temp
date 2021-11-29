package ch.heig.amt2021.servlet;

import ch.heig.amt2021.bean.UserAccount;
import ch.heig.amt2021.integration.*;
import ch.heig.amt2021.utils.AppUtils;
import ch.heig.amt2021.model.*;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private StationDAOLocal stationDAO;
    @Inject
    private EmplacementDAOLocal emplacementDAO;
    @Inject
    private ClientDAOLocal clientDAO;
    @Inject
    private TrajetDAOLocal trajetDAO;
    @Inject
    private VehiculeDAOLocal vehiculeDAO;

    public UserInfoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserAccount usr = AppUtils.getLoginedUser(request.getSession());
        request.setAttribute("usr",usr);

        List<Station> stations = stationDAO.getStations();
        request.setAttribute("stations", stations);

        List<Emplacement> emplacements = emplacementDAO.getEmplacements();
        request.setAttribute("emplacements", emplacements);



        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
