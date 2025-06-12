USE [PP2-Aerolinea];

-- Alta Aviones
-- Airbus
INSERT INTO [PP2-Aerolinea].dbo.Avion
(Fabricante, Modelo, CapacidadTurista, CapacidadBusiness, CapacidadPrimera, Autonomia, Matricula, Estado)
VALUES
('Airbus', 'A320neo', 150, 12, NULL, 6, 'ARX-3201', 'Disponible'),
('Airbus', 'A330-300', 220, 30, 8, 11, 'ARX-3302', 'Disponible'),
('Airbus', 'A350-900', 240, 32, 12, 15, 'ARX-3503', 'En Mantenimiento'),

-- Boeing
('Boeing', '737 MAX 8', 162, 16, NULL, 6.5, 'BMX-7381', 'Disponible'),
('Boeing', '787-9 Dreamliner', 230, 28, 10, 14, 'BMX-7892', 'Disponible'),
('Boeing', '777-300ER', 270, 35, 14, 16, 'BMX-7733', 'Disponible'),

-- Embraer
('Embraer', 'E190-E2', 100, 8, NULL, 5, 'EMB-1901', 'Disponible'),
('Embraer', 'E195-E2', 120, 10, NULL, 5.5, 'EMB-1952', 'Disponible'),
('Embraer', 'E175', 88, 6, NULL, 4.5, 'EMB-1753', 'En vuelo'),

-- Bombardier
('Bombardier', 'CRJ900', 90, 6, NULL, 4, 'BDR-9001', 'Disponible'),
('Bombardier', 'CS100 (A220-100)', 110, 8, NULL, 5.5, 'BDR-CS102', 'Disponible'),
('Bombardier', 'CS300 (A220-300)', 130, 10, NULL, 6, 'BDR-CS303', 'En vuelo');

-- ///////////////////////////////////////////////////////////////////////////

-- Alta Pais
-- América
INSERT INTO [PP2-Aerolinea].dbo.Pais (Nombre) VALUES
('Argentina'),       -- 1
('Brasil'),          -- 2
('Chile'),           -- 3
('Uruguay'),         -- 4
('Paraguay'),        -- 5
('Bolivia'),         -- 6
('Perú'),            -- 7
('Colombia'),        -- 8
('México'),          -- 9
('Estados Unidos'),  -- 10
('Canadá'),          -- 11
('Cuba');            -- 12

-- Europa
INSERT INTO [PP2-Aerolinea].dbo.Pais (Nombre) VALUES
('España'),          -- 13
('Francia'),         -- 14
('Italia'),          -- 15
('Alemania'),        -- 16
('Reino Unido'),     -- 17
('Países Bajos');    -- 18

--Alta Ciudad ARG
INSERT INTO [PP2-Aerolinea].dbo.Ciudad (Nombre, IdPais) VALUES
('Ciudad de Buenos Aires', 1),
('Ezeiza', 1),
('Córdoba', 1),
('Mendoza', 1),
('Rosario', 1),
('San Miguel de Tucumán', 1),
('Salta', 1),
('Mar del Plata', 1),
('Neuquén', 1),
('San Carlos de Bariloche', 1),
('Comodoro Rivadavia', 1),
('San Salvador de Jujuy', 1),
('Bahía Blanca', 1),
('Resistencia', 1),
('Río Gallegos', 1),
('Ushuaia', 1),
('Puerto Iguazú', 1);

-- Alta Ciudad Otros Paises
INSERT INTO [PP2-Aerolinea].dbo.Ciudad (Nombre, IdPais) VALUES
-- Brasil (2)
('São Paulo', 2),
('Rio de Janeiro', 2),
-- Chile (3)
('Santiago', 3),
('Antofagasta', 3),
-- Uruguay (4)
('Montevideo', 4),
('Punta del Este', 4),
-- Paraguay (5)
('Asunción', 5),
('Ciudad del Este', 5),
-- Bolivia (6)
('La Paz', 6),
('Santa Cruz de la Sierra', 6),
-- Perú (7)
('Lima', 7),
('Cusco', 7),
-- Colombia (8)
('Bogotá', 8),
('Medellín', 8),
-- México (9)
('Ciudad de México', 9),
('Guadalajara', 9),
-- Estados Unidos (10)
('Nueva York', 10),
('Los Ángeles', 10),
-- Canadá (11)
('Toronto', 11),
('Vancouver', 11),
-- Cuba (12)
('La Habana', 12),
('Santiago de Cuba', 12),
-- España (13)
('Madrid', 13),
('Barcelona', 13),
-- Francia (14)
('París', 14),
('Marsella', 14),
-- Italia (15)
('Roma', 15),
('Milán', 15),
-- Alemania (16)
('Berlín', 16),
('Múnich', 16),
-- Reino Unido (17)
('Londres', 17),
('Manchester', 17),
-- Países Bajos (18)
('Ámsterdam', 18),
('Róterdam', 18);

