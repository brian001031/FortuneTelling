package com.example.user.fortunesticks;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Csv_Read {

    int selectNum ,indexVer;
    Context ctx;
    InputStream is;

    public Csv_Read(int indexVer , int iNumber , Context ctx)
    {
        this.selectNum = iNumber;
        this.indexVer = indexVer;
        this.ctx = ctx;
        if(this.indexVer == 1 || this.indexVer == 2) //button type or text type
            is = this.ctx.getResources().openRawResource(R.raw.ask1);
        else// select number
            is = this.ctx.getResources().openRawResource(R.raw.ask2);
    }

    public List<String[]> ReadCSVData()
    {
        InputStreamReader isread = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        List<String[]> list = new ArrayList<String[]>();

        //從第一筆開始搜尋
        int icount = 0;
        try {
            String csvLine;
            String sSelect = String.valueOf(selectNum);
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                if(this.indexVer == 1 || this.indexVer == 2){
                    for(int cul = 0 ; cul < row.length;cul++)
                    {
                        if(cul == 0 && row[cul].equals(sSelect))
                        {
                            list.add(row);
                            return list;
                        }
                        else
                            continue;
                    }
                }else{
                    String s1 = row[2].toString() ,s2 = row[3].toString(), s3 = row[4].toString();
                    String all = s1+s2+s3;
                    //if(all == sSelect)
                    if(all.contentEquals(sSelect))
                    {
                        list.add(row);
                        return list;
                    }
                }
                icount++;
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try{
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return list;
    }
}
