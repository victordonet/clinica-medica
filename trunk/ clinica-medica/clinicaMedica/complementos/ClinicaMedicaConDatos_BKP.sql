-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.87-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema clinicamedica
--

CREATE DATABASE IF NOT EXISTS clinicamedica;
USE clinicamedica;

--
-- Definition of table `administrativos`
--

DROP TABLE IF EXISTS `administrativos`;
CREATE TABLE `administrativos` (
  `ID` varchar(30) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `IDCARGO` decimal(2,0) NOT NULL,
  `ESTADO` varchar(1) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrativos`
--

/*!40000 ALTER TABLE `administrativos` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrativos` ENABLE KEYS */;


--
-- Definition of table `afiliados`
--

DROP TABLE IF EXISTS `afiliados`;
CREATE TABLE `afiliados` (
  `ID` varchar(10) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDO` varchar(20) NOT NULL,
  `CI` varchar(8) NOT NULL,
  `MAIL` varchar(50) default ' ',
  `DIRECCION` varchar(50) default ' ',
  `TELEFONO` varchar(50) NOT NULL,
  `FECHAINGRESO` date NOT NULL,
  `FONASA` varchar(1) NOT NULL,
  `ESTADO` varchar(1) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `afiliados`
--

/*!40000 ALTER TABLE `afiliados` DISABLE KEYS */;
INSERT INTO `afiliados` (`ID`,`NOMBRE`,`APELLIDO`,`CI`,`MAIL`,`DIRECCION`,`TELEFONO`,`FECHAINGRESO`,`FONASA`,`ESTADO`) VALUES 
 ('1001','PedroModif','ApellidoMod','1001','pj@gmail.com','Soca 1234','26199911','2009-12-31','0','I');
/*!40000 ALTER TABLE `afiliados` ENABLE KEYS */;


--
-- Definition of table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
CREATE TABLE `cargos` (
  `ID` decimal(2,0) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cargos`
--

/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` (`ID`,`DESCRIPCION`) VALUES 
 ('1','Gerente'),
 ('2','Administrador'),
 ('3','Cajero');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;


--
-- Definition of table `consultas`
--

DROP TABLE IF EXISTS `consultas`;
CREATE TABLE `consultas` (
  `IDMEDICO` decimal(10,0) NOT NULL,
  `IDAFILIADO` decimal(10,0) NOT NULL,
  `FECHA` date NOT NULL,
  `DIA` varchar(2) NOT NULL,
  `IDCONSULTORIO` decimal(2,0) NOT NULL,
  `TURNO` decimal(2,0) NOT NULL,
  `HORARIO` decimal(2,0) NOT NULL,
  `TIMBRE` varchar(1) NOT NULL,
  PRIMARY KEY  (`IDMEDICO`,`IDAFILIADO`,`FECHA`,`TURNO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consultas`
--

/*!40000 ALTER TABLE `consultas` DISABLE KEYS */;
INSERT INTO `consultas` (`IDMEDICO`,`IDAFILIADO`,`FECHA`,`DIA`,`IDCONSULTORIO`,`TURNO`,`HORARIO`,`TIMBRE`) VALUES 
 ('12341','1001','2010-03-20','4','3','2','12','0');
/*!40000 ALTER TABLE `consultas` ENABLE KEYS */;


--
-- Definition of table `consultorios`
--

DROP TABLE IF EXISTS `consultorios`;
CREATE TABLE `consultorios` (
  `ID` decimal(2,0) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consultorios`
--

/*!40000 ALTER TABLE `consultorios` DISABLE KEYS */;
INSERT INTO `consultorios` (`ID`,`NOMBRE`) VALUES 
 ('1','Figari'),
 ('2','Cuneo'),
 ('3','Barradas'),
 ('4','Torres Garcia'),
 ('5','Blanes');
/*!40000 ALTER TABLE `consultorios` ENABLE KEYS */;


--
-- Definition of table `disponibilidad`
--

DROP TABLE IF EXISTS `disponibilidad`;
CREATE TABLE `disponibilidad` (
  `IDMEDICO` decimal(10,0) NOT NULL,
  `DIA` varchar(2) NOT NULL,
  `HORARIO` decimal(2,0) NOT NULL,
  PRIMARY KEY  (`IDMEDICO`,`DIA`,`HORARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disponibilidad`
--

/*!40000 ALTER TABLE `disponibilidad` DISABLE KEYS */;
INSERT INTO `disponibilidad` (`IDMEDICO`,`DIA`,`HORARIO`) VALUES 
 ('1234','2','10'),
 ('1234','4','12'),
 ('1234','6','18');
/*!40000 ALTER TABLE `disponibilidad` ENABLE KEYS */;


--
-- Definition of table `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
CREATE TABLE `especialidades` (
  `ID` decimal(3,0) NOT NULL,
  `DESCRIPCION` varchar(40) NOT NULL,
  `MONTOBASE` decimal(15,2) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `especialidades`
--

/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` (`ID`,`DESCRIPCION`,`MONTOBASE`) VALUES 
 ('1','Medicina General','300.00'),
 ('4','Traumatoogia','200.00'),
 ('5','Oftalmologia','170.00');
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;


--
-- Definition of table `examenes`
--

DROP TABLE IF EXISTS `examenes`;
CREATE TABLE `examenes` (
  `IDAFILIADO` decimal(10,0) NOT NULL,
  `FECHAINICIO` date NOT NULL,
  `IDTIPOEXAMEN` decimal(3,0) NOT NULL,
  `ENVIAMAIL` varchar(1) NOT NULL,
  `COBRATIMBRE` varchar(1) NOT NULL,
  `FECHARESULTADO` date default NULL,
  PRIMARY KEY  (`IDAFILIADO`,`FECHAINICIO`,`IDTIPOEXAMEN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examenes`
--

/*!40000 ALTER TABLE `examenes` DISABLE KEYS */;
INSERT INTO `examenes` (`IDAFILIADO`,`FECHAINICIO`,`IDTIPOEXAMEN`,`ENVIAMAIL`,`COBRATIMBRE`,`FECHARESULTADO`) VALUES 
 ('1001','2010-03-20','1','1','1',NULL);
/*!40000 ALTER TABLE `examenes` ENABLE KEYS */;


--
-- Definition of table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
CREATE TABLE `medicos` (
  `ID` varchar(10) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDO` varchar(20) NOT NULL,
  `CI` varchar(8) NOT NULL,
  `TELEFONO` varchar(50) NOT NULL,
  `IDESPECIALIDAD` decimal(3,0) NOT NULL,
  `ESTADO` varchar(1) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicos`
--

/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` (`ID`,`NOMBRE`,`APELLIDO`,`CI`,`TELEFONO`,`IDESPECIALIDAD`,`ESTADO`) VALUES 
 ('1234','Jose Maria','Prociutto','17863574','24860101','4','A'),
 ('4567','Jose','Castro','19358516','24863278','1','I');
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;


--
-- Definition of table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
CREATE TABLE `parametros` (
  `PARAMETRO` varchar(50) NOT NULL,
  `VALOR` varchar(50) NOT NULL,
  PRIMARY KEY  (`PARAMETRO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parametros`
--

/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` (`PARAMETRO`,`VALOR`) VALUES 
 ('ValorTimbre','80');
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;


--
-- Definition of table `tipoexamenes`
--

DROP TABLE IF EXISTS `tipoexamenes`;
CREATE TABLE `tipoexamenes` (
  `ID` decimal(3,0) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipoexamenes`
--

/*!40000 ALTER TABLE `tipoexamenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoexamenes` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `ID` varchar(30) NOT NULL,
  `CONTRASENA` varchar(50) character set latin1 collate latin1_bin NOT NULL,
  `TIPO` varchar(2) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`ID`,`CONTRASENA`,`TIPO`) VALUES 
 ('1001',0x3831646339626462353264303464633230303336646264383331336564303535,'AF'),
 ('1234',0x3831646339626462353264303464633230303336646264383331336564303535,'ME'),
 ('4567',0x3831646339626462353264303464633230303336646264383331336564303535,'ME'),
 ('FMARTINEZ',0x3831646339626462353264303464633230303336646264383331336564303535,'AD');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
