package studio.visualdust.uiwidgets.common;


import java.io.*;
import java.util.Vector;

public class LinedFile {
    public Vector<String> strings = new Vector<>();
    private ReaderThread readerThread = null;
    private String name;
    private String path;
    private long wordCount;

    public LinedFile(File file) throws FileNotFoundException {
        readerThread = new ReaderThread(file);
        readerThread.start();
        name = file.getName();
        path = file.getPath();
        wordCount = file.length();
    }

    public LinedFile(InputStream inputStream) {

    }

    public boolean isReading() {
        return readerThread.isAlive();
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public long getWordCount() {
        return wordCount;
    }

    @Override
    public String toString() {
        while (isReading()) {
            System.out.println("LindFile " + this.toString() + " is still reading. Please wait.");
        }
        String string = "";
        for (int i = 0; i < strings.size(); i++) {
            string = string + strings.elementAt(i) + "\n";
        }
        return string;
    }

    public Vector<String> getLinedFile() {
        while (isReading()) {
            System.out.println("LindFile " + this.getPath() + " is still reading. Please wait.");
        }
        return strings;
    }

    private class ReaderThread extends Thread {
        File readerFile = null;
        InputStream inputStream = null;

        public ReaderThread(File file) throws FileNotFoundException {
            readerFile = file;
            inputStream = new FileInputStream(readerFile);
        }

        public ReaderThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String str = bufferedReader.readLine();
                while (str != null) {
                    if (!str.isEmpty())
                        strings.add(str);
                    str = bufferedReader.readLine();
                }
            } catch (Exception e) {
                EventRW.write(e);
            }
        }
    }
}
