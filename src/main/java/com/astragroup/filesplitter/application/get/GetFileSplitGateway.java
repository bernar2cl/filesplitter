package com.astragroup.filesplitter.application.get;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetFileSplitGateway {

    private final GetFileSplitService getFileSplitService;

    public ResponseEntity<Resource> descargarFragmento(String nombreFragmento) throws IOException {
        return getFileSplitService.descargarFragmento(nombreFragmento);
    }
    public List<String> listarFragmentosOrdenados(String baseName, String extension) throws IOException {
        return getFileSplitService.listarFragmentosOrdenados(baseName, extension);
    }
}
