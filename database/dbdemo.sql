--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: demo; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA demo;


ALTER SCHEMA demo OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = demo, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tblcustomer; Type: TABLE; Schema: demo; Owner: postgres; Tablespace: 
--

CREATE TABLE tblcustomer (
    custid integer NOT NULL,
    cust_name text,
    location text
);


ALTER TABLE demo.tblcustomer OWNER TO postgres;

--
-- Name: tblcustomer_custid_seq; Type: SEQUENCE; Schema: demo; Owner: postgres
--

CREATE SEQUENCE tblcustomer_custid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE demo.tblcustomer_custid_seq OWNER TO postgres;

--
-- Name: tblcustomer_custid_seq; Type: SEQUENCE OWNED BY; Schema: demo; Owner: postgres
--

ALTER SEQUENCE tblcustomer_custid_seq OWNED BY tblcustomer.custid;


SET search_path = public, pg_catalog;

--
-- Name: staff; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE staff (
    staff_id integer NOT NULL,
    staff_name text,
    location text
);


ALTER TABLE public.staff OWNER TO postgres;

--
-- Name: staff_staff_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE staff_staff_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.staff_staff_id_seq OWNER TO postgres;

--
-- Name: staff_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE staff_staff_id_seq OWNED BY staff.staff_id;


--
-- Name: tblstudent; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tblstudent (
    regino integer NOT NULL,
    st_name text,
    location text
);


ALTER TABLE public.tblstudent OWNER TO postgres;

--
-- Name: tblstudent_regino_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tblstudent_regino_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tblstudent_regino_seq OWNER TO postgres;

--
-- Name: tblstudent_regino_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tblstudent_regino_seq OWNED BY tblstudent.regino;


SET search_path = demo, pg_catalog;

--
-- Name: custid; Type: DEFAULT; Schema: demo; Owner: postgres
--

ALTER TABLE ONLY tblcustomer ALTER COLUMN custid SET DEFAULT nextval('tblcustomer_custid_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- Name: staff_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY staff ALTER COLUMN staff_id SET DEFAULT nextval('staff_staff_id_seq'::regclass);


--
-- Name: regino; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tblstudent ALTER COLUMN regino SET DEFAULT nextval('tblstudent_regino_seq'::regclass);


SET search_path = demo, pg_catalog;

--
-- Data for Name: tblcustomer; Type: TABLE DATA; Schema: demo; Owner: postgres
--

COPY tblcustomer (custid, cust_name, location) FROM stdin;
2	Elbin	Portugal
3	Elwin	India
1	nintedanib	UK
\.


--
-- Name: tblcustomer_custid_seq; Type: SEQUENCE SET; Schema: demo; Owner: postgres
--

SELECT pg_catalog.setval('tblcustomer_custid_seq', 3, true);


SET search_path = public, pg_catalog;

--
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY staff (staff_id, staff_name, location) FROM stdin;
2	Alen	kerala
3	irin	india
4	ediwn	inda
5	sobha	EU
6	sosamma	EU
7	EU	kuriakose
1	nintedanib	kerala
\.


--
-- Name: staff_staff_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('staff_staff_id_seq', 7, true);


--
-- Data for Name: tblstudent; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tblstudent (regino, st_name, location) FROM stdin;
1	geethan	kerala
2	Alen	kerala
3	irin	india
4	ediwn	inda
7	EU	kuriakose
5	sobha	nintedanib
6	sosamma	nintedanib
\.


--
-- Name: tblstudent_regino_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tblstudent_regino_seq', 7, true);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

