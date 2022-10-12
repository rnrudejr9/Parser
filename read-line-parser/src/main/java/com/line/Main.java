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

        for(Hospital hospital : hospitals){
            System.out.println(hospital.getId());
        }
    }
}
