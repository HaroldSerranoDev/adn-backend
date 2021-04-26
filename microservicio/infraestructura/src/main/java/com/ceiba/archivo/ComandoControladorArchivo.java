package com.ceiba.archivo;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/archivo")
@Api(tags = {"Controlador comando archivo (blob)"})
public class ComandoControladorArchivo {

    private final CloudBlobClient clienteArchivo;
    private final String NOMBRE_COLA="adn";

    @Autowired
    public ComandoControladorArchivo(CloudBlobClient clienteArchivo) {
        this.clienteArchivo = clienteArchivo;
    }

    @GetMapping
    @ApiOperation("Obtener Imagen")
    public void obtenerImagen(@RequestParam String nombreArchivo, HttpServletResponse respuesta) throws Exception {
        CloudBlobContainer contenedor = obtenerContenedorAlmacenamiento(NOMBRE_COLA);

        CloudBlob referenciaArchivo = contenedor.getBlobReferenceFromServer(nombreArchivo);

        referenciaArchivo.download(respuesta.getOutputStream());
    }


    @PostMapping
    @ApiOperation("Enviar archivo")
    public void subirImagen(@RequestParam MultipartFile archivo) throws Exception{
        CloudBlobContainer contenedor = obtenerContenedorAlmacenamiento(NOMBRE_COLA);
        CloudBlockBlob bloqueReferenciaArchivo = contenedor.getBlockBlobReference(archivo.getOriginalFilename());
        bloqueReferenciaArchivo.upload(archivo.getInputStream(), -1);
    }

    private CloudBlobContainer obtenerContenedorAlmacenamiento(String nombreContenedor) throws URISyntaxException, StorageException {
        return clienteArchivo.getContainerReference(nombreContenedor);
    }

}
