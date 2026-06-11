--
-- PostgreSQL database dump
--

\restrict cZWKon91BNgeqBEVnTyOthyMyF4X01KViQfWPauqeBLgahiDIuAYhszIB3oxA3I

-- Dumped from database version 16.14 (Debian 16.14-1.pgdg13+1)
-- Dumped by pg_dump version 16.14 (Debian 16.14-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE IF EXISTS ONLY public.antecedent DROP CONSTRAINT IF EXISTS fksoul6klwuqqyp0mmc3gkvokbu;
ALTER TABLE IF EXISTS ONLY public.medical_records DROP CONSTRAINT IF EXISTS fkrav12h9aiw7pegjt62p8owwn3;
ALTER TABLE IF EXISTS ONLY public.hospitalization DROP CONSTRAINT IF EXISTS fko3vfryvi6b5ws6b9p4ahvik37;
ALTER TABLE IF EXISTS ONLY public.patients DROP CONSTRAINT IF EXISTS fkkqiqblkbhfc4xjyfw90a9mh5d;
ALTER TABLE IF EXISTS ONLY public.dossier_medical DROP CONSTRAINT IF EXISTS fki21rp4v390pq3o3gfsw5v3spe;
ALTER TABLE IF EXISTS ONLY public.patients DROP CONSTRAINT IF EXISTS fkhkntdq6ujwdgqbx8iwffi2ffb;
ALTER TABLE IF EXISTS ONLY public.hospitalization_acts DROP CONSTRAINT IF EXISTS fkgymhi3mxls9afvxkumeu21xkb;
ALTER TABLE IF EXISTS ONLY public.patients DROP CONSTRAINT IF EXISTS fkgilaks1al0adrufqoswh38utx;
ALTER TABLE IF EXISTS ONLY public.staff DROP CONSTRAINT IF EXISTS fkdlvw23ak3u9v9bomm8g12rtc0;
ALTER TABLE IF EXISTS ONLY public.assurance DROP CONSTRAINT IF EXISTS fkd8cjpkyhwejkck5i2bo3qtyvy;
ALTER TABLE IF EXISTS ONLY public.hospitalization_acts DROP CONSTRAINT IF EXISTS fkcl7ule38uf72psd1sqgcrfg6l;
ALTER TABLE IF EXISTS ONLY public.hospitalisation DROP CONSTRAINT IF EXISTS fk1lfa1xt6qlpnlkwux2druiqo5;
ALTER TABLE IF EXISTS ONLY public.users DROP CONSTRAINT IF EXISTS users_pkey;
ALTER TABLE IF EXISTS ONLY public.cities DROP CONSTRAINT IF EXISTS ukqww1g66rmhx352jxut53oqh3y;
ALTER TABLE IF EXISTS ONLY public.assurance DROP CONSTRAINT IF EXISTS ukqf5rp3i9nnf407fyols90orng;
ALTER TABLE IF EXISTS ONLY public.medical_records DROP CONSTRAINT IF EXISTS ukpfo95i6n9sje9q9mb429f5qor;
ALTER TABLE IF EXISTS ONLY public.patients DROP CONSTRAINT IF EXISTS uknmvbsxuoshhevlgvvx87v0vtj;
ALTER TABLE IF EXISTS ONLY public.medical_records DROP CONSTRAINT IF EXISTS ukjljvxv7moeliebth00v2nsrac;
ALTER TABLE IF EXISTS ONLY public.dossier_medical DROP CONSTRAINT IF EXISTS ukgfiptfsbc9wfeql9lq9hsj3co;
ALTER TABLE IF EXISTS ONLY public.hospitalization_acts DROP CONSTRAINT IF EXISTS ukc8wj13ahhcplrrl26d5hfnxk3;
ALTER TABLE IF EXISTS ONLY public.staff DROP CONSTRAINT IF EXISTS uk7qatq4kob2sr6rlp44khhj53g;
ALTER TABLE IF EXISTS ONLY public.insurances DROP CONSTRAINT IF EXISTS uk16ob0msjex8cyk62gy2l8ln9l;
ALTER TABLE IF EXISTS ONLY public.staff DROP CONSTRAINT IF EXISTS staff_pkey;
ALTER TABLE IF EXISTS ONLY public.professions DROP CONSTRAINT IF EXISTS professions_pkey;
ALTER TABLE IF EXISTS ONLY public.patients DROP CONSTRAINT IF EXISTS patients_pkey;
ALTER TABLE IF EXISTS ONLY public.medical_records DROP CONSTRAINT IF EXISTS medical_records_pkey;
ALTER TABLE IF EXISTS ONLY public.insurances DROP CONSTRAINT IF EXISTS insurances_pkey;
ALTER TABLE IF EXISTS ONLY public.hospitalization DROP CONSTRAINT IF EXISTS hospitalization_pkey;
ALTER TABLE IF EXISTS ONLY public.hospitalization_act DROP CONSTRAINT IF EXISTS hospitalization_act_pkey;
ALTER TABLE IF EXISTS ONLY public.hospitalisation DROP CONSTRAINT IF EXISTS hospitalisation_pkey;
ALTER TABLE IF EXISTS ONLY public.dossier_medical DROP CONSTRAINT IF EXISTS dossier_medical_pkey;
ALTER TABLE IF EXISTS ONLY public.clinic_services DROP CONSTRAINT IF EXISTS clinic_services_pkey;
ALTER TABLE IF EXISTS ONLY public.cities DROP CONSTRAINT IF EXISTS cities_pkey;
ALTER TABLE IF EXISTS ONLY public.assurance DROP CONSTRAINT IF EXISTS assurance_pkey;
ALTER TABLE IF EXISTS ONLY public.antecedent DROP CONSTRAINT IF EXISTS antecedent_pkey;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.staff;
DROP TABLE IF EXISTS public.professions;
DROP TABLE IF EXISTS public.patients;
DROP TABLE IF EXISTS public.medical_records;
DROP TABLE IF EXISTS public.insurances;
DROP TABLE IF EXISTS public.hospitalization_acts;
DROP TABLE IF EXISTS public.hospitalization_act;
DROP TABLE IF EXISTS public.hospitalization;
DROP TABLE IF EXISTS public.hospitalisation;
DROP TABLE IF EXISTS public.dossier_medical;
DROP TABLE IF EXISTS public.clinic_services;
DROP TABLE IF EXISTS public.cities;
DROP TABLE IF EXISTS public.assurance;
DROP TABLE IF EXISTS public.antecedent;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: antecedent; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.antecedent (
    id bigint NOT NULL,
    description character varying(255),
    type character varying(255),
    patient_id bigint
);


--
-- Name: antecedent_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.antecedent ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.antecedent_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: assurance; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.assurance (
    id bigint NOT NULL,
    affiliation character varying(255),
    droits character varying(255),
    matricule character varying(255),
    nom_assurance character varying(255),
    patient_id bigint
);


--
-- Name: assurance_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.assurance ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.assurance_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: cities; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.cities (
    id bigint NOT NULL,
    code character varying(255) NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255) NOT NULL,
    updated_at timestamp(6) without time zone
);