-- ///////////////////////////////////////////////////////////////////////////

-- Alta Aeropuertos
-- De Argentina
INSERT INTO [PP2-Aerolinea].dbo.Aeropuerto (CodigoIATA, IdCiudad, Estado, NombreAeropuerto) VALUES
('AEP', 1, 'Operativo', 'Aeroparque Jorge Newbery'),
('EZE', 2, 'Operativo', 'Aeropuerto Internacional Ministro Pistarini'),
('COR', 3, 'Operativo', 'Aeropuerto Internacional Ingeniero Ambrosio Taravella'),
('MDZ', 4, 'Operativo', 'Aeropuerto Internacional Gobernador Francisco Gabrielli'),
('ROS', 5, 'Operativo', 'Aeropuerto Internacional Islas Malvinas'),
('TUC', 6, 'Operativo', 'Aeropuerto Internacional Teniente General Benjamín Matienzo'),
('SLA', 7, 'Operativo', 'Aeropuerto Internacional Martín Miguel de Güemes'),
('MDQ', 8, 'Operativo', 'Aeropuerto Internacional Astor Piazzolla'),
('NQN', 9, 'Operativo', 'Aeropuerto Internacional Presidente Perón'),
('BRC', 10, 'Operativo', 'Aeropuerto Internacional Teniente Luis Candelaria'),
('CRD', 11, 'Emergencia', 'Aeropuerto Internacional General Enrique Mosconi'),
('JUJ', 12, 'En Mantenimiento', 'Aeropuerto Internacional Gobernador Horacio Guzmán'),
('BHI', 13, 'Operativo', 'Aeropuerto Comandante Espora'),
('RES', 14, 'Operativo', 'Aeropuerto Internacional de Resistencia'),
('RGL', 15, 'Operativo', 'Aeropuerto Internacional de Río Gallegos'),
('USH', 16, 'Operativo', 'Aeropuerto Internacional de Ushuaia Malvinas Argentinas'),
('IGR', 17, 'Operativo', 'Aeropuerto Internacional de Puerto Iguazú');

