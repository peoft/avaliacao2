CREATE DATABASE AV2;
USE AV2;
CREATE TABLE Pessoa (
id INT NOT NULL AUTO_INCREMENT,
nome varchar(255) NOT NULL,
dataNascimento date NOT NULL,
cpf varchar(11) NOT NULL,
sexo enum ('MASCULINO', 'FEMININO'),
PRIMARY KEY ( id ) );

CREATE TABLE Motorista (
pessoa_id INT NOT NULL,
numeroCNH varchar(255) NOT NULL,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa( id )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
PRIMARY KEY ( numeroCNH ));

CREATE TABLE Funcionario (
pessoa_id INT NOT NULL,
matricula varchar(255) NOT NULL,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa( id )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
PRIMARY KEY ( matricula ));

CREATE TABLE Acessorio (
id INT NOT NULL AUTO_INCREMENT,
descricao varchar(50) NOT NULL,
PRIMARY KEY ( id ) );

CREATE TABLE Fabricante (
id INT NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
PRIMARY KEY ( id ) );

CREATE TABLE ModeloCarro (
id INT NOT NULL AUTO_INCREMENT,
fabricante_id INT NOT NULL,
descricao varchar(50) NOT NULL,
categoria  enum ('HATCH_COMPACTO', 'HATCH_MEDIO', 'SEDAN_COMPACTO', 'SEDAN_MEDIO', 'SEDAN_GRANDE', 'MINIVAN', 'ESPORTIVO', 'UTILITARIO_COMERCIAL'),
FOREIGN KEY ( fabricante_id )
	REFERENCES Fabricante( id ),
PRIMARY KEY ( id ) );

CREATE TABLE Carro (
id INT NOT NULL AUTO_INCREMENT,
acessorio_id INT NOT NULL,
modeloCarro_id INT NOT NULL,
placa varchar(10) NOT NULL,
chassi varchar(30) NOT NULL,
cor varchar(50) NOT NULL,
valorDiaria double NOT NULL,
FOREIGN KEY ( acessorio_id )
	REFERENCES Acessorio( id ),
FOREIGN KEY ( modeloCarro_id )
	REFERENCES ModeloCarro( id ),
PRIMARY KEY ( id ) );

CREATE TABLE ApoliceSeguro (
id INT NOT NULL AUTO_INCREMENT,
valorFranquia double NOT NULL,
protecaoTerceiro boolean,
protecaoCausasNaturais boolean,
protecaoRoubo boolean,
PRIMARY KEY ( id ) );


CREATE TABLE Aluguel (
id INT NOT NULL AUTO_INCREMENT,
pessoa_id INT NOT NULL,
carro_id INT NOT NULL,
apoliceSeguro_id INT NOT NULL,
dataPedido date NOT NULL,
dataEntrega date NOT NULL,
dataDevolucao date,
valorTotal double NOT NULL,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa( id ),
FOREIGN KEY ( carro_id )
	REFERENCES Carro( id ),
FOREIGN KEY ( apoliceSeguro_id )
	REFERENCES ApoliceSeguro( id ),    
PRIMARY KEY ( id ) );