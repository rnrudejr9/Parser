package com.line;


import com.line.database.DBLoader;
import com.line.database.NUserDAO;
import com.line.database.UserDAO;
import com.line.domain.Hospital;
import com.line.domain.User;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws IOException {

//        LineReader<Hospital> lr = new LineReader<>(new HospitalParser());
//        String filename = "C:\\Users\\KOO\\git\\CodeLion-Git\\서울시 병의원 위치 정보.csv";
//        List<Hospital> hospitals = lr.readLines(filename);
//        //lr.readLines 로 csv 파일 내 정보를 hospitals 객체에 정보들을 저장
//
//        SQLWriter<Hospital> sw = new SQLWriter<>(new HospitalParser());
//        sw.sqlWrite("hospital.sql",hospitals);
        //sw write 메소드로 hospital list 에 있는 정보들을 hospital.sql 파일에 쓰기


        UserDAO dao = new UserDAO();
        try {
            dao.add(new User("hello","k","pw"));
            dao.add(new User("2","k","pw"));
            dao.add(new User("3","k","pw"));
            dao.select("hello");
            dao.delete(new User());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
