/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tx.utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Taffarel <taffarel_deus@hotmail.com>
 */
public class TXDatas {

    /**
     *
     * @return
     */
    public static String getDataFormatada() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'ÀS' HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String data = String.valueOf(dateFormat.format(cal.getTime()));
        return data;
    }

    /**
     *
     * @param timestamp
     * @return
     */
    public static String getDataFromTimeStamp(long timestamp) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'ÀS' HH:mm:ss");
        String data = String.valueOf(dateFormat.format(timestamp));
        return data;
    }
    /**
     *
     * @return
     */
    public static long getTimeStampAtual() {
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }

}