--
-- Name: cities_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.cities ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: clinic_services; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.clinic_services (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    description text,
    name character varying(255) NOT NULL,
    status character varying(255) NOT NULL,
    updated_at timestamp(6) without time zone
);


--
-- Name: clinic_services_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.clinic_services ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.clinic_services_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: dossier_medical; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.dossier_medical (
    id bigint NOT NULL,
    allergies character varying(255),
    groupe_sanguin character varying(255),
    remarques character varying(255),
    patient_id bigint
);


--
-- Name: dossier_medical_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.dossier_medical ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.dossier_medical_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: hospitalisation; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.hospitalisation (
    id bigint NOT NULL,
    acte character varying(255),
    date_entree date,
    date_sortie date,
    medecin_traitant character varying(255),
    patient_id bigint
);


--
-- Name: hospitalisation_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.hospitalisation ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.hospitalisation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: hospitalization; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.hospitalization (
    id bigint NOT NULL,
    admission_date date,
    discharge_date date,
    hospitalization_code character varying(255),
    incubator_days integer,
    insurance character varying(255),
    intensive_care_days integer,
    observations text,
    patient_name character varying(255),
    reanimation_days integer,
    room_number character varying(255),
    status character varying(255),
    treating_doctor character varying(255),
    patient_id bigint,
    additional_amount double precision,
    hospitalization_amount double precision,
    insurance_amount double precision,
    patient_amount double precision,
    deleted_at timestamp(6) without time zone,
    is_deleted boolean,
    CONSTRAINT hospitalization_status_check CHECK (((status)::text = ANY ((ARRAY['PLANIFIEE'::character varying, 'EN_COURS'::character varying, 'SORTIE'::character varying, 'ANNULEE'::character varying])::text[])))
);


--
-- Name: hospitalization_act; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.hospitalization_act (
    id bigint NOT NULL,
    act_name character varying(255),
    amo_code character varying(255),
    quantity integer,
    quotation double precision,
    total double precision,
    deleted_at timestamp(6) without time zone,
    is_deleted boolean
);


--
-- Name: hospitalization_act_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.hospitalization_act ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.hospitalization_act_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: hospitalization_acts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.hospitalization_acts (
    hospitalization_id bigint NOT NULL,
    acts_id bigint NOT NULL
);


--
-- Name: hospitalization_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.hospitalization ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.hospitalization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: insurances; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.insurances (
    id bigint NOT NULL,
    affiliation character varying(255),
    created_at timestamp(6) without time zone,
    matricule character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    status character varying(255),
    type character varying(255),
    updated_at timestamp(6) without time zone,
    CONSTRAINT insurances_status_check CHECK (((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'INACTIVE'::character varying])::text[]))),
    CONSTRAINT insurances_type_check CHECK (((type)::text = ANY ((ARRAY['PUBLIC'::character varying, 'PRIVEE'::character varying, 'MUTUELLE'::character varying])::text[])))
);


--
-- Name: insurances_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.insurances ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.insurances_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: medical_records; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.medical_records (
    id bigint NOT NULL,
    allergies text,
    blood_group character varying(255),
    created_at timestamp(6) without time zone,
    medical_history text,
    medical_record_code character varying(255) NOT NULL,
    notes text,
    updated_at timestamp(6) without time zone,
    patient_id bigint
);


--
-- Name: medical_records_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.medical_records ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.medical_records_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: patients; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.patients (
    id bigint NOT NULL,
    adresse character varying(255),
    created_at timestamp(6) without time zone,
    date_of_birth date,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    phone character varying(255),
    sex character varying(255),
    status character varying(255),
    updated_at timestamp(6) without time zone,
    city_id bigint,
    insurance_id bigint,
    profession_id bigint,
    patient_code character varying(255),
    address character varying(255),
    cin character varying(255),
    CONSTRAINT patients_status_check CHECK (((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'HOSPITALIZED'::character varying, 'DISCHARGED'::character varying, 'INACTIVE'::character varying])::text[])))
);


--
-- Name: patients_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.patients ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.patients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: professions; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.professions (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255) NOT NULL,
    status character varying(255) NOT NULL,
    updated_at timestamp(6) without time zone
);


