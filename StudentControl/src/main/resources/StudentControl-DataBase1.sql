CREATE DATABASE `studentcontrol1` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `alumno` (
  `IdAlumno` varchar(35) NOT NULL,
  `PNombre` varchar(35) NOT NULL,
  `SNombre` varchar(35) DEFAULT NULL,
  `TNombre` varchar(35) DEFAULT NULL,
  `PApellido` varchar(35) NOT NULL,
  `SApellido` varchar(35) DEFAULT NULL,
  `Direccion` varchar(70) DEFAULT '('''')',
  `FechaNacimiento` date NOT NULL,
  `Sexo` varchar(35) NOT NULL,
  `Padre` varchar(35) DEFAULT NULL,
  `Madre` varchar(35) DEFAULT NULL,
  `Encargado` varchar(35) NOT NULL,
  `DPI` int(15) NOT NULL,
  `DireccionEmpleo` varchar(70) NOT NULL,
  `TelefonoEncargado` int(8) NOT NULL,
  `TelefonoEmpleo` int(8) DEFAULT NULL,
  `FechaIngreso` date NOT NULL,
  `Grado` int(11) NOT NULL,
  `Religion` varchar(25) DEFAULT NULL,
  `Mensualidad` double DEFAULT NULL,
  `RNombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdAlumno`),
  KEY `Grado` (`Grado`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`Grado`) REFERENCES `grado` (`IdGrado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `empleado` (
  `IdEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `PNombre` varchar(35) NOT NULL,
  `SNombre` varchar(35) DEFAULT NULL,
  `TNombre` varchar(35) DEFAULT NULL,
  `PApellido` varchar(35) NOT NULL,
  `SApellido` varchar(35) DEFAULT NULL,
  `CApellido` varchar(35) DEFAULT NULL,
  `Direccion` varchar(150) NOT NULL,
  `Telefono` varchar(35) NOT NULL,
  `email` varchar(35) DEFAULT NULL,
  `FechaNacimiento` date NOT NULL,
  `DPI` varchar(35) NOT NULL,
  `EstadoCivil` varchar(20) DEFAULT NULL,
  `Nacionalidad` varchar(20) DEFAULT NULL,
  `Puesto` int(11) DEFAULT NULL,
  `ServidorEmail` varchar(45) NOT NULL,
  PRIMARY KEY (`IdEmpleado`),
  KEY `Puesto` (`Puesto`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`Puesto`) REFERENCES `puesto` (`IdPuesto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `grado` (
  `IdGrado` int(11) NOT NULL AUTO_INCREMENT,
  `Grado` varchar(10) DEFAULT NULL,
  `Nivel` int(11) NOT NULL,
  `Seccion` varchar(10) DEFAULT NULL,
  `Jornada` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdGrado`),
  KEY `Jornada` (`Jornada`),
  KEY `Nivel` (`Nivel`),
  CONSTRAINT `grado_ibfk_1` FOREIGN KEY (`Jornada`) REFERENCES `jornada` (`IdJornada`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grado_ibfk_2` FOREIGN KEY (`Nivel`) REFERENCES `nivel` (`IdNivel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `jornada` (
  `IdJornada` int(11) NOT NULL AUTO_INCREMENT,
  `Jornada` varchar(25) NOT NULL,
  PRIMARY KEY (`IdJornada`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `materia` (
  `IdMateria` int(11) NOT NULL,
  `Materia` varchar(25) NOT NULL,
  `Grado` int(11) NOT NULL,
  PRIMARY KEY (`IdMateria`),
  KEY `Grado` (`Grado`),
  CONSTRAINT `materia_ibfk_1` FOREIGN KEY (`Grado`) REFERENCES `grado` (`IdGrado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `nivel` (
  `IdNivel` int(11) NOT NULL AUTO_INCREMENT,
  `Nivel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdNivel`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Producto` varchar(45) NOT NULL,
  `Precio` double NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `puesto` (
  `IdPuesto` int(11) NOT NULL AUTO_INCREMENT,
  `Puesto` varchar(34) NOT NULL,
  PRIMARY KEY (`IdPuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `recibo` (
  `idRecibo` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` varchar(7) NOT NULL,
  `Mes` varchar(15) NOT NULL,
  `Colegiatura` int(11) NOT NULL,
  `FECHA` datetime NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idRecibo`),
  KEY `rec_idx` (`idAlumno`),
  KEY `emp_idx` (`idEmpleado`),
  CONSTRAINT `rec` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`IdAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `emp` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `recuperacion` (
  `IdRecuperacion` int(11) NOT NULL AUTO_INCREMENT,
  `Alumno` varchar(10) NOT NULL,
  `Grado` int(11) NOT NULL,
  `Materia` int(11) NOT NULL,
  `Recuperacion` double NOT NULL,
  `Año` year(4) NOT NULL,
  PRIMARY KEY (`IdRecuperacion`),
  KEY `Alumno` (`Alumno`),
  KEY `Grado` (`Grado`),
  KEY `Materia` (`Materia`),
  CONSTRAINT `recuperacion_ibfk_1` FOREIGN KEY (`Alumno`) REFERENCES `alumno` (`IdAlumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recuperacion_ibfk_2` FOREIGN KEY (`Grado`) REFERENCES `grado` (`IdGrado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recuperacion_ibfk_3` FOREIGN KEY (`Materia`) REFERENCES `materia` (`IdMateria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `unidad` (
  `IdUnidad` int(11) NOT NULL AUTO_INCREMENT,
  `Unidad` varchar(70) NOT NULL,
  PRIMARY KEY (`IdUnidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `ventas` (
  `idVentas` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` varchar(7),
  `Total` double NOT NULL,
  `Fecha` datetime NOT NULL,
  PRIMARY KEY (`idVentas`),
  KEY `alumn_idx` (`idAlumno`),
  CONSTRAINT `alumn` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`IdAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `concepto` (
  `idConcepto` int(11) NOT NULL AUTO_INCREMENT,
  `IdVenta` int(11) not null,
  `idProducto` int(11) not null,
  `Cantidad` int(11) not null,
  PRIMARY KEY (`idConcepto`),
  KEY `prod_idx` (`idProducto`),
  Key `venta_idx` (`IdVenta`),
  CONSTRAINT `Venta` FOREIGN KEY(`IdVenta`) references `ventas`(`idVentas`) on delete cascade on update cascade,
  CONSTRAINT `prod` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE asignacion(
	IdAsignacion int primary key auto_increment,
    Maestro int not null,
    Materia int not null,
    Ciclo year,
    FechaAsignacion date,
    Foreign key (Maestro) references empleado(IdEmpleado) on delete cascade on update cascade,
    Foreign key (Materia) references materia(IdMateria) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `cycsyste_studentcontrol1`.`nota` (
  `IdNota` INT NOT NULL AUTO_INCREMENT,
  `Estudiante` VARCHAR(35) NOT NULL,
  `Unidad` INT NOT NULL,
  `Zona` DOUBLE NOT NULL,
  `Examen` DOUBLE NOT NULL,
  `Total` DOUBLE NOT NULL,
  `Materia` INT NOT NULL,
  PRIMARY KEY (`IdNota`),
  INDEX `Alumno_idx` (`Estudiante` ASC),
  INDEX `Unidad_idx` (`Unidad` ASC),
  INDEX `Materia_idx` (`Materia` ASC),
  CONSTRAINT `Alumno`
    FOREIGN KEY (`Estudiante`)
    REFERENCES `cycsyste_studentcontrol1`.`alumno` (`IdAlumno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Unidad`
    FOREIGN KEY (`Unidad`)
    REFERENCES `cycsyste_studentcontrol1`.`unidad` (`IdUnidad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Materia`
    FOREIGN KEY (`Materia`)
    REFERENCES `cycsyste_studentcontrol1`.`materia` (`IdMateria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8













