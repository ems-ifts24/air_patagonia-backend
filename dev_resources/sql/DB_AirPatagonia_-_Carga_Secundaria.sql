USE [PP2-Aerolinea];

INSERT INTO AVION (
    Fabricante, Modelo, CapacidadTurista, CapacidadBusiness, CapacidadPrimera,
    Autonomia, Matricula, Estado
)
VALUES
-- Boeing 737-800
('Boeing', '737-800', 160, 12, NULL, 6.5, 'LV-BOE737', 'Reservado'),

-- Airbus A320neo
('Airbus', 'A320neo', 180, 8, NULL, 7.6, 'LV-AIR320', 'Reservado'),

-- Boeing 787-9 DM
('Boeing', '787-9 DM', 220, 30, 8, 15.6, 'LV-BOE789', 'Reservado'),

-- Airbus A350-900
('Airbus', 'A350-900', 270, 36, 12, 16.5, 'LV-AIR350', 'Reservado'),

-- Embraer E190
('Embraer', 'E190', 96, 8, NULL, 5.4, 'LV-EMB190', 'Reservado'),

-- Boeing 777-300ER
('Boeing', '777-300ER', 300, 42, 14, 17.5, 'LV-BOE773', 'Reservado'),

-- Airbus A330-200
('Airbus', 'A330-200', 250, 30, 10, 15.4, 'LV-AIR330', 'Reservado'),

-- Bombardier CRJ900
('Bombardier', 'CRJ900', 76, 6, NULL, 3.5, 'LV-BOM900', 'Reservado'),

-- Airbus A220-300
('Airbus', 'A220-300', 130, 10, NULL, 7.5, 'LV-AIR220', 'Reservado'),

-- Boeing 747-8
('Boeing', '747-8', 400, 50, 20, 17.1, 'LV-BOE748', 'Reservado');


-- ////////////////////////////////



BEGIN TRANSACTION;

UPDATE Aeropuerto
SET ciudad      = N'Ciudad de Buenos Aires',
    nombreCorto = N'CABA',
    pais        = N'Argentina'
WHERE IdAeropuerto = 1;  -- AEP

UPDATE Aeropuerto
SET ciudad      = N'Buenos Aires',
    nombreCorto = N'Bs. As.',
    pais        = N'Argentina'
WHERE IdAeropuerto = 2;  -- EZE

UPDATE Aeropuerto
SET ciudad      = N'Córdoba',
    nombreCorto = N'Córdoba',
    pais        = N'Argentina'
WHERE IdAeropuerto = 3;  -- COR

UPDATE Aeropuerto
SET ciudad      = N'Mendoza',
    nombreCorto = N'Mendoza',
    pais        = N'Argentina'
WHERE IdAeropuerto = 4;  -- MDZ

UPDATE Aeropuerto
SET ciudad      = N'Rosario',
    nombreCorto = N'Rosario',
    pais        = N'Argentina'
WHERE IdAeropuerto = 5;  -- ROS

UPDATE Aeropuerto
SET ciudad      = N'San Miguel de Tucumán',
    nombreCorto = N'Tucumán',
    pais        = N'Argentina'
WHERE IdAeropuerto = 6;  -- TUC

UPDATE Aeropuerto
SET ciudad      = N'Salta',
    nombreCorto = N'Salta',
    pais        = N'Argentina'
WHERE IdAeropuerto = 7;  -- SLA

UPDATE Aeropuerto
SET ciudad      = N'Mar del Plata',
    nombreCorto = N'Mar del Plata',
    pais        = N'Argentina'
WHERE IdAeropuerto = 8;  -- MDQ

UPDATE Aeropuerto
SET ciudad      = N'Neuquén',
    nombreCorto = N'Neuquén',
    pais        = N'Argentina'
WHERE IdAeropuerto = 9;  -- NQN

UPDATE Aeropuerto
SET ciudad      = N'San Carlos de Bariloche',
    nombreCorto = N'Bariloche',
    pais        = N'Argentina'
WHERE IdAeropuerto = 10; -- BRC

UPDATE Aeropuerto
SET ciudad      = N'Comodoro Rivadavia',
    nombreCorto = N'Rivadavia',
    pais        = N'Argentina'
WHERE IdAeropuerto = 11; -- CRD

UPDATE Aeropuerto
SET ciudad      = N'San Salvador de Jujuy',
    nombreCorto = N'Jujuy',
    pais        = N'Argentina'
WHERE IdAeropuerto = 12; -- JUJ

UPDATE Aeropuerto
SET ciudad      = N'Bahía Blanca',
    nombreCorto = N'Bahía Blanca',
    pais        = N'Argentina'
WHERE IdAeropuerto = 13; -- BHI

UPDATE Aeropuerto
SET ciudad      = N'Resistencia',
    nombreCorto = N'Resistencia',
    pais        = N'Argentina'
WHERE IdAeropuerto = 14; -- RES

UPDATE Aeropuerto
SET ciudad      = N'Río Gallegos',
    nombreCorto = N'Río Gallegos',
    pais        = N'Argentina'
WHERE IdAeropuerto = 15; -- RGL

UPDATE Aeropuerto
SET ciudad      = N'Ushuaia',
    nombreCorto = N'Ushuaia',
    pais        = N'Argentina'
