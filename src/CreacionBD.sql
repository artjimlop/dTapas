/*MODELO FISICO:
--------------*/

/*DROPS
--------*/
DROP TABLE if exists usercomments;
DROP TABLE if exists taparoutecomments;
DROP TABLE if exists establishmentcomments;
DROP TABLE if exists productcomments;
DROP TABLE if exists comments;
DROP TABLE if exists taparouteestablishments;
DROP TABLE if exists taparouteusers;
DROP TABLE if exists taparoutes;
DROP TABLE if exists establishmentscores;
DROP TABLE if exists productscores;
DROP TABLE if exists others;
DROP TABLE if exists wines;
DROP TABLE if exists beers;
DROP TABLE if exists meals;
DROP TABLE if exists products;
DROP TABLE if exists establishments;
DROP TABLE if exists followers;
DROP TABLE if exists users;


/*Users: 
-------------------- */

CREATE TABLE users (

	name			VARCHAR(50) NOT NULL,
	surnames		VARCHAR(150) NOT NULL,
	login			VARCHAR(15) NOT NULL UNIQUE,
	password		VARCHAR(31) NOT NULL,
	email			VARCHAR(100) NOT NULL UNIQUE,
	registryDate		DATE NOT NULL,
	USOID			VARCHAR(64) PRIMARY KEY
);

/*Seguidores: 
------------------- */


CREATE TABLE followers(

	FOLLOWOID		VARCHAR(64) PRIMARY KEY,
	FK_USEROID		VARCHAR(64) NOT NULL,
	FK_FOLLOWEDOID		VARCHAR(64) NOT NULL,
	UNIQUE(FK_USEROID,FK_FOLLOWEDOID),
	FOREIGN KEY (FK_USEROID) 	REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_FOLLOWEDOID) REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE	
);
		
	

/*ESTABLECIEMIENTO:
-------------------*/

CREATE TABLE establishments(

		
	nameEstablishment	VARCHAR(50) NOT NULL,
	city			VARCHAR(50) NOT NULL,
	province		VARCHAR(50) NOT NULL,
	zone			VARCHAR(50) NOT NULL,
	street			VARCHAR(50),
	zipCode			NUMERIC(5),
	registryDate		DATE NOT NULL,
	ESTOID			VARCHAR(64) PRIMARY KEY,
	establishmentID		INT NOT NULL,
	FK_USOID		VARCHAR(64),
	FOREIGN KEY (FK_USOID) 	REFERENCES users(USOID) ON DELETE SET NULL

);

	
/*PRODUCTO:
-------------------*/

CREATE TABLE products(
		
	productName		VARCHAR(50) NOT NULL,
	registryDate		DATE NOT NULL,
	price			NUMERIC(5,2) NOT NULL CHECK (precio>0),
	PRODOID			VARCHAR(64) PRIMARY KEY,
	FK_USOID		VARCHAR(64),
	FK_ESTOID		VARCHAR(64) NOT NULL,
	productID		INT NOT NULL ,
	FOREIGN KEY (FK_USOID) 	REFERENCES users(USOID) ON DELETE SET NULL,
	FOREIGN KEY (FK_ESTOID) REFERENCES establishments(ESTOID) ON DELETE CASCADE ON UPDATE CASCADE
);

/*Comida: falla el  NOT NULL CHECK (tipo IN('Tapa','Ración','1/2 Ración','Plato','Postre'))
-------------------*/


CREATE TABLE meals(
		
	type			VARCHAR(20),
	MEALOID			VARCHAR(64) PRIMARY KEY,
	FK_PRODOID		VARCHAR(64) NOT NULL,
	foodID			INT NOT NULL ,
	FOREIGN KEY (FK_PRODOID) REFERENCES products(PRODOID) ON DELETE CASCADE ON UPDATE CASCADE
);

/*Cerveza:
-------------------*/


CREATE TABLE beers(
		
	size			VARCHAR(20) NOT NULL,
	label			VARCHAR(20) NOT NULL,
	colour			VARCHAR(20) NOT NULL,
	temperature		VARCHAR(20) NOT NULL,
	BEEROID			VARCHAR(64) PRIMARY KEY,
	beerID			INT NOT NULL ,
	FK_PRODOID		VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_PRODOID) REFERENCES products(PRODOID) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Vino:
-------------------*/


CREATE TABLE wines(
		
	type			VARCHAR(20) NOT NULL,
	od			VARCHAR(20) NOT NULL,
	year			NUMERIC(4),
	growUpTime		VARCHAR(20) CHECK (growUpTime IN('Joven','Crianza','Reserva','Gran Reserva',NULL)),
	label			VARCHAR(20),
	WINEOID			VARCHAR(64) PRIMARY KEY,
	wineID			INT NOT NULL ,
	FK_PRODOID		VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_PRODOID) REFERENCES products(PRODOID) ON DELETE CASCADE ON UPDATE CASCADE
);

/*OTROS:
-------------------*/


CREATE TABLE others(
	
	size			VARCHAR(20) NOT NULL,	
	type			VARCHAR(20) NOT NULL,
	OTHEROID		VARCHAR(64) PRIMARY KEY,
	otherID			INT NOT NULL ,
	FK_PRODOID		VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_PRODOID) REFERENCES products(PRODOID) ON DELETE CASCADE ON UPDATE CASCADE
);

