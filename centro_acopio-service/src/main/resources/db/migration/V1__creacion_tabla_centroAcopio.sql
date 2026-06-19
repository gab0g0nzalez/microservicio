
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `donaton_centro_acopio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centro_acopio`
--

CREATE TABLE `centro_acopio` (
                                 `id` int(11) NOT NULL,

                                 `nombre` VARCHAR(100) NOT NULL,

                                 `direccion` VARCHAR(200),

                                 `ciudad` VARCHAR(100),

                                 `capacidad` INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centro_acopio`
--
ALTER TABLE `centro_acopio`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centro_acopio`
--
ALTER TABLE `centro_acopio`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
