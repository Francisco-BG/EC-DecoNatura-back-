USE deconatura;
-- productos
INSERT INTO producto(nombre,precio,descripcion,stock,imagen,categoria,subcategoria)
VALUES	
	('Maceta en forma de conejo',100.50,'Esta macetita te quiere mucho, cómprala por favor.',36,'https://res.cloudinary.com/dgtrdgsgg/image/upload/v1676585219/images/otros/oriento-GLe--6F1Up4-unsplash_drq8c5.jpg','Plantas de ornato','Maceta'),
    ('Figura ave',1999.99,'¡¡Compra compra compra!!',5,'https://res.cloudinary.com/dgtrdgsgg/image/upload/v1676585221/images/otros/oriento-0dg-EfHgA8Q-unsplash_c8l5cp.jpg','Decoracion','Figuras'),
    ('Maceta en forma de caracol',300,'Esta maceta no se comerá tus plantas.',15,'https://res.cloudinary.com/dgtrdgsgg/image/upload/v1676585231/images/otros/victor-collados-U3YWF2n_q-M-unsplash_gmcpkp.jpg','Plantas de ornato','Maceta'),
    ('Arreglo de suculentas',1349.90,'Hermosas plantitas, ¿quién no querría unas?',3,'https://res.cloudinary.com/dgtrdgsgg/image/upload/v1676585253/images/otros/katie-burkhart-REk6cxrceoQ-unsplash_hl2yg4.jpg','Plantas de ornato','Suculentas'),
    ('Maceta en forma de gato',500,'Como un gato, pero menos desastroso. ¡Ah! Y solo tiene una vida.',66,'https://res.cloudinary.com/dgtrdgsgg/image/upload/v1676585242/images/otros/art-and-soil-bangalore-I5ofzP2nICE-unsplash_d4izgw.jpg','Plantas de ornato','Maceta');
-- clientes
INSERT INTO cliente(nombre,apellido,telefono,email,carrito_idcarrito)
VALUES 
	('Pax','Bet','5556717444','mr.pax@hotmail.com',1),
	('Jessica','García','5509830938','jess@generation.mx',2),
    ('Gabriel Eduardo','Sevilla','3309239852','ged@generation.mx',3),
    ('Eduardo','Hernández','5509810932','eduhdz@generation.mx',4),
    ('Victoria','Bolaños','7710986843','victoriamexa@gen.mx',5);

-- paqueteria
INSERT INTO paqueteria(nombre)
VALUES ('estafeta'),('DHL'),('ups'),('Correos de México');
SELECT * FROM paqueteria;

-- orden status
INSERT INTO `orden status`(`orden status`)
VALUES ('Pagado'),('Enviado'),('Entregado');
SELECT * FROM `orden status`;

INSERT INTO envio(`numero de pedido`,direccion,`codigo postal`,estado,municipio,`precio de envio`,paqueteria_idpaqueteria)
VALUES 
	(1,'San Ig. 19','14370','CDMX','Tlalpan',500.90,3),
	(2,'Pedrogas St. 77','50294','Estado de México','Toluca',420.65,1),
    (3,'Av siempreviva 7','50294','Estado de México','Toluca',1220.32,1),
    (4,'Av Reforma 277','2345','CDMX','Toluca',120.22,1),
    (5,'San Juan de Dios 343','14370','CDMX','Tlalpan',160.00,1);

SELECT * FROM producto;
SELECT * FROM cliente;
SELECT * FROM carrito;
SELECT * FROM carrito_has_producto;
SELECT * FROM orden;
SELECT * FROM `orden status`;
SELECT * FROM envio;
SELECT * FROM paqueteria;
