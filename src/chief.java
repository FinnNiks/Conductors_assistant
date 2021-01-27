import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class chief {
	static int row;
	static String[] M = new String[5];
	static ArrayList<String> catnamesList = new ArrayList<String>();
	static Scanner scn;
	static FileWriter f;
    static String [] mas = {};
    static Vector<String> v;
    public static void main(String[] args) throws Exception {
		openFile();
		
		out();
		filewrite();
		Secondary r = new Secondary();
		r.f1.setLayout(new GridLayout(4, 0, 0, 3));
		r.f1.setSize(250, 400);
		r.f1.setVisible(true);
		r.f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		r.f1.setResizable(false);
		r.f1.setLocationRelativeTo(null);
		r.f2.setLayout(new GridLayout(3, 0, 0, 3));
		r.f2.setSize(300, 200);
		r.f2.setVisible(false);
		r.f2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		r.f2.setResizable(false);
		r.f2.setLocationRelativeTo(null);
		r.f3.setLayout(new GridLayout(5, 0, 0, 3));
		r.f3.setSize(250, 250);
		r.f3.setVisible(false);
		r.f3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		r.f3.setResizable(false);
		r.f3.setLocationRelativeTo(null);
		r.f4.setLayout(new GridLayout(5, 0, 0, 3));
		r.f4.setSize(250, 250);
		r.f4.setVisible(false);
		r.f4.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		r.f4.setResizable(false);
		r.f4.setLocationRelativeTo(null);

	}

	private static void filewrite() throws Exception {
		try {
			f = new FileWriter("res//final.txt", true);

		} catch (Exception i) {
			JOptionPane.showMessageDialog(null,
					"Файл не найден или другая ошибка");
		}
	}

	static String catname;

	private static void out() {
		for (String tmp : catnamesList) {
			System.out.print(tmp + " ");
		}
	}

	public static Vector<String> getListData(){
        String str="";
        while(scn.hasNext()){
        str = scn.nextLine();
        } scn.close();
        v = new Vector<String>();
        String [] arr = str.split(" ");
 
        for(int i = 0; i < arr.length; i+=2){
            v.add(arr[i] + " " + arr[i+1]);
        }
 
        return v;
		
			
			
			
		
	     
		
		
	}

	private static void openFile() {
		try {
			scn = new Scanner(new File("res//final.txt"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Файл не найден или другая ошибка");
		}

	}

}