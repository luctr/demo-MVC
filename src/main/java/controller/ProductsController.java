package controller;

import model.Products;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "productsController",
        value = "/products"
)
public class ProductsController extends HttpServlet {
    private ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "create":
                create(req, resp);
                break;
            default:
                showAllProducts(req, resp);
        }
        showAllProducts(req, resp);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/edit.jsp");
        int index = Integer.parseInt(req.getParameter("id"));
        Products products = productServiceImpl.findById(index);
        req.setAttribute("product", products);
        dispatcher.forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/list.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        productServiceImpl.delete(id);
        req.setAttribute("dssp", productServiceImpl.findAll());
        req.setAttribute("message", "Xoa Thanh Cong");
        dispatcher.forward(req, resp);
    }

    private void showAllProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/list.jsp");
        List<Products> productsList = productServiceImpl.findAll();
        req.setAttribute("dssp", productsList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showFormEdit(req, resp);
                break;
            case "create":
                create(req, resp);
            case "delete":
                delete(req, resp);
            default:
                showAllProducts(req, resp);
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/list.jsp");
        int index = productServiceImpl.findAll().size() + 1;
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        Products products = new Products(index, name, price);
        productServiceImpl.add(products);
        req.setAttribute("message", "Thêm Thành Công");
        List<Products> productsList = productServiceImpl.findAll();
        req.setAttribute("dssp", productsList);
        dispatcher.forward(req, resp);
    }
}