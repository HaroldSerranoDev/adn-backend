insert into cliente (nombre, direccion, telefono, cedula, correo) values ('test', 'calle 10', '12345', '12345', 'testqgmail.com')
insert into moto (matricula, marca, modelo, tipo_moto, kilometros_recorridos, precio_alquiler) values ('CLB45T', 'HONDA', 2021, 'SPORT',0,200000)
insert into alquiler (fecha_alquiler, fecha_entrega,valor_pago,cliente_id,moto_id) values ('2021-03-02', '2021-03-05',2000000,1,1)
insert into devolucion (fecha_devolucion, km_finales, alquiler_id,valor_pago_final) values ('2021-03-05', 200, 1,200000 )