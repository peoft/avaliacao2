CREATE DATABASE AV1;

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
	REFERENCES Pessoa(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
PRIMARY KEY (numeroCNH));

CREATE TABLE Funcionario (
pessoa_id INT NOT NULL,
matricula varchar(255) NOT NULL,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
PRIMARY KEY (matricula));

CREATE TABLE Aluguel (
id INT NOT NULL AUTO_INCREMENT,
pessoa_id INT NOT NULL,
dataPedido date NOT NULL,
dataEntrega date NOT NULL,
dataDevolucao date,
valorTotal double NOT NULL,
FOREIGN KEY ( pessoa_id )
	REFERENCES Pessoa(id),
PRIMARY KEY ( id ) );

