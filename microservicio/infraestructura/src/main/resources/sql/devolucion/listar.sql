select devolucion.id as id_devolucion,devolucion.fecha_devolucion,devolucion.km_finales,devolucion.alquiler_id,
cliente.id as id_cliente, cliente.nombre, cliente.direccion, cliente.telefono, cliente.cedula, cliente.correo,
moto.id as id_moto, moto.matricula, moto.marca, moto.modelo, moto.tipo_moto, moto.kilometros_recorridos, moto.precio_alquiler,
alquiler.id as id_alquiler, fecha_alquiler, fecha_entrega, valor_pago
from devolucion
inner join alquiler on devolucion.alquiler_id = alquiler.id
inner join cliente on alquiler.cliente_id = cliente.id
inner join moto on alquiler.moto_id = moto.id