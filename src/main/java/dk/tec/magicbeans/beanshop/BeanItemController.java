package dk.tec.magicbeans.beanshop;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    List<BeanItem> getAll(){
        return repository.findAll();
    }

    @PutMapping()
    void update(@RequestBody BeanItem beanItem){
        repository.save(beanItem);
    }


    /*
    // ved ikke hvilken returtype jeg skal anvende her tænker int men så mangler jeg selve objektet
    @DeleteMapping("/{id}")
     BeanItem (@PathVariable int id){
        return repository.deleteById(id);
    }
     */

}