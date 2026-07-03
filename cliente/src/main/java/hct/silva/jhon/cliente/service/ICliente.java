package hct.silva.jhon.cliente.service;

import hct.silva.jhon.cliente.model.clienteModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICliente {

    Flux<clienteModel> findAll();

    Mono<clienteModel> findById(Long id);

    Mono<clienteModel> save(clienteModel cl);

    Mono<clienteModel> update(Long id, clienteModel cl);

    Mono<clienteModel> deleteById(Long id);

    Mono<clienteModel> restoreById(Long id);

    Mono<Void> delete(Long id);

}
