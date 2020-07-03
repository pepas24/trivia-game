package trivia;

public class Utilities {

    /**
     * Return the file name passed without the extension
     * ex. myfile.txt to myfile
     * @param fileName
     * @return the string passed without extension
     */
    public static String removeExtension(String fileName) {
        return fileName.replaceFirst("[.][^.]+$", "");
    }

    /**
     * Return the string passed turning the first letter to uppercase.
     * ex. mystring to Mystring
     * @param str
     * @return the string passed with first letter in uppercase
     */
    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
