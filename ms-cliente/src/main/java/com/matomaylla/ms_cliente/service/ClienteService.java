package com.matomaylla.ms_cliente.service;

import com.matomaylla.ms_cliente.client.ProductoClient;
import com.matomaylla.ms_cliente.mapper.ClienteMapper;
import com.matomaylla.ms_cliente.repository.ClienteRepository;
import com.matomaylla.ms_cliente.util.EncryptionUtil;
import com.openapi.gen.springboot.model.ClienteProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoClient productoClient;

    private static final String SECRET_KEY = "un_dato_mayor_de";

    public Mono<ClienteProductos> getClienteByCodigoUnico(String codigoUnico) {
        log.debug("Busqueda de cliente con codigoUnico {}", codigoUnico);
        return Mono.fromCallable(() -> EncryptionUtil.decrypt(codigoUnico, SECRET_KEY))
                .map(Long::parseLong)
                .flatMap(clienteId -> clienteRepository.findById(clienteId)
                        .flatMap(cliente -> productoClient.getProductos(clienteId).collectList()
                                .map(productos -> {
                                        ClienteProductos clienteProductos = new ClienteProductos();
                                        ClienteMapper clienteMapper = new ClienteMapper();
                                        com.openapi.gen.springboot.model.Cliente clienteDocument = clienteMapper.toDocument(cliente);
                                        clienteProductos.setCliente(clienteDocument);
                                        clienteProductos.setProductos(productos);
                                        return clienteProductos;})
                        )
                )
                .onErrorResume(e -> Mono.error(new RuntimeException("Error al desencriptar el codigoUnico", e)));


    }

    public String encriptar(String data) {
        try {
            return EncryptionUtil.encrypt(data, SECRET_KEY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
