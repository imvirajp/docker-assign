package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
@RestController
public class TodoController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/todos")
    public String getTodo() {
        try {
            byte[] contents = Files.readAllBytes(Paths.get("todos.txt"));
            String todos = new String(contents, "UTF-8");
            return todos;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/todos")
    public ResponseEntity<String> postTodo(@RequestBody Todo todo) {
        try {
            File file = new File("todos.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.append(todo.toString());
            fr.close();
            return new ResponseEntity<>("result successful result",
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("nigh ithan",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public static void main(String[] args) {
        SpringApplication.run(TodoController.class, args);
    }

}
