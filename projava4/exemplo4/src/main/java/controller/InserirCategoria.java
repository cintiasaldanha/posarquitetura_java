package controller;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet - Implementação da classe InserirCategoria
 */

 @WebServlet("/InserirCategoria")
 public class InserirCategoria extends HTTPServlet{
     private static final long serialVersionUID = 1L;

     CategoriaDAO dao  = new CategoriaDAO();
     protected void doPost(HttoServletRequest request, HttpServletResponse response) 
                throws ServletEception, IOEception{
            
            String nome = request.getParameter("nome");
            Categoria categoria = new Categoria();
            categoria.setNome(nome);

            String retorno = dao.inserir(categoria);

            if (retorno.equals("sucesso")){
                response.sendRedirect("InserirCategoria");
            } else {
                PrintWriter out = response.getWriter();
                out.print("<html>");
                out.print("<h2> Não foi possível inserir a categoria!</h2>");
                out.print("<br />");
                out.print("<a href = 'index.jsp'>Voltar </a>");
                out.print("</html>");
            }
    }

    protected void doGet(HttpservletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                try{
                    String action = request.getServletPath();
                    listaCategoria(request, response);
                }catch (SQLException ex){
                    throw new ServletException(ex);
                }
    }

    private void listaCategoria(HttpservletRequest request, HttpServletResponse response)
        throws  SQLException,IOException, ServletException{
            List<Categoria> listaCategoria = dao.Listar();
            request.setAttribute("listaCategoria", listaCategoria);
            Resquest.Dispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
    }
 
 }