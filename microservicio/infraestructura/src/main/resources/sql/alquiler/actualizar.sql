update alquiler
set fecha_alquiler=:fechaAlquiler,
    fecha_entrega=:fechaEntrega,
    valor_pago=:valorPago,
    cliente_id=:idCliente,
    moto_id = :idMoto
where id = :id