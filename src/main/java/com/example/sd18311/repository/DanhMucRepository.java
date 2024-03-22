package com.example.sd18311.repository;

import com.example.sd18311.connect.HibernateUtils;
import com.example.sd18311.model.DanhMuc;
import org.hibernate.Session;

import java.util.ArrayList;

public class DanhMucRepository {

    public ArrayList<DanhMuc> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        //1. Entity DanhMuc
        //2. table danh_muc
        ArrayList<DanhMuc> list =
                (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc").list();
        session.close();
        return list;
    }

    public static void main(String[] args) {
        ArrayList<DanhMuc> list = new DanhMucRepository().getList();
        for (DanhMuc danhMuc : list) {
            System.out.println(danhMuc.toString());
        }
    }
}
