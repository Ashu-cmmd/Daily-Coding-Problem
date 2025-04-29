// Implement a file syncing algorithm for two computers over a low-bandwidth network. What if we know the files in the two computers are mostly the same

import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;

public class _59_BlockLevelFileSync {

    // Block size for splitting files into chunks
    private static final int BLOCK_SIZE = 1024;  // You can adjust this size
    
    // Method to generate a checksum for a specific block (using MD5)
    public static String generateBlockChecksum(byte[] block) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(block);
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    // Method to read a file into blocks and return a list of checksums for each block
    public static List<String> getFileBlockChecksums(Path filePath) throws IOException, NoSuchAlgorithmException {
        List<String> blockChecksums = new ArrayList<>();
        
        try (InputStream is = Files.newInputStream(filePath)) {
            byte[] buffer = new byte[BLOCK_SIZE];
            int bytesRead;
            
            while ((bytesRead = is.read(buffer)) != -1) {
                // Only consider the actual bytes read
                byte[] block = Arrays.copyOf(buffer, bytesRead);
                blockChecksums.add(generateBlockChecksum(block));
            }
        }
        
        return blockChecksums;
    }

    // Method to check if two files are identical based on block checksums
    public static boolean areFilesIdentical(Path sourceFile, Path targetFile) throws IOException, NoSuchAlgorithmException {
        List<String> sourceChecksums = getFileBlockChecksums(sourceFile);
        List<String> targetChecksums = getFileBlockChecksums(targetFile);
        
        // Files are different if block counts or any block checksum differs
        if (sourceChecksums.size() != targetChecksums.size()) {
            return false;
        }
        
        for (int i = 0; i < sourceChecksums.size(); i++) {
            if (!sourceChecksums.get(i).equals(targetChecksums.get(i))) {
                return false; // Found a difference in the blocks
            }
        }
        
        return true;
    }

    // Method to transfer a block (e.g., send a block over the network)
    public static void transferBlock(Path sourceFile, Path targetFile, int blockIndex) throws IOException {
        try (InputStream is = Files.newInputStream(sourceFile);
             OutputStream os = Files.newOutputStream(targetFile, StandardOpenOption.APPEND)) {
            byte[] buffer = new byte[BLOCK_SIZE];
            long skipBytes = blockIndex * BLOCK_SIZE;
            is.skip(skipBytes);  // Skip to the blockIndex position

            int bytesRead = is.read(buffer);
            if (bytesRead > 0) {
                os.write(buffer, 0, bytesRead);  // Transfer the block
            }
        }
        System.out.println("Transferred block " + blockIndex);
    }

    // Sync files from source to target directory based on block-level differences
    public static void syncFiles(Path sourceFile, Path targetFile) throws Exception {
        // Step 1: Check if the source and target files are identical
        if (!Files.exists(targetFile) || !areFilesIdentical(sourceFile, targetFile)) {
            // If files are different or the target file doesn't exist, perform block-level sync
            List<String> sourceChecksums = getFileBlockChecksums(sourceFile);
            List<String> targetChecksums = getFileBlockChecksums(targetFile);

            // Step 2: Transfer only changed blocks
            for (int i = 0; i < sourceChecksums.size(); i++) {
                if (i >= targetChecksums.size() || !sourceChecksums.get(i).equals(targetChecksums.get(i))) {
                    // If block has changed or doesn't exist in target file, transfer it
                    transferBlock(sourceFile, targetFile, i);
                }
            }
        } else {
            System.out.println("Files are identical, no sync needed.");
        }
    }

    // Main method to initiate file syncing
    public static void main(String[] args) {
        try {
            Path sourceFile = Paths.get("path/to/source/file.txt");
            Path targetFile = Paths.get("path/to/target/file.txt");

            syncFiles(sourceFile, targetFile); // Start file sync

            System.out.println("File sync completed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
