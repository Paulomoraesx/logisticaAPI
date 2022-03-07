create table entrega (
	id bigint not null AUTO_INCREMENT,
    cliente_id bigint not null,
    taxa decimal (10,2) not null,
    status varchar(20) not null,
    data_pedido datetime not null,
    data_finalizacao datetime,
    
    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(255) not null,
    destinatario_numero varchar(30) not null,
    destinatario_complemento varchar(60) not null,
    destinatario_bairro varchar(30) not null,
    
    PRIMARY KEY (id)
);

alter table entrega add CONSTRAINT fk_entrega_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id);