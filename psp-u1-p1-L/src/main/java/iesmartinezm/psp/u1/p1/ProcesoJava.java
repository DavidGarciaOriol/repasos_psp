/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.u1.p1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class ProcesoJava {

    public static Process exec(Class clase) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = clase.getCanonicalName();

        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);
        return builder.start();
    }

    public static Process exec(Class clase, String[] args) throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = clase.getCanonicalName();

        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

        for (String arg : args) {
            builder.command().add(arg);
        }

        return builder.start();
    }

    public static Process execCMD(String cmd, String[] args) throws IOException {

        ArrayList<String> comandos = new ArrayList<String>();

        comandos.add("cmd");
        comandos.add("/C");
        comandos.add(cmd);
        for (String arg : args) {
            comandos.add(arg);
        }
        ProcessBuilder pb = new ProcessBuilder(comandos);

        return pb.start();

    }

    public static Process execNavegador(String web) throws IOException {
        String navegador = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        ArrayList<String> comandos = new ArrayList<String>();
        comandos.add(navegador);
        comandos.add(web);
        ProcessBuilder pb = new ProcessBuilder(comandos);

        return pb.start();
    }
}
