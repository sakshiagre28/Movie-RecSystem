import java.io.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class CsvReader {
    static String list="";
    static void reader1(String input,JTextArea txta)
    {   txta.setText("");
        try
        { 
            String splitby=",";
            String file="C:\\Users\\pc\\Documents\\NetBeansProjects\\RecSys\\csvfile\\movies.csv";
            BufferedReader br=new BufferedReader(new FileReader(file));
            String current=null,temp=null;
            int status=0;
            while((current=br.readLine())!=null)
            {
                String[] indexing=current.split(splitby);
                //System.out.println(indexing[0]+" "+indexing[1]+" "+indexing[2]);
                if(input.equals(indexing[1]))
                {
                    //System.out.println("hello");
                    temp = indexing[2];
                    //System.out.println(temp);
                    status=1;
                }
            }
            br=new BufferedReader(new FileReader(file));
            txta.setText("");
            if(status==1){
                while((current=br.readLine())!=null)
                {
                    String[] indexing=current.split(splitby);
                    //System.out.println(indexing[0]+" "+indexing[1]+" "+indexing[2]);
                    
                    if(temp.equals(indexing[2]))
                    {    //System.out.println(indexing[2]);
                        //bl.setText(indexing[1]);
                        if(!indexing[1].equals(input)&&!indexing[1].equalsIgnoreCase(null))
                        {
                            list=list+indexing[1]+"\n";
                        } else {
                        }
                    }
                }
                System.out.println(list+"\n");
                txta.setText(list);
                           
                
            }
            br.close();
        }
        catch(FileNotFoundException e){}
        catch(IOException ie){}
        list="";
    }
}
