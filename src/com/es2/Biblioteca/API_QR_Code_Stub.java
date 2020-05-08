package com.es2.Biblioteca;

import java.util.ArrayList;

public class API_QR_Code_Stub {
    private static int qr_code_count = 0;
    private static ArrayList<String> qr_codes = new ArrayList();
    private String path="https://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=";
    private int id;


    public API_QR_Code_Stub() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        //path: id_qrcode, id_livro, nome, autor, biblioteca
        //informacao dividida por ";"
        this.id=qr_codes.size()+1;
        this.path= "https://chart.apis.google.com/chart?cht=qr&chs=300x300&chl="+ this.id+";"+ path;
        qr_code_count++;
        qr_codes.add(this.path);
    }

    public static int getQr_code_count() {
        return qr_code_count;
    }

    public static void setQr_code_count(int qr_code_count) {
        API_QR_Code_Stub.qr_code_count = qr_code_count;
    }

    public static ArrayList<String> getQr_codes() {
        return qr_codes;
    }

    public static void setQr_codes(ArrayList<String> qr_codes) {
        API_QR_Code_Stub.qr_codes = qr_codes;
    }
}
