create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(150) not null,
 direccion varchar(255) not null,
 telefono varchar(12) not null,
 cedula varchar(12) not null unique,
 correo varchar(100) not null unique,
 primary key (id)
);


create table moto (
 id int(11) not null auto_increment,
 matricula varchar(10) not null unique,
 marca varchar(20) not null,
 modelo smallint not null,
 tipo_moto varchar(255) not null,
 kilometros_recorridos int not null,
 precio_alquiler double not null,
 primary key (id)
);

create table alquiler (
 id int(11) not null auto_increment,
 fecha_alquiler date not null,
 fecha_entrega date not null,
 valor_pago double not null,
 cliente_id int(11) not null,
 moto_id int(11) not null,
 primary key (id),
 foreign key (cliente_id) REFERENCES cliente(id),
 foreign key (moto_id) REFERENCES moto(id)
);

create table devolucion (
 id int(11) not null auto_increment,
 fecha_devolucion date not null,
 km_finales smallint not null,
 alquiler_id int(11) not null unique,
 primary key (id),
 foreign key (alquiler_id) REFERENCES alquiler(id)
);
