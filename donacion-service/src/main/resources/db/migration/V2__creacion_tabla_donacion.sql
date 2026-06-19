
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `donaton_donacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donacion`
--

CREATE TABLE `donacion` (
                            `id_donacion` int(11) NOT NULL,
                            `descripcion` varchar(150) NOT NULL,
                            `cantidad` int(9) NOT NULL,
                            `fecha_donacion` date NOT NULL,
                            `estado` tinyint(1) NOT NULL,
                            `id_usuario` int(11) NOT NULL,
                            `id_tipo` int(11) NOT NULL,
                            `id_centro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `donacion`
--
ALTER TABLE `donacion`
    ADD PRIMARY KEY (`id_donacion`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `donacion`
--
ALTER TABLE `donacion`
    MODIFY `id_donacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `donacion`
    ADD CONSTRAINT `donacion_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_donacion` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