--
-- Name: professions_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.professions ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.professions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: staff; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.staff (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    phone character varying(255),
    specialty character varying(255),
    status character varying(255),
    user_id bigint,
    CONSTRAINT staff_status_check CHECK (((status)::text = ANY ((ARRAY['Active'::character varying, 'Inactive'::character varying])::text[])))
);


--
-- Name: staff_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.staff ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.staff_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    password character varying(255),
    role character varying(255),
    username character varying(255),
    CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['ADMIN'::character varying, 'MEDECIN'::character varying, 'SECRETAIRE'::character varying, 'INFIRMIER'::character varying])::text[])))
);


--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: antecedent; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.antecedent (id, description, type, patient_id) FROM stdin;
\.


--
-- Data for Name: assurance; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.assurance (id, affiliation, droits, matricule, nom_assurance, patient_id) FROM stdin;
\.


--
-- Data for Name: cities; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.cities (id, code, created_at, name, updated_at) FROM stdin;
1	OUJ	2026-05-27 16:50:44	Oujda	2026-05-27 21:36:55.205885
2	CAS	2026-05-27 16:54:11.810204	Casablanca	2026-05-27 21:39:16.438484
7	RAB	2026-06-10 10:34:49.528397	Rabat	2026-06-10 10:34:49.528397
8	MAR	2026-06-10 10:34:49.528397	Marrakech	2026-06-10 10:34:49.528397
9	FES	2026-06-10 10:34:49.528397	F├¿s	2026-06-10 10:34:49.528397
10	TNG	2026-06-10 10:34:49.528397	Tanger	2026-06-10 10:34:49.528397
11	AGA	2026-06-10 10:34:49.528397	Agadir	2026-06-10 10:34:49.528397
12	MEK	2026-06-10 10:34:49.528397	Mekn├¿s	2026-06-10 10:34:49.528397
13	NAD	2026-06-10 10:34:49.528397	Nador	2026-06-10 10:34:49.528397
14	TET	2026-06-10 10:34:49.528397	T├®touan	2026-06-10 10:34:49.528397
15	PAR	2026-06-10 10:35:24.935678	Paris	2026-06-10 10:35:24.935678
16	MRS	2026-06-10 10:35:24.935678	Marseille	2026-06-10 10:35:24.935678
17	LYN	2026-06-10 10:35:24.935678	Lyon	2026-06-10 10:35:24.935678
18	TLS	2026-06-10 10:35:24.935678	Toulouse	2026-06-10 10:35:24.935678
19	NIC	2026-06-10 10:35:24.935678	Nice	2026-06-10 10:35:24.935678
20	NAN	2026-06-10 10:35:24.935678	Nantes	2026-06-10 10:35:24.935678
21	MTP	2026-06-10 10:35:24.935678	Montpellier	2026-06-10 10:35:24.935678
22	STR	2026-06-10 10:35:24.935678	Strasbourg	2026-06-10 10:35:24.935678
23	BRD	2026-06-10 10:35:24.935678	Bordeaux	2026-06-10 10:35:24.935678
24	LIL	2026-06-10 10:35:24.935678	Lille	2026-06-10 10:35:24.935678
\.


--
-- Data for Name: clinic_services; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.clinic_services (id, created_at, description, name, status, updated_at) FROM stdin;
5	2026-06-10 10:41:26.203272	Prise en charge des cas urgents 24/7	Urgences	ACTIVE	2026-06-10 10:41:26.203272
6	2026-06-10 10:41:26.203272	Service dÔÇÖhospitalisation des patients	Hospitalisation	ACTIVE	2026-06-10 10:41:26.203272
7	2026-06-10 10:41:26.203272	Bloc op├®ratoire et interventions chirurgicales	Chirurgie	ACTIVE	2026-06-10 10:41:26.203272
8	2026-06-10 10:41:26.203272	Imagerie m├®dicale (Scanner, IRM, Radio)	Radiologie	ACTIVE	2026-06-10 10:41:26.203272
9	2026-06-10 10:41:26.203272	Analyses biologiques et m├®dicales	Laboratoire	ACTIVE	2026-06-10 10:41:26.203272
10	2026-06-10 10:41:26.203272	Suivi grossesse et accouchement	Maternit├®	ACTIVE	2026-06-10 10:41:26.203272
11	2026-06-10 10:41:26.203272	Soins m├®dicaux pour enfants	P├®diatrie	ACTIVE	2026-06-10 10:41:26.203272
12	2026-06-10 10:41:26.203272	Soins du c┼ôur et maladies cardiovasculaires	Cardiologie	ACTIVE	2026-06-10 10:41:26.203272
13	2026-06-10 10:41:26.203272	Soins dentaires et chirurgie dentaire	Dentisterie	ACTIVE	2026-06-10 10:41:26.203272
14	2026-06-10 10:41:26.203272	Soins des yeux et vision	Ophtalmologie	ACTIVE	2026-06-10 10:41:26.203272
15	2026-06-10 10:41:26.203272	R├®├®ducation fonctionnelle	Kin├®sith├®rapie	ACTIVE	2026-06-10 10:41:26.203272
16	2026-06-10 10:41:26.203272	Distribution de m├®dicaments	Pharmacie	ACTIVE	2026-06-10 10:41:26.203272
17	2026-06-10 10:41:26.203272	Soins intensifs pour patients critiques	R├®animation	ACTIVE	2026-06-10 10:41:26.203272
18	2026-06-10 10:41:26.203272	Suivi m├®dical ├á domicile	Soins ├á domicile	ACTIVE	2026-06-10 10:41:26.203272
19	2026-06-10 10:41:26.203272	Programme de vaccination	Vaccination	ACTIVE	2026-06-10 10:41:26.203272
20	2026-06-10 10:41:26.203272	Bilan de sant├® complet	Check-up m├®dical	ACTIVE	2026-06-10 10:41:26.203272
1	2026-05-27 21:51:11.86554	Imagerie m├®dicale	Radiologie	ACTIVE	2026-06-10 12:48:31.028744
2	2026-05-27 22:26:30.663788	urgencesss	urgence	ACTIVE	2026-06-10 12:48:35.013986
3	2026-06-10 10:41:26.203272	Consultation avec un m├®decin g├®n├®raliste	Consultation G├®n├®rale	ACTIVE	2026-06-10 12:48:43.488117
4	2026-06-10 10:41:26.203272	Consultation avec m├®decin sp├®cialiste	Consultation Sp├®cialis├®e	ACTIVE	2026-06-10 12:48:47.582229
\.


