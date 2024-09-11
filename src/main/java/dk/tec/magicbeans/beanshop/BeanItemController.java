package dk.tec.magicbeans.beanshop;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beanshop")
public class BeanItemController {

    BeanItemRepository repository;

    BeanItemController(BeanItemRepository repository){
        this.repository = repository;
    }


    @PostMapping()
    int create(@RequestBody BeanItem beanItem){
        repository.save(beanItem);
        return beanItem == null ? -1 : beanItem.getId();
    }

    @GetMapping("/{id}")
    BeanItem read(@PathVariable int id){
        return repository.findById(id).get();
    }


}