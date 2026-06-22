Plan de Pruebas
Objetivo
Validar el correcto funcionamiento de los microservicios
Herramientas
JUnit
DataFaker
Caso de prueba
CP-01# Plan de Pruebas

## Objetivo
Validar el correcto funcionamiento de los microservicios.

## Herramientas
- JUnit
- DataFaker

---

## Caso de Prueba CP-01

### Nombre
Registro de auditoría

### Objetivo
Verificar que una auditoría se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- La descripción no debe ser nula.
- La fecha y hora no deben ser nulas.
- La acción no debe ser nula.
- La acción debe ser igual a `"Actualizar"`.

---

## Caso de Prueba CP-02

### Nombre
Registro de beneficiario

### Objetivo
Verificar que un beneficiario se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- El nombre no debe ser nulo.
- El RUT no debe ser nulo.
- El teléfono no debe ser nulo.

---

## Caso de Prueba CP-03

### Nombre
Registro de centro de acopio

### Objetivo
Verificar que un centro de acopio se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- El nombre no debe ser nulo.
- La ciudad no debe ser nula.
- La dirección no debe ser nula.
- La capacidad no debe ser nula.

---

## Caso de Prueba CP-04

### Nombre
Registro de distribución

### Objetivo
Verificar que una distribución se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- El ID de donación no debe ser nulo.
- El ID de emergencia no debe ser nulo.
- El ID de beneficiario no debe ser nulo.

---

## Caso de Prueba CP-05

### Nombre
Registro de donación

### Objetivo
Verificar que una donación se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- El ID de usuario no debe ser nulo.
- El ID de centro no debe ser nulo.
- La descripción no debe ser nula.
- La cantidad no debe ser nula.
- El tipo de donación no debe ser nulo.
- La fecha de donación no debe ser nula.

---

## Caso de Prueba CP-06

### Nombre
Registro de emergencia

### Objetivo
Verificar que una emergencia se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- La descripción no debe ser nula.
- La fecha de inicio no debe ser nula.
- La ubicación no debe ser nula.
- La comuna no debe ser nula.
- El ID debe ser igual a `6084`.

---

## Caso de Prueba CP-07

### Nombre
Registro de inventario

### Objetivo
Verificar que un inventario se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- El stock actual no debe ser nulo.
- La fecha de actualización no debe ser nula.
- El ID de donación no debe ser nulo.
- El ID debe ser igual a `1564`.

---

## Caso de Prueba CP-08

### Nombre
Registro de vehículo

### Objetivo
Verificar que un vehículo se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- La patente no debe ser nula.
- El tipo no debe ser nulo.
- La capacidad de carga (kg) no debe ser nula.
- El estado no debe ser nulo.
- El estado debe ser igual a `"Disponible"`.

---

## Caso de Prueba CP-09

### Nombre
Registro de usuario

### Objetivo
Verificar que un usuario se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- El RUT no debe ser nulo.
- El dígito verificador (DV) no debe ser nulo.
- Primer nombre, segundo nombre, apellido paterno y apellido materno no deben ser nulos.
- El correo electrónico no debe ser nulo.
- El teléfono no debe ser nulo.
- El rol no debe ser nulo.
- El ID debe ser igual a `1564`.

---

## Caso de Prueba CP-10

### Nombre
Registro de voluntario

### Objetivo
Verificar que un voluntario se pueda crear correctamente.

### Validaciones
- El registro no debe ser nulo.
- La fecha de ingreso no debe ser nula.
- El ID de usuario no debe ser nulo.
- El ID de usuario debe ser mayor o igual a `1`.
- La disponibilidad debe ser verdadera (`true`).
Registro de curso
Objetivo
Verificar que una auditoria se pueda crear correctamente
registro no sea nulo
desc. no sea nulo
fecha y hora no sea nula
accion no sea nula
accion sea igual a "Actualizar"
CP-02
Registro de curso
Objetivo
Verificar que un beneficiario se pueda crear correctamente
registro no sea nulo
nombre no sea nulo
rut no sea nulo
telefono no sea nulo
CP-03
Registro de curso
Objetivo
Verificar que un centro de acopio se pueda crear correctamente
registro no sea nulo
nombre no sea nulo
ciudad no sea nula
direccion no sea nula
capacidad no sea nula
CP-04
Registro de curso
Objetivo
Verificar que una distribucion se pueda crear correctamente
registro no sea nulo
id_donacion no sea nulo
id_emergencia no sea nulo
id_beneficiario no sea nulo
CP-05
Registro de curso
Objetivo
Verificar que una donacion se pueda crear correctamente
registro no sea nulo
id_usuario no sea nulo
id_centro no sea nulo
descripcion no sea nula
cantidad no sea nula
tipoDonacion no sea nula
fecha_donacion no sea nula
CP-06
Registro de curso
Objetivo
Verificar que una emergencia se pueda crear correctamente
registro no sea nulo
descripcion no sea nula
fecha_inicio no sea nula
ubicacion no sea nula
comuna no sea nula
id sea igual a 6084
CP-07
Registro de curso
Objetivo
Verificar que un inventario se pueda crear correctamente
registro no sea nulo
stock_actual no sea nulo
fecha_actualizacion no sea nula
id_donacion no sea nulo
id sea igual a 1564
CP-08
Registro de curso
Objetivo
Verificar que un vehiculo se pueda crear correctamente
registro no sea nulo
patente no sea nula
tipo no sea nulo
capacidad_carga_kg no sea nula
estado no sea nulo
estado sea igual a "Disponible"
CP-09
Registro de curso
Objetivo
Verificar que un usuario se pueda crear correctamente
registro no sea nulo
rut no sea nulo
dv no sea nulo
pnombre, snombre, papellido y sapellido no sean nulos
email no sea nulo
telefono no sea nulo
rol no sea nulo
id sea igual a 1564
CP-10
Registro de curso
Objetivo
Verificar que un voluntario se pueda crear correctamente
registro no sea nulo
fecha_ingreso no sea nula
id_usuario no sea nulo
id_usuario sea mayor o igual a 1
disponibilidad sea verdadera (True)