/*PRODUCTO-PUNTUACION:
----------------------*/


CREATE TABLE productscores (

	mediumScore		 NUMERIC(3,1) NOT NULL CHECK (mediumScore BETWEEN 0 AND 10),
	presentationScore	 NUMERIC(3,1) NOT NULL CHECK (presentationScore BETWEEN 0 AND 10),
	quantityScore		 NUMERIC(3,1) NOT NULL CHECK (quantityScore BETWEEN 0 AND 10),
	priceScore		 NUMERIC(3,1) NOT NULL CHECK (priceScore BETWEEN 0 AND 10),
	scoreDate		 DATE NOT NULL,
	scoreTime		 TIME NOT NULL,
	PRODSCOREOID		 VARCHAR(64) PRIMARY KEY,
	productScoreID		 INT NOT NULL ,
	FK_USOID		 VARCHAR(64) NOT NULL,
 	FK_PRODOID		 VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_USOID)   REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_PRODOID) REFERENCES products(PRODOID) ON DELETE CASCADE ON UPDATE CASCADE
	
);

/*Establishments-PUNTUACION:  FALLA EL  NOT NULL CHECK (notaServicio BETWEEN 0 AND 10)                  
------------------------------*/


CREATE TABLE establishmentscores (

	mediumScore		NUMERIC(3,1),
	qualityScore		NUMERIC(3,1),
	serviceScore		NUMERIC(3,1),
	cleaningScore		NUMERIC(3,1),
	sizeScore		NUMERIC(3,1),
	locationScore		NUMERIC(3,1),
	priceScore		NUMERIC(3,1),
	scoreDate		DATE NOT NULL,
	scoreTime		TIME NOT NULL,
	ESCOREOID		VARCHAR(64) PRIMARY KEY,
	establishmentScoreID	INT NOT NULL ,
	FK_USOID		VARCHAR(64) NOT NULL,
	FK_ESTOID		VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_USOID)  REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_ESTOID) REFERENCES establishments(ESTOID) ON DELETE CASCADE ON UPDATE CASCADE
	
);

/*RUTA-TAPA:
--------------------*/


CREATE TABLE taparoutes (
	nameRoute		VARCHAR(50) NOT NULL,
	creationRouteDate	DATE NOT NULL,
	routeDate		DATE CHECK (routeDate>=creationRouteDate),
	ROUTEOID		VARCHAR(64) PRIMARY KEY,
	tapaRouteID			INT NOT NULL ,
	FK_USOID		VARCHAR(64),
	FOREIGN KEY (FK_USOID) REFERENCES users(USOID) ON DELETE SET NULL
	
);



/*Users-RutaTAPA:
-------------------*/


CREATE TABLE taparouteusers(
		
	TRUSEROID		VARCHAR(64) PRIMARY KEY,
	tapaRouteUserID			INT NOT NULL ,
	FK_USOID		VARCHAR(64) NOT NULL,
	FK_ROUTEOID		VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_USOID) 	REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_ROUTEOID) REFERENCES taparoutes(ROUTEOID) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Establishments-RutaTAPA:          
----------------------------*/


CREATE TABLE taparouteestablishments(
		
	TRESTOID		VARCHAR(64) PRIMARY KEY,
	tapaRouteEstablishmentID			INT NOT NULL ,
	FK_ESTOID		VARCHAR(64) NOT NULL,
	FK_ROUTEOID		VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_ESTOID) REFERENCES establishments(ESTOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_ROUTEOID) REFERENCES taparoutes(ROUTEOID) ON DELETE CASCADE ON UPDATE CASCADE
);



/*COMENTARIO 
--------------------------------------*/	


CREATE TABLE comments(

	commentarie 	VARCHAR(500) NOT NULL,
	commentDate	DATE NOT NULL,
	commentTime	TIME NOT NULL,
	COMOID		VARCHAR(64) PRIMARY KEY,
	commentID	INT NOT NULL ,	
	FK_USOID	VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_USOID) REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE

);





/*COMENTARIO Producto
--------------------------------------*/	


CREATE TABLE productcomments(

	COMPROID	VARCHAR(64) PRIMARY KEY,
	productCommentID			INT NOT NULL ,	
	FK_COMOID	VARCHAR(64) NOT NULL,
	FK_PRODOID	VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_COMOID) REFERENCES comments(COMOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_PRODOID) REFERENCES products(PRODOID) ON DELETE CASCADE ON UPDATE CASCADE

);




/*COMENTARIO Establishments
--------------------------------------*/	


CREATE TABLE establishmentcomments(

	COMNTESTOID	VARCHAR(64) PRIMARY KEY,
	establishmentCommentID			INT NOT NULL ,	
	FK_COMOID	VARCHAR(64) NOT NULL,
	FK_ESTOID	VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_COMOID) REFERENCES comments(COMOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_ESTOID) REFERENCES establishments(ESTOID) ON DELETE CASCADE ON UPDATE CASCADE

);

