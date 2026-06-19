# Plan de Pruebas
## Objetivo
Validar el correcto funcionamiento de los microservicios
## Herramientas

* JUnit
* DataFaker

## Caso de prueba

### CP-01

Registro de curso

### Objetivo

Verificar que una auditoria se pueda crear correctamente
* registro no sea nulo
* desc. no sea nulo
* fecha y hora no sea nula
* accion no sea nula
* accion sea igual a "Actualizar"

### CP-02

Registro de curso

### Objetivo

Verificar que un beneficiario se pueda crear correctamente
* registro no sea nulo
* nombre no sea nulo
* rut no sea nulo
* telefono no sea nulo

### CP-03

Registro de curso

### Objetivo

Verificar que un centro de acopio se pueda crear correctamente
* registro no sea nulo
* nombre no sea nulo
* ciudad no sea nula
* direccion no sea nula
* capacidad no sea nula

### CP-04

Registro de curso

### Objetivo

Verificar que una distribucion se pueda crear correctamente
* registro no sea nulo
* id_donacion no sea nulo
* id_emergencia no sea nulo
* id_beneficiario no sea nulo

### CP-05

Registro de curso

### Objetivo

Verificar que una donacion se pueda crear correctamente
* registro no sea nulo
* id_usuario no sea nulo
* id_centro no sea nulo
* descripcion no sea nula
* cantidad no sea nula
* tipoDonacion no sea nula
* fecha_donacion no sea nula

### CP-06

Registro de curso

### Objetivo

Verificar que una emergencia se pueda crear correctamente
* registro no sea nulo
* descripcion no sea nula
* fecha_inicio no sea nula
* ubicacion no sea nula
* comuna no sea nula
* id sea igual a 6084

### CP-07

Registro de curso

### Objetivo

Verificar que un inventario se pueda crear correctamente
* registro no sea nulo
* stock_actual no sea nulo
* fecha_actualizacion no sea nula
* id_donacion no sea nulo
* id sea igual a 1564

### CP-08

Registro de curso

### Objetivo

Verificar que un vehiculo se pueda crear correctamente
* registro no sea nulo
* patente no sea nula
* tipo no sea nulo
* capacidad_carga_kg no sea nula
* estado no sea nulo
* estado sea igual a "Disponible"

### CP-09

Registro de curso

### Objetivo

Verificar que un usuario se pueda crear correctamente
* registro no sea nulo
* rut no sea nulo
* dv no sea nulo
* pnombre, snombre, papellido y sapellido no sean nulos
* email no sea nulo
* telefono no sea nulo
* rol no sea nulo
* id sea igual a 1564

### CP-10

Registro de curso

### Objetivo

Verificar que un voluntario se pueda crear correctamente
* registro no sea nulo
* fecha_ingreso no sea nula
* id_usuario no sea nulo
* id_usuario sea mayor o igual a 1
* disponibilidad sea verdadera (True)
