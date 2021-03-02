insert into cliente (id,nombre, direccion, telefono, cedula, correo) values (1,'test', 'calle 10', '12345', '12345', 'test@gmail.com');
insert into moto (id,matricula, marca, modelo, tipo_moto, kilometros_recorridos, precio_alquiler) values (1,'CLB45T', 'HONDA', 2021, 'SPORT',0,200000);
insert into moto (id,matricula, marca, modelo, tipo_moto, kilometros_recorridos, precio_alquiler) values (2,'CSH56Y', 'HONDA', 2020, 'ENDURO',0,150000);
insert into moto (id,matricula, marca, modelo, tipo_moto, kilometros_recorridos, precio_alquiler) values (3,'RSH45A', 'HONDA', 2019, 'ENDURO',0,120000);
insert into alquiler (id,fecha_alquiler, fecha_entrega,valor_pago,cliente_id,moto_id) values (1,'2021-03-02', '2021-03-05',2000000,1,1);
insert into alquiler (id,fecha_alquiler, fecha_entrega,valor_pago,cliente_id,moto_id) values (2,'2021-03-06', '2021-03-08',2000000,1,2);
insert into devolucion (id,fecha_devolucion, km_finales, alquiler_id,valor_pago_final) values (1,'2021-03-05', 200, 1,200000 )