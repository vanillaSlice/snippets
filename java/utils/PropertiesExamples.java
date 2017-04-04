/**
 * Note to self on different ways to interact with properties files.
 */

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Mike Lowe
 */
public final class PropertiesExamples {

    /*
     * There are two ways to read and write properties files using Java.
     * With plain text files and xml files.
     */

    public static void usingPlainText() throws IOException {
        // load properties
        File defaultTxt = new File("default.properties");
        Properties defaultProperties = loadDefaultPropertiesFromPlainText(defaultTxt);
        File userTxt = new File("user.properties");
        Properties userProperties = loadUserPropertiesFromPlainText(userTxt, defaultProperties);

        String name = userProperties.getProperty("name");

        // have we run it before?
        if (userProperties.containsKey("runBefore")) {
            System.out.println("Welcome back " + name);
            return;
        }

        // we haven't so get input from user
        System.out.println("You have not run this before");
        System.out.println("The default name is " + name);
        System.out.print("Enter new name: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        scanner.close();
        System.out.println("Hello " + name);
        userProperties.put("name", name);
        userProperties.put("runBefore", "true");

        // update the user properties file
        writePropertiesToPlainText(userProperties, userTxt);
    }

    private static Properties loadDefaultPropertiesFromPlainText(File file) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            properties.load(inputStream);
        }
        return properties;
    }

    private static Properties loadUserPropertiesFromPlainText(File file, Properties defaultProperties)
            throws IOException {
        Properties properties = new Properties(defaultProperties);
        if (file.exists()) {
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                properties.load(inputStream);
            }
        }
        return properties;
    }

    private static void writePropertiesToPlainText(Properties properties, File file) throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            properties.store(outputStream, null);
        }
    }

    public static void usingXML() throws IOException {
        //load properties
        File defaultXML = new File("default.properties.xml");
        Properties defaultProperties = loadDefaultPropertiesFromXML(defaultXML);
        File userXML = new File("user.properties.xml");
        Properties userProperties = loadUserPropertiesFromXML(userXML, defaultProperties);

        String name = userProperties.getProperty("name");

        // have we run it before?
        if (userProperties.containsKey("runBefore")) {
            System.out.println("Welcome back " + name);
            return;
        }

        // we haven't so get input from user
        System.out.println("You have not run this before");
        System.out.println("The default name is " + name);
        System.out.print("Enter new name: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        scanner.close();
        System.out.println("Hello " + name);
        userProperties.put("name", name);
        userProperties.put("runBefore", "true");

        // update the user properties file
        writePropertiesToXML(userProperties, userXML);
    }


    private static Properties loadDefaultPropertiesFromXML(File file) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            properties.loadFromXML(inputStream);
        }
        return properties;
    }

    private static Properties loadUserPropertiesFromXML(File file, Properties defaultProperties) throws IOException {
        Properties properties = new Properties(defaultProperties);
        if (file.exists()) {
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                properties.loadFromXML(inputStream);
            }
        }
        return properties;
    }

    private static void writePropertiesToXML(Properties properties, File file) throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            properties.storeToXML(outputStream, null);
        }
    }

}
