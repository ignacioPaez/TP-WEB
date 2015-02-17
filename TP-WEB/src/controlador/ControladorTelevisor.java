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
import modelo.Televisor;
import dao.LavarropaDao;
import dao.TelevisorDao;


public class ControladorTelevisor extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/televisor.jsp";
    private static String LIST_ELE = "/listElectrodomestico.jsp";
    private TelevisorDao dao;
    private LavarropaDao daoLava;
    ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();

    public ControladorTelevisor() {
        super();
        dao = new TelevisorDao();
        daoLava = new LavarropaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int idElectrodomestico = Integer.parseInt(request.getParameter("idElectrodomestico"));
            Televisor tele = dao.GetTelevisorPorId(idElectrodomestico);
            dao.eliminarLavarropa(tele);
            forward = LIST_ELE;
            electrodomesticos.addAll(daoLava.buscarLavarropa());
            electrodomesticos.addAll(dao.buscarTelevisor());
            request.setAttribute("electrodomesticos", electrodomesticos);    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int idElectrodomestico = Integer.parseInt(request.getParameter("idElectrodomestico"));
            Televisor tele = dao.GetTelevisorPorId(idElectrodomestico);
            request.setAttribute("lavarropa", tele);
        } else if (action.equalsIgnoreCase("listElectrodomestico")){
            forward = LIST_ELE;
            electrodomesticos.addAll(daoLava.buscarLavarropa());
            electrodomesticos.addAll(dao.buscarTelevisor());
            request.setAttribute("electrodomesticos", electrodomesticos);
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Televisor tele = new Televisor();
        tele.setPeso(Double.parseDouble(request.getParameter("peso")));
        tele.setPrecioBase(Double.parseDouble(request.getParameter("precioBase")));
        /*try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        Color color = new Color();
        color.setColor(request.getParameter("color"));
        tele.setColor(color);
        ConsumoEnergetico con = new ConsumoEnergetico();
        String cons = request.getParameter("consumo");
        char consumo = cons.charAt(0);
        con.setConsumoEner(consumo);
        tele.setConsumoEnergetico(con);
        tele.setResolucion(Double.parseDouble(request.getParameter("resolucion")));
        tele.setSintonizador(Boolean.parseBoolean(request.getParameter("sintonizador")));
        String idElectrodomestico = request.getParameter("idElectrodomestico");
        if(idElectrodomestico == null || idElectrodomestico.isEmpty())
        {
            dao.registrarTelevisor(tele);;
        }
        else
        {
            //user.setUserid(Integer.parseInt(userid));
            tele.setIdElectrodomestico(Integer.parseInt(idElectrodomestico));
            //dao.updateUser(user);
            dao.modificarTelevisor(tele);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_ELE);
        electrodomesticos.addAll(daoLava.buscarLavarropa());
        electrodomesticos.addAll(dao.buscarTelevisor());
        request.setAttribute("electrodomesticos", electrodomesticos);
        view.forward(request, response);
    }
    
}
