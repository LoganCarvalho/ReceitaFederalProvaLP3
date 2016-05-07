
package Controller;

import Model.Bean.declaracaoImpostoRenda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastroReceita extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            declaracaoImpostoRenda dir = new declaracaoImpostoRenda();
            
            dir.setNome(request.getParameter("txtNome"));
            dir.setCpf(request.getParameter("txtcpf"));
            dir.setAnoReferencia(Integer.parseInt(request.getParameter("txtAnoReferencia")));
            dir.setValorTotalReceitas(Float.parseFloat(request.getParameter("txtValorTotalReceitas")));
            dir.setValorTotalDespesas(Float.parseFloat(request.getParameter("txtValorTotalDespesas")));
            dir.setValorPagoImpostoAno(Float.parseFloat(request.getParameter("txtValorPagoImpostoAno")));
            
            dir.calcularImposto(dir);
        } catch (Exception ex) {
            Logger.getLogger(CadastroReceita.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
        rd.include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
