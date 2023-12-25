package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class File {
    public static Program prog;

    public File(Program program) {
        this.prog = program;
    }

    public void reader() throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get("./giris.txt"));

        for (String line : allLines) {
            Process process = createProcessFromLine(line);
            prog.AddtoList(process);
        }

        prog.DpProgram();
    }

    private Process createProcessFromLine(String line) {
        String[] data = line.split(",");
        int[] dataArray = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            dataArray[i] = Integer.parseInt(data[i].trim());
        }

        return new Process(dataArray);
    }
}