--
-- Data for Name: dossier_medical; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.dossier_medical (id, allergies, groupe_sanguin, remarques, patient_id) FROM stdin;
\.


--
-- Data for Name: hospitalisation; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.hospitalisation (id, acte, date_entree, date_sortie, medecin_traitant, patient_id) FROM stdin;
\.


--
-- Data for Name: hospitalization; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.hospitalization (id, admission_date, discharge_date, hospitalization_code, incubator_days, insurance, intensive_care_days, observations, patient_name, reanimation_days, room_number, status, treating_doctor, patient_id, additional_amount, hospitalization_amount, insurance_amount, patient_amount, deleted_at, is_deleted) FROM stdin;
1	2026-06-10	2026-06-19	HOSP-2026-CF181AD8	0	CNSS	2	test hospi 	Mohamed A	1	A-101	EN_COURS		1	\N	6750	4725	2025	\N	f
2	2026-06-10	2026-06-10	HOSP-2026-4CC8BC7D	0	CNOPS	0		Sara B	0	A-101	PLANIFIEE		2	\N	900	630	270	\N	f
3	2026-06-11	2026-06-13	HOSP-2026-29C7BA2B	0	MAIF Sant├®	1		Salma L	0	A-101	PLANIFIEE		12	\N	3600	2520	1080	\N	f
\.


--
-- Data for Name: hospitalization_act; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.hospitalization_act (id, act_name, amo_code, quantity, quotation, total, deleted_at, is_deleted) FROM stdin;
10	Scanner	SCAN001	1	600	600	\N	f
11	Radiographie	RAD001	1	250	250	\N	f
12	Consultation sp├®cialis├®e	CONS010	2	400	800	\N	f
13	Journee hospitalisation	HOS-01	1	900	900	\N	f
14	Scanner	SCAN001	1	600	600	\N	f
15	Radiographie	RAD001	1	250	250	\N	f
16	Journee hospitalisation	HOS-01	1	900	900	\N	f
17	Reanimation	REA-20	1	2200	2200	\N	f
\.


--
-- Data for Name: hospitalization_acts; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.hospitalization_acts (hospitalization_id, acts_id) FROM stdin;
1	13
1	14
1	15
2	16
3	17
\.


--
-- Data for Name: insurances; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.insurances (id, affiliation, created_at, matricule, name, status, type, updated_at) FROM stdin;
4	Caisse Nationale de S├®curit├® Sociale	2026-06-10 10:55:09.094489	CNSS-001	CNSS	ACTIVE	PUBLIC	2026-06-10 10:55:09.094489
5	Caisse Nationale des Organismes de Pr├®voyance Sociale	2026-06-10 10:55:09.094489	CNOPS-001	CNOPS	ACTIVE	PUBLIC	2026-06-10 10:55:09.094489
6	Saham Group	2026-06-10 10:55:09.094489	SAHAM-001	Saham Sant├®	ACTIVE	PRIVEE	2026-06-10 10:55:09.094489
7	AXA Maroc	2026-06-10 10:55:09.094489	AXA-001	AXA Assurance	ACTIVE	PRIVEE	2026-06-10 10:55:09.094489
8	Allianz Group	2026-06-10 10:55:09.094489	ALLIANZ-001	Allianz Maroc	ACTIVE	PRIVEE	2026-06-10 10:55:09.094489
9	RMA Assurance	2026-06-10 10:55:09.094489	RMA-001	RMA Watanya	ACTIVE	PRIVEE	2026-06-10 10:55:09.094489
10	AtlantaSanad Assurance	2026-06-10 10:55:09.094489	ATL-001	AtlantaSanad	ACTIVE	PRIVEE	2026-06-10 10:55:09.094489
11	Attijariwafa Bank	2026-06-10 10:55:09.094489	WAFA-001	Wafa Assurance	ACTIVE	PRIVEE	2026-06-10 10:55:09.094489
12	Mutuelle G├®n├®rale de lÔÇÖ├ëducation Nationale	2026-06-10 10:55:09.094489	MGEN-001	MGEN	ACTIVE	MUTUELLE	2026-06-10 10:55:09.094489
13	VYV Group	2026-06-10 10:55:09.094489	HM-001	Harmonie Mutuelle	ACTIVE	MUTUELLE	2026-06-10 12:55:32.990807
14	France Mutuelle	2026-06-10 10:55:09.094489	MG-001	Mutuelle G├®n├®rale	INACTIVE	MUTUELLE	2026-06-10 14:23:46.072313
15	MAIF Groupe	2026-06-10 10:55:09.094489	MAIF-001	MAIF Sant├®	ACTIVE	MUTUELLE	2026-06-10 21:51:29.91525
\.


