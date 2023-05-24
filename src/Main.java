import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        String mainDirectory = "C:\\My projects\\Java\\Netology\\Games";

        String[] subdirectories = {"src", "res", "savegames", "temp"};
        for (String subdirectory : subdirectories) {
            File file = new File(mainDirectory + "/" + subdirectory);
            if (file.mkdir()) {
                log.append("Subdirectory '").append(subdirectory).append("' created\n");
            }
        }

        String[] srcSubdirectories = {"main", "test"};
        for (String subdirectory : srcSubdirectories) {
            File file = new File(mainDirectory + "/src/" + subdirectory);
            if (file.mkdir()) {
                log.append("Subdirectory 'src/").append(subdirectory).append("' created\n");
            }
        }

        String[] mainFiles = {"Main.java", "Utils.java"};
        for (String mainFile : mainFiles) {
            File file = new File(mainDirectory + "/src/main/" + mainFile);
            try {
                if (file.createNewFile()) {
                    log.append("File 'src/main/").append(mainFile).append("' created\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String[] resSubdirectories = {"drawables", "vectors", "icons"};
        for (String subdirectory : resSubdirectories) {
            File file = new File(mainDirectory + "/res/" + subdirectory);
            if (file.mkdir()) {
                log.append("Subdirectory 'res/").append(subdirectory).append("' created\n");
            }
        }

        File file = new File(mainDirectory + "/temp/temp.txt");
        try {
            if (file.createNewFile()) {
                log.append("File 'temp/temp.txt' created\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(mainDirectory + "/temp/temp.txt")) {
            writer.write(log.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All operations were successful. Check the 'temp.txt' file for logs.");
    }
}