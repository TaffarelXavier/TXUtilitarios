/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tx.utilitarios;

import java.io.File;
import java.io.IOException;
import static tx.utilitarios.TXStrings.strValueOf;

/**
 *
 * @author Taffarel <taffarel_deus@hotmail.com>
 */
public class TXFiles {

    private static File file;
    private static String dirFile;
    private static boolean fileExists;
    private static boolean arquivo = false;
    private static boolean diretorio = false;

    
    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        TXFiles.file = file;
    }

    public static String getDirFile() {
        return dirFile;
    }

    public static void setDirFile(String dirFile) {
        TXFiles.dirFile = dirFile;
    }

    public static boolean isFileExists() {
        return fileExists;
    }

    public static void setFileExists(boolean fileExists) {
        TXFiles.fileExists = fileExists;
    }

    public static boolean isArquivo() {
        return arquivo;
    }

    public static void setArquivo(boolean arquivo) {
        TXFiles.arquivo = arquivo;
    }

    public static boolean isDiretorio() {
        return diretorio;
    }

    public static void setDiretorio(boolean diretorio) {
        TXFiles.diretorio = diretorio;
    }

    /**
     *
     * @param f
     * @return
     * @throws IOException
     */
    public static String[] getInfoFile(File f) throws IOException {
        TXFiles.setFile(f);
        TXFiles.setArquivo(f.isFile());
        TXFiles.setDiretorio(f.isDirectory());
        TXFiles.setFileExists(f.canRead());
        TXFiles.setDirFile(strValueOf(f.toPath().getParent()));
        String[] fl = {f.getAbsoluteFile().toString(), f.getAbsolutePath(), f.getCanonicalFile().toString(), f.getPath(), f.getParent(), f.getParentFile().toString(), strValueOf(f.isDirectory()), strValueOf(f.isFile()), strValueOf(f.toPath().getParent()), strValueOf(f.toPath().getRoot().toString())};
        return fl;
    }
}
