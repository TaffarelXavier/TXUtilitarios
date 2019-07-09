/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tx.utilitarios;
/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class TXBrowser {

    /**
     *
     * @param url
     */
    public static void abrirUrl(String url) {
        String completeCmd = "explorer.exe /select," + url;
        try {
            new ProcessBuilder(("explorer.exe " + completeCmd).split(" ")).start();
        } catch (IOException ex) {
            Logger.getLogger(TXBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
