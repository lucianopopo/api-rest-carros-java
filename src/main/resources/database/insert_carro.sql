USE [carrosdb]
GO

INSERT INTO [dbo].[carro_tb]
           ([modelo]
           ,[marca_id]
           ,[preco]
           ,[cor]
           ,[ano]
           ,[cambio]
           ,[combustivel]
           ,[carroceria]
           ,[blindagem]
           ,[opcionais])
     VALUES
           ('Palio'
           , 2
           ,23990.00
           ,'Prata'
           ,2016
           ,'Manual'
           ,'Flex'
           ,'Hatchback'
           ,0
           ,'1.0 MPI FIRE 8V FLEX 4P MANUAL')
GO

INSERT INTO [dbo].[carro_tb]
           ([modelo]
           ,[marca_id]
           ,[preco]
           ,[cor]
           ,[ano]
           ,[cambio]
           ,[combustivel]
           ,[carroceria]
           ,[blindagem]
           ,[opcionais])
     VALUES
           ('Fiorino'
           , 2
           ,34990.00
           ,'Branco'
           ,2016
           ,'Manual'
           ,'Flex'
           ,'Van/Utilitário'
           ,0
           ,'Airbag, Ar condicionado, Freio ABS, Travas elétricas, Vidros elétricos')
GO


