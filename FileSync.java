import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;

public class FileSync {

    // Method to generate the checksum of a file
    public static String generateChecksum(Path path) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (InputStream is = Files.newInputStream(path)) {
            byte[] byteArray = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(byteArray)) != -1) {
                md.update(byteArray, 0, bytesRead);
            }
        }
        byte[] hashBytes = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    // Method to check if a file needs to be updated or synced
    public static boolean needsSync(Path sourceFile, Path targetFile) throws Exception {
        // If the source and target files are different in size or checksum, they need to be synced
        if (!Files.exists(targetFile)) {
            return true; // target file doesn't exist, need to sync
        }
        if (Files.size(sourceFile) != Files.size(targetFile)) {
            return true; // sizes are different
        }
        // Compare checksums
        String sourceChecksum = generateChecksum(sourceFile);
        String targetChecksum = generateChecksum(targetFile);
        return !sourceChecksum.equals(targetChecksum);
    }

    // Method to transfer a file (dummy implementation for the network)
    public static void transferFile(Path sourceFile, Path targetFile) throws IOException {
        System.out.println("Transferring file: " + sourceFile.toString());
        // In a real implementation, this would involve sending the file over a network
        Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
    }

    // Sync files from source to target directory
    public static void syncFiles(Path sourceDir, Path targetDir) throws Exception {
        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir); // Ensure target directory exists
        }

        try (Stream<Path> paths = Files.walk(sourceDir)) {
            paths.filter(Files::isRegularFile).forEach(sourcePath -> {
                try {
                    Path relativePath = sourceDir.relativize(sourcePath);
                    Path targetPath = targetDir.resolve(relativePath);

                    // Check if the file needs to be synced
                    if (needsSync(sourcePath, targetPath)) {
                        transferFile(sourcePath, targetPath); // Transfer the file if needed
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // Main method to initiate file sync
    public static void main(String[] args) {
        try {
            Path sourceDir = Paths.get("path/to/source/folder");
            Path targetDir = Paths.get("path/to/target/folder");

            syncFiles(sourceDir, targetDir); // Sync files from source to target

            System.out.println("Sync completed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
