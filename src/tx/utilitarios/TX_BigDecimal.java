/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tx.utilitarios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class TX_BigDecimal extends BigDecimal {

    public TX_BigDecimal(String string) {
        super(string);
    }

    /**
     *
     * @param str
     * @return
     */
    public static String replaceNumber(String str) {
        return str.replaceAll("\\.", "").replaceAll("\\,", ".");
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal multiplicar(String x, String y) {
        return new BigDecimal(replaceNumber(x)).multiply(new BigDecimal(replaceNumber(y)));
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal somar(String x, String y) {
        return new BigDecimal(replaceNumber(x)).add(new BigDecimal(replaceNumber(y)));
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal subtrair(String x, String y) {
        return new BigDecimal(replaceNumber(x)).subtract(new BigDecimal(replaceNumber(y)));
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal dividir(String x, String y) {
        return new BigDecimal(replaceNumber(x)).divide(new BigDecimal(replaceNumber(y)), new MathContext(16, RoundingMode.HALF_EVEN)).setScale(3, BigDecimal.ROUND_DOWN);
    }

    /**
     * <p>
     * Formata uma saída. Por exemplo, com o valor: 200000,50, o resultado será este: 200.000,50</p>
     *
     * @param bd
     * @return
     */
    public static String formatarSaida(BigDecimal bd) {

        DecimalFormat df = new DecimalFormat();

        String result = df.format(bd);

        df.setMaximumFractionDigits(2);

        df.setMinimumFractionDigits(0);

        df.setGroupingUsed(false);

        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(multiplicar("1,0", "1,0"));
    }

    /**
     * <p style="font-weight:900;">Aplica padding aos Objetos. [...=um array de objetos]</p>
     *
     * @param field
     */
    public static void setPadding(JTextField... field) {
        for (JTextField t : field) {
            t.setBorder(BorderFactory.createCompoundBorder(t.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }
    }

    /**
     * <p style="font:16px arial">Formata um número.</p>
     *
     * @param numero o número para ser formatado
     * @return
     */
    public static String formatarNumeroAsCurrency(Object numero) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(numero);
    }

    /**
     *
     * @param jFormatTextFied
     */
    public static void permitirNumeroAsCurrencyLocal(JFormattedTextField jFormatTextFied) {
        DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
        NumberFormatter formatar = new NumberFormatter(dFormat);
        formatar.setFormat(dFormat);
        formatar.setAllowsInvalid(false);
        formatar.setOverwriteMode(false);
        jFormatTextFied.setFormatterFactory(new DefaultFormatterFactory(formatar));
    }

    public static String decimalFormat(BigDecimal Preis) {
        String res = "0.00";
        if (Preis != null) {
            NumberFormat nf = NumberFormat.getInstance();
            if (nf instanceof DecimalFormat) {
                ((DecimalFormat) nf).applyPattern("###0.00");

            }
            res = nf.format(Preis);
        }
        return res;
    }
}
