package com.example.sd18311.repository;

import com.example.sd18311.connect.HibernateUtils;
import com.example.sd18311.model.DanhMuc;
import com.example.sd18311.model.SanPham;
import org.hibernate.Session;

import java.util.ArrayList;

public class SanPhamRepository {
    public ArrayList<SanPham> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();

        ArrayList<SanPham> list =
                (ArrayList<SanPham>) session.createQuery("FROM SanPham order by ngayTao asc ").list();
        session.close();
        return list;
    }
}
