package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Color;
import modelo.ConsumoEnergetico;
import modelo.Electrodomestico;
import modelo.Lavarropa;
import dao.LavarropaDao;
import dao.TelevisorDao;


public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private static String INSERT_OR_EDIT = "/lavarropa.jsp";
    private static String LIST_ELE = "/listElectrodomestico.jsp";
	private LavarropaDao lavaDao;
	private TelevisorDao teleDao;
	ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();

    public Controlador() {
        super();
        lavaDao = new LavarropaDao();
        teleDao = new TelevisorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        /*if (action.equalsIgnoreCase("delete")){
            int idElectrodomestico = Integer.parseInt(request.getParameter("idElectrodomestico"));
            Lavarropa lava = dao.GetLavarropaPorId(idElectrodomestico);
            dao.eliminarLavarropa(lava);
            forward = LIST_ELE;
            request.setAttribute("electrodomesticos", dao.buscarLavarropa());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int IdElectrodomestico = Integer.parseInt(request.getParameter("idElectrodomestico"));
            Lavarropa lava = dao.GetLavarropaPorId(IdElectrodomestico);
            request.setAttribute("lavarropa", lava);
        } else if (action.equalsIgnoreCase("listElectrodomestico")){
            forward = LIST_ELE;
            request.setAttribute("electrodomesticos", lavaDao.buscarLavarropa());
            request.setAttribute("electrodomesticos", teleDao.buscarTelevisor());
        } else {
            forward = INSERT_OR_EDIT;
        }*/
        
        if (action.equalsIgnoreCase("listElectrodomestico")){
            forward = LIST_ELE;
            electrodomesticos.addAll(lavaDao.buscarLavarropa());
            electrodomesticos.addAll(teleDao.buscarTelevisor());
            request.setAttribute("electrodomesticos", electrodomesticos);
            request.setAttribute("electrodomesticos", electrodomesticos);
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
}