/*COMENTARIO taparoutecomments
--------------------------------------*/	


CREATE TABLE taparoutecomments(


	TRCOID		VARCHAR(64) PRIMARY KEY,
	tapaRouteCommentID			INT NOT NULL ,	
	FK_COMOID	VARCHAR(64) NOT NULL,
	FK_ROUTEOID	VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_COMOID) REFERENCES comments(COMOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_ROUTEOID) REFERENCES taparoutes(ROUTEOID) ON DELETE CASCADE ON UPDATE CASCADE

);

/*COMENTARIO usercomments
--------------------------------------*/


CREATE TABLE usercomments(
	UCOID		VARCHAR(64) PRIMARY KEY,
	userCommentID	INT NOT NULL ,	
	FK_USEROID	VARCHAR(64) NOT NULL,
	FK_COMOID	VARCHAR(64) NOT NULL,
	FOREIGN KEY (FK_USEROID) REFERENCES users(USOID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (FK_COMOID) REFERENCES comments(COMOID) ON DELETE CASCADE ON UPDATE CASCADE

);


/* INSERTS BD */

/*USERS*/

INSERT INTO `dtapas`.`users` (`name`, `surnames`, `login`, `password`, `email`, `registryDate`, `USOID`)
	VALUES ('Arturo', 'Jimenez', 'artjimlop', 'practica', 'artjimlop@us.es', '2012-01-01', '1');
INSERT INTO `dtapas`.`users` (`name`, `surnames`, `login`, `password`, `email`, `registryDate`, `USOID`)
	VALUES ('Antonio', 'Nieto', 'antniegar', 'practica', 'antniegar@us.es', '2012-01-01', '2');
INSERT INTO `dtapas`.`users` (`name`, `surnames`, `login`, `password`, `email`, `registryDate`, `USOID`)
	VALUES ('David', 'Alanis', 'davalavar', 'practica', 'davalavar@us.es', '2012-01-01', '3');
INSERT INTO `dtapas`.`users` (`name`, `surnames`, `login`, `password`, `email`, `registryDate`, `USOID`)
	VALUES ('Juan Pedro', 'Pina', 'juapinort', 'practica', 'juapinort@us.es', '2012-01-01', '4');

/* FOLLOWERS */

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('1', '1', '2');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('2', '1', '3');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('3', '2', '3');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('4', '2', '4');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('5', '3', '1');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('6', '3', '4');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('7', '4', '1');

INSERT INTO `dtapas`.`followers` (`FOLLOWOID`, `FK_USEROID`, `FK_FOLLOWEDOID`) VALUES ('8', '4', '2');

/* COMMENTS */

INSERT INTO `dtapas`.`comments` (`commentarie`, `commentDate`, `commentTime`, `COMOID`, `commentID`, `FK_USOID`)
	VALUES ('Hola =)', '2012-05-29', '17:10:00', '1', 7, '1');

INSERT INTO `dtapas`.`comments` (`commentarie`, `commentDate`, `commentTime`, `COMOID`, `commentID`, `FK_USOID`) 
	VALUES ('Que tal? Cuanto tiempo', '2012-05-29', '17:11:00', '2', 8, '3');

/* USER COMMENTS */

INSERT INTO `dtapas`.`usercomments` (`UCOID`, `userCommentID`, `FK_USEROID`, `FK_COMOID`) 
	VALUES ('1', 1, '3', '1');

INSERT INTO `dtapas`.`usercomments` (`UCOID`, `userCommentID`, `FK_USEROID`, `FK_COMOID`) 
	VALUES ('2', 2, '1', '2');

/* ESTABLISHMENTS */

INSERT INTO `dtapas`.`establishments` (`nameEstablishment`, `city`, `province`, `zone`, `street`, `zipCode`, `registryDate`, `ESTOID`, `establishmentID`, `FK_USOID`) 
	VALUES ('El Baron', 'Sevilla', 'Sevilla', 'Norte', 'LLanes', 41008, '2012-05-05', '1', 1, '1');
INSERT INTO `dtapas`.`establishments` (`nameEstablishment`, `city`, `province`, `zone`, `street`, `zipCode`, `registryDate`, `ESTOID`, `establishmentID`, `FK_USOID`) 
	VALUES ('Calixto', 'Sevilla', 'Sevilla', 'Heliopolis', 'Reina Mercedes', 41012, '2012-05-05', '2', 2, '2');
INSERT INTO `dtapas`.`establishments` (`nameEstablishment`, `city`, `province`, `zone`, `street`, `zipCode`, `registryDate`, `ESTOID`, `establishmentID`, `FK_USOID`) 
	VALUES ('Blanco Cerillo', 'Sevilla', 'Sevilla', 'Centro', 'Sierpes', 41007, '2012-05-05', '3', 3, '3');
INSERT INTO `dtapas`.`establishments` (`nameEstablishment`, `city`, `province`, `zone`, `street`, `zipCode`, `registryDate`, `ESTOID`, `establishmentID`, `FK_USOID`) 
	VALUES ('La Internacional', 'Sevilla', 'Sevilla', 'Centro', 'Plaza Nueva', 41007, '2012-05-05', '4', 4, '4');