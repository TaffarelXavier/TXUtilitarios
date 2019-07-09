package tx.utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Exemplo para pegar o caminho do arquivo. static { String path =
 * TelaConfiguracoes.class.getProtectionDomain().getCodeSource().getLocation().getPath();
 * try { String decodedPath = URLDecoder.decode(path, "UTF-8");
 *
 * File file = new File(decodedPath);
 *
 * TXProperties.setFilePath(file.getParent() + "\\config.properties");
 *
 * } catch (IOException exs) {
 * Logger.getLogger(TelaEditor.class.getName()).log(Level.SEVERE, null, exs); }
 * }
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class TXProperties {

    private static String filePath = "";

    /**
     *
     * @return <p style="font:16px arial">O Caminho do arquivo.</p>
     */
    public static String getFilePath() {
        return filePath;
    }

    /**
     *
     * @param filePath <p style="font:16px arial">Define o caminho do
     * arquivo.</p>
     */
    public static void setFilePath(String filePath) {
        TXProperties.filePath = filePath;
        TXProperties.criarArquivoDePropriedade();
    }
    
    /**
     * 
     * @param filePath 
     */
    public static void definirCaminhoDoArquivoDePropriedade(String filePath) {
        TXProperties.filePath = filePath;
    }

    /**
     *
     * @param path
     * @return
     */
    public static boolean inicializador(String path) {

        try {
            String decodedPath = URLDecoder.decode(path, "UTF-8");

            File file = new File(decodedPath);

            TXProperties.setFilePath(file.getParent() + "\\config.properties");
            return true;
        } catch (IOException exs) {
        }
        return false;
    }

    /**
     *
     * Exemplo:
     *
     * Map<String, String> example =
     * TXProperties.readPropertiesFile("src\\config\\config.properties");
     * example.keySet().forEach((key) -> { //Capturamos o valor a partir da
     * chave String value = example.get(key); System.out.println(key + " = " +
     * value); });
     *
     * @return
     * @throws Exception
     *
     */
    public static Map<String, String> readAllPropertiesFile() throws Exception {

        Map<String, String> properties = new HashMap<>();

        Properties props = new Properties();

        props.load(new FileInputStream(new File(getFilePath())));

        props.forEach((key, value) -> {

            properties.put(key.toString(), value.toString());

        });

        return properties;

    }

    /**
     * <p>
     * Lê todas propriedades e seus respectivos valores.</p>
     *
     * @return
     */
    public static String[] getAllValuesFromFilePropertie() {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            String[] keys = properties.keySet().toArray(new String[0]);

            String[] arrReturn = new String[keys.length];

            int i = -1;

            for (String values : keys) {
                ++i;
                arrReturn[i] = properties.getProperty(values);

            }

            return arrReturn;

        } catch (IOException e) {

        }
        return null;
    }

    /**
     *
     * @return
     */
    public static String[] getAllKeysFromFilePropertie() {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            String[] keys = properties.keySet().toArray(new String[0]);

            return keys;

        } catch (IOException e) {

        }
        return null;
    }

    /**
     * <p>
     * Verifica se uma chave existe</p>
     *
     * @param key
     * @return
     */
    public static boolean keyExists(String key) {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            return properties.getProperty(key) != null;

        } catch (IOException e) {

        }

        return false;

    }

 /**
  * 
  */
    public static void criarArquivoDePropriedade() {
        File f = new File(filePath);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     *
     * @param newKey <p style="font:16px arial">A nova chave</p>
     * @param newValue <p style="font:16px arial">O novo valor</p>
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void addItem(String newKey, String newValue) throws FileNotFoundException, IOException {
        File f = new File(filePath);

        Properties prop1 = new Properties();

        prop1.load(new java.io.FileInputStream(getFilePath()));

        Properties prop2 = new Properties();

        prop1.load(new java.io.FileInputStream(getFilePath()));

        for (String key : prop1.stringPropertyNames()) {

            String value = prop1.getProperty(key);

            prop2.setProperty(key, value);

        }

        prop2.setProperty(newKey, newValue);

        OutputStream out = new FileOutputStream(f);

        prop2.store(out, "Arquivo de configuração da classe de Propriedade Java.");

    }

    /**
     * @param key <p style="font:16px arial">A chave para procurar</p>
     * @return
     */
    public static String getProp(String key) {

        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getFilePath()));

            return keyExists(key) ? properties.getProperty(key) : "";

        } catch (IOException e) {

        }

        return null;

    }

}