WHERE IdAeropuerto = 16; -- USH

UPDATE Aeropuerto
SET ciudad      = N'Puerto Iguazú',
    nombreCorto = N'Iguazú',
    pais        = N'Argentina'
WHERE IdAeropuerto = 17; -- IGR

UPDATE Aeropuerto
SET ciudad      = N'São Paulo',
    nombreCorto = N'São Paulo',
    pais        = N'Brasil'
WHERE IdAeropuerto = 18; -- GRU

UPDATE Aeropuerto
SET ciudad      = N'Río de Janeiro',
    nombreCorto = N'Río de Janeiro',
    pais        = N'Brasil'
WHERE IdAeropuerto = 19; -- GIG

UPDATE Aeropuerto
SET ciudad      = N'Santiago de Chile',
    nombreCorto = N'Santiago de Chile',
    pais        = N'Chile'
WHERE IdAeropuerto = 20; -- SCL

UPDATE Aeropuerto
SET ciudad      = N'Antofagasta',
    nombreCorto = N'Antofagasta',
    pais        = N'Chile'
WHERE IdAeropuerto = 21; -- ANF

UPDATE Aeropuerto
SET ciudad      = N'Montevideo',
    nombreCorto = N'Montevideo',
    pais        = N'Uruguay'
WHERE IdAeropuerto = 22; -- MVD

UPDATE Aeropuerto
SET ciudad      = N'Punta del Este',
    nombreCorto = N'Punta del Este',
    pais        = N'Uruguay'
WHERE IdAeropuerto = 23; -- PDP

UPDATE Aeropuerto
SET ciudad      = N'Asunción',
    nombreCorto = N'Asunción',
    pais        = N'Paraguay'
WHERE IdAeropuerto = 24; -- ASU

UPDATE Aeropuerto
SET ciudad      = N'Ciudad del Este',
    nombreCorto = N'Guaraní',
    pais        = N'Paraguay'
WHERE IdAeropuerto = 25; -- AGT

UPDATE Aeropuerto
SET ciudad      = N'La Paz',
    nombreCorto = N'La Paz',
    pais        = N'Bolivia'
WHERE IdAeropuerto = 26; -- LPB

UPDATE Aeropuerto
SET ciudad      = N'Santa Cruz de la Sierra',
    nombreCorto = N'Santa Cruz',
    pais        = N'Bolivia'
WHERE IdAeropuerto = 27; -- VVI

UPDATE Aeropuerto
SET ciudad      = N'Lima',
    nombreCorto = N'Lima',
    pais        = N'Perú'
WHERE IdAeropuerto = 28; -- LIM

UPDATE Aeropuerto
SET ciudad      = N'Cusco',
    nombreCorto = N'Cusco',
    pais        = N'Perú'
WHERE IdAeropuerto = 29; -- CUZ

UPDATE Aeropuerto
SET ciudad      = N'Bogotá',
    nombreCorto = N'Bogotá',
    pais        = N'Colombia'
WHERE IdAeropuerto = 30; -- BOG

UPDATE Aeropuerto
SET ciudad      = N'Medellín',
    nombreCorto = N'Medellín',
    pais        = N'Colombia'
WHERE IdAeropuerto = 31; -- MDE

UPDATE Aeropuerto
SET ciudad      = N'Ciudad de México',
    nombreCorto = N'CDMX',
    pais        = N'México'
WHERE IdAeropuerto = 32; -- MEX

UPDATE Aeropuerto
SET ciudad      = N'Guadalajara',
    nombreCorto = N'Guadalajara',
    pais        = N'México'
WHERE IdAeropuerto = 33; -- GDL

UPDATE Aeropuerto
SET ciudad      = N'New York',
    nombreCorto = N'NYC',
    pais        = N'Estados Unidos'
WHERE IdAeropuerto = 34; -- JFK

UPDATE Aeropuerto
SET ciudad      = N'Los Ángeles',
    nombreCorto = N'LA',
    pais        = N'Estados Unidos'
WHERE IdAeropuerto = 35; -- LAX

UPDATE Aeropuerto
SET ciudad      = N'Toronto',
    nombreCorto = N'Toronto',
    pais        = N'Canadá'
WHERE IdAeropuerto = 36; -- YYZ

UPDATE Aeropuerto
SET ciudad      = N'Vancouver',
    nombreCorto = N'Vancouver',
    pais        = N'Canadá'
WHERE IdAeropuerto = 37; -- YVR

UPDATE Aeropuerto
SET ciudad      = N'La Habana',
    nombreCorto = N'La Habana',
    pais        = N'Cuba'
WHERE IdAeropuerto = 38; -- HAV

UPDATE Aeropuerto
SET ciudad      = N'Santiago de Cuba',
    nombreCorto = N'Santiago de Cuba',
    pais        = N'Cuba'
WHERE IdAeropuerto = 39; -- SCU

UPDATE Aeropuerto
SET ciudad      = N'Madrid',
    nombreCorto = N'Madrid',
    pais        = N'España'
WHERE IdAeropuerto = 40; -- MAD

UPDATE Aeropuerto
SET ciudad      = N'Barcelona',
    nombreCorto = N'Barcelona',
    pais        = N'España'
