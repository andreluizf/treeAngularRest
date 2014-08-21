

CREATE TABLE equipe (
    id integer NOT NULL,
    nome character varying(100),
    id_plano integer
);


ALTER TABLE public.equipe OWNER TO postgres;


CREATE SEQUENCE equipe_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipe_id_seq OWNER TO postgres;



ALTER SEQUENCE equipe_id_seq OWNED BY equipe.id;


CREATE TABLE plano (
    id integer NOT NULL,
    nome character varying(100),
    data_inicio date,
    data_fim date,
    id_plano integer
);


ALTER TABLE public.plano OWNER TO postgres;



CREATE SEQUENCE plano_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.plano_id_seq OWNER TO postgres;



ALTER SEQUENCE plano_id_seq OWNED BY plano.id;



ALTER TABLE ONLY equipe ALTER COLUMN id SET DEFAULT nextval('equipe_id_seq'::regclass);




ALTER TABLE ONLY plano ALTER COLUMN id SET DEFAULT nextval('plano_id_seq'::regclass);






SELECT pg_catalog.setval('equipe_id_seq', 1, false);







SELECT pg_catalog.setval('plano_id_seq', 1, false);




ALTER TABLE ONLY equipe
    ADD CONSTRAINT equipe_pkey PRIMARY KEY (id);




ALTER TABLE ONLY plano
    ADD CONSTRAINT plano_pkey PRIMARY KEY (id);




ALTER TABLE ONLY equipe
    ADD CONSTRAINT equipe_id_plano_fkey FOREIGN KEY (id_plano) REFERENCES plano(id);




ALTER TABLE ONLY plano
    ADD CONSTRAINT plano_id_plano_fkey FOREIGN KEY (id_plano) REFERENCES plano(id);




REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;