--
-- Data for Name: medical_records; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.medical_records (id, allergies, blood_group, created_at, medical_history, medical_record_code, notes, updated_at, patient_id) FROM stdin;
3	\N	\N	2026-06-10 13:22:46.858119	\N	MED-2026-2DBFAF6E	\N	2026-06-10 13:22:46.858119	3
4	\N	\N	2026-06-10 13:22:47.082202	\N	MED-2026-7E363B28	\N	2026-06-10 13:22:47.082202	4
5	\N	\N	2026-06-10 13:22:47.304927	\N	MED-2026-01BB8CC9	\N	2026-06-10 13:22:47.304927	5
6	\N	\N	2026-06-10 13:22:47.527318	\N	MED-2026-5EB45FAF	\N	2026-06-10 13:22:47.527318	6
7	\N	\N	2026-06-10 13:22:47.764823	\N	MED-2026-53089B81	\N	2026-06-10 13:22:47.764823	7
8	\N	\N	2026-06-10 13:22:48.003845	\N	MED-2026-96E935C8	\N	2026-06-10 13:22:48.003845	8
9	\N	\N	2026-06-10 13:22:48.227068	\N	MED-2026-087943AC	\N	2026-06-10 13:22:48.227068	9
10	\N	\N	2026-06-10 13:22:48.465066	\N	MED-2026-037B23C1	\N	2026-06-10 13:22:48.465066	10
11	\N	\N	2026-06-10 13:22:48.703236	\N	MED-2026-E8113327	\N	2026-06-10 13:22:48.703236	11
12	\N	\N	2026-06-10 13:22:48.940046	\N	MED-2026-A0E11E97	\N	2026-06-10 13:22:48.940046	12
13	\N	\N	2026-06-10 13:22:49.181225	\N	MED-2026-1497551D	\N	2026-06-10 13:22:49.181225	13
14	\N	\N	2026-06-10 13:22:49.41111	\N	MED-2026-980B6CB7	\N	2026-06-10 13:22:49.41111	14
15	\N	\N	2026-06-10 13:22:49.633491	\N	MED-2026-9296B925	\N	2026-06-10 13:22:49.633491	15
16	\N	\N	2026-06-10 13:22:49.856499	\N	MED-2026-F27268D8	\N	2026-06-10 13:22:49.856499	16
17	\N	\N	2026-06-10 13:22:50.079911	\N	MED-2026-1EEB68F8	\N	2026-06-10 13:22:50.079911	17
18	\N	\N	2026-06-10 13:22:50.302183	\N	MED-2026-B75F8878	\N	2026-06-10 13:22:50.302183	18
19	\N	\N	2026-06-10 13:22:50.522724	\N	MED-2026-63DAA33C	\N	2026-06-10 13:22:50.522724	19
20	\N	\N	2026-06-10 13:22:50.746552	\N	MED-2026-542512EF	\N	2026-06-10 13:22:50.746552	20
1			2026-06-10 13:22:46.342961		MED-2026-0C980887	\N	2026-06-10 14:23:25.841085	1
2			2026-06-10 13:22:46.627534		MED-2026-2BF36B8D	\N	2026-06-10 15:01:27.61703	2
\.


