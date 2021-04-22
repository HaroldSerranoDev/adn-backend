package com.ceiba.archivo;

import com.ceiba.configuracion.ClienteArchivoAzure;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Locale;

@RestController
@RequestMapping("/archivo")
@Api(tags = {"Controlador comando archivo (blob)"})
public class ComandoControladorArchivo {

    private final CloudBlobClient clienteArchivo;

    @Autowired
    public ComandoControladorArchivo(ClienteArchivoAzure clienteArchivoAzure) {
        this.clienteArchivo = clienteArchivoAzure.clienteArchivo();
    }

    @GetMapping(value = "/{nombreArchivo}")
    @ApiOperation("Obtener Imagen")
    public void obtenerImagen(@PathVariable String nombreArchivo, HttpServletResponse respuesta) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        CloudBlobContainer contenedor = obtenerContenedorAlmacenamiento("adn");

        CloudBlob referenciaArchivo = contenedor.getBlobReferenceFromServer(nombreArchivo.toLowerCase(Locale.ROOT));

        referenciaArchivo.download(respuesta.getOutputStream());
    }


    @PostMapping
    @ApiOperation("Enviar archivo")
    public Object subirImagen(@RequestBody MultipartFile archivo) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        CloudBlobContainer contenedor = obtenerContenedorAlmacenamiento("adn");

        File archivoCargar = convertirDeMultipartAFile(archivo);
        CloudBlockBlob bloqueReferenciaArchivo = contenedor.getBlockBlobReference(archivoCargar.getName().toLowerCase());

        //Creating blob and uploading file to it
        bloqueReferenciaArchivo.uploadFromFile(archivoCargar.getAbsolutePath().toLowerCase(Locale.ROOT));
        archivoCargar.delete();

        return "Archivo: " + archivoCargar.getName() + " cargado con éxito";
    }

    private File convertirDeMultipartAFile(MultipartFile archivoMultipart) throws IOException {
        File archivoConvertido = new File(archivoMultipart.getOriginalFilename());
        archivoConvertido.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(archivoConvertido);
        fileOutputStream.write(archivoMultipart.getBytes());
        fileOutputStream.close();
        return archivoConvertido;
    }

    private CloudBlobContainer obtenerContenedorAlmacenamiento(String nombreContenedor) throws URISyntaxException, StorageException {
        return clienteArchivo.getContainerReference(nombreContenedor);
    }

}
