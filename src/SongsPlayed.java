import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongsPlayed {

    final List<String> songList = new ArrayList<>();

    public SongsPlayed(String songTitle, String data) {
        songList.add(songTitle);
        songList.add(data);
    }

    public void PrintSongToFile(String fileName) throws IOException {

        try(FileWriter file = new FileWriter(fileName)) {

            songList.forEach(e -> {

                try {
                    file.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                };
            });
        }
    }
}
