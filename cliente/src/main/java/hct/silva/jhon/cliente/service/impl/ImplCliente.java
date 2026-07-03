package hct.silva.jhon.cliente.service.impl;


import hct.silva.jhon.cliente.model.clienteModel;
import hct.silva.jhon.cliente.repository.clienteRepository;
import hct.silva.jhon.cliente.service.ICliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ImplCliente implements ICliente {

    private final clienteRepository repository;


    @Override
    public Flux<clienteModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<clienteModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<clienteModel> save(clienteModel cl) {
        return repository.save(cl);
    }

    @Override
    public Mono<clienteModel> update(Long id, clienteModel cl) {
        return repository.findById(id)
                .switchIfEmpty(
                        Mono.error(
                                new RuntimeException("El id no existe: "+ id)
                        )
                )
                .flatMap(existing ->{
                    existing.setNombres(cl.getNombres());
                    existing.setApellidos(cl.getApellidos());
                    existing.setCelular(cl.getCelular());
                    existing.setCorreo(cl.getCorreo());
                    existing.setLicencia(cl.getLicencia());
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<clienteModel> deleteById(Long id) {
        return repository.findById(id)
                .switchIfEmpty(
                        Mono.error(
                                new RuntimeException("El id no existe: "+ id)
                        )
                )
                .flatMap(existing ->{
                    existing.setEstado("inactivo");
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<clienteModel> restoreById(Long id) {
        return repository.findById(id)
                .switchIfEmpty(
                        Mono.error(
                                new RuntimeException("El id no existe: "+ id)
                        )
                )
                .flatMap(existing ->{
                    existing.setEstado("activo");
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return repository.findById(id)
                .flatMap(repository::delete);
    }
}
