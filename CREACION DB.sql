-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-07-2024 a las 18:46:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `supermercado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `Id_Cargo` int(11) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--
USE SUPERMERCADO;
CREATE TABLE `cliente` (
  `id_Cliente` int(11) NOT NULL,
  `identificacion` int(11) NOT NULL,
  `id_Tipo_Identificacion` int(11) NOT NULL,
  `nombre_1` varchar(30) NOT NULL,
  `nombre_2` varchar(30) DEFAULT NULL,
  `apellido_1` varchar(30) NOT NULL,
  `apellido_2` varchar(30) DEFAULT NULL,
  `domicilio` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `estado` bit(1) NOT NULL,
  `fecha_Registro` datetime NOT NULL
);

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_Cliente`, `identificacion`, `id_Tipo_Identificacion`, `nombre_1`, `nombre_2`, `apellido_1`, `apellido_2`, `domicilio`, `telefono`, `email`, `estado`, `fecha_Registro`) VALUES
(2, 111, 1, 'semana', NULL, 'dos', NULL, 'calle falsa', '3108089161', 'mail@mail.com', b'1', '2024-07-28 16:51:46'),
(3, 76, 1, 'ddd', 'ggg', 'dd', 'ddd', '3333', '55', 'mail@mail.com', b'0', '2024-07-28 00:00:00'),
(4, 6666, 1, 'kjkj', 'kjhkjh', 'iuyiu', 'kjhj', '333333', '319909', 'mail.@gmail.com', b'0', '2024-07-28 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `Id_Tipo_Documento` int(11) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`Id_Tipo_Documento`, `Descripcion`, `Estado`) VALUES
(1, 'cc', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` int(11) NOT NULL,
  `Identificacion` int(11) NOT NULL,
  `Id_Tipo_Identificacion` int(11) NOT NULL,
  `Id_Cargo` int(11) NOT NULL,
  `Nombre_1` varchar(30) NOT NULL,
  `Nombre_2` varchar(30) DEFAULT NULL,
  `Apellido_1` varchar(30) NOT NULL,
  `Apellido_2` varchar(30) DEFAULT NULL,
  `Domicilio` varchar(100) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Estado` bit(1) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Fecha_Registro` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`Id_Cargo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_Cliente`),
  ADD KEY `FK_Cliente_TipoDocumento` (`id_Tipo_Identificacion`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`Id_Tipo_Documento`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`),
  ADD KEY `FK_Usuario_TipoDocumento` (`Id_Tipo_Identificacion`),
  ADD KEY `FK_Usuario_Cargo` (`Id_Cargo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `Id_Cargo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `Id_Tipo_Documento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_Cliente_TipoDocumento` FOREIGN KEY (`Id_Tipo_Identificacion`) REFERENCES `tipo_documento` (`Id_Tipo_Documento`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_Usuario_Cargo` FOREIGN KEY (`Id_Cargo`) REFERENCES `cargo` (`Id_Cargo`),
  ADD CONSTRAINT `FK_Usuario_TipoDocumento` FOREIGN KEY (`Id_Tipo_Identificacion`) REFERENCES `tipo_documento` (`Id_Tipo_Documento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
