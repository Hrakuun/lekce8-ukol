package hrakuun.ja.lekce8ukol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@RestController
public class MainController {

    @GetMapping("/scifi")
    public String scifiPrint() {
        return loadFileToString("data/scifi.txt");
    }
    @GetMapping("/romantic")
    public String romanticPrint(){
        return loadFileToString("data/romantic.txt");
    }
    @GetMapping("/historic")
    public String historicPrint(){
        return loadFileToString("data/historic.txt");
    }

    private String fileName;
    private String loadFileToString(String fileName){
        String text = "";
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            text = scanner.nextLine();
        } catch (FileNotFoundException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
    return text;
    }


}