WHERE IdAeropuerto = 41; -- BCN

UPDATE Aeropuerto
SET ciudad      = N'París',
    nombreCorto = N'París',
    pais        = N'Francia'
WHERE IdAeropuerto = 42; -- CDG

UPDATE Aeropuerto
SET ciudad      = N'Marsella',
    nombreCorto = N'Marsella',
    pais        = N'Francia'
WHERE IdAeropuerto = 43; -- MRS

UPDATE Aeropuerto
SET ciudad      = N'Roma',
    nombreCorto = N'Roma',
    pais        = N'Italia'
WHERE IdAeropuerto = 44; -- FCO

UPDATE Aeropuerto
SET ciudad      = N'Milán',
    nombreCorto = N'Milán',
    pais        = N'Italia'
WHERE IdAeropuerto = 45; -- MXP

UPDATE Aeropuerto
SET ciudad      = N'Berlín',
    nombreCorto = N'Berlín',
    pais        = N'Alemania'
WHERE IdAeropuerto = 46; -- BER

UPDATE Aeropuerto
SET ciudad      = N'Múnich',
    nombreCorto = N'Múnich',
    pais        = N'Alemania'
WHERE IdAeropuerto = 47; -- MUC

UPDATE Aeropuerto
SET ciudad      = N'Londres',
    nombreCorto = N'Londres',
    pais        = N'Reino Unido'
WHERE IdAeropuerto = 48; -- LHR

UPDATE Aeropuerto
SET ciudad      = N'Mánchester',
    nombreCorto = N'Mánchester',
    pais        = N'Reino Unido'
WHERE IdAeropuerto = 49; -- MAN

UPDATE Aeropuerto
SET ciudad      = N'Ámsterdam',
    nombreCorto = N'Ámsterdam',
    pais        = N'Países Bajos'
WHERE IdAeropuerto = 50; -- AMS

UPDATE Aeropuerto
SET ciudad      = N'Róterdam',
    nombreCorto = N'Róterdam',
    pais        = N'Países Bajos'
WHERE IdAeropuerto = 51; -- RTM

COMMIT;


-- //////////////

-- 1. Insertar pagos con tarjeta
INSERT INTO Pago (FechaOperacion, Monto, NumeroTarjeta, TitularTarjeta, EntidadEmisoraTarjeta)
VALUES 
(GETDATE(), 5000.00, '4111111111111111', 'Juan Pérez', 'Visa'),
(GETDATE(), 6200.00, '5500000000000004', 'Ana Gómez', 'MasterCard'),
(GETDATE(), 7000.00, '340000000000009',  'Luis Martínez', 'American Express'),
(GETDATE(), 4700.00, '6011000000000004', 'Lucía Fernández', 'Discover');

-- 2. Insertar pagos en efectivo
INSERT INTO Pago (FechaOperacion, Monto, SucursalCobro, PuestoCobro)
VALUES 
(GETDATE(), 3500.00, 'Sucursal 1', 'Caja 3'),
(GETDATE(), 4100.00, 'Sucursal 2', 'Caja 1'),
(GETDATE(), 3900.00, 'Sucursal 3', 'Caja 2'),
(GETDATE(), 4600.00, 'Sucursal 1', 'Caja 4');

-- 3. Insertar pagos por transferencia
INSERT INTO Pago (FechaOperacion, Monto, BancoOrigen, CBUOrigen, NumeroOperacion)
VALUES 
(GETDATE(), 5200.00, 'Banco Nación', '2850590940090418123456', 'TRX0001'),
(GETDATE(), 4900.00, 'Banco Galicia', '0070059420000001234567', 'TRX0002'),
(GETDATE(), 5800.00, 'Banco Santander', '0720059230000003456789', 'TRX0003'),
(GETDATE(), 5300.00, 'Banco BBVA', '0170059320000009876543', 'TRX0004');

-- 4. Insertar 12 DetallePasaje usando los IdPago generados (del 1 al 12, suponiendo tabla vacía antes)
INSERT INTO DetallePasaje (EstadoPasaje, Categoria, Asiento, FechaOperacion, Precio, IdPago, EstadoPago)
VALUES 
-- Pagos con tarjeta
('CONFIRMADO', 'ADULTO', '12A', GETDATE(), 5000.00, 1, 'APROBADO'),
('CANCELADO',  'MENOR',  '14B', GETDATE(), 6200.00, 2, 'PENDIENTE'),
('PENDIENTE',  'JUBILADO','16C', GETDATE(), 7000.00, 3, 'RECHAZADO'),
('CONFIRMADO', 'ADULTO', '18D', GETDATE(), 4700.00, 4, 'APROBADO'),

-- Pagos en efectivo
('CONFIRMADO', 'MENOR',  '20E', GETDATE(), 3500.00, 5, 'APROBADO'),
('CONFIRMADO', 'ADULTO', '22F', GETDATE(), 4100.00, 6, 'APROBADO'),
('PENDIENTE',  'JUBILADO','24G', GETDATE(), 3900.00, 7, 'PENDIENTE'),
('CANCELADO',  'ADULTO', '26H', GETDATE(), 4600.00, 8, 'RECHAZADO'),

