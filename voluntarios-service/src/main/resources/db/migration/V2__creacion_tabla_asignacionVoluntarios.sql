-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2026 a las 00:47:02
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
-- Base de datos: `donaton_voluntarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones_voluntarios`
--

CREATE TABLE `asignaciones_voluntarios` (
                                            `id_asignacion` int(11) NOT NULL,
                                            `id_voluntario` int(11) NOT NULL,
                                            `id_emergencia` int(11) NOT NULL,
                                            `tarea` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignaciones_voluntarios`
--
ALTER TABLE `asignaciones_voluntarios`
    ADD PRIMARY KEY (`id_asignacion`),
  ADD KEY `id_voluntario` (`id_voluntario`);


--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignaciones_voluntarios`
--
ALTER TABLE `asignaciones_voluntarios`
    MODIFY `id_asignacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


ALTER TABLE `asignaciones_voluntarios`
    ADD CONSTRAINT `asignaciones_voluntarios_ibfk_1` FOREIGN KEY (`id_voluntario`) REFERENCES `voluntarios` (`id_voluntario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
