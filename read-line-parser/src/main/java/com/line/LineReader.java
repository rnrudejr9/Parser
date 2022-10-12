package com.line;

import com.line.domain.Patient;
import com.line.parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {
    Parser<T> paser;
    boolean isRemoveColName = true;
    public LineReader(Parser<T> paser) {
        this.paser = paser;
    }

    List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        if(isRemoveColName == true) {
            br.readLine();
        }
        while((str = br.readLine()) != null){
            result.add(paser.parse(str));
        }
        return result;
    }

    public List<Patient> readAndParse(String filename){
        List<Patient> result = new ArrayList<>();


        return result;
    }
}
