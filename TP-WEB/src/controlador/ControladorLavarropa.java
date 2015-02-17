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


public class ControladorLavarropa extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/lavarropa.jsp";
    private static String LIST_ELE = "/listElectrodomestico.jsp";
    private LavarropaDao dao;
    private TelevisorDao daoTele;
    ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();

    public ControladorLavarropa() {
        super();
        dao = new LavarropaDao();
        daoTele = new TelevisorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int idElectrodomestico = Integer.parseInt(request.getParameter("idElectrodomestico"));
            Lavarropa lava = dao.GetLavarropaPorId(idElectrodomestico);
            dao.eliminarLavarropa(lava);
            forward = LIST_ELE;
            electrodomesticos.addAll(dao.buscarLavarropa());
            electrodomesticos.addAll(daoTele.buscarTelevisor());
            request.setAttribute("electrodomesticos", electrodomesticos);    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int IdElectrodomestico = Integer.parseInt(request.getParameter("idElectrodomestico"));
            Lavarropa lava = dao.GetLavarropaPorId(IdElectrodomestico);
            request.setAttribute("lavarropa", lava);
        } else if (action.equalsIgnoreCase("listElectrodomestico")){
            forward = LIST_ELE;
            electrodomesticos.addAll(dao.buscarLavarropa());
            electrodomesticos.addAll(daoTele.buscarTelevisor());
            request.setAttribute("electrodomesticos", electrodomesticos);
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Lavarropa lava = new Lavarropa();
        lava.setPeso(Double.parseDouble(request.getParameter("peso")));
        lava.setPrecioBase(Double.parseDouble(request.getParameter("precioBase")));
        /*try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        Color color = new Color();
        color.setColor(request.getParameter("color"));
        lava.setColor(color);
        ConsumoEnergetico con = new ConsumoEnergetico();
        String cons = request.getParameter("consumo");
        char consumo = cons.charAt(0);
        con.setConsumoEner(consumo);
        lava.setConsumoEnergetico(con);
        lava.setCarga(Double.parseDouble(request.getParameter("carga")));
        String idElectrodomestico = request.getParameter("idElectrodomestico");
        if(idElectrodomestico == null || idElectrodomestico.isEmpty())
        {
            dao.registrarLavarropa(lava);
        }
        else
        {
            //user.setUserid(Integer.parseInt(userid));
            lava.setIdElectrodomestico(Integer.parseInt(idElectrodomestico));
            //dao.updateUser(user);
            dao.modificarLavarropa(lava);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_ELE);
        electrodomesticos.addAll(dao.buscarLavarropa());
        electrodomesticos.addAll(daoTele.buscarTelevisor());
        request.setAttribute("electrodomesticos", electrodomesticos);
        view.forward(request, response);
    }
}