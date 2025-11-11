-- ---
-- 1. Estructura de la Tabla de Festivales (Mantenida como solicitaste)
-- List<String> -> text[] | country -> ISO-2
-- ---

CREATE TABLE IF NOT EXISTS festivales (
    id SERIAL PRIMARY KEY,  -- ID único
    name  VARCHAR(255) NOT NULL UNIQUE,  -- Nombre del festival
    city  VARCHAR(100) NOT NULL,  -- Ciudad de celebración
    country VARCHAR(2) NOT NULL, -- País (ISO-2)
    date DATE  NOT NULL,  -- Fecha de inicio (Columna original)
    genres  TEXT[]  DEFAULT '{}' -- Géneros musicales principales
);

-- ---
-- 2. Índices (Se mantienen, aunque algunos ya no son útiles para esta estructura simple)
-- ---

CREATE INDEX IF NOT EXISTS idx_festivales_country ON festivales (country);
-- Nota: 'idx_festivales_start_date' se referirá a 'date' en algunos SGBD, 
-- pero se mantiene el nombre original del índice para ser fiel al código previo.
CREATE INDEX IF NOT EXISTS idx_festivales_genres_gin ON festivales USING GIN (genres);


-- ---
-- 3. Inserción de Datos de Ejemplo (Atributos sobrantes eliminados)
-- Se insertan solo: name, city, country, date, genres
-- ---

INSERT INTO festivales (name, city, country, date, genres) VALUES
(
    'Primavera Sound Barcelona', 
    'Barcelona', 
    'ES', 
    '2025-05-28', 
    ARRAY['Alternative', 'Pop', 'Electronic']::TEXT[]
),
(
    'Glastonbury Festival', 
    'Pilton', 
    'GB', 
    '2025-06-25', 
    ARRAY['Rock', 'Pop', 'Dance']::TEXT[]
),
(
    'Coachella Valley Music and Arts Festival', 
    'Indio', 
    'US', 
    '2025-04-11', 
    ARRAY['Pop', 'Hip Hop', 'Electronic']::TEXT[]
),
(
    'Tomorrowland', 
    'Boom', 
    'BE', 
    '2025-07-18', 
    ARRAY['EDM', 'House', 'Trance']::TEXT[]
),
(
    'Lollapalooza Chicago', 
    'Chicago', 
    'US', 
    '2025-07-31', 
    ARRAY['Alternative', 'Rock', 'Pop']::TEXT[]
),
(
    'Mad Cool Festival', 
    'Madrid', 
    'ES', 
    '2025-07-10', 
    ARRAY['Rock', 'Pop', 'Indie']::TEXT[]
),
(
    'Rock in Rio', 
    'Rio de Janeiro', 
    'BR', 
    '2025-09-13', 
    ARRAY['Rock', 'Pop', 'Latin']::TEXT[]
),
(
    'Sónar Barcelona', 
    'Barcelona', 
    'ES', 
    '2025-06-19', 
    ARRAY['Electronic', 'Experimental']::TEXT[]
);