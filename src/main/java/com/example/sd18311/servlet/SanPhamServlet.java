package com.example.sd18311.servlet;

import com.example.sd18311.model.SanPham;
import com.example.sd18311.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi"
})
public class SanPhamServlet extends HttpServlet {
    ArrayList<SanPham> list = new ArrayList<>();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/hien-thi")) {
            list = sanPhamRepository.getList();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/san-pham/trang-chu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
