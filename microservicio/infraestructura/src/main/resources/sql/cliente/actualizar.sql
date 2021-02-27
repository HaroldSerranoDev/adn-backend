update cliente
set nombre = :nombre,
	direccion = :direccion,
	telefono = :telefono,
	cedula = :cedula,
	correo = :correo
where id = :id