package proclass;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.Ostermiller.util.ExcelCSVParser;

public class CSVreader {
public int readcsvstudent(String strfile,String id[],String name[],String lastname[]) throws FileNotFoundException, IOException{
	String[][]value=null;
	int cl=0;
	FileInputStream fs= new FileInputStream(strfile);
	DataInputStream in= new DataInputStream(fs);
	BufferedReader br= new BufferedReader(new InputStreamReader(in));
	String strL;
	while((strL=br.readLine())!=null)
	{
		value=(String[][]) ExcelCSVParser.parse(new StringReader(strL));
		id[cl]=value[0][0];
		name[cl]=value[0][1];
		lastname[cl]=value[0][2];
		cl=cl+1;
	}
	return cl;
}
public int readcsvsubject(String strfile,String idsubject[],String namesubject[]) throws FileNotFoundException, IOException{
	String[][]value=null;
	int cl=0;
	FileInputStream fs= new FileInputStream(strfile);
	DataInputStream in= new DataInputStream(fs);
	BufferedReader br= new BufferedReader(new InputStreamReader(in));
	String strL;
	while((strL=br.readLine())!=null)
	{
		value=(String[][]) ExcelCSVParser.parse(new StringReader(strL));
		idsubject[cl]=value[0][0];
		namesubject[cl]=value[0][1];
		cl=cl+1;
	}
	return cl;
}
}
