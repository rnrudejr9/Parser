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
        ,splitted[12]
        );
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