-- Pagos por transferencia
('CONFIRMADO', 'ADULTO', '28I', GETDATE(), 5200.00, 9, 'APROBADO'),
('PENDIENTE',  'MENOR',  '30J', GETDATE(), 4900.00, 10, 'PENDIENTE'),
('CONFIRMADO', 'JUBILADO','32K', GETDATE(), 5800.00, 11, 'APROBADO'),
('CANCELADO',  'ADULTO', '34L', GETDATE(), 5300.00, 12, 'RECHAZADO');

--//////////////////////


UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'PM2938'
WHERE Email = 'marcos1@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'RS9174'
WHERE Email = 'sofia2@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'IL4102'
WHERE Email = 'lucas3@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'RC8465'
WHERE Email = 'camila4@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'ST2845'
WHERE Email = 'tomas5@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'HL9123'
WHERE Email = 'lucia6@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'AD8945'
WHERE Email = 'diego7@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'MJ7456'
WHERE Email = 'julieta8@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'RM2845'
WHERE Email = 'mateo9@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'VE1928'
WHERE Email = 'elena10@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'PM8936'
WHERE Email = 'marina11@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'SE8174'
WHERE Email = 'emilio12@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'PV8465'
WHERE Email = 'valeria13@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'MB9846'
WHERE Email = 'bruno14@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'CM3948'
WHERE Email = 'martina15@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'FI2736'
WHERE Email = 'ivan16@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'OF2841'
WHERE Email = 'florencia17@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'CR4615'
WHERE Email = 'ramiro18@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'FP4759'
WHERE Email = 'paula19@empresa.com';

UPDATE [PP2-Aerolinea].dbo.Empleado
SET Legajo = 'MA2193'
WHERE Email = 'agustina20@empresa.com';

-- //////////////

INSERT INTO [PP2-Aerolinea].dbo.PuestoTripulante
(Puesto, Descripcion, Estado)
VALUES(N'Azafata', N'Responsable del servicio en vuelo.', 1);