-- Otros Paises
INSERT INTO [PP2-Aerolinea].dbo.Aeropuerto (CodigoIATA, IdCiudad, Estado, NombreAeropuerto) VALUES
('GRU', 18, 'Operativo', 'Aeropuerto Internacional de São Paulo-Guarulhos'), ('GIG', 19, 'Operativo', 'Aeropuerto Internacional de Río de Janeiro-Galeão'),
('SCL', 20, 'Operativo', 'Aeropuerto Internacional Arturo Merino Benítez'), ('ANF', 21, 'Operativo', 'Aeropuerto Andrés Sabella'),
('MVD', 22, 'Operativo', 'Aeropuerto Internacional de Carrasco'), ('PDP', 23, 'Operativo', 'Aeropuerto Internacional de Punta del Este'),
('ASU', 24, 'En Mantenimiento', 'Aeropuerto Internacional Silvio Pettirossi'),('AGT', 25, 'Operativo', 'Aeropuerto Internacional Guaraní'),
('LPB', 26, 'Operativo', 'Aeropuerto Internacional El Alto'), ('VVI', 27, 'Operativo', 'Aeropuerto Internacional Viru Viru'),
('LIM', 28, 'Operativo', 'Aeropuerto Internacional Jorge Chávez'), ('CUZ', 29, 'Operativo', 'Aeropuerto Internacional Alejandro Velasco Astete'),
('BOG', 30, 'Operativo', 'Aeropuerto Internacional El Dorado'), ('MDE', 31, 'Operativo', 'Aeropuerto Internacional José María Córdova'),
('MEX', 32, 'En Mantenimiento', 'Aeropuerto Internacional de la Ciudad de México'), ('GDL', 33, 'Operativo', 'Aeropuerto Internacional de Guadalajara'),
('JFK', 34, 'Operativo', 'Aeropuerto Internacional John F. Kennedy'), ('LAX', 35, 'Operativo', 'Aeropuerto Internacional de Los Ángeles'),
('YYZ', 36, 'Emergencia', 'Aeropuerto Internacional Toronto Pearson'), ('YVR', 37, 'Operativo', 'Aeropuerto Internacional de Vancouver'),
('HAV', 38, 'Operativo', 'Aeropuerto Internacional José Martí'), ('SCU', 39, 'Operativo', 'Aeropuerto Internacional Antonio Maceo'),
('MAD', 40, 'Operativo', 'Aeropuerto Adolfo Suárez Madrid-Barajas'), ('BCN', 41, 'Operativo', 'Aeropuerto de Barcelona-El Prat'),
('CDG', 42, 'Cerrado', 'Aeropuerto Charles de Gaulle'), ('MRS', 43, 'Operativo', 'Aeropuerto de Marsella-Provenza'),
('FCO', 44, 'Operativo', 'Aeropuerto Internacional Leonardo da Vinci'), ('MXP', 45, 'Operativo', 'Aeropuerto de Milán-Malpensa'),
('BER', 46, 'Operativo', 'Aeropuerto de Berlín-Brandeburgo'), ('MUC', 47, 'Operativo', 'Aeropuerto de Múnich'),
('LHR', 48, 'Operativo', 'Aeropuerto de Londres-Heathrow'), ('MAN', 49, 'Operativo', 'Aeropuerto de Mánchester'),
('AMS', 50, 'Cerrado', 'Aeropuerto de Ámsterdam-Schiphol'), ('RTM', 51, 'Operativo', 'Aeropuerto de Róterdam-La Haya');

-- ///////////////////////////////////////////////////////////////////////////

-- Puestos Tripulantes
INSERT INTO [PP2-Aerolinea].dbo.PuestoTripulante (Puesto, Descripcion, Estado) VALUES
('Piloto', 'Responsable principal de operar la aeronave.', 1),
('Copiloto', 'Asiste al piloto y puede asumir el control si es necesario.', 1),
('Jefe de Cabina', 'Encargado del equipo de cabina y del servicio a bordo.', 1),
('Aux. de Vuelo', 'Asiste a los pasajeros y garantiza la seguridad a bordo.', 1),
('Mecánico de Vuelo', 'Supervisa y asegura el funcionamiento técnico durante el vuelo.', 1);

-- ///////////////////////////////////////////////////////////////////////////

-- Roles de Empleados con acceso al sistema 
INSERT INTO [PP2-Aerolinea].dbo.RolUsuario (NombreRol, Descripcion) VALUES
('Administrador', 'Acceso completo'),
('Operador', 'ABM Vuelos, Tripulación, Pasajeros, etc'),
('Supervisor', 'Solo acceso a reportes');

-- ///////////////////////////////////////////////////////////////////////////

