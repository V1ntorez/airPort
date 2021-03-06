PGDMP     5                     z            AirCompanies    14.1    14.1                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16476    AirCompanies    DATABASE     k   CREATE DATABASE "AirCompanies" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "AirCompanies";
                postgres    false            A           1247    16517    flightstatus    TYPE     i   CREATE TYPE public.flightstatus AS ENUM (
    'ACTIVE',
    'COMPLETED',
    'DELAYED',
    'PENDING'
);
    DROP TYPE public.flightstatus;
       public          postgres    false            ?            1259    16567    flight    TABLE     l  CREATE TABLE public.flight (
    id integer NOT NULL,
    flightstatus public.flightstatus,
    aircompanyid integer,
    distance integer,
    estimatedflighttime integer,
    endedat date,
    delaystartedat date,
    createdat date,
    startedat date,
    departurecountry character varying,
    destinationcountry character varying,
    airplaneid integer
);
    DROP TABLE public.flight;
       public         heap    postgres    false    833            ?            1259    16572    Flight_id_seq    SEQUENCE     ?   ALTER TABLE public.flight ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Flight_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            ?            1259    16482 
   aircompany    TABLE     ?   CREATE TABLE public.aircompany (
    id integer NOT NULL,
    name character varying,
    companytype character varying,
    foundedat date
);
    DROP TABLE public.aircompany;
       public         heap    postgres    false            ?            1259    16531    aircompany_id_seq    SEQUENCE     ?   ALTER TABLE public.aircompany ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.aircompany_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            ?            1259    16477    airplane    TABLE     (  CREATE TABLE public.airplane (
    id integer NOT NULL,
    name character varying,
    factoryserialnumber character varying,
    aircompanyid character varying,
    numberofflights integer,
    flightdistance integer,
    fuelcapacity integer,
    type character varying,
    createdat date
);
    DROP TABLE public.airplane;
       public         heap    postgres    false            ?            1259    16530    airplane_id_seq    SEQUENCE     ?   ALTER TABLE public.airplane ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.airplane_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            ?          0    16482 
   aircompany 
   TABLE DATA           F   COPY public.aircompany (id, name, companytype, foundedat) FROM stdin;
    public          postgres    false    210   ?       ?          0    16477    airplane 
   TABLE DATA           ?   COPY public.airplane (id, name, factoryserialnumber, aircompanyid, numberofflights, flightdistance, fuelcapacity, type, createdat) FROM stdin;
    public          postgres    false    209   ?       ?          0    16567    flight 
   TABLE DATA           ?   COPY public.flight (id, flightstatus, aircompanyid, distance, estimatedflighttime, endedat, delaystartedat, createdat, startedat, departurecountry, destinationcountry, airplaneid) FROM stdin;
    public          postgres    false    213   r                  0    0    Flight_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."Flight_id_seq"', 6, true);
          public          postgres    false    214                       0    0    aircompany_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.aircompany_id_seq', 5, true);
          public          postgres    false    212                       0    0    airplane_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.airplane_id_seq', 5, true);
          public          postgres    false    211            l           2606    16498    aircompany aircompany_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.aircompany
    ADD CONSTRAINT aircompany_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.aircompany DROP CONSTRAINT aircompany_pkey;
       public            postgres    false    210            j           2606    16500    airplane airplane_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.airplane
    ADD CONSTRAINT airplane_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.airplane DROP CONSTRAINT airplane_pkey;
       public            postgres    false    209            ?   D   x?3?,)????LI?I?4202?50?5??2?,?(JM???L?(AH?qr???r?䗗?E??b???? ?Ia      ?   ?   x?E??
?0???_*??D??xL?	TZ??w??^?ֽ?5D??!D&"Ԧժ?D<19???sK?(?i	s$<[JK>?|w??2Zb?pU?O??K?ZfQږ?i???q?7s>????qq?}kD'u      ?   ?   x??ϱ
?@?z?_"??w'??!?	)??&??(	??E?!6)n?)?ǌ???c?5 ??H???Ze?????????0?@	??r?%f.?SX??+A???S{?aP?X?b???Ra.h?{Mҷ??Z8?r݈??;eV     