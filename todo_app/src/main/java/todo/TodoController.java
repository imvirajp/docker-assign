package todo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TodoController {

    @RequestMapping("/todos")
    public String index() {
        return "{todo1:'new todo 1',todo2:'new todo 2'}";
    }
}
