package edu.gcsc.celltreeedit;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;


/**
 * Created by Erid on 16.02.2018.
 *
 *  The class implements a file chooser, which can choose a number of Swc-files to compare or a whole folder.
 */
public class Utils {

    /**
     *
     * @return a list of files which were selected
     */
    public static File[] choose(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //accept files and directories as input
        FileNameExtensionFilter swc=new FileNameExtensionFilter("SWC","SWC");
        fileChooser.addChoosableFileFilter(swc);                            // filter on swc files
        fileChooser.setAcceptAllFileFilterUsed(false);                     // show only swc files
        fileChooser.setMultiSelectionEnabled(true);                       // accept multiple files as input
        fileChooser.showOpenDialog(null);

        if(fileChooser.getSelectedFile().isFile())
            return fileChooser.getSelectedFiles();
        else{
            File folder= new File(fileChooser.getSelectedFile().getAbsolutePath());
            File[] selectedFiles= folder.listFiles(new FilenameFilter() {              // return only swc files
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".swc");
                }
            });
            return selectedFiles;
        }
    }


    public static void printToTxt(float[][] results){
        System.out.println("Please choose the directory where you want to save the file");
        JFileChooser save= new JFileChooser();
        save.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        save.showSaveDialog(null);
        String path=save.getSelectedFile().getAbsolutePath();
        try {
            FileWriter export=new FileWriter(path+"/export.txt");
            BufferedWriter br=new BufferedWriter(export);
            br.write("#;");
            for(int i=0;i<results.length;i++){                              //kopfzeile
                int a=i+1;
                br.write(a+";");
            }
            br.newLine();
            for(int i=0;i<results.length;i++){
                int a=i+1;
                br.write(a+";");
                for(int j=0;j<results.length;j++){
                    br.write(results[i][j]+";");
                }
                br.newLine();
            }

            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}