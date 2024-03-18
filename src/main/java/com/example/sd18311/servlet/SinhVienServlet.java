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
                "/sinh-vien/detail",
                "/sinh-vien/update",
                "/sinh-vien/delete",

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
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/sinh-vien/trang-chu")) {
            request.setAttribute("listSinhVien", listSinhVien);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        } else if (uri.equals("/sinh-vien/detail")) {
            String ma = request.getParameter("maSinhVien");
            SinhVien sinhVienDetail = new SinhVien();
            for (SinhVien sinhVien : listSinhVien) {
                if (sinhVien.getMaSv().equals(ma)) {
                    sinhVienDetail = sinhVien;
                }
            }
            request.setAttribute("sinhVienDetail", sinhVienDetail);
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
        } else if (uri.contains("/sinh-vien/delete")) {
            String ma = request.getParameter("maSinhVien");
            for (SinhVien sinhVien : listSinhVien) {
                if (sinhVien.getMaSv().equals(ma)) {
                    listSinhVien.remove(sinhVien);
                    break;
                }
            }
            response.sendRedirect("/sinh-vien/trang-chu");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sinh-vien/add")) {
            String ma = request.getParameter("maSinhVien");
            String ten = request.getParameter("tenSinhVien");
            String diaChi = request.getParameter("diaChi");
            Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
            SinhVien sinhVien = new SinhVien(ma, ten, tuoi, diaChi);
            listSinhVien.add(sinhVien);
            response.sendRedirect("/sinh-vien/trang-chu");
        } else if (uri.equals("/sinh-vien/update")) {
            // thuc hien update
            String ma = request.getParameter("maSinhVien");
            String ten = request.getParameter("tenSinhVien");
            String diaChi = request.getParameter("diaChi");
            Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
            for (SinhVien sinhVien : listSinhVien) {
                if (sinhVien.getMaSv().equals(ma)) {
                    sinhVien.setTenSv(ten);
                    sinhVien.setTuoi(tuoi);
                    sinhVien.setDiaChi(diaChi);
                }
            }
            response.sendRedirect("/sinh-vien/trang-chu");
        }
    }
}