--
-- Data for Name: patients; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.patients (id, adresse, created_at, date_of_birth, email, first_name, last_name, phone, sex, status, updated_at, city_id, insurance_id, profession_id, patient_code, address, cin) FROM stdin;
3	\N	2026-06-10 13:22:46.855988	1995-01-01	a3@test.com	Youssef	C	0600000003	M	ACTIVE	2026-06-10 13:22:46.855988	7	6	3	PAT-2026-02930B47	Test Address	AA333
4	\N	2026-06-10 13:22:47.080107	1995-01-01	a4@test.com	Imane	D	0600000004	F	ACTIVE	2026-06-10 13:22:47.080107	8	7	5	PAT-2026-C10C972C	Test Address	AA444
5	\N	2026-06-10 13:22:47.301759	1995-01-01	a5@test.com	Omar	E	0600000005	M	ACTIVE	2026-06-10 13:22:47.301759	9	8	6	PAT-2026-D243D758	Test Address	AA555
6	\N	2026-06-10 13:22:47.523638	1995-01-01	a6@test.com	Aicha	F	0600000006	F	ACTIVE	2026-06-10 13:22:47.523638	10	9	7	PAT-2026-0A3DE033	Test Address	AA666
7	\N	2026-06-10 13:22:47.762168	1995-01-01	a7@test.com	Hamza	G	0600000007	M	ACTIVE	2026-06-10 13:22:47.762168	11	10	8	PAT-2026-FE64DC92	Test Address	AA777
8	\N	2026-06-10 13:22:48.001246	1995-01-01	a8@test.com	Khadija	H	0600000008	F	ACTIVE	2026-06-10 13:22:48.001246	12	11	9	PAT-2026-43E3C654	Test Address	AA888
9	\N	2026-06-10 13:22:48.223912	1995-01-01	a9@test.com	Anas	I	0600000009	M	ACTIVE	2026-06-10 13:22:48.223912	13	12	10	PAT-2026-315838E0	Test Address	AA999
10	\N	2026-06-10 13:22:48.462422	1995-01-01	a10@test.com	Lina	J	0600000010	F	ACTIVE	2026-06-10 13:22:48.462952	14	13	11	PAT-2026-1B4EBC30	Test Address	AA101
11	\N	2026-06-10 13:22:48.70058	1995-01-01	a11@test.com	Adil	K	0600000011	M	ACTIVE	2026-06-10 13:22:48.70058	15	14	12	PAT-2026-0D5DEC95	Test Address	AA102
12	\N	2026-06-10 13:22:48.937952	1995-01-01	a12@test.com	Salma	L	0600000012	F	ACTIVE	2026-06-10 13:22:48.937952	16	15	13	PAT-2026-498942A5	Test Address	AA103
13	\N	2026-06-10 13:22:49.178567	1995-01-01	a13@test.com	Yassine	M	0600000013	M	ACTIVE	2026-06-10 13:22:49.178567	17	4	14	PAT-2026-1147F141	Test Address	AA104
14	\N	2026-06-10 13:22:49.409027	1995-01-01	a14@test.com	Hajar	N	0600000014	F	ACTIVE	2026-06-10 13:22:49.409027	18	5	15	PAT-2026-0171C083	Test Address	AA105
15	\N	2026-06-10 13:22:49.631407	1995-01-01	a15@test.com	Mehdi	O	0600000015	M	ACTIVE	2026-06-10 13:22:49.631407	19	6	16	PAT-2026-C21DD29B	Test Address	AA106
16	\N	2026-06-10 13:22:49.854399	1995-01-01	a16@test.com	Nour	P	0600000016	F	ACTIVE	2026-06-10 13:22:49.854399	20	7	17	PAT-2026-52C84E7E	Test Address	AA107
17	\N	2026-06-10 13:22:50.077281	1995-01-01	a17@test.com	Zakaria	Q	0600000017	M	ACTIVE	2026-06-10 13:22:50.077281	21	8	18	PAT-2026-422BAB5A	Test Address	AA108
18	\N	2026-06-10 13:22:50.300086	1995-01-01	a18@test.com	Kawtar	R	0600000018	F	ACTIVE	2026-06-10 13:22:50.300086	22	9	19	PAT-2026-4CF0778D	Test Address	AA109
19	\N	2026-06-10 13:22:50.520648	1995-01-01	a19@test.com	Ayoub	S	0600000019	M	ACTIVE	2026-06-10 13:22:50.520648	23	10	20	PAT-2026-448959CD	Test Address	AA110
20	\N	2026-06-10 13:22:50.74395	1995-01-01	a20@test.com	Fatima	T	0600000020	F	ACTIVE	2026-06-10 13:22:50.74395	24	11	21	PAT-2026-68E8E94E	Test Address	AA1110
1	\N	2026-06-10 13:22:46.333946	1995-01-01	a1@test.com	Mohamed	Az	0600000001	M	ACTIVE	2026-06-10 14:23:25.811006	1	4	1	PAT-2026-41B45FE3	Test Address	AA111
2	\N	2026-06-10 13:22:46.624903	1995-01-01	a2@test.com	Sara	Ba	0600000002	F	ACTIVE	2026-06-10 15:01:27.584028	2	5	2	PAT-2026-25B74817	Test Address	AA222
\.


