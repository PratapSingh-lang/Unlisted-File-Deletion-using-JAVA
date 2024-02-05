package FileDelete;

//public class FileDeletion {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.print("OM NAMO GANESHAY NAMAH");
//	}
//
//}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileDeletion {
    public static void main(String[] args) {
        // Path to the folder containing files
        String folderPath = "C:\\Users\\Bhanu\\projects\\server-core\\lib";

        // Path to the text file containing the list of file names
        String textFilePath = "C:\\Users\\Bhanu\\Desktop\\file_names.txt";

        try {
            // Read the list of file names from the text file
            Set<String> allowedFileNames = readTextFile(textFilePath);

            // Get a list of files in the folder
            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                // Check each file in the folder
                for (File file : files) {
                    String fileName = file.getName();

                    // Check if the file name is not in the text file
                    if (!allowedFileNames.contains(fileName)) {
                        System.out.println("Deleting: " + file.getAbsolutePath());
                        file.delete();
                    }
                }

                System.out.println("Files deletion completed.");
            } else {
                System.out.println("No files found in the folder.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> readTextFile(String filePath) throws IOException {
        Set<String> fileNames = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            fileNames.add(line);
        }
        reader.close();
        return fileNames;
    }
        
        
		/*
		 * try { // Read the list of file names from the text file BufferedReader reader
		 * = new BufferedReader(new FileReader(textFilePath)); String line; while ((line
		 * = reader.readLine()) != null) { // Construct the file path using the folder
		 * path and file name String filePath = folderPath + File.separator + line;
		 * 
		 * // Check if the file exists and delete it File fileToDelete = new
		 * File(filePath); if (fileToDelete.exists()) { System.out.println("Deleting: "
		 * + filePath); // fileToDelete.delete(); } }
		 * 
		 * reader.close();
		 * 
		 * System.out.println("Files deletion completed."); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
//    }
}
