package hct.silva.jhon.cliente.rest;




import hct.silva.jhon.cliente.model.clienteModel;
import hct.silva.jhon.cliente.service.ICliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")

public class clienteRest {

    private final ICliente service;

    @GetMapping
    public Flux<clienteModel> findAll(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    public Mono<clienteModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<clienteModel> save(@RequestBody clienteModel cl){
        return service.save(cl);
    }

    @PutMapping("/{id}")
    public Mono<clienteModel> update(@PathVariable Long id, @RequestBody clienteModel cl){
        return service.update(id,cl);
    }

    @PatchMapping("/elimidoLogico/{id}")
    public Mono<clienteModel>  deleteById(@PathVariable Long id ){
        return service.deleteById(id);
    }

    @PatchMapping("/restauradoLogico/{id}")
    public Mono<clienteModel> restoreById(@PathVariable Long id){
        return service.restoreById(id);
    }


    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id ){
        return service.delete(id);
    }

}
