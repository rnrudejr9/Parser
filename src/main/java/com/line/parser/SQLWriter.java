package com.line.parser;


import com.line.domain.Hospital;
import com.line.parser.Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SQLWriter<T> {
    Parser<T> parser;
    private String databasename = "likelion-db";
    private String tablename = "Hospital-table";
    public SQLWriter(Parser<T> parser) {
        this.parser = parser;
    }

    public void sqlWrite(String filename, List<T> list){

        try{
            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }else{
                file.delete();
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
            for(int i = 0 ; i<list.size();i++) {
                writer.write("insert into `" + databasename + "`.`"+tablename + "`\n");
                writer.write("(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n");
                writer.write(parser.parseToString(list.get(i)) + ";\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
