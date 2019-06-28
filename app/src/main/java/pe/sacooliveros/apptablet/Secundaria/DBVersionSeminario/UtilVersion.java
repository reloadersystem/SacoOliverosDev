package pe.sacooliveros.apptablet.Secundaria.DBVersionSeminario;

public class UtilVersion {

    public static String TABLA_VERSIONSEMINARIO = "tablaversiondb";
    public static String CAMPO_CODIGO = "codigo";
    public static String CAMPO_VERSION = "version";
    public static String CAMPO_URLTOMO = "urltomo";
    public static String CAMPO_NOMBRETOMO = "nombretomo";


    public static final String CREAR_TABLA_VERSIONSEMINARIO = "CREATE TABLE " + TABLA_VERSIONSEMINARIO + "(" + CAMPO_CODIGO + " TEXT, " + CAMPO_VERSION + " TEXT, " + CAMPO_URLTOMO + " TEXT, " + CAMPO_NOMBRETOMO + " TEXT)";

}
