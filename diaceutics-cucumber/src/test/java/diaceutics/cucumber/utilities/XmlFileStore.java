package diaceutics.cucumber.utilities;

import aquality.selenium.browser.AqualityServices;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class XmlFileStore {

    private XmlFileStore() {
    }

    private static final String ENV_KEY = "store.absolutePath";

    public static <T> void storeEnv(String fileName, T object) {
        store(getStoreDirectory(), fileName, object);
    }

    public static <T> T getEnv(String fileName) {
        return get(getStoreDirectory(), fileName);
    }

    public static <T> T getEnv(ITokenString fileName) {
        return getEnv(fileName.toString());
    }

    public static List<File> getFilesEnv() {
        List<File> files = new ArrayList<>();
        File[] fileArray = getStoreDirectory().listFiles();
        if (fileArray != null && fileArray.length > 0) {
            files = Arrays.asList(fileArray);
        }
        return files;
    }

    public static <T> void store(String fileName, T object) {
        store(getTargetStoreDirectory(), fileName, object);
    }

    public static <T> void store(ITokenString fileName, T object) {
        store(fileName.toString(), object);
    }

    public static <T> T get(String fileName) {
        return get(getTargetStoreDirectory(), fileName);
    }

    public static <T> T get(ITokenString fileName) {
        return get(fileName.toString());
    }

    private static <T> void store(File storeDirectory, String fileName, T object) {
        String storePath = getStorePath(storeDirectory, fileName);
        try (FileOutputStream fos = new FileOutputStream(storePath);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             XMLEncoder e = new XMLEncoder(bos)) {
            e.writeObject(object);
        } catch (FileNotFoundException e) {
            throw new AssertionError(String.format("Store file '%s' isn't found", storePath));
        } catch (IOException e) {
            throw new AssertionError(String.format("IO exception during store operation%n%s", e.getMessage()));
        }
    }

    private static <T> T get(File storeDirectory, String fileName) {
        String storePath = getStorePath(storeDirectory, fileName);
        try (FileInputStream fis = new FileInputStream(storePath);
             XMLDecoder xmlDecoder = new XMLDecoder(fis)) {
            Object object = xmlDecoder.readObject();
            return (T) object;
        } catch (FileNotFoundException e) {
            throw new AssertionError(String.format("Store file '%s' isn't found", storePath));
        } catch (IOException e) {
            throw new AssertionError(String.format("IO exception during store operation%n%s", e.getMessage()));
        }
    }

    private static String getStorePath(File directory, String fileName) {
        return Paths.get(directory.getAbsolutePath(), fileName).toString();
    }

    private static boolean isFileExist(String fileName) {
        File file = new File(getStoreDirectory() + "/" + fileName);
        return file.exists();
    }

    private static File getStoreDirectory() {
        File storeDir = getTargetStoreDirectory();
        String storeDirEnv = System.getProperty(ENV_KEY);
        try {
            if (storeDirEnv != null && !storeDirEnv.equalsIgnoreCase("")) {
                File envDirectory = new File(storeDirEnv);
                if (envDirectory.exists() || envDirectory.mkdirs()) {
                    storeDir = envDirectory;
                }
            }
        } catch (Exception e) {
            AqualityServices.getLogger().warn("An exception while creating/reading store directory '" + storeDirEnv + "' received from the environment variable: " + e.getMessage());
        }
        return storeDir;
    }

    private static File getTargetStoreDirectory() {
        File directory = new File("target/store");
        if (!directory.exists()) {
            directory.mkdir();
        }
        return directory;
    }
}
