package com.line;


import com.line.domain.Hospital;
import com.line.parser.Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SQLWriter<T> {
    Parser<T> parser;
    private String databasename = "";
    private String tablename = "";
    public SQLWriter(Parser<T> parser) {
        this.parser = parser;
    }

    public void sqlWrite(String filename, List<T> list){

        try{
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
            for(int i = 0 ; i<list.size();i++) {
                writer.write("insert into '" + databasename + "'.'"+tablename + "'('");
                writer.write("hello");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
