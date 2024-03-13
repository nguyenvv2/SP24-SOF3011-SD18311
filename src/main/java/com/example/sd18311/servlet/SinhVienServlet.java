package com.example.sd18311.servlet;

import com.example.sd18311.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet",
        value = {"/sinh-vien/trang-chu",
                "/sinh-vien/add",
        })
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienServlet() {
        SinhVien sinhVien = new SinhVien("Ph12345", "Nguyen Thi C", 20, "HCM");
        listSinhVien.add(sinhVien);
        listSinhVien.add(new SinhVien("123", "Nguyen Thi A", 21, "HN"));
        listSinhVien.add(new SinhVien("113", "Nguyen Van A", 21, "HN"));

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSinhVien", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maSinhVien");
        String ten = request.getParameter("tenSinhVien");
        String diaChi = request.getParameter("diaChi");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        SinhVien sinhVien = new SinhVien(ma, ten, tuoi, diaChi);
        listSinhVien.add(sinhVien);
        response.sendRedirect("/sinh-vien/trang-chu");
    }
}
