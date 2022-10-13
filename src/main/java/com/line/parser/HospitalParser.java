package com.line.parser;

import com.line.domain.Hospital;

import java.util.Iterator;

public class HospitalParser implements Parser<Hospital>{

    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        int temp = 0;
        if(splitted[6] != null){
            temp = Integer.parseInt(splitted[6].replace("\"",""));
        }
        return new Hospital(splitted[0]
        ,splitted[1]
        ,setDistrict(splitted[1])
        ,splitted[4]
        ,temp
        ,splitted[10]
        ,setSubdivision(splitted[3])
        );
    }

    private String setSubdivision(String s){
        String[] subdivisionList = new String[]{
                "치과", "성형외과", "한방병원", "한의원", "영상의학과", "이비인후과", "소아청소년과", "내과", "정형외과", "외과",
                "가정의학과","피부과", "안과", "소아과", "요양병원", "비뇨기과", "정신건강의학과", "산부인과", "재활의학과",
                "정신과", "마취통증의학과"};
        for(String str : subdivisionList){
            if(s.contains(str)){
                s = str;
            }
        }
        return s;
    }

    public String setDistrict(String s){
        String[] temp = s.split(" ");
        String result = temp[0]+ " "+ temp[1];
        return result;
    }
    @Override
    public String parseToString(Hospital obj) {
        String sb = null;
        String info = null;

        info = obj.getId() + ","+obj.getAdress()+","+obj.getDistrict() + "," + obj.getCategory()+","+obj.getEmergencyRoom()+","+obj.getName()+","+obj.getSubdivision();
        sb = "values(" + info + ")";

        return sb;
    }

}
