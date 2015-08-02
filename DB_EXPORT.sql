CREATE TABLE MATRIZ(
mtr_id serial NOT NULL,
mtr_tamaño integer NOT NULL,
mtr_fecha_creacion timestamp without time zone DEFAULT now(),

primary key(mtr_id)
);

CREATE TABLE OPERACION(
opr_id serial not null,
opr_nombre character varying(100) not null,
opr_descripcion character varying(500),
opr_fecha_creacion timestamp without time zone DEFAULT now(),

primary key (opr_id)
);

CREATE TABLE OPERACION_MATRIZ(
opmt_id serial not null,
opmt_id_mtr  integer,
opmt_id_opr integer,
opmt_fecha_creacion timestamp without time zone DEFAULT now(),

primary key (opmt_id)
);


CREATE TABLE RESULTADOS_OPR(
rsl_id serial not null,
rsl_id_opmt  integer,
rsl_valor integer,
rsl_fecha_creacion timestamp without time zone DEFAULT now(),

primary key (rsl_id)
);

<-- CREACION DE FORANEAS!-->
ALTER TABLE OPERACION_MATRIZ
ADD CONSTRAINT fk_OPERACION_MATRIZ_MATRIZ FOREIGN KEY (opmt_id_mtr)
REFERENCES MATRIZ (mtr_id),
ADD CONSTRAINT fk_OPERACION_MATRIZ_OPERACION FOREIGN KEY (opmt_id_opr)
REFERENCES OPERACION (opr_id)

ALTER TABLE RESULTADOS_OPR
ADD CONSTRAINT fk_RESULTADOS_OPR_OPERACION_MATRIZ FOREIGN KEY (rsl_id_opmt)
REFERENCES OPERACION_MATRIZ (opmt_id)


<-- Datos para cargar la tabla de operaciones!-->
insert into OPERACION (opr_nombre,opr_descripcion)
values ('operacion1','Actualizaciòn');
insert into OPERACION (opr_nombre,opr_descripcion)
values ('operacion2','Consulta');