--////////////////////////

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Iborra', 'Maxi', 'maxi.iborra@mail.com', 'Doc. Extranjero', '468471011', 30, 'Urbanización de Juan Bautista Núñez 527', '+34702 40 59 80', '2002-05-05');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Osuna', 'Eutropio', 'eutropio.osuna@mail.com', 'Pasaporte', '123608584', 34, 'Calle de Amador Hernández 597', '+34 700 351 056', '1968-09-07');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Gascón', 'Tecla', 'tecla.gascón@mail.com', 'DNI', '70259310', 44, 'Vial de Pepito Mesa 540', '+34 715660648', '1995-08-07');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Sevillano', 'Nilda', 'nilda.sevillano@mail.com', 'Doc. Extranjero', '915062414', 5, 'Camino África Casado 937', '+34706 208 298', '2007-01-18');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Bernal', 'Eusebio', 'eusebio.bernal@mail.com', 'DNI', '54298696', 19, 'Rambla Jose Manuel Alonso 622', '+34 708216919', '2002-03-19');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Conesa', 'Zacarías', 'zacarías.conesa@mail.com', 'Pasaporte', '760283691', 31, 'Callejón Noé Peñas 407', '+34 807 154 273', '1993-12-21');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cámara', 'Pelayo', 'pelayo.cámara@mail.com', 'Doc. Extranjero', '889736803', 38, 'Alameda de Julián Ugarte 895', '+34804 848 708', '1998-04-06');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Jáuregui', 'Carmina', 'carmina.jáuregui@mail.com', 'DNI', '15140653', 43, 'C. de Lorena Carretero 768', '+34857 004 049', '2007-04-05');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Manjón', 'Maura', 'maura.manjón@mail.com', 'DNI', '37796219', 20, 'C. de Perlita Iglesia 270', '+34 731953985', '1970-07-03');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Coronado', 'Yésica', 'yésica.coronado@mail.com', 'Pasaporte', '455041823', 5, 'Camino Olalla Azcona 278', '+34722554457', '1986-11-28');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Rosa', 'Eliana', 'eliana.rosa@mail.com', 'Pasaporte', '282574199', 50, 'Vial Cloe Arranz 839', '+34722 507 493', '1964-03-21');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Rodrigo', 'Carmela', 'carmela.rodrigo@mail.com', 'Pasaporte', '399259584', 4, 'Pasadizo Fortunato Barroso 967', '+34702 91 88 96', '1989-01-06');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Merino', 'Juan Pablo', 'juan pablo.merino@mail.com', 'DNI', '48247064', 16, 'Ronda Melania Lozano 859', '+34 988 85 53 62', '1959-11-05');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Vidal', 'Maricela', 'maricela.vidal@mail.com', 'Pasaporte', '266787553', 4, 'Acceso de Abril Arce 502', '+34716930582', '2005-09-24');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Pablo', 'Guiomar', 'guiomar.pablo@mail.com', 'Pasaporte', '774111377', 10, 'Plaza de Lupe Ibañez 894', '+34723426197', '1975-07-21');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Sancho', 'Mar', 'mar.sancho@mail.com', 'Doc. Extranjero', '646426167', 46, 'Glorieta Fidel Saez 725', '+34 726 644 659', '1981-09-29');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Melero', 'Cipriano', 'cipriano.melero@mail.com', 'DNI', '14044564', 23, 'Plaza de María Belén Iglesia 636', '+34 726666097', '1983-07-28');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Castañeda', 'Paula', 'paula.castañeda@mail.com', 'Pasaporte', '706036300', 25, 'Alameda de Paca Amador 113', '+34878 201 955', '1959-09-30');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Farré', 'Buenaventura', 'buenaventura.farré@mail.com', 'Pasaporte', '870181823', 50, 'Paseo Adriana Aroca 43', '+34 720 56 24 62', '1999-12-23');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Quintero', 'Eusebio', 'eusebio.quintero@mail.com', 'Doc. Extranjero', '428670068', 40, 'Rambla Edgardo Cañete 341', '+34740 808 625', '1999-04-24');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Blanch', 'Odalis', 'odalis.blanch@mail.com', 'DNI', '20835319', 45, 'Callejón Heriberto Julián 364', '+34 724 48 72 78', '1969-11-03');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Elorza', 'Antonio', 'antonio.elorza@mail.com', 'DNI', '96107336', 25, 'Alameda Olimpia Bellido 806', '+34 727937825', '2004-01-11');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Tamayo', 'Elpidio', 'elpidio.tamayo@mail.com', 'Pasaporte', '928414225', 8, 'Paseo Celestino Villaverde 634', '+34 730 11 69 59', '1990-03-04');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Pineda', 'Nico', 'nico.pineda@mail.com', 'Doc. Extranjero', '650184670', 30, 'Via de Elías Moliner 966', '+34 822 059 306', '2003-05-12');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Merino', 'Bernabé', 'bernabé.merino@mail.com', 'Pasaporte', '955521434', 42, 'Calle de Eli Diéguez 708', '+34 741 60 75 99', '1976-11-06');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Menendez', 'Hortensia', 'hortensia.menendez@mail.com', 'Doc. Extranjero', '704232893', 40, 'Ronda de Gerardo Anglada 879', '+34734 361 511', '1961-03-22');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Almazán', 'Pascual', 'pascual.almazán@mail.com', 'DNI', '33768198', 25, 'Plaza de Mohamed Sastre 948', '+34717710864', '1961-05-01');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Villalobos', 'Flora', 'flora.villalobos@mail.com', 'Doc. Extranjero', '202776466', 44, 'Alameda Plinio Cabello 134', '+34740 284 006', '1982-06-03');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Collado', 'Faustino', 'faustino.collado@mail.com', 'Doc. Extranjero', '272398123', 51, 'Rambla Felicidad Herrera 49', '+34650760334', '1981-10-19');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Gárate', 'Francisco', 'francisco.gárate@mail.com', 'Pasaporte', '478045356', 29, 'Rambla Selena Rivero 205', '+34735 926 902', '1999-02-27');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Porta', 'Adelardo', 'adelardo.porta@mail.com', 'Pasaporte', '871448173', 23, 'Vial Alejo Amaya 87', '+34 728 00 01 99', '1969-06-28');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Coronado', 'Melania', 'melania.coronado@mail.com', 'DNI', '60985868', 3, 'Ronda Tristán Méndez 932', '+34733 25 83 86', '1964-05-30');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Raya', 'Efraín', 'efraín.raya@mail.com', 'DNI', '85981851', 34, 'Via de Tomás Rubio 595', '+34 676363769', '1964-02-20');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Iniesta', 'Petrona', 'petrona.iniesta@mail.com', 'DNI', '47027347', 15, 'Paseo de Alfredo Sánchez 849', '+34 640956180', '1969-04-03');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Poza', 'Leyre', 'leyre.poza@mail.com', 'Doc. Extranjero', '128771678', 50, 'C. de Toribio Calvo 546', '+34737 97 22 57', '1987-06-01');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Luz', 'Federico', 'federico.luz@mail.com', 'Pasaporte', '918009705', 33, 'Acceso Onofre Clavero 126', '+34957 80 34 29', '1981-07-14');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Pinto', 'Manu', 'manu.pinto@mail.com', 'DNI', '95150817', 28, 'Cañada Carmen Rosado 442', '+34 706 463 522', '1966-12-12');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Palau', 'Emperatriz', 'emperatriz.palau@mail.com', 'DNI', '32247666', 7, 'Ronda Corona Puig 111', '+34731 168 822', '1969-11-07');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Córdoba', 'Hipólito', 'hipólito.córdoba@mail.com', 'Pasaporte', '345081028', 50, 'Pasadizo Elpidio Ureña 987', '+34 749 45 16 42', '1982-09-30');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Valls', 'Eusebia', 'eusebia.valls@mail.com', 'DNI', '54532078', 51, 'C. Manola Mayoral 712', '+34 665678466', '1966-02-02');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Correa', 'Isabela', 'isabela.correa@mail.com', 'Pasaporte', '258533918', 2, 'Camino Dulce Villar 894', '+34 743 998 149', '1970-12-01');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Blázquez', 'Remigio', 'remigio.blázquez@mail.com', 'Pasaporte', '951850665', 47, 'Plaza David Paredes 370', '+34747 51 75 94', '2004-10-18');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Granados', 'Amanda', 'amanda.granados@mail.com', 'DNI', '31346937', 8, 'Pasadizo Zoraida Diéguez 40', '+34 828 693 764', '1960-11-18');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cañete', 'Diana', 'diana.cañete@mail.com', 'Pasaporte', '516845936', 23, 'Pasaje Clara Baeza 860', '+34919 653 870', '1992-02-07');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cal', 'Estefanía', 'estefanía.cal@mail.com', 'DNI', '46063208', 24, 'Paseo de Filomena Prado 924', '+34744 238 524', '2000-11-15');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cobo', 'Paz', 'paz.cobo@mail.com', 'DNI', '71326891', 14, 'Avenida Ale Pozuelo 684', '+34726814731', '1979-08-19');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Palomares', 'Epifanio', 'epifanio.palomares@mail.com', 'Doc. Extranjero', '971731544', 47, 'Vial Genoveva Barberá 136', '+34702 98 30 06', '1997-06-07');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Trujillo', 'Juana', 'juana.trujillo@mail.com', 'Doc. Extranjero', '866777788', 1, 'Cuesta Celia Olivera 716', '+34 731 03 37 44', '1974-09-22');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Valcárcel', 'Agapito', 'agapito.valcárcel@mail.com', 'DNI', '57629193', 39, 'Avenida de Casemiro Mayol 155', '+34726356234', '1973-01-01');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Teruel', 'Manuelita', 'manuelita.teruel@mail.com', 'DNI', '98584357', 30, 'Cañada de Rodrigo Castelló 362', '+34 665 873 556', '1978-04-27');

