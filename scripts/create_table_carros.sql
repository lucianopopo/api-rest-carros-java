USE [carrosdb]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE carro_tb(
	carro_id INT IDENTITY(1,1) NOT NULL,
	modelo VARCHAR (60) NOT NULL,
	marca_id INT NOT NULL,
	preco NUMERIC (15,2) NOT NULL,
	cor VARCHAR (20) NOT NULL,
	ano INT NOT NULL,
	cambio VARCHAR (10) NOT NULL,
	combustivel VARCHAR (50) NOT NULL,
	carroceria VARCHAR (30) NOT NULL,
	blindagem bit NOT NULL,
	opcionais VARCHAR (255) NOT NULL,
	CONSTRAINT [PK_carro_tb] PRIMARY KEY CLUSTERED 
	(
		[carro_id] ASC
	)
)
GO

ALTER TABLE carro_tb  WITH CHECK ADD CONSTRAINT [FK_carro_tb_X_marca_tb_M] FOREIGN KEY(marca_id)
REFERENCES marca_tb (marca_id)
GO
ALTER TABLE carro_tb CHECK CONSTRAINT [FK_carro_tb_X_marca_tb_M]
GO