-- Alta Clientes
INSERT INTO [PP2-Aerolinea].dbo.Cliente
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES
('Activo', 'Pérez', 'Juan', 'juan1@mail.com', 'DNI', '28452938', 1, 'Av. Rivadavia 123', '11-5555-0011', '1985-06-14'),
('Activo', 'González', 'Lucía', 'lucia2@mail.com', 'DNI', '33829174', 3, 'Calle Córdoba 456', '11-5555-0012', '1992-02-08'),
('Activo', 'Fernández', 'Carlos', 'carlos3@mail.com', 'DNI', '27584102', 5, 'San Martín 789', '11-5555-0013', '1989-11-20'),
('Activo', 'Rodríguez', 'Ana', 'ana4@mail.com', 'DNI', '31928465', 4, 'Av. Belgrano 234', '11-5555-0014', '1995-08-01'),
('Activo', 'López', 'Martín', 'martin5@mail.com', 'DNI', '30192845', 7, 'Mitre 890', '11-5555-0015', '1987-03-11'),
('Activo', 'Gómez', 'Julieta', 'julieta6@mail.com', 'DNI', '26789123', 1, 'Alsina 741', '11-5555-0016', '1990-09-25'),
('Activo', 'Díaz', 'Pablo', 'pablo7@mail.com', 'DNI', '31278945', 6, 'Urquiza 300', '11-5555-0017', '1988-12-14'),
('Activo', 'Sánchez', 'María', 'maria8@mail.com', 'DNI', '29837456', 10, 'Santa Fe 1290', '11-5555-0018', '1982-07-22'),
('Activo', 'Romero', 'Pedro', 'pedro9@mail.com', 'DNI', '27192845', 1, 'Av. Corrientes 555', '11-5555-0019', '1993-01-30'),
('Activo', 'Alvarez', 'Laura', 'laura10@mail.com', 'DNI', '28641928', 8, 'Lavalle 400', '11-5555-0020', '1984-05-17'),
('Activo', 'Torres', 'Leandro', 'leandro11@mail.com', 'DNI', '31428936', 1, 'España 213', '11-5555-0021', '1990-10-05'),
('Activo', 'Ramírez', 'Sofía', 'sofia12@mail.com', 'DNI', '30928174', 12, 'Catamarca 921', '11-5555-0022', '1991-04-29'),
('Activo', 'Flores', 'Jorge', 'jorge13@mail.com', 'DNI', '29738465', 13, 'Sarmiento 180', '11-5555-0023', '1983-09-12'),
('Activo', 'Acosta', 'Clara', 'clara14@mail.com', 'DNI', '31529846', 14, 'Yrigoyen 500', '11-5555-0024', '1994-12-03'),
('Activo', 'Medina', 'Lucas', 'lucas15@mail.com', 'DNI', '27283948', 15, 'Perón 842', '11-5555-0025', '1986-07-07'),
('Activo', 'Rojas', 'Valentina', 'valentina16@mail.com', 'DNI', '29182736', 16, 'Independencia 601', '11-5555-0026', '1981-02-18'),
('Activo', 'Molina', 'Iván', 'ivan17@mail.com', 'DNI', '30592841', 17, 'Maipú 314', '11-5555-0027', '1989-06-21'),
('Activo', 'Castro', 'Florencia', 'florencia18@mail.com', 'Doc. Extranjero', '928374615', 3, 'Junín 143', '11-5555-0028', '1996-03-15'),
('Bloqueado', 'Silva', 'Diego', 'diego19@mail.com', 'Doc. Extranjero', '912384759', 1, 'La Rioja 217', '11-5555-0029', '1980-08-10'),
('Bloqueado', 'Ortiz', 'Camila', 'camila20@mail.com', 'Pasaporte', '981273645', 5, 'San Luis 384', '11-5555-0030', '1983-11-03'),
('Activo', 'Navarro', 'Tomás', 'tomas21@mail.com', 'Pasaporte', '984752193', 1, 'Av. La Plata 121', '11-5555-0031', '1991-09-09');