--//////////////////

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Arnal', 'Quique', 'quique.arnal@mail.com', 'Doc. Extranjero', '904377386', 6, 'Pasaje de Felicidad Rozas 945', '+34 682 36 94 02', '2007-03-02');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Linares', 'Eutropio', 'eutropio.linares@mail.com', 'Pasaporte', '457994529', 51, 'Avenida de Nilo Araujo 272', '+34 704 229 456', '1982-05-29');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Castilla', 'Carlota', 'carlota.castilla@mail.com', 'DNI', '49380421', 42, 'Urbanización de Atilio Mena 676', '+34 718146546', '1967-04-05');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cabezas', 'César', 'césar.cabezas@mail.com', 'Doc. Extranjero', '702186609', 23, 'Alameda de Prudencia Nuñez 168', '+34 671 760 452', '1992-03-08');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Diaz', 'Zaira', 'zaira.diaz@mail.com', 'Pasaporte', '772959144', 2, 'Avenida de Blas Blazquez 220', '+34 723060168', '1997-11-08');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Manjón', 'Aurelia', 'aurelia.manjón@mail.com', 'Doc. Extranjero', '581620759', 17, 'Ronda Celso Pedrosa 979', '+34 744926351', '1992-09-09');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Amorós', 'Bernardo', 'bernardo.amorós@mail.com', 'Pasaporte', '664590324', 37, 'Via Anastasia Puig 53', '+34 930 39 21 37', '1990-03-04');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Pardo', 'Reyes', 'reyes.pardo@mail.com', 'Doc. Extranjero', '686683151', 45, 'Cuesta Eusebio Ramis 516', '+34968 75 77 38', '1969-09-27');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Gilabert', 'Emilia', 'emilia.gilabert@mail.com', 'Doc. Extranjero', '110420303', 42, 'Alameda de Andrés Felipe Zapata 665', '+34 849269471', '1982-08-05');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Blazquez', 'Nereida', 'nereida.blazquez@mail.com', 'Pasaporte', '654617503', 24, 'Urbanización Eladio Armas 192', '+34 710 75 22 75', '1962-02-14');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Piña', 'Anselma', 'anselma.piña@mail.com', 'DNI', '81109580', 25, 'Camino Cipriano Villaverde 19', '+34741634896', '1993-08-18');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Toledo', 'Paola', 'paola.toledo@mail.com', 'DNI', '62152833', 10, 'Plaza Gala Abad 355', '+34624 89 45 17', '2000-10-10');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Juárez', 'Rosalina', 'rosalina.juárez@mail.com', 'Pasaporte', '985858843', 46, 'C. de Nélida Pla 808', '+34 712 234 500', '1980-01-18');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Rios', 'Alicia', 'alicia.rios@mail.com', 'Doc. Extranjero', '251295463', 3, 'Vial Nélida Osorio 177', '+34700 976 701', '1992-11-28');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cordero', 'Adriana', 'adriana.cordero@mail.com', 'DNI', '12714966', 38, 'Alameda Cruz Olivares 414', '+34 726710979', '1961-08-25');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Nebot', 'Evelia', 'evelia.nebot@mail.com', 'Doc. Extranjero', '798439189', 9, 'Vial de Viviana Ponce 499', '+34 701 83 06 75', '1967-11-26');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Farré', 'Maristela', 'maristela.farré@mail.com', 'Doc. Extranjero', '589057443', 16, 'Calle Valeria Ariño 325', '+34640 899 331', '1983-09-15');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Vallés', 'Maura', 'maura.vallés@mail.com', 'DNI', '80291372', 34, 'Via de Esteban Rojas 319', '+34726116116', '1988-01-11');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Costa', 'María Ángeles', 'maría ángeles.costa@mail.com', 'Pasaporte', '888426432', 22, 'Ronda de Itziar Rincón 121', '+34 875 415 115', '1961-07-13');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Andreu', 'Jesusa', 'jesusa.andreu@mail.com', 'DNI', '56364857', 36, 'Plaza Paulina Gual 495', '+34 619 23 03 10', '1983-02-11');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Peinado', 'Lázaro', 'lázaro.peinado@mail.com', 'Pasaporte', '840308992', 22, 'Vial Glauco Santiago 128', '+34 675 420 355', '1961-02-12');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Marco', 'Ainara', 'ainara.marco@mail.com', 'Doc. Extranjero', '418199782', 32, 'Rambla de Dorita Berrocal 319', '+34 748 942 622', '1997-01-31');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Gisbert', 'Nilda', 'nilda.gisbert@mail.com', 'Pasaporte', '439185828', 48, 'Urbanización Marisela Espejo 169', '+34 705 60 29 06', '1994-01-12');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Beltran', 'Casemiro', 'casemiro.beltran@mail.com', 'DNI', '27719461', 41, 'Paseo de Sigfrido Cisneros 835', '+34736451375', '1988-01-14');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Ángel', 'Febe', 'febe.ángel@mail.com', 'Doc. Extranjero', '162123606', 6, 'Plaza de Silvestre Montes 96', '+34723 547 121', '1985-01-21');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Caparrós', 'Leonel', 'leonel.caparrós@mail.com', 'DNI', '84917864', 48, 'Pasaje Íngrid Pujadas 404', '+34 716623758', '2000-08-24');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Padilla', 'Erasmo', 'erasmo.padilla@mail.com', 'DNI', '72067022', 7, 'Cuesta Marisol Frías 541', '+34 700 79 70 34', '2002-06-01');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Mascaró', 'Darío', 'darío.mascaró@mail.com', 'Pasaporte', '685412753', 29, 'Ronda Lara Soto 817', '+34 737 386 401', '2000-11-22');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Armas', 'Julián', 'julián.armas@mail.com', 'Doc. Extranjero', '100271881', 46, 'Pasadizo de Tania Prieto 443', '+34721 454 391', '1976-11-25');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Bejarano', 'Andrés Felipe', 'andrés felipe.bejarano@mail.com', 'DNI', '45230380', 24, 'Via de Benita Ibañez 277', '+34 701644829', '1980-03-27');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Gallo', 'Azeneth', 'azeneth.gallo@mail.com', 'Doc. Extranjero', '670560431', 50, 'Paseo de Sancho Lopez 206', '+34 707 59 22 11', '1966-08-10');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Quero', 'Rico', 'rico.quero@mail.com', 'Pasaporte', '734648503', 8, 'Paseo Guiomar Martínez 894', '+34 747 63 77 85', '1991-04-14');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Barrena', 'América', 'américa.barrena@mail.com', 'Doc. Extranjero', '576721777', 2, 'Cuesta Baldomero Garriga 472', '+34 857 608 116', '1979-11-14');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Paniagua', 'Adolfo', 'adolfo.paniagua@mail.com', 'Doc. Extranjero', '144214393', 13, 'Callejón Samanta Marco 417', '+34743 29 43 16', '1967-05-06');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Murillo', 'Édgar', 'édgar.murillo@mail.com', 'Pasaporte', '512456613', 14, 'Ronda de Flora Rozas 980', '+34 872852327', '1970-11-22');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Porcel', 'Paco', 'paco.porcel@mail.com', 'DNI', '67349920', 40, 'Urbanización de Natalia Ferrández 212', '+34723 906 031', '1992-12-01');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Estévez', 'Sabina', 'sabina.estévez@mail.com', 'Pasaporte', '490423441', 25, 'Urbanización Emiliana Martorell 856', '+34618456708', '1963-04-27');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Ros', 'Graciela', 'graciela.ros@mail.com', 'DNI', '87975149', 7, 'Callejón de Julie Tamarit 509', '+34 735400025', '1990-05-18');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Manjón', 'Abraham', 'abraham.manjón@mail.com', 'DNI', '97862626', 37, 'Avenida Miriam Roman 706', '+34713 96 83 73', '1959-12-05');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Calatayud', 'Norberto', 'norberto.calatayud@mail.com', 'Pasaporte', '751068194', 34, 'Alameda de Blanca Sarmiento 949', '+34 724 08 03 51', '1965-04-08');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Zamorano', 'Hugo', 'hugo.zamorano@mail.com', 'Pasaporte', '471243246', 32, 'Callejón Hortensia Mata 660', '+34 718 64 75 30', '1972-03-21');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Belmonte', 'Mariano', 'mariano.belmonte@mail.com', 'Doc. Extranjero', '109887511', 13, 'Pasaje de Asdrubal Revilla 963', '+34677 111 312', '1990-10-22');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'García', 'Severiano', 'severiano.garcía@mail.com', 'DNI', '69141669', 1, 'Ronda Celia Prado 995', '+34 702 373 245', '2001-02-20');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Royo', 'Miguel', 'miguel.royo@mail.com', 'Doc. Extranjero', '215196794', 21, 'Paseo de Modesta Fortuny 46', '+34734 78 97 84', '1997-05-07');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Guardiola', 'Leandro', 'leandro.guardiola@mail.com', 'Doc. Extranjero', '117779473', 10, 'Rambla Luz Ribera 627', '+34 634088601', '1967-07-10');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Llamas', 'Rodrigo', 'rodrigo.llamas@mail.com', 'DNI', '25870482', 25, 'Urbanización de Imelda Luján 745', '+34 743184535', '1997-11-12');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Tenorio', 'Eusebia', 'eusebia.tenorio@mail.com', 'Doc. Extranjero', '407982494', 31, 'Vial Nélida Alcántara 96', '+34718559026', '1999-01-19');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Elorza', 'Fabián', 'fabián.elorza@mail.com', 'Doc. Extranjero', '648117835', 3, 'Glorieta Merche Valdés 143', '+34723323659', '1964-08-23');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('ACTIVO', 'Cazorla', 'Domitila', 'domitila.cazorla@mail.com', 'DNI', '94421522', 20, 'Plaza Belen Palmer 874', '+34674 038 277', '1993-05-12');

