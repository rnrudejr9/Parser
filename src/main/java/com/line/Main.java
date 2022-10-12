package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> lr = new LineReader<>(new HospitalParser());
        String filename = "C:\\Users\\KOO\\git\\CodeLion-Git\\서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = lr.readLines(filename);
        System.out.println(hospitals.size());


        //hospitals 객체에 내용들이 저장되어 있으므로, 이 내용들을 db에 올리면 됨
        //csv 파일 꺠질 시 메모장으로 열고 utf-8 설정한 후에 다른이름으로 저장해서 불러오기

    }
}
