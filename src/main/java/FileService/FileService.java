package FileService;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    List<String> list= new ArrayList<>();

   public List<String>FileRead(String FilePathIn) throws IOException {
       Path fileIn = Path.of(FilePathIn);
       list= Files.readAllLines(fileIn);
       return list;
    }
   public void FileWrite() throws IOException {
       FileWriter fileOut=new FileWriter("C:\\Users\\matvv\\IdeaProjects\\vitalii.matviichuk.decoder\\src\\test\\test_out.txt");
       for (String str : list) {
           fileOut.write(str+System.lineSeparator());
       }
       fileOut.close();}
   }