INSERT INTO [PP2-Aerolinea].dbo.Cliente 
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES ('BLOQUEADO', 'Mir', 'Carina', 'carina.mir@mail.com', 'Pasaporte', '856154840', 22, 'Vial de Elisabet Querol 829', '+34733 54 60 30', '1964-10-19');


-- ///////////////////////////

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('CANCELADO', '2025-06-15 15:24:08', '2025-06-16 02:24:08', 19, 37, 15);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('FINALIZADO', '2025-06-09 22:11:14', '2025-06-10 00:11:14', 38, 6, 11);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EN_VUELO', '2025-06-01 07:00:56', '2025-06-01 10:00:56', 25, 10, 11);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('CERRADO', '2025-06-19 11:16:06', '2025-06-19 15:16:06', 33, 16, 16);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('REPROGRAMADO', '2025-06-10 07:48:13', '2025-06-10 18:48:13', 24, 28, 15);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('PROGRAMADO', '2025-06-02 00:53:12', '2025-06-02 07:53:12', 39, 2, 9);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EMBARCANDO', '2025-06-17 19:57:29', '2025-06-18 00:57:29', 9, 28, 5);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('DEMORADO', '2025-06-03 16:04:43', '2025-06-03 21:04:43', 38, 28, 9);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('FINALIZADO', '2025-06-12 21:09:09', '2025-06-13 08:09:09', 16, 30, 5);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('FINALIZADO', '2025-06-08 00:04:51', '2025-06-08 07:04:51', 4, 26, 22);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('PROGRAMADO', '2025-06-05 06:08:51', '2025-06-05 14:08:51', 47, 21, 19);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('CERRADO', '2025-06-12 14:15:19', '2025-06-12 16:15:19', 19, 32, 17);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('REPROGRAMADO', '2025-06-20 10:04:41', '2025-06-20 19:04:41', 18, 8, 8);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('REPROGRAMADO', '2025-06-07 06:47:48', '2025-06-07 13:47:48', 26, 12, 20);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('DEMORADO', '2025-06-01 12:28:32', '2025-06-01 18:28:32', 16, 31, 11);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('REPROGRAMADO', '2025-06-14 19:37:45', '2025-06-15 06:37:45', 30, 42, 17);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EMBARCANDO', '2025-06-15 01:14:00', '2025-06-15 06:14:00', 49, 14, 21);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('PROGRAMADO', '2025-06-18 17:53:53', '2025-06-18 18:53:53', 40, 30, 20);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('CERRADO', '2025-06-21 02:39:23', '2025-06-21 07:39:23', 8, 42, 15);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('REPROGRAMADO', '2025-06-18 14:21:11', '2025-06-18 22:21:11', 46, 50, 19);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EMBARCANDO', '2025-06-23 15:39:35', '2025-06-24 00:39:35', 49, 15, 21);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('DEMORADO', '2025-06-06 21:25:39', '2025-06-06 23:25:39', 41, 2, 14);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EN_VUELO', '2025-06-15 13:33:00', '2025-06-15 20:33:00', 1, 18, 4);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('DEMORADO', '2025-06-20 13:28:36', '2025-06-20 18:28:36', 7, 49, 20);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('FINALIZADO', '2025-06-11 06:55:34', '2025-06-11 10:55:34', 49, 44, 15);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EMBARCANDO', '2025-06-19 19:21:59', '2025-06-20 00:21:59', 5, 18, 4);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('FINALIZADO', '2025-06-07 11:24:35', '2025-06-07 14:24:35', 34, 16, 8);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EMBARCANDO', '2025-06-11 10:47:33', '2025-06-11 19:47:33', 19, 20, 19);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('REPROGRAMADO', '2025-06-21 07:45:50', '2025-06-21 16:45:50', 41, 14, 22);

INSERT INTO [PP2-Aerolinea].dbo.Vuelo 
(Estado, FechaPartida, FechaArribo, IdAeropuertoPartida, IdAeropuertoArribo, IdAvion)
VALUES ('EMBARCANDO', '2025-05-27 06:15:27', '2025-05-27 13:15:27', 41, 35, 19);



