-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2026 a las 00:28:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `donaton_beneficiarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beneficiarios`
--

CREATE TABLE `beneficiarios` (
                                 `id_beneficiario` int(11) NOT NULL,
                                 `nombre` varchar(100) NOT NULL,
                                 `rut` varchar(8) NOT NULL,
                                 `telefono` int(9) NOT NULL,
                                 `id_comuna` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `beneficiarios`
--
ALTER TABLE `beneficiarios`
    ADD PRIMARY KEY (`id_beneficiario`),
  ADD KEY `id_comuna` (`id_comuna`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `beneficiarios`
--
ALTER TABLE `beneficiarios`
    MODIFY `id_beneficiario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Filtros para la tabla `beneficiarios`
--
ALTER TABLE `beneficiarios`
    ADD CONSTRAINT `beneficiarios_ibfk_1` FOREIGN KEY (`id_comuna`) REFERENCES `comuna` (`id_comuna`) ON DELETE CASCADE ON UPDATE CASCADE;


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