--
-- Data for Name: professions; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.professions (id, created_at, name, status, updated_at) FROM stdin;
1	2026-05-27 22:41:29.126357	M├®decin G├®n├®raliste	ACTIVE	2026-05-27 22:41:29.126357
2	2026-06-08 12:41:45.342667	Ing├®nieure	ACTIVE	2026-06-08 12:41:45.342667
3	2026-06-08 12:42:07.103907	Professeur	ACTIVE	2026-06-08 12:42:07.103907
5	2026-06-10 10:38:00.629511	M├®decin G├®n├®raliste	ACTIVE	2026-06-10 10:38:00.629511
6	2026-06-10 10:38:00.629511	Cardiologue	ACTIVE	2026-06-10 10:38:00.629511
7	2026-06-10 10:38:00.629511	P├®diatre	ACTIVE	2026-06-10 10:38:00.629511
8	2026-06-10 10:38:00.629511	Dentiste	ACTIVE	2026-06-10 10:38:00.629511
9	2026-06-10 10:38:00.629511	Pharmacien	ACTIVE	2026-06-10 10:38:00.629511
10	2026-06-10 10:38:00.629511	Infirmier	ACTIVE	2026-06-10 10:38:00.629511
11	2026-06-10 10:38:00.629511	Kin├®sith├®rapeute	ACTIVE	2026-06-10 10:38:00.629511
12	2026-06-10 10:38:00.629511	Sage-femme	ACTIVE	2026-06-10 10:38:00.629511
13	2026-06-10 10:38:00.629511	Radiologue	ACTIVE	2026-06-10 10:38:00.629511
14	2026-06-10 10:38:00.629511	Chirurgien	ACTIVE	2026-06-10 10:38:00.629511
15	2026-06-10 10:38:00.629511	Ing├®nieur	ACTIVE	2026-06-10 10:38:00.629511
16	2026-06-10 10:38:00.629511	D├®veloppeur Informatique	ACTIVE	2026-06-10 10:38:00.629511
17	2026-06-10 10:38:00.629511	Technicien Informatique	ACTIVE	2026-06-10 10:38:00.629511
18	2026-06-10 10:38:00.629511	Enseignant	ACTIVE	2026-06-10 10:38:00.629511
19	2026-06-10 10:38:00.629511	Professeur Universitaire	ACTIVE	2026-06-10 10:38:00.629511
20	2026-06-10 10:38:00.629511	├ëtudiant	ACTIVE	2026-06-10 10:38:00.629511
21	2026-06-10 10:38:00.629511	Comptable	ACTIVE	2026-06-10 10:38:00.629511
22	2026-06-10 10:38:00.629511	Banquier	ACTIVE	2026-06-10 10:38:00.629511
23	2026-06-10 10:38:00.629511	Commercial	ACTIVE	2026-06-10 10:38:00.629511
24	2026-06-10 10:38:00.629511	Chef d'Entreprise	ACTIVE	2026-06-10 10:38:00.629511
25	2026-06-10 10:38:00.629511	Fonctionnaire	ACTIVE	2026-06-10 10:38:00.629511
26	2026-06-10 10:38:00.629511	Employ├® Administratif	ACTIVE	2026-06-10 10:38:00.629511
27	2026-06-10 10:38:00.629511	Secr├®taire	ACTIVE	2026-06-10 10:38:00.629511
28	2026-06-10 10:38:00.629511	Avocat	ACTIVE	2026-06-10 10:38:00.629511
29	2026-06-10 10:38:00.629511	Notaire	ACTIVE	2026-06-10 10:38:00.629511
30	2026-06-10 10:38:00.629511	Architecte	ACTIVE	2026-06-10 10:38:00.629511
31	2026-06-10 10:38:00.629511	Artisan	ACTIVE	2026-06-10 10:38:00.629511
32	2026-06-10 10:38:00.629511	├ëlectricien	ACTIVE	2026-06-10 10:38:00.629511
33	2026-06-10 10:38:00.629511	Plombier	ACTIVE	2026-06-10 10:38:00.629511
34	2026-06-10 10:38:00.629511	M├®canicien	ACTIVE	2026-06-10 10:38:00.629511
35	2026-06-10 10:38:00.629511	Chauffeur	ACTIVE	2026-06-10 10:38:00.629511
36	2026-06-10 10:38:00.629511	Agriculteur	ACTIVE	2026-06-10 10:38:00.629511
37	2026-06-10 10:38:00.629511	P├¬cheur	ACTIVE	2026-06-10 10:38:00.629511
38	2026-06-10 10:38:00.629511	Commer├ºant	ACTIVE	2026-06-10 10:38:00.629511
39	2026-06-10 10:38:00.629511	Agent de S├®curit├®	ACTIVE	2026-06-10 10:38:00.629511
40	2026-06-10 10:38:00.629511	Policier	ACTIVE	2026-06-10 10:38:00.629511
41	2026-06-10 10:38:00.629511	Militaire	ACTIVE	2026-06-10 10:38:00.629511
42	2026-06-10 10:38:00.629511	Retrait├®	ACTIVE	2026-06-10 10:38:00.629511
43	2026-06-10 10:38:00.629511	Sans Emploi	ACTIVE	2026-06-10 10:38:00.629511
44	2026-06-10 10:38:00.629511	Femme au Foyer	ACTIVE	2026-06-10 10:38:00.629511
45	2026-06-10 10:38:00.629511	Autre	ACTIVE	2026-06-10 10:38:00.629511
\.


--
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.staff (id, created_at, email, first_name, last_name, phone, specialty, status, user_id) FROM stdin;
1	2026-05-27 23:03:20.121439	lucas.moreau@clinic.fr	Lucas	Moreau	0612345678	Cardiologie	Active	1
2	2026-05-27 23:03:59.004889	emma.dubois@clinic.fr	Emma	Dubois	0622334455	P├®diatrie	Active	2
6	2026-05-27 23:15:47.960463	m.azizi@outlook.fr	Mohammed	AZIZI	0761237150	ADMIN	Active	3
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.users (id, password, role, username) FROM stdin;
1	$2a$10$2VXehexAjTfCya6DjLTibeCRTTmxKs6Z/N.6cLKFmefrUJRaOAkha	ADMIN	admin
2	$2a$10$7EqJtq98hPqEX7fNZaFWoOHiWqD0fM6M9vDOMkMt2rt7NmBGG99G	ADMIN	admin@proclinic.com
3	$2a$10$.cQVbnYVow1Peu.2oOw4FeF/eLHyV1VmnqJ5HsNyXU351CgT3m6kC	ADMIN	admin1@proclinic.com
\.


--
-- Name: antecedent_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.antecedent_id_seq', 1, false);


--
-- Name: assurance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.assurance_id_seq', 1, false);


--
-- Name: cities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.cities_id_seq', 24, true);


--
-- Name: clinic_services_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.clinic_services_id_seq', 20, true);


--
-- Name: dossier_medical_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.dossier_medical_id_seq', 1, false);


--
-- Name: hospitalisation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.hospitalisation_id_seq', 1, false);


--
-- Name: hospitalization_act_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.hospitalization_act_id_seq', 17, true);


--
-- Name: hospitalization_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.hospitalization_id_seq', 3, true);


--
-- Name: insurances_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.insurances_id_seq', 15, true);


--
-- Name: medical_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.medical_records_id_seq', 20, true);


--
-- Name: patients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.patients_id_seq', 20, true);


--
-- Name: professions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.professions_id_seq', 45, true);


--
-- Name: staff_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.staff_id_seq', 6, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- Name: antecedent antecedent_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.antecedent
    ADD CONSTRAINT antecedent_pkey PRIMARY KEY (id);


--
-- Name: assurance assurance_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.assurance
    ADD CONSTRAINT assurance_pkey PRIMARY KEY (id);


--
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- Name: clinic_services clinic_services_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clinic_services
    ADD CONSTRAINT clinic_services_pkey PRIMARY KEY (id);


--
-- Name: dossier_medical dossier_medical_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dossier_medical
    ADD CONSTRAINT dossier_medical_pkey PRIMARY KEY (id);


--
-- Name: hospitalisation hospitalisation_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalisation
    ADD CONSTRAINT hospitalisation_pkey PRIMARY KEY (id);


