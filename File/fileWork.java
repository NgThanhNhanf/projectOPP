package File;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface fileWork {
    void readFile() throws FileNotFoundException;
    void writeFile() throws IOException;
}
