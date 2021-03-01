package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jm = "";
        String zp = "";
        int poc = 0;
        int pcet = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("chat"));
            String next = br.readLine();
            while (next != null) {
                zp += next + "\n";
                next = br.readLine();
                pcet++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Něco se nepovedlo");
        }
        String konec;
        System.out.println("Zadej jméno:");
        jm = sc.nextLine();
        System.out.println("########################");

        if (pcet == 0)
            System.out.println(jm + " nemáš žádné zprávy");
        if (pcet >= 1) {
            System.out.println(jm + " máš " + pcet + " zpráv:");
        }
        System.out.println(zp);
        System.out.println("#########################");
        System.out.println("Zadej zprávu:");
        System.out.println("#########################");
        while (poc == 0) {
            konec = sc.nextLine();
            if (konec.equals("!konec")) {
                break;
            }
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("chat", true));
                bw.write(jm + ": " + konec);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                System.out.println("Bohužel se nepovedlo vaši zprávu nahrát.");
            }
        }
    }
}