--
-- Name: hospitalization_act hospitalization_act_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalization_act
    ADD CONSTRAINT hospitalization_act_pkey PRIMARY KEY (id);


--
-- Name: hospitalization hospitalization_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalization
    ADD CONSTRAINT hospitalization_pkey PRIMARY KEY (id);


--
-- Name: insurances insurances_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.insurances
    ADD CONSTRAINT insurances_pkey PRIMARY KEY (id);


--
-- Name: medical_records medical_records_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT medical_records_pkey PRIMARY KEY (id);


--
-- Name: patients patients_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT patients_pkey PRIMARY KEY (id);


--
-- Name: professions professions_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.professions
    ADD CONSTRAINT professions_pkey PRIMARY KEY (id);


--
-- Name: staff staff_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_pkey PRIMARY KEY (id);


--
-- Name: insurances uk16ob0msjex8cyk62gy2l8ln9l; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.insurances
    ADD CONSTRAINT uk16ob0msjex8cyk62gy2l8ln9l UNIQUE (matricule);


--
-- Name: staff uk7qatq4kob2sr6rlp44khhj53g; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT uk7qatq4kob2sr6rlp44khhj53g UNIQUE (user_id);


--
-- Name: hospitalization_acts ukc8wj13ahhcplrrl26d5hfnxk3; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalization_acts
    ADD CONSTRAINT ukc8wj13ahhcplrrl26d5hfnxk3 UNIQUE (acts_id);


--
-- Name: dossier_medical ukgfiptfsbc9wfeql9lq9hsj3co; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dossier_medical
    ADD CONSTRAINT ukgfiptfsbc9wfeql9lq9hsj3co UNIQUE (patient_id);


--
-- Name: medical_records ukjljvxv7moeliebth00v2nsrac; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT ukjljvxv7moeliebth00v2nsrac UNIQUE (medical_record_code);


--
-- Name: patients uknmvbsxuoshhevlgvvx87v0vtj; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT uknmvbsxuoshhevlgvvx87v0vtj UNIQUE (cin);


--
-- Name: medical_records ukpfo95i6n9sje9q9mb429f5qor; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT ukpfo95i6n9sje9q9mb429f5qor UNIQUE (patient_id);


--
-- Name: assurance ukqf5rp3i9nnf407fyols90orng; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.assurance
    ADD CONSTRAINT ukqf5rp3i9nnf407fyols90orng UNIQUE (patient_id);


--
-- Name: cities ukqww1g66rmhx352jxut53oqh3y; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT ukqww1g66rmhx352jxut53oqh3y UNIQUE (code);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: hospitalisation fk1lfa1xt6qlpnlkwux2druiqo5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalisation
    ADD CONSTRAINT fk1lfa1xt6qlpnlkwux2druiqo5 FOREIGN KEY (patient_id) REFERENCES public.patients(id);


--
-- Name: hospitalization_acts fkcl7ule38uf72psd1sqgcrfg6l; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalization_acts
    ADD CONSTRAINT fkcl7ule38uf72psd1sqgcrfg6l FOREIGN KEY (acts_id) REFERENCES public.hospitalization_act(id);


--
-- Name: assurance fkd8cjpkyhwejkck5i2bo3qtyvy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.assurance
    ADD CONSTRAINT fkd8cjpkyhwejkck5i2bo3qtyvy FOREIGN KEY (patient_id) REFERENCES public.patients(id);


--
-- Name: staff fkdlvw23ak3u9v9bomm8g12rtc0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT fkdlvw23ak3u9v9bomm8g12rtc0 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: patients fkgilaks1al0adrufqoswh38utx; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT fkgilaks1al0adrufqoswh38utx FOREIGN KEY (city_id) REFERENCES public.cities(id);


--
-- Name: hospitalization_acts fkgymhi3mxls9afvxkumeu21xkb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalization_acts
    ADD CONSTRAINT fkgymhi3mxls9afvxkumeu21xkb FOREIGN KEY (hospitalization_id) REFERENCES public.hospitalization(id);
ALTER ROLE

--
-- Name: patients fkhkntdq6ujwdgqbx8iwffi2ffb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT fkhkntdq6ujwdgqbx8iwffi2ffb FOREIGN KEY (insurance_id) REFERENCES public.insurances(id);


--
-- Name: dossier_medical fki21rp4v390pq3o3gfsw5v3spe; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dossier_medical
    ADD CONSTRAINT fki21rp4v390pq3o3gfsw5v3spe FOREIGN KEY (patient_id) REFERENCES public.patients(id);


--
-- Name: patients fkkqiqblkbhfc4xjyfw90a9mh5d; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT fkkqiqblkbhfc4xjyfw90a9mh5d FOREIGN KEY (profession_id) REFERENCES public.professions(id);


--
-- Name: hospitalization fko3vfryvi6b5ws6b9p4ahvik37; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.hospitalization
    ADD CONSTRAINT fko3vfryvi6b5ws6b9p4ahvik37 FOREIGN KEY (patient_id) REFERENCES public.patients(id);


--
-- Name: medical_records fkrav12h9aiw7pegjt62p8owwn3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT fkrav12h9aiw7pegjt62p8owwn3 FOREIGN KEY (patient_id) REFERENCES public.patients(id);


--
-- Name: antecedent fksoul6klwuqqyp0mmc3gkvokbu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.antecedent
    ADD CONSTRAINT fksoul6klwuqqyp0mmc3gkvokbu FOREIGN KEY (patient_id) REFERENCES public.patients(id);


--
-- PostgreSQL database dump complete
--



