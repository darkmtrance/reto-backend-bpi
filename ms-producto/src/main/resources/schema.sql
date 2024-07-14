CREATE TABLE IF NOT EXISTS productos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipoproducto VARCHAR(255) NOT NULL,
    nombreproducto VARCHAR(255) NOT NULL,
    saldo DECIMAL(19, 2),
    clienteid BIGINT
);