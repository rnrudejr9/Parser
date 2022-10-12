package com.line.parser;

import com.line.domain.Hospital;

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
        ,splitted[2]
        ,splitted[4]
        ,temp
        ,splitted[10]
        ,splitted[12]
        );
    }
}