--Alta Empleados
INSERT INTO [PP2-Aerolinea].dbo.Empleado
(Estado, Apellido, Nombre, Email, TipoDocumento, Documento, IdCiudad, Direccion, Telefono, FechaNacimiento)
VALUES
('Activo', 'Paz', 'Marcos', 'marcos1@empresa.com', 'CUIL', '20-28452938-5', 1, 'Alsina 123', '11-6000-0011', '1985-06-14'),
('Activo', 'Rey', 'Sofía', 'sofia2@empresa.com', 'CUIL', '27-33829174-8', 1, 'Av. Rivadavia 456', '11-6000-0012', '1990-04-20'),
('Activo', 'Ibarra', 'Lucas', 'lucas3@empresa.com', 'CUIL', '20-27584102-3', 1, 'Lavalle 100', '11-6000-0013', '1988-11-10'),
('Activo', 'Ruiz', 'Camila', 'camila4@empresa.com', 'CUIL', '27-31928465-6', 1, 'Maipú 400', '11-6000-0014', '1992-08-01'),
('Activo', 'Suárez', 'Tomás', 'tomas5@empresa.com', 'CUIL', '20-30192845-4', 1, 'Mitre 789', '11-6000-0015', '1987-01-11'),
('Activo', 'Herrera', 'Lucía', 'lucia6@empresa.com', 'CUIL', '27-26789123-9', 1, 'Catamarca 321', '11-6000-0016', '1993-05-25'),
('Activo', 'Aguilar', 'Diego', 'diego7@empresa.com', 'CUIL', '20-31278945-0', 1, 'Belgrano 812', '11-6000-0017', '1989-12-14'),
('Activo', 'Moreno', 'Julieta', 'julieta8@empresa.com', 'CUIL', '27-29837456-7', 1, 'Corrientes 920', '11-6000-0018', '1986-07-22'),
('Activo', 'Rivas', 'Mateo', 'mateo9@empresa.com', 'CUIL', '20-27192845-1', 1, 'Perón 159', '11-6000-0019', '1995-02-15'),
('Activo', 'Vega', 'Elena', 'elena10@empresa.com', 'CUIL', '27-28641928-2', 1, 'Viamonte 55', '11-6000-0020', '1984-03-09'),
('Activo', 'Ponce', 'Marina', 'marina11@empresa.com', 'CUIL', '27-31428936-3', 1, 'Santa Fe 1002', '11-6000-0021', '1981-10-05'),
('Activo', 'Sosa', 'Emilio', 'emilio12@empresa.com', 'CUIL', '20-30928174-5', 1, 'Yrigoyen 1100', '11-6000-0022', '1991-04-29'),
('Activo', 'Peralta', 'Valeria', 'valeria13@empresa.com', 'CUIL', '27-29738465-8', 1, 'La Pampa 180', '11-6000-0023', '1983-09-12'),
('Licencia', 'Maldonado', 'Bruno', 'bruno14@empresa.com', 'CUIL', '20-31529846-6', 1, 'Callao 500', '11-6000-0024', '1987-12-03'),
('Activo', 'Castillo', 'Martina', 'martina15@empresa.com', 'CUIL', '27-27283948-4', 3, 'Córdoba 420', '11-6000-0025', '1986-07-07'),
('Activo', 'Figueroa', 'Iván', 'ivan16@empresa.com', 'CUIL', '20-29182736-0', 5, 'Santiago 601', '11-6000-0026', '1981-02-18'),
('Activo', 'Ojeda', 'Florencia', 'florencia17@empresa.com', 'CUIL', '27-30592841-1', 8, 'Neuquén 314', '11-6000-0027', '1989-06-21'),
('Activo', 'Campos', 'Ramiro', 'ramiro18@empresa.com', 'CUIL', '20-928374615-2', 11, 'Jujuy 143', '11-6000-0028', '1996-03-15'),
('Licencia', 'Ferreyra', 'Paula', 'paula19@empresa.com', 'CUIL', '27-912384759-1', 14, 'Chaco 217', '11-6000-0029', '1980-08-10'),
('Activo', 'Miranda', 'Agustina', 'agustina20@empresa.com', 'CUIL', '27-984752193-7', 16, 'Tierra del Fuego 384', '11-6000-0030', '1983-11-03');

-- ///////////////////////////////////////////////////////////////////////////

-- Alta Usuarios deñ sistema
INSERT INTO [PP2-Aerolinea].dbo.UsuarioEmpresa
(UserName, Password, Email, UltimoLogin, UltimoCambioPass, IdRolUsuario, Estado)
VALUES
('admin1', 'admin123', 'admin1@empresa.com', '2025-05-10 08:15:00', '2025-04-01 10:00:00', 1, 'Activo'),
('admin2', 'admin456', 'admin2@empresa.com', '2025-05-09 09:25:00', '2025-03-28 09:30:00', 1, 'Bloqueado'),
('operador1', 'operador123', 'operador1@empresa.com', '2025-05-08 11:40:00', '2025-04-10 11:00:00', 2, 'Activo'),
('operador2', 'operador456', 'operador2@empresa.com', '2025-05-07 14:05:00', '2025-04-15 14:10:00', 2, 'Activo'),
('supervisor1', 'super123', 'supervisor1@empresa.com', '2025-05-06 15:30:00', '2025-04-05 08:20:00', 3, 'Bloqueado'),
('supervisor2', 'super456', 'supervisor2@empresa.com', '2025-05-05 17:00:00', '2025-04-12 16:00:00', 3, 'Activo');

