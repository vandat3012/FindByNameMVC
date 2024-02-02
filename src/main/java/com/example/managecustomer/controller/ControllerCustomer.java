package com.example.managecustomer.controller;

import com.example.managecustomer.model.Customer;
import com.example.managecustomer.model.service.CustomerService;
import com.example.managecustomer.model.service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllerCustomer", urlPatterns = "/customer")
public class ControllerCustomer extends HttpServlet {
    static ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit" :
                showEditCustomer(req, resp);
                break;
            case "delete" :
                showDeleteCustomer(req, resp);
                break;
            case "view" :
                viewCustomer(req, resp);
                break;
            case "find":
                findCustomer(req, resp);
                break;
            default:
                showAllCustomer(req, resp);
        }
    }

    private static void findCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("searchName");
        List<Customer> customers = customerService.findByName(name);
        RequestDispatcher requestDispatcher;
        if (customers == null ){
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("customer",customers);
            requestDispatcher = req.getRequestDispatcher("list.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void viewCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("customer",customer);
            requestDispatcher = req.getRequestDispatcher("view.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showDeleteCustomer(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("customer",customer);
            requestDispatcher = req.getRequestDispatcher("delete.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showEditCustomer(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("customer",customer);
            requestDispatcher = req.getRequestDispatcher("edit.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createcustomer.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showAllCustomer(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        List<Customer> c = customerService.findAll();
        req.setAttribute("customer", c);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                createNewCustomer(req, resp);
                break;
            case "edit" :
                editInformationCustomer(req, resp);
                break;
            case "delete" :
                deleteCustomer(req, resp);
                break;
        }
    }

    private static void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            customerService.removeById(id);
        }
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void editInformationCustomer(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            customerService.updateById(id,customer);
            req.setAttribute("customer",customer);
            req.setAttribute("message","Customer information was updated");
            requestDispatcher = req.getRequestDispatcher("edit.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNewCